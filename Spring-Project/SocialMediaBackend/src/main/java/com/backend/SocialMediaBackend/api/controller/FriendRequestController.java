package com.backend.SocialMediaBackend.api.controller;

import com.backend.SocialMediaBackend.api.model.FriendRequestBody;
import com.backend.SocialMediaBackend.api.model.FriendRequestResponseBody;
import com.backend.SocialMediaBackend.api.services.FriendRequestService;
import com.backend.SocialMediaBackend.model.LocalUser;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/friends")
public class FriendRequestController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private FriendRequestService friendRequestService;

    @PostMapping("/send")
    public ResponseEntity<FriendRequestResponseBody> friendRequestSend(@RequestBody @Valid FriendRequestBody friendRequestBody,
                                                                       Authentication authentication) {

        try {
            // Get the authenticated user's details
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String senderUsername = userDetails.getUsername(); // Assuming the username can be used to identify the user

            Long senderId = friendRequestService.getUserIdByUsername(senderUsername);
            friendRequestService.sendFriendRequest(senderId, friendRequestBody.getReceiverId(), friendRequestBody.getReceiverEmail());

            FriendRequestResponseBody friendRequestResponseBody = new FriendRequestResponseBody();
            friendRequestResponseBody.setRequest_status(true);
            return ResponseEntity.ok(friendRequestResponseBody);

        } catch (RuntimeException ignored) {
            logger.warn("Friend request already sent.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}

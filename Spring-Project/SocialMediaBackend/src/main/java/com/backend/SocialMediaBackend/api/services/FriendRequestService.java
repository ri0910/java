package com.backend.SocialMediaBackend.api.services;


import com.backend.SocialMediaBackend.api.repository.FriendRequestRepository;
import com.backend.SocialMediaBackend.api.repository.UserRepository;
import com.backend.SocialMediaBackend.model.FriendRequest;
import com.backend.SocialMediaBackend.model.LocalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FriendRequestService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FriendRequestRepository friendRequestRepository;

    public FriendRequest sendFriendRequest(Long senderId, Long receiverId, String receiverEmail) {
        // Check if a friend request already exists
        Optional<FriendRequest> existingRequest = friendRequestRepository.findBySenderIdAndReceiverId(senderId, receiverId);
        if (existingRequest.isEmpty()) {
            // Create a new friend request
            FriendRequest friendRequest = new FriendRequest();
            friendRequest.setSenderId(senderId);
            friendRequest.setReceiverId(receiverId);
            friendRequest.setReceiverEmail(receiverEmail);
            friendRequest.setStatus("PENDING");

            return friendRequestRepository.save(friendRequest);
        } else {
            throw new RuntimeException("Friend request already sent.");
        }


    }

    public Long getUserIdByUsername(String username) {
        // Retrieve the user's ID from the database based on the username
        Optional<LocalUser> user = userRepository.findByEmailIgnoreCase(username);
        if(user.isPresent()) {
            LocalUser localUser = user.get();
            return localUser.getId();
        }
        return null;
    }
}

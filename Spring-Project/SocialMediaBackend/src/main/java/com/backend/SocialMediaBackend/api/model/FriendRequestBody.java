package com.backend.SocialMediaBackend.api.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FriendRequestBody {

    @NotNull
    private Long receiverId;

    @NotNull
    private String receiverEmail;
}

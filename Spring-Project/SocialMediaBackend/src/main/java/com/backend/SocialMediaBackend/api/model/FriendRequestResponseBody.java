package com.backend.SocialMediaBackend.api.model;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FriendRequestResponseBody {

    @NotNull
    private boolean request_status;

}

package com.emsi.airbnb.Payload.Mapper;

import org.springframework.stereotype.Service;
import com.emsi.airbnb.Entity.User;
import com.emsi.airbnb.Payload.Request.UserRequest;
import com.emsi.airbnb.Payload.Response.UserResponse;

@Service
public class UserMapper {

    public User toUser(UserRequest userRequest) {
        return User.builder()
                .username(userRequest.username())
                .email(userRequest.email())
                .password(userRequest.password())
                .createdAt(userRequest.createdAt())
                .updatedAt(userRequest.updatedAt())
                .build();
    }

    public UserResponse toUserResponse(User user) {
        String reservationId = null;
        if (user.getReservation() != null) {
            reservationId = user.getReservation().getId().toString();
        }
        
        return new UserResponse(
                user.getId().toString(), 
                user.getUsername(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getUpdatedAt(),
                reservationId 
        );
    }
}

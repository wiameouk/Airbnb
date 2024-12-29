package com.emsi.airbnb.IService;

import com.emsi.airbnb.Payload.Request.UserRequest;
import com.emsi.airbnb.Payload.Response.UserResponse;

import java.util.List;

public interface IUserService {
    void saveUser(UserRequest userRequest);
    UserResponse getUserById(String userId);
    List<UserResponse> getAllUsers();
    void updateUser(String userId, UserRequest userRequest);
    void deleteUser(String userId);
    

}

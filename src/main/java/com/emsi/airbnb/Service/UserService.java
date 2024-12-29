package com.emsi.airbnb.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.emsi.airbnb.Entity.User;
import com.emsi.airbnb.Exception.UserNotFoundException;
import com.emsi.airbnb.IService.IUserService;
import com.emsi.airbnb.Payload.Mapper.UserMapper;
import com.emsi.airbnb.Payload.Request.UserRequest;
import com.emsi.airbnb.Payload.Response.UserResponse;
import com.emsi.airbnb.Repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void saveUser(UserRequest userRequest) {
        User user = userMapper.toUser(userRequest);
        userRepository.save(user);
    }

    @Override
    public UserResponse getUserById(String userId) {
        User user = userRepository.findById(UUID.fromString(userId))
                .orElseThrow(() -> new UserNotFoundException("Cannot find user with id: " + userId));
        return userMapper.toUserResponse(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toUserResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void updateUser(String userId, UserRequest userRequest) {
        User user = userRepository.findById(UUID.fromString(userId))
                .orElseThrow(() -> new UserNotFoundException("Cannot find user with id: " + userId));
                user.setUsername(userRequest.username());
                user.setEmail(userRequest.email());
                user.setPassword(userRequest.password());
                user.setCreatedAt(userRequest.createdAt());
                user.setUpdatedAt(userRequest.updatedAt());

                userRepository.save(user);
    }

    @Override
    public void deleteUser(String userId) {
        if (userRepository.existsById(UUID.fromString(userId))) {
            userRepository.deleteById(UUID.fromString(userId));
        } else {
            throw new UserNotFoundException("Cannot find user with id: " + userId);
        }
    }

}

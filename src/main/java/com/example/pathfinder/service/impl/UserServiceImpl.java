package com.example.pathfinder.service.impl;

import com.example.pathfinder.model.entity.User;
import com.example.pathfinder.model.entity.enums.LevelEnum;
import com.example.pathfinder.model.service.UserServiceModel;
import com.example.pathfinder.repo.UserRepo;
import com.example.pathfinder.security.CurrentUser;
import com.example.pathfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepo userRepo, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        userRepo.save(modelMapper.map(userServiceModel, User.class)
                .setLevel(LevelEnum.BEGINNER));
//                .setRoles(Set.of(RoleEnum.valueOf())));
    }

    @Override
    public UserServiceModel findByUsername(String username) {
        User user = userRepo.findByUsername(username).orElse(null);
        return user == null ? null : modelMapper.map(user, UserServiceModel.class);
    }

    @Override
    public UserServiceModel loginUser(String username, String password) {
        Optional<User> user = userRepo.findByUsername(username);
        if (user.isEmpty()) {
            return null;
        }
        currentUser.setUsername(username).setId(user.get().getId());
        return user.get().getPassword().equals(password) ?
                modelMapper.map(user, UserServiceModel.class) : null;
    }

    @Override
    public void logoutUser() {
        currentUser.setId(null).setUsername(null);
    }

    @Override
    public UserServiceModel findById(Long id) {
        User user = userRepo.findById(id).orElse(null);
        return user == null ? null : modelMapper.map(user, UserServiceModel.class);
    }
}

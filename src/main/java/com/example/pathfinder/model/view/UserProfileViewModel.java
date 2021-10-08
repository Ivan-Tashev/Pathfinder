package com.example.pathfinder.model.view;

import com.example.pathfinder.model.entity.enums.LevelEnum;

public class UserProfileViewModel {
    private Long id;
    private String fullName;
    private String username;
    private int age;
    private LevelEnum level;

    public Long getId() {
        return id;
    }

    public UserProfileViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserProfileViewModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserProfileViewModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public int getAge() {
        return age;
    }

    public UserProfileViewModel setAge(int age) {
        this.age = age;
        return this;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public UserProfileViewModel setLevel(LevelEnum level) {
        this.level = level;
        return this;
    }
}

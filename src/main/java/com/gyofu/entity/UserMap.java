package com.gyofu.entity;

import lombok.Data;

import java.util.Map;

@Data
public class UserMap {
    private Map<String, User> users;
}

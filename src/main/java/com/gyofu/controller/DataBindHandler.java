package com.gyofu.controller;

import com.gyofu.entity.User;
import com.gyofu.entity.UserList;
import com.gyofu.entity.UserMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@RestController
@RequestMapping("/data")
public class DataBindHandler {
    @RequestMapping("/baseType")
    public String baseType(int id) {
        return id + "";
    }

    @RequestMapping("/packageType")
    public String packageType(@RequestParam(value = "num", required = false, defaultValue = "0") Integer id) {
        return id + "";
    }

    @RequestMapping("/array")
    public String array(String[] name) {
        String str = Arrays.toString(name);
        return str;
    }

    @RequestMapping("/list")
    public String list(UserList userList, HttpServletResponse response) {
        StringBuffer stringBuffer = new StringBuffer();
        for (User user : userList.getUsers()) {
            stringBuffer.append(user);
        }
        return stringBuffer.toString();
    }

    @RequestMapping("/map")
    public String map(UserMap userMap) {
        StringBuffer stringBuffer = new StringBuffer();
        for (String key : userMap.getUsers().keySet()) {
            User user = userMap.getUsers().get(key);
            stringBuffer.append(user);
        }
        return stringBuffer.toString();
    }

    @RequestMapping("/json")
    public User json(@RequestBody User user) {
        System.out.println(user.toString());
        user.setId(6);
        user.setName("张六");
        return user;
    }
}

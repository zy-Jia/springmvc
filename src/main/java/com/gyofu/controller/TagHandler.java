package com.gyofu.controller;

import com.gyofu.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/tag")
public class TagHandler {
    @RequestMapping("/get")
    public ModelAndView get() {
        ModelAndView modelAndView = new ModelAndView("tag");
        Student student = new Student();
        student.setId(1L);
        student.setName("张三");
        student.setAge(18);
        student.setFlag(true);
        String[] hobby = {"读书", "看电影", "玩游戏", "逛街", "摄影"};
        String[] selectHobby = {"读书", "看电影", "玩游戏", "逛街"};
        List<String> hobbyList = Arrays.asList(hobby);
        List<String> selectHobbyList = Arrays.asList(selectHobby);
        student.setHobby(hobbyList);
        student.setSelectHobby(selectHobbyList);
        student.setRadioId(1);
        Map<Integer, String> gradeMap = new HashMap<>();
        gradeMap.put(1, "一年级");
        gradeMap.put(2, "二年级");
        gradeMap.put(3, "三年级");
        gradeMap.put(4, "四年级");
        gradeMap.put(5, "五年级");
        gradeMap.put(6, "六年级");
        student.setGradeMap(gradeMap);
        student.setSelectGrade(3);
        Map<Integer, String> cityMap = new HashMap<>();
        cityMap.put(1, "北京");
        cityMap.put(2, "上海");
        cityMap.put(3, "广州");
        student.setCityMap(cityMap);
        student.setSelectCity(1);
        student.setIntroduce("我是谁？");
        modelAndView.addObject("student", student);
        return modelAndView;
    }
}

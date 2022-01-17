package com.gyofu.controller;

import com.gyofu.entity.Student;
import com.gyofu.entity.User;
import com.gyofu.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

@RestController
@RequestMapping("/rest")
public class RESTHandler {

    @Autowired
    private StudentRepository studentRepository;

//    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @GetMapping("/findAll")
    public Collection<Student> findAll(HttpServletResponse response) {
        response.setContentType("text/jsom;charset=UTF-8");
        return studentRepository.findAll();
    }

    @RequestMapping("/test")
    public User test() {
        User user = new User();
        user.setName("张三");
        return user;
    }

    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable("id") long id) {
        return studentRepository.findById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Student student) {
        studentRepository.saveOrUpdate(student);
    }

    @PostMapping("/update")
    public void update(@RequestBody Student student) {
        studentRepository.saveOrUpdate(student);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id) {
        studentRepository.deleteById(id);
    }
}

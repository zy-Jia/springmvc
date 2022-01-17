package com.gyofu.entity.impl;

import com.gyofu.entity.Student;
import com.gyofu.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private static Map<Long, Student> studentMap;
    static {
        studentMap = new HashMap<>();
        studentMap.put(1L, new Student(1L, "张三", 18));
        studentMap.put(2L, new Student(2L, "李四", 20));
        studentMap.put(3L, new Student(3L, "王五", 22));
    }

    @Override
    public Collection<Student> findAll() {
        return studentMap.values();
    }

    @Override
    public Student findById(long id) {
        return studentMap.get(id);
    }

    @Override
    public void saveOrUpdate(Student student) {
        studentMap.put(student.getId(), student);
    }

    @Override
    public void deleteById(long id) {
        studentMap.remove(id);
    }
}

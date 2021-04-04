package com.hc.crud.teacherlist.controller;


import com.fasterxml.jackson.databind.util.JSONPObject;
import com.hc.crud.teacherlist.entity.Teacher;
import com.hc.crud.teacherlist.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/teacher")
public class MainController {
    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping("/findAll")
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @PostMapping("/save")
    public Map<String, Object> save(@RequestBody Teacher teacher) {
        Teacher result = teacherRepository.save(teacher);
        Map<String, Object> map = new HashMap<>();
        if(result != null) {
            map.put("userData", result);
        } else {
            map.put("error", 01);
        }
        return map;
    }

    @GetMapping("/findById/{id}")
    public Teacher findById(@PathVariable("id") Integer id) {
        return teacherRepository.findById(id).get();
    }

    @PutMapping("/update")
    public String update(@RequestBody Teacher teacher) {
        Teacher result = teacherRepository.save(teacher);
        if(result != null) {
            return "success";
        } else {
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        teacherRepository.deleteById(id);
    }
}

package com.hc.crud.teacherlist.controller;

import com.hc.crud.teacherlist.entity.Teacher;
import com.hc.crud.teacherlist.repository.TeacherRepository;
import com.hc.crud.teacherlist.util.Validator;
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

    @GetMapping("/findById/{id}")
    public Teacher findById(@PathVariable("id") Integer id) {
        return teacherRepository.findById(id).get();
    }

    @PostMapping("/save")
    public Map<String, Object> save(@RequestBody Teacher teacher) {
        Map<String, Object> validateMap = new HashMap<>();
        validateMap = Validator.saveValidate(teacher);
        if((int)validateMap.get("errorCode") < 0) {
            // 数据有误
            return validateMap;
        } else {
            Teacher result = teacherRepository.save((Teacher)validateMap.get("data"));
            Map<String, Object> map = new HashMap<>();
            if(result != null) {
                map.put("userData", result);
            } else {
                map.put("errorCode", -1);
            }
            return map;
        }
    }

    @PutMapping("/update")
    public String update(@RequestBody Teacher teacher) {
        Map<String, Object> validateMap = new HashMap<>();
        validateMap = Validator.saveValidate(teacher);
        if((int)validateMap.get("errorCode") < 0) {
            // 数据有误
            return "error";
        } else {
            Teacher result = teacherRepository.save((Teacher)validateMap.get("data"));
            if(result != null) {
                return "success";
            } else {
                return "error";
            }
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        teacherRepository.deleteById(id);
    }
}

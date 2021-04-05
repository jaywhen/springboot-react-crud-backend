package com.hc.crud.teacherlist.util;

import com.hc.crud.teacherlist.entity.Teacher;

import java.util.HashMap;
import java.util.Map;

// errorCode -1 数据不合法

public class Validator {
    public static Map<String, Object> saveValidate(Teacher teacher) {
        Map<String, Object> retMap = new HashMap<>();
        if(teacher.getName().length() > 20) {
            retMap.put("errorCode", -1);
            retMap.put("msg", "姓名超过20个字符长度");
            return retMap;
        } else if(teacher.getTel().length() > 11 || !(teacher.getTel().matches("[0-9]+"))) {
            retMap.put("errorCode", -1);
            retMap.put("msg", "电话号码格式错误");
            return retMap;
        } else if(teacher.getGender().length() > 5) {
            retMap.put("errorCode", -1);
            retMap.put("msg", "性别超过5个字符长度");
            return retMap;
        } else if(teacher.getDepartment().length() > 30) {
            retMap.put("errorCode", -1);
            retMap.put("msg", "部门超过30个字符长度");
            return retMap;
        } else if(teacher.getJoinDate().length() > 10) {
            retMap.put("errorCode", -1);
            retMap.put("msg", "加入日期超过10个字符长度");
            return retMap;
        } else if(teacher.getRate() > 5) {
            retMap.put("errorCode", -1);
            retMap.put("msg", "rate 大于5");
            return retMap;
        } else if(teacher.getAge() > 150 || teacher.getAge() < 18) {
            retMap.put("errorCode", -1);
            retMap.put("msg", "非正常年龄");
            return retMap;
        } else if(teacher.getStack().length() > 50) {
            retMap.put("errorCode", -1);
            retMap.put("msg", "stack 超过50个字符长度");
            return retMap;
        } else {
            retMap.put("errorCode", 1);
            retMap.put("data", teacher);
            return retMap;
        }
    }
}

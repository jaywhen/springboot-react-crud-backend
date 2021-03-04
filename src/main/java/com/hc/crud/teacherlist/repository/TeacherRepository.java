package com.hc.crud.teacherlist.repository;

import com.hc.crud.teacherlist.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}

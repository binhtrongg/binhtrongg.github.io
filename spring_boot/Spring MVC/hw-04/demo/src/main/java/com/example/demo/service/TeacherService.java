package com.example.demo.service;
import com.example.demo.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {
    public TeacherService(){
        creatData();
    }
    private final List<Teacher>teachers=new ArrayList<>();
    public void creatData(){
        for (int i = 0; i <10 ; i++) {
            teachers.add(new Teacher(i,"nguyen văn "+i,"016"+i,"thanh pho "+i,"12A"+i));
        }
    }
    public List<Teacher> getAllTeachers(){
        return teachers;
    }

    public void deleteTeacher(int teacherId) {
        List<Teacher> teachersToRemove = new ArrayList<>();
        for (Teacher teacher : teachers) {
            if (teacher.getId()== teacherId) {
                teachersToRemove.add(teacher);
            }
        }
        teachers.removeAll(teachersToRemove);
    }
    public void saveTeacher(Teacher teacher) {
        teacher.setId((teachers.get(teachers.size()-1).getId()+1));
        teachers.add(teacher);
    }

    public Teacher getTeacherById(int teacherId) {
        for (Teacher teacher:teachers) {
            if (teacher.getId()==teacherId){
                return teacher;
            }
        }
        return null;
    }

    public void updateTeacher(int teacherId, Teacher updatedTeacher) {
        Teacher teacher=getTeacherById(teacherId);
        teacher.setName(updatedTeacher.getName());
        teacher.setPhoneNumber(updatedTeacher.getPhoneNumber());
        teacher.setAddress(updatedTeacher.getAddress());
        teacher.setClassName(updatedTeacher.getClassName());
    }
}
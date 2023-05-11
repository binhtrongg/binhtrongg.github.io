package com.example.demo.controller;
import com.example.demo.model.Teacher;
import com.example.demo.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/teachers")
public class TeacherController {
    TeacherService teacherService;
    @GetMapping
    public String getTeacher(Model model){
        List<Teacher>teachers=teacherService.getAllTeachers();
        model.addAttribute("dsGV",teachers);
        return "teacher-list";
    }

    @PostMapping("/delete/{id}")
    public String deleteTeacher(@PathVariable("id") int teacherId) {
        teacherService.deleteTeacher(teacherId);
        return "redirect:/teachers"; // Chuyển hướng về trang danh sách giáo viên
    }

    @GetMapping("/create-form")
    public String forwardToCreateForm(Model model, Teacher teacher) {
        model.addAttribute("newTeacher", teacher);
        return "create-teacher";
    }
    @PostMapping
    public String createNewStudent(@ModelAttribute("student") Teacher teacher) {
        teacherService.saveTeacher(teacher);
        return "redirect:/teachers";
    }
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") int teacherId, Model model) {
        Teacher teacher = teacherService.getTeacherById(teacherId);
        model.addAttribute("teacher", teacher);
        return "update-teacher"; // Trang HTML để hiển thị form cập nhật thông tin giáo viên
    }
    @PostMapping("/update/{id}")
    public String updateTeacher(@PathVariable("id") int teacherId, @ModelAttribute("teacher") Teacher updatedTeacher) {
        teacherService.updateTeacher(teacherId, updatedTeacher);
        return "redirect:/teachers"; // Chuyển hướng về trang danh sách giáo viên sau khi cập nhật thành công
    }
}

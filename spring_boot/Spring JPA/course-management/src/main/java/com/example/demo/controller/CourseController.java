package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.entity.Supporter;
import com.example.demo.entity.Topic;
import com.example.demo.model.request.CourseRequest;
import com.example.demo.service.CourseService;
import com.example.demo.service.SupporterService;
import com.example.demo.service.TopicService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class CourseController {
    private final CourseService courseService;
    private final TopicService topicService;
    private final SupporterService supporterService;


    @GetMapping("/")
    public String getAllCourse(@RequestParam(required = false, defaultValue = "1") Integer page,
                               @RequestParam(required = false, defaultValue = "6") Integer pageSize,
                               Model model) {
        Page<Course> pageInfo = courseService.getAllCourse(page, pageSize);
        List<Topic> topicList = topicService.getAllTopic();

        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("currentPage", page);
        return "course-list";
    }

    @GetMapping("/admin/course/createForm")
    public String createForm(Model model) {
        List<Topic> topicList = topicService.getAllTopic();
        List<Supporter>supporterList=supporterService.getSupporter();
        model.addAttribute("topicList", topicList);
        model.addAttribute("supporterList", supporterList);
        return "course-create";
    }

    @GetMapping("/admin/course/editForm/{courseId}")
    public String updateForm(Model model,@PathVariable("courseId") Integer id) {
        List<Topic> topicList = topicService.getAllTopic();
        List<Supporter>supporterList=supporterService.getSupporter();
        model.addAttribute("topicList", topicList);
        model.addAttribute("supporterList", supporterList);
        model.addAttribute("courseId",id);
        return "cource-edit";
    }
    @GetMapping("/api/v1/course/{id}")
    public ResponseEntity<?> getCourse(@PathVariable("id") Integer id){
        return ResponseEntity.ok(courseService.findById(id));
    }

    @PostMapping("/api/v1/admin/courses")
    public ResponseEntity<?> creatCouse(@RequestBody CourseRequest courseRequest) {
        courseService.save(courseRequest);
        return ResponseEntity.ok(null);
    }

    @PutMapping("api/v1/admin/courses/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable Integer id ,@RequestBody CourseRequest courseRequest){
        courseService.updateCourse(id,courseRequest);
        return ResponseEntity.ok(null);
    }
    @DeleteMapping("api/v1/admin/courses/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
        return ResponseEntity.ok(null);
    }
}

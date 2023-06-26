package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.entity.Supporter;
import com.example.demo.entity.Topic;
import com.example.demo.model.request.CourseRequest;
import com.example.demo.model.request.CreatSupporterRequest;
import com.example.demo.model.request.TopicRequest;
import com.example.demo.model.request.UpdateSupporterRequest;
import com.example.demo.model.response.ErrorResponse;
import com.example.demo.service.CourseService;
import com.example.demo.service.SupporterService;
import com.example.demo.service.TopicService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
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

    @GetMapping("admin/topics")
    public String topics(@RequestParam(required = false, defaultValue = "1") Integer page,
                         @RequestParam(required = false, defaultValue = "6") Integer pageSize,Model model){
        Page<Topic> pageInfo=topicService.getAllTopicPage(page,pageSize);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("currentPage", page);
        return "topic-list";
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

    @PutMapping("/api/v1/admin/courses/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable Integer id ,@RequestBody CourseRequest courseRequest){
        courseService.updateCourse(id,courseRequest);
        return ResponseEntity.ok(null);
    }
    @DeleteMapping("/api/v1/admin/courses/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
        return ResponseEntity.ok(null);
    }
    @GetMapping("/api/v1/admin/topics/{id}")
    public ResponseEntity<?> getTopic(@PathVariable("id") Integer id){
       return ResponseEntity.ok(topicService.getTopic(id));
    }
    @PostMapping("/api/v1/admin/topics")
    public ResponseEntity<?> creatTopic(@RequestBody TopicRequest topicRequest){
       try {
           Topic topic= topicService.save(topicRequest.getName());
           return ResponseEntity.ok(topic);
       }
       catch (Exception e){
           return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST,e.getMessage()), HttpStatus.BAD_REQUEST);
       }

    }
    @PutMapping("/api/v1/admin/topics/{id}")
    public ResponseEntity<?> updateTopic(@PathVariable("id") Integer id,@RequestBody TopicRequest topicRequest){
        try {
            Topic topic= topicService.update(id,topicRequest.getName());
            return ResponseEntity.ok(topic);
        }
        catch (Exception e){
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST,e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("api/v1/admin/topics/{id}")
    public ResponseEntity<?> deleteTopic(@PathVariable("id") Integer id){
        topicService.deleteTopic(id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
    @GetMapping("/admin/supporters")
    public String allSupporter(@RequestParam(required = false, defaultValue = "1") Integer page,
                               @RequestParam(required = false, defaultValue = "6") Integer pageSize,Model model){
        Page<Supporter> pageInfo=supporterService.getAllSPPage(page,pageSize);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("currentPage", page);
        return "supporter-list";
    }
    @GetMapping("/admin/supporters/create")
    public String creatFormSp(){
        return "supporter-create";
    }
    @DeleteMapping("/api/v1/admin/supporters/{id}")
    public ResponseEntity<?> deleteSupporter(@PathVariable("id") Integer id){
        supporterService.deleteSp(id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
    @PostMapping("api/v1/admin/supporter")
    public ResponseEntity<?> creatSupporter(@RequestBody CreatSupporterRequest creatSupporterRequest){
        try {
            return ResponseEntity.ok(supporterService.save(creatSupporterRequest));
        }
        catch (Exception e){
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST,e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/admin/supporters/update/{id}")
    public String updateSp(@PathVariable("id") Integer id,Model model){
        Supporter supporter =supporterService.getSupporterId(id);
        model.addAttribute("spId",id);
        model.addAttribute("supporter",supporter);
        return "supporter-edit";
    }
    @PutMapping("/api/v1/admin/supporters/{id}")
    public ResponseEntity<?> updateSupporter(@PathVariable("id") Integer id, @RequestBody UpdateSupporterRequest update){
        supporterService.update(id,update);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
}

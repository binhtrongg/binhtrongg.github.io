package com.example.jpareview.controller;

import com.example.jpareview.entity.Cource;
import com.example.jpareview.entity.Supporter;
import com.example.jpareview.service.CourceService;
import com.example.jpareview.statics.Type;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping
public class WebController {
    CourceService courceService;
    @GetMapping("/khoahoc")
    public String getAll(Model model){
       List<Cource> courceList= courceService.getAll();
        model.addAttribute("courceList",courceList);
        return "course-list";
    }

    @GetMapping("/khoahoc/onlab")
    public String getByTypeOnlab(Model model){
        List<Cource> cources=courceService.getByType(Type.ONLAB);
        model.addAttribute("onlab",cources);
        return "course-onlab-list";
    }

    @GetMapping("/khoahoc/online")
    public String getByTypeOffline(Model model){
        List<Cource> cources=courceService.getByType(Type.ONLINE);
        model.addAttribute("offline",cources);
        return "course-online-list";
    }

    @GetMapping("khoahoc/detail/{id}")
    public String getDetails(Model model, @PathVariable("id") Integer id){
        Cource cource=courceService.getCourceById(id);
       Supporter supporter= courceService.getSupporterByCourseid(id);
        model.addAttribute("supporter",supporter);
        model.addAttribute("cource",cource);
        return "detail";
    }

}

package com.example.book_management.controller;
import com.example.book_management.model.ReaderModel;
import com.example.book_management.service.ReaderService;
import com.example.book_management.statics.ReaderType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/readers")
@AllArgsConstructor
public class ReaderController {
    ReaderService readerService;
    @GetMapping
    public String showBookList(Model model) {
        List<ReaderModel> readerModels = readerService.getReaders();
        model.addAttribute("dsReader", readerModels);
        model.addAttribute("readerTypes", ReaderType.values());
        model.addAttribute("reader",new ReaderModel());
        return "list-reader";
    }

    @PostMapping("/add-reader")
    public String addReader(@ModelAttribute("reader") ReaderModel readerModel) {
        readerService.saveReader(readerModel);
        return "redirect:/readers";
    }

    @PostMapping("/update-reader/{id}")
    public String updateReader(@ModelAttribute("reader") ReaderModel updateReaderModel) {
        readerService.updateReader(updateReaderModel);
        return "redirect:/readers";
    }
    @PostMapping("/delete/{id}")
    public String deleteReader(@PathVariable("id") int id){
        readerService.deleteReader(id);
        return "redirect:/readers";
    }
}

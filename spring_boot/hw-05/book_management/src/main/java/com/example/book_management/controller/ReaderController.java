package com.example.book_management.controller;
import com.example.book_management.model.Reader;
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
        List<Reader> readers = readerService.getReaders();
        model.addAttribute("dsReader", readers);
        model.addAttribute("readerTypes", ReaderType.values());
        model.addAttribute("reader",new Reader());
        return "list-reader";
    }

    @PostMapping("/add-reader")
    public String addReader(@ModelAttribute("reader") Reader reader) {
        readerService.saveReader(reader);
        return "redirect:/readers";
    }

    @PostMapping("/update-reader/{id}")
    public String updateReader(@PathVariable("id") int id, @ModelAttribute("reader") Reader updateReader) {
        readerService.updateReader(id,updateReader);
        return "redirect:/readers";
    }
}

package com.example.doto.controller;


import com.example.doto.domain.Note;
import com.example.doto.repos.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private NoteRepo noteRepo;

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Note> notes = noteRepo.findAll();
        model.put("notes", notes);

        return "main";
    }

    @PostMapping("/main")
    public String addNote(@RequestParam String text, @RequestParam Integer priority, Map<String, Object> model) {
        Note note = new Note(text, priority);
        noteRepo.save(note);

        Iterable<Note> notes = noteRepo.findAll();
        model.put("notes", notes);

        return "main";
    }


}
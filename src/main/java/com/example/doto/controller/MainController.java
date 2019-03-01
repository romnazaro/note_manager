package com.example.doto.controller;


import com.example.doto.domain.Note;
import com.example.doto.domain.User;
import com.example.doto.repository.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
public class MainController {
    @Autowired
    private NoteRepo noteRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Note> notes = noteRepo.findAll();
        model.put("notes", notes);


        return "main";
    }

    @PostMapping("/main")
    public String addNote(@AuthenticationPrincipal User user,
                          @RequestParam String text,
                          @RequestParam Integer priority, Map<String, Object>  model,
                          @RequestParam("file")MultipartFile file) throws IOException {
        Note note = new Note(text, priority, user);

        if (file !=null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resFilename));
            note.setFileName(resFilename);
        }

        noteRepo.save(note);

        Iterable<Note> notes = noteRepo.findAll();
        model.put("notes", notes);

        return "main";
    }


}
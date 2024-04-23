package com.example.controller;

import com.example.auth.AuthService;
import com.example.dto.NoteDTO;
import com.example.note.Note;
import com.example.storage.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
@RequestMapping("/note")
public class NoteController {

    private final AuthService authService;
    private final NoteService noteService;

    @GetMapping("/list")
    public String list(Model model) {

        List<NoteDTO> noteDTOs = noteService.getAllNotes().stream()
                .map(NoteDTO::fromNote)
                .collect(Collectors.toList());
        model.addAttribute("notes", noteDTOs);
        return "list";
    }

    @PostMapping("/delete")
    public String deleteNote(@RequestParam("id") int id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }


    @PostMapping("/add")
    public ModelAndView addNote(@RequestParam("title") String title,
                          @RequestParam("content") String content) {
        Note newNote = new Note();
        newNote.setTitle(title);
        newNote.setContent(content);

        noteService.addNote(newNote);

        return new ModelAndView("redirect:/note/list");
    }

    @GetMapping("/edit")
    public ModelAndView editNoteForm(@RequestParam("id") int id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        Note note = noteService.getNoteById(id);
        modelAndView.addObject("note", note);
        return modelAndView;
    }

    @PostMapping("/edit")
    public String editNote(@ModelAttribute("test") Note note) {
        noteService.addUpdateNote(note);
        return "redirect:/note/list";
    }

}

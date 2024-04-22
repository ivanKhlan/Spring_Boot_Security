package com.example.storage;

import com.example.note.Note;
import com.example.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NoteService {

    private final NoteRepository noteRepository;


    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }


    public void addNote(Note note) {
        noteRepository.save(note);
    }


    public void deleteById(int id) {
        noteRepository.deleteById(id);

    }

    public Note getNoteById(int id) {
        return noteRepository.findById(id).orElse(null);
    }

    public void addUpdateNote(Note note) {
        noteRepository.save(note);
    }
}

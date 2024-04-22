package com.example.dto;


import com.example.note.Note;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class NoteDTO {
    private int id;
    private String title;
    private String content;

    public static NoteDTO fromNote(Note note) {

        return NoteDTO.builder()
                .id(note.getId())
                .title(note.getTitle())
                .content(note.getContent())
                .build();
    }

    public static Note fromDTO(NoteDTO noteDTO) {
        Note note = new Note();
        note.setId(noteDTO.getId());
        note.setTitle(noteDTO.getTitle());
        note.setContent(noteDTO.getContent());

        return note;
    }
}

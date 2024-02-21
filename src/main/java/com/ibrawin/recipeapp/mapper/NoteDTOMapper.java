package com.ibrawin.recipeapp.mapper;

import com.ibrawin.recipeapp.domain.Note;
import com.ibrawin.recipeapp.dto.NotesClientDTO;
import com.ibrawin.recipeapp.dto.NotesServerDTO;

public class NoteDTOMapper {

    private NoteDTOMapper() {}

    public static NotesClientDTO toNotesDTO(Note note) {
        NotesClientDTO notesClientDTO = new NotesClientDTO();
        notesClientDTO.setId(note.getId());
        notesClientDTO.setNotes(note.getNotes());
        return notesClientDTO;
    }

    public static Note toNotes(NotesServerDTO severDTO) {
        Note note = new Note();
        note.setNotes(severDTO.getNotes());
        return note;
    }
}

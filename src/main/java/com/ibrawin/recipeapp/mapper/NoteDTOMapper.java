package com.ibrawin.recipeapp.mapper;

import com.ibrawin.recipeapp.domain.Notes;
import com.ibrawin.recipeapp.dto.NotesClientDTO;
import com.ibrawin.recipeapp.dto.NotesServerDTO;

public class NoteDTOMapper {

    private NoteDTOMapper() {}

    public static NotesClientDTO toNotesDTO(Notes note) {
        NotesClientDTO notesClientDTO = new NotesClientDTO();
        notesClientDTO.setId(note.getId());
        notesClientDTO.setNotes(note.getNotes());
        return notesClientDTO;
    }

    public static Notes toNotes(NotesServerDTO severDTO) {
        Notes note = new Notes();
        note.setNotes(severDTO.getNotes());
        return note;
    }
}

package com.example.doto.repos;

import com.example.doto.domain.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepo extends CrudRepository<Note, Long> {
}

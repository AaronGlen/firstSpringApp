package com.qa.com.qa.repository;

import com.qa.com.qa.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepository extends JpaRepository<Note, Long> {


}

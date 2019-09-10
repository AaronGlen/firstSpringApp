package com.qa.Controllers;


import com.qa.controllers.NotesController;
import com.qa.model.Note;
import com.qa.repository.NotesRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class NotesControllerTest {

    @InjectMocks
    private NotesController notesController;

    @Mock
    private NotesRepository repository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetAllNotes(){
        List<Note> notesList = new ArrayList<>();
        Note note = new Note();
        note.setDescription("blah");
        note.setName("blah");
        notesList.add(note);

        when(repository.findAll()).thenReturn(notesList);

        assertEquals(notesController.listAllNotes().get(0).getName(), "blah");
    }

    @Test
    public void testGetNote(){

        Note note = new Note();
        note.setDescription("blah");
        note.setName("blake");
        note.setId(3l);


        when(repository.findOne(3l)).thenReturn(note);
        assertEquals(notesController.getNote(3l).getName(), "blake");


    }

    @Test
    public void testDeleteNote(){

        Note note = new Note();
        note.setDescription("bark");
        note.setName("ruff");
        note.setId(7l);


        when(repository.findOne(7l)).thenReturn(note);
        repository.delete(7l);
        assertEquals( notesController.deleteNote(7l),true);


    }


}

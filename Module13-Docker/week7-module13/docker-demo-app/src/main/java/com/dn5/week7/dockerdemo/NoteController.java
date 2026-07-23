package com.dn5.week7.dockerdemo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Simple CRUD-ish controller so this app is worth containerizing/testing
 * against a real MySQL container via docker-compose.
 */
@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private final NoteRepository repository;

    public NoteController(NoteRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Note> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Note create(@RequestBody Note note) {
        return repository.save(note);
    }
}

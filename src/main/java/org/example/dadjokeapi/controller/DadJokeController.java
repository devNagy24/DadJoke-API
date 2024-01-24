package org.example.dadjokeapi.controller;


import org.example.dadjokeapi.domain.DadJoke;
import org.example.dadjokeapi.domain.DadJokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jokes")
public class DadJokeController {

    private final DadJokeService dadJokeService;

    @Autowired
    public DadJokeController(DadJokeService dadJokeService) {
        this.dadJokeService = dadJokeService;
    }

    @GetMapping
    public ResponseEntity<List<DadJoke>> getAllJokes() {
        return ResponseEntity.ok(dadJokeService.getAll());
    }

    @PostMapping
    public ResponseEntity<DadJoke> addJoke(@RequestBody DadJoke joke) {
        return ResponseEntity.ok(dadJokeService.add(joke));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DadJoke> updateJoke(@PathVariable int id, @RequestBody String newJokeText) {
        DadJoke updatedJoke = dadJokeService.update(id, newJokeText);
        if (updatedJoke != null) {
            return ResponseEntity.ok(updatedJoke);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJoke(@PathVariable int id) {
        dadJokeService.delete(id);
        return ResponseEntity.ok().build();
    }
}

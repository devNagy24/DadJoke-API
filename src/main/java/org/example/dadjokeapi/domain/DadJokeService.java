package org.example.dadjokeapi.domain;

import org.example.dadjokeapi.domain.DadJoke;
import org.example.dadjokeapi.DadJokeRepository.DadJokeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DadJokeService {

    private final DadJokeRepository dadJokeRepository;

    @Autowired
    public DadJokeService(DadJokeRepository dadJokeRepository) {
        this.dadJokeRepository = dadJokeRepository;
    }

    public List<DadJoke> getAll() {
        return dadJokeRepository.findAll();
    }

    public DadJoke add(DadJoke joke) {
        return dadJokeRepository.save(joke);
    }

    public DadJoke update(int id, String newJokeText) {
        Optional<DadJoke> existingJoke = dadJokeRepository.findById((long) id);
        if (existingJoke.isPresent()) {
            DadJoke joke = existingJoke.get();
            joke.setJokeText(newJokeText);
            return dadJokeRepository.save(joke);
        }
        // Handle the case where the joke is not found
        return null;
    }

    public void delete(int id) {
        dadJokeRepository.deleteById((long) id);
    }
}
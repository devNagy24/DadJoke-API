package org.example.dadjokeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.example.dadjokeapi.DadJokeRepository.DadJokeRepository;
import org.example.dadjokeapi.domain.DadJoke;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DadJokeApiApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DadJokeApiApplication.class, args);
        DadJokeRepository repository = context.getBean(DadJokeRepository.class);

        // Create a list of DadJoke objects
        List<DadJoke> dadJokes = new ArrayList<>();

        dadJokes.add(new DadJoke(1, "I'm reading a book on anti-gravity. It's impossible to put down!"));
        dadJokes.add(new DadJoke(2, "Did you hear about the restaurant on the moon? Great food, no atmosphere."));
        dadJokes.add(new DadJoke(3, "Why don't scientists trust atoms? Because they make up everything."));
        dadJokes.add(new DadJoke(4, "I told my wife she should embrace her mistakes. She gave me a hug."));
        dadJokes.add(new DadJoke(5, "What do you call fake spaghetti? An impasta."));
        dadJokes.add(new DadJoke(6, "Why don't eggs tell jokes? They'd crack each other up."));
        dadJokes.add(new DadJoke(7, "I would tell you a joke about an elevator, but it’s an uplifting experience."));
        dadJokes.add(new DadJoke(8, "Why don't skeletons fight each other? They don't have the guts."));
        dadJokes.add(new DadJoke(9, "What do you call a belt made of watches? A waist of time."));
        dadJokes.add(new DadJoke(10, "I'm on a seafood diet. I see food and I eat it."));

        // Save all jokes to the database
        repository.saveAll(dadJokes);
    }
}

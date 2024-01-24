package org.example.dadjokeapi.DadJokeRepository;


import org.example.dadjokeapi.domain.DadJoke;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DadJokeRepository extends JpaRepository<DadJoke, Long> {
}

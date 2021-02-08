package com.galo.webflux;

import com.galo.webflux.api.document.Playlist;
import com.galo.webflux.api.repository.PlaylistRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.UUID;

//@Component
public class DummyData implements CommandLineRunner {

    private final PlaylistRepository playlistRepository;

    DummyData(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    public void run(String... args) throws Exception {
        playlistRepository.deleteAll() // removendo os dados existentes
                .thenMany(
                        Flux.just("API REST Spring Boot", "Deploy de uma aplicação", "Java 8")
                                .map(nome -> new Playlist(UUID.randomUUID().toString(), nome))
                                .flatMap(playlistRepository::save))
                .subscribe(System.out::println);
    }
}
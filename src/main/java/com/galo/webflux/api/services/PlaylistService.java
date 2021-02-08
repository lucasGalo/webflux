package com.galo.webflux.api.services;

import com.galo.webflux.api.document.Playlist;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlaylistService {

    Flux<Playlist> finAll();
    Mono<Playlist> findById(String id);
    Mono<Playlist> save(Playlist playlist);
}

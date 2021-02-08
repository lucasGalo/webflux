package com.galo.webflux.api.services.impl;

import com.galo.webflux.api.document.Playlist;
import com.galo.webflux.api.repository.PlaylistRepository;
import com.galo.webflux.api.services.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    @Autowired
    private PlaylistRepository pr;

    @Override
    public Flux<Playlist> finAll() {
        return pr.findAll();
    }

    @Override
    public Mono<Playlist> findById(String id) {
        return pr.findById(id);
    }

    @Override
    public Mono<Playlist> save(Playlist playlist) {
        return pr.save(playlist);
    }
}

package com.galo.webflux.api.controller;

import com.galo.webflux.api.document.Playlist;
import com.galo.webflux.api.services.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//@RestController
public class PlaylistController {

    @Autowired
    PlaylistService service;

    @GetMapping("/playlist")
    public Flux<Playlist> getPlaylist(){
        return service.finAll();
    }

    @GetMapping("/playlist/{id}")
    public Mono<Playlist> getPlaylistId(@PathVariable String id){
        return service.findById(id);
    }

    @PostMapping("/playlist")
    public Mono<Playlist> save(@RequestBody Playlist playlist){
        return service.save(playlist);
    }
}
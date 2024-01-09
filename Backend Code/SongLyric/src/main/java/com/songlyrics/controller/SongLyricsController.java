package com.songlyrics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.songlyrics.service.SongLyrics;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/songs")
@RequiredArgsConstructor
public class SongLyricsController {

	@Autowired
	private SongLyrics songLyrics;
	
	@GetMapping("/search/{artistname}")
	public ResponseEntity<?> callRapidEndpointToGetSongData(@PathVariable String artistname){
		return ResponseEntity.ok(songLyrics.getAllSongsByArtist(artistname));
	}
	
	@GetMapping("/lyrics/{songId}")
	public ResponseEntity<?> callRapidEndpointToGetSongLyrics(@PathVariable int songId){
		return ResponseEntity.ok(songLyrics.getLyricsBySongId(songId));
	}
}

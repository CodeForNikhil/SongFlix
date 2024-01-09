package com.songlyrics.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SongLyrics {

	private static final Logger log = LoggerFactory.getLogger(SongLyrics.class);

	private static final String BaseUrl = "https://genius-song-lyrics1.p.rapidapi.com/search/?q=";

	//Get it from rapidapi, by creating an account.
	private static final String xRapidAPIkey = "";

	private static final String xRapidAPIHost = "genius-song-lyrics1.p.rapidapi.com";
	
	@Autowired
	private RestTemplate restTemplate;

	public Object getAllSongsByArtist(String artistname) {

		String url = BaseUrl + artistname;

		try {
			HttpHeaders headers = new HttpHeaders();

			headers.set("X-RapidAPI-Key", xRapidAPIkey);
			headers.set("X-RapidAPI-Host", xRapidAPIHost);
			ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers),
					Object.class);
			log.info("Output from rapidAPI {}", response.getBody());

			return response.getBody();

		} catch (Exception e) {
			log.error("Something went wrong ", e);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Exception while calling endpoint of RapidAPI for Song", e);
		}
	}

	public Object getLyricsBySongId(int songId) {

		String url = "https://genius-song-lyrics1.p.rapidapi.com/song/lyrics/?id=" + songId;
		System.out.println(url);
		
		try {
			HttpHeaders headers = new HttpHeaders();
			
			headers.set("X-RapidAPI-Key", xRapidAPIkey);
			headers.set("X-RapidAPI-Host", xRapidAPIHost);
			
			ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers),
					Object.class);
			log.info("output from RapidAPI for lyrics: {}",response.getBody());
			
			return response.getBody();
		} catch(Exception e) {
			log.error("Something is wrong", e);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Exception while calling endpoint of RapidAPI for lyrics",e);
		}
	}

}

package com.openclassrooms.watchlist.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.node.ObjectNode;

public class MovieRatingService {
	
	String apiUrl = "http://www.omdbapi.com/?i=tt3896198&apikey=7c62f16e";
	
	public String getMovieRating(String title) {
		
		try {
			RestTemplate template = new RestTemplate();
			
			ResponseEntity<ObjectNode> response = 
					template.getForEntity(apiUrl + title , ObjectNode.class);
			
			ObjectNode jsonObject = response.getBody();
			
			return jsonObject.path("imdbRating").asText();
		} catch (Exception e) {
			System.out.println("Something went wrong while calling imdb API" + e.getMessage());
			return null;
		}
	}

}

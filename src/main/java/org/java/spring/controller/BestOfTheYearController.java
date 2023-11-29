package org.java.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.java.spring.Movie;
import org.java.spring.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BestOfTheYearController {

	@GetMapping("/")
	public String nome(Model model) {
		final String nome = "Daniel";
		model.addAttribute("nome", nome);
		return "Nome";
	}

	@GetMapping("/movies")
	public String movies(Model model) {
		List<Movie> bestMovies = getBestMovies();
		model.addAttribute("bestMovies", bestMovies);
		return "Movies";
	}

	@GetMapping("/songs")
	public String songs(Model model) {
		List<Song> bestSongs = getBestSongs();
		model.addAttribute("bestSongs", bestSongs);
		return "Songs";
	}

	@GetMapping("/movies/{id}")
	public String movieId(Model model, @PathVariable int id) {
		List<Movie> bestMovies = getBestMovies();
		String movieTitle="";
		for(Movie movie : bestMovies) {
			if(movie.getId()==id) {
				movieTitle= movie.getTitle();
			}
		}
		model.addAttribute("movieId", id);
		model.addAttribute("movieTitle", movieTitle);
		return "MovieId";
	}
	
	@GetMapping("/songs/{id}")
	public String songId(Model model, @PathVariable int id) {
		List<Song> bestSongs = getBestSongs();
		String songTitle="";
		for(Song song : bestSongs) {
			if(song.getId()==id) {
				songTitle= song.getTitle();
			}
		}
		model.addAttribute("songId", id);
		model.addAttribute("songTitle", songTitle);
		return "SongId";
	}

	private List<Movie> getBestMovies() {
		List<Movie> movies = new ArrayList<>();
		movies.add(new Movie(1, "The Godfather"));
		movies.add(new Movie(2, "The Dark Knight"));
		movies.add(new Movie(3, "Forrest Gump"));
		return movies;
	}

	private List<Song> getBestSongs() {
		List<Song> songs = new ArrayList<>();
		songs.add(new Song(1, "Eminem - Mockin' Bird"));
		songs.add(new Song(2, "Post Malone Hollywood's Bleeding"));
		songs.add(new Song(3, "Brenan Ssavage - Scars"));
		return songs;
	}
}

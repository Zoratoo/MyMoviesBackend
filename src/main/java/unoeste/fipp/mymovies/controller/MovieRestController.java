package unoeste.fipp.mymovies.controller;

import org.springframework.web.bind.annotation.*;
import unoeste.fipp.mymovies.entity.Filme;
import unoeste.fipp.mymovies.repository.MovieRepository;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieRestController {
    private final MovieRepository movieRepository;

    public MovieRestController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/all")
    public List<Filme> getAllFilmes() {
        return movieRepository.findAll();
    }

    @GetMapping("/search")
    public List<Filme> searchFilmes(@RequestParam String title) {
        return movieRepository.searchByTitle(title);
    }

    @PostMapping("/add")
    public Filme addFilme(@RequestBody Filme filme) {
        return movieRepository.save(filme);
    }
}
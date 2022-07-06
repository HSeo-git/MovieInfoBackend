package com.example.moviehunterproject.dto;


import com.example.moviehunterproject.entity.MovieInfoResultEntity;
import lombok.*;

import javax.persistence.Id;

@Data
@Getter
@Setter
@ToString
public class MovieInfoGetDto {
    @Id
    private Long id;

    private String backdrop_path;
    private String first_air_date;
    private String name;
    private String original_language;
    private String original_name;
    private String overview;
    private Double popularity;
    private String poster_path;
    private Double vote_average;
    private Double vote_count;

    public MovieInfoGetDto(Long id, String backdrop_path, String first_air_date, String name, String original_language, String original_name, String overview, Double popularity, String poster_path, Double vote_average, Double vote_count) {
        this.id = id;
        this.backdrop_path = backdrop_path;
        this.first_air_date = first_air_date;
        this.name = name;
        this.original_language = original_language;
        this.original_name = original_name;
        this.overview = overview;
        this.popularity = popularity;
        this.poster_path = poster_path;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
    }

    public static MovieInfoGetDto create(MovieInfoResultEntity entity) {
        return new MovieInfoGetDto(
                entity.getId(),
                entity.getBackdrop_path(),
                entity.getFirst_air_date(),
                entity.getName(),
                entity.getOriginal_language(),
                entity.getOriginal_name(),
                entity.getOverview(),
                entity.getPopularity(),
                entity.getPoster_path(),
                entity.getVote_average(),
                entity.getVote_count()
        );
    };
}

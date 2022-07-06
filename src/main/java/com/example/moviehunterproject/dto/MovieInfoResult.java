package com.example.moviehunterproject.dto;

import lombok.*;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MovieInfoResult {

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
    private Double  vote_average;
    private Double vote_count;
    private Long[] genre_ids;
    private String[] origin_country;

}

package com.example.moviehunterproject.entity;


import com.example.moviehunterproject.dto.MovieInfoGetDto;
import com.example.moviehunterproject.dto.MovieInfoResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MovieInfoResultEntity {

    @Id
    private Long id;

    @Column
    private String backdrop_path;
    @Column
    private String first_air_date;
    @Column
    private String name;
    @Column
    private String original_language;
    @Column
    private String original_name;
    @Column
    private String overview;
    @Column
    private Double popularity;
    @Column
    private String poster_path;
    @Column
    private Double  vote_average;
    @Column
    private Double vote_count;

    public static MovieInfoResultEntity create(MovieInfoResult result) {
        String overviewResult = result.getOverview();
        if (overviewResult.length() > 10) {
            overviewResult = overviewResult.substring(0, 10);
        }
        return new MovieInfoResultEntity(
                result.getId(),
                result.getBackdrop_path(),
                result.getFirst_air_date(),
                result.getName(),
                result.getOriginal_language(),
                result.getOriginal_name(),
                overviewResult,
                result.getPopularity(),
                result.getPoster_path(),
                result.getVote_average(),
                result.getVote_count());
    }

    public MovieInfoGetDto toDto(){
        return MovieInfoGetDto.create(this);
    }


}

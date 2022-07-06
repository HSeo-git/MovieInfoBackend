package com.example.moviehunterproject.dto;

import com.example.moviehunterproject.entity.MovieInfoResultEntity;
import lombok.*;

import javax.persistence.Id;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MovieInfoDto {

    private Long page;
    private MovieInfoResult[] results;
    private Long total_pages;
    private Long total_results;

    public ArrayList<MovieInfoResultEntity> toEntities(MovieInfoResult[] results){
        ArrayList<MovieInfoResultEntity> movieInfoResultEntityArrayList = new ArrayList<MovieInfoResultEntity>(results.length);
        for (MovieInfoResult result : results) {
            movieInfoResultEntityArrayList.add(MovieInfoResultEntity.create(result));
        }
        return movieInfoResultEntityArrayList;
    };


}

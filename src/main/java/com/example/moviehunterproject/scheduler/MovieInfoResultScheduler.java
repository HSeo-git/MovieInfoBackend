package com.example.moviehunterproject.scheduler;

import com.example.moviehunterproject.dto.MovieInfoDto;
import com.example.moviehunterproject.entity.MovieInfoResultEntity;
import com.example.moviehunterproject.service.MovieInfoResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class MovieInfoResultScheduler {

    @Autowired
    private MovieInfoResultService movieInfoResultService;

    @Scheduled(cron = "0 0 21 * * MON") //execute at 21pm on every Monday
    public void saveSchedule(){
        MovieInfoDto movieInfoDto = movieInfoResultService.download(); //download the Dto(download the data from 3rd party API)
        ArrayList<MovieInfoResultEntity> resultList = movieInfoDto.toEntities(movieInfoDto.getResults()); //convert Dto into Entity to save the data in DB
        movieInfoResultService.save(resultList);
    }

}

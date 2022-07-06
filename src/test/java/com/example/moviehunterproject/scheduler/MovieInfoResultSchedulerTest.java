package com.example.moviehunterproject.scheduler;

import com.example.moviehunterproject.dto.MovieInfoDto;
import com.example.moviehunterproject.entity.MovieInfoResultEntity;
import com.example.moviehunterproject.repository.MovieInfoResultRepository;
import com.example.moviehunterproject.service.MovieInfoResultService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MovieInfoResultSchedulerTest {

    @Autowired
    MovieInfoResultScheduler movieInfoResultScheduler;

    @Autowired
    MovieInfoResultService movieInfoResultService;

    @Autowired
    MovieInfoResultRepository movieInfoResultRepository;

    @Test
    void toEntities() {
        MovieInfoDto movieInfoDto = movieInfoResultService.download();
        MovieInfoResultEntity movieInfoResultEntity = MovieInfoResultEntity.create(movieInfoDto.getResults()[0]);
        ArrayList<MovieInfoResultEntity> resultList = movieInfoDto.toEntities(movieInfoDto.getResults());

        assertEquals(resultList.get(0).getId(), movieInfoResultEntity.getId());
    }

    @Test
    void saveSchedule() {
        MovieInfoDto movieInfoDto = movieInfoResultService.download();
        ArrayList<MovieInfoResultEntity> resultList = movieInfoDto.toEntities(movieInfoDto.getResults());
        movieInfoResultService.save(resultList);
        Optional<MovieInfoResultEntity> optional = movieInfoResultRepository.findById(resultList.get(0).getId());
        MovieInfoResultEntity movieInfoResultEntity = optional.orElse(null);

        assert movieInfoResultEntity != null;
        assertEquals(movieInfoResultEntity.getName(), resultList.get(0).getName());
    }


}
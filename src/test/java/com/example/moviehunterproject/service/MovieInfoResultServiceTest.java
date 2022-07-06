package com.example.moviehunterproject.service;

import com.example.moviehunterproject.dto.MovieInfoDto;
import com.example.moviehunterproject.dto.MovieInfoGetDto;
import com.example.moviehunterproject.dto.MovieInfoResult;
import com.example.moviehunterproject.repository.MovieInfoResultRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MovieInfoResultServiceTest {

    @Autowired
    MovieInfoResultService movieInfoResultService;

    @Autowired
    MovieInfoResultRepository movieInfoResultRepository;

    @Test
    void create() {
        //http랑 통신해서 dto를 만들어줘요
        MovieInfoDto movieInfoResultDto = movieInfoResultService.download();
        //Dto에 원하는 정보가 들어왔는지 확인해요
        assertTrue(movieInfoResultDto.getResults().length > 5);
    }

    @Test
    void getAllInfoResponse() {
        ResponseEntity<ArrayList<MovieInfoGetDto>> responseEntity = movieInfoResultService.getAllInfoResponse();
        assertEquals(responseEntity.getBody().get(0).getId(), 63174L);
    }
}
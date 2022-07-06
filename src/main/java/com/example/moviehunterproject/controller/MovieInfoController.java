package com.example.moviehunterproject.controller;

import com.example.moviehunterproject.dto.MovieInfoGetDto;
import com.example.moviehunterproject.dto.MovieInfoResult;
import com.example.moviehunterproject.service.MovieInfoResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/discover")
public class MovieInfoController {

    @Autowired
    MovieInfoResultService movieInfoResultService;

    @RequestMapping(value = "netflix", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<MovieInfoGetDto>> getAllInfo() throws Throwable{
        return movieInfoResultService.getAllInfoResponse();
    }
}

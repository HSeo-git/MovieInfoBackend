package com.example.moviehunterproject.service;

import com.example.moviehunterproject.dto.MovieInfoDto;
import com.example.moviehunterproject.dto.MovieInfoGetDto;
import com.example.moviehunterproject.dto.MovieInfoResult;
import com.example.moviehunterproject.entity.MovieInfoResultEntity;
import com.example.moviehunterproject.repository.MovieInfoResultRepository;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;

@Slf4j
@Service
@RequiredArgsConstructor
public class MovieInfoResultService {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    MovieInfoResultRepository movieInfoResultRepository;

    public void save(ArrayList<MovieInfoResultEntity> resultList) {
        //save entities into DB with repository
        movieInfoResultRepository.saveAll(resultList);
    }

    public UriComponents getUriComponents() {
        String apiKey = "319cc19364b36f43cd8b66c6780b3690";
        String mediaId = "tv";
        return UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("api.themoviedb.org")
                .path("/3/discover/" + mediaId)
                .queryParam("api_key", apiKey)
                .queryParam("with_networks", "213")
                .build(true);
    }

    public MovieInfoDto download() {
        UriComponents uriComponents = getUriComponents();

        final HttpHeaders headers = new HttpHeaders();
        final HttpEntity<String> headerEntity = new HttpEntity<>(headers);

        return restTemplate.exchange(uriComponents.toUriString(), HttpMethod.GET, headerEntity, MovieInfoDto.class).getBody();
    }

    public ResponseEntity<ArrayList<MovieInfoGetDto>> getAllInfoResponse() {
        ArrayList<MovieInfoResultEntity> movieInfoResultEntityArrayList = movieInfoResultRepository.findAll();
        ArrayList<MovieInfoGetDto> movieInfoGetDtoArrayList = new ArrayList<MovieInfoGetDto>(movieInfoResultEntityArrayList.toArray().length);
        for (MovieInfoResultEntity entity: movieInfoResultEntityArrayList) {
            movieInfoGetDtoArrayList.add(entity.toDto());
        }
        return new ResponseEntity<>(movieInfoGetDtoArrayList, HttpStatus.OK);
    };
}

package com.example.moviehunterproject.repository;
import com.example.moviehunterproject.entity.MovieInfoResultEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface MovieInfoResultRepository extends CrudRepository<MovieInfoResultEntity, Long> {

    @Override
    ArrayList<MovieInfoResultEntity> findAll();

    @Override
    Optional<MovieInfoResultEntity> findById(Long id);

}

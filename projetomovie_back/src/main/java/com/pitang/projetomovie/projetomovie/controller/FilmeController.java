package com.pitang.projetomovie.projetomovie.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pitang.projetomovie.projetomovie.Infraestrutura.MovieService;
import com.pitang.projetomovie.projetomovie.models.*;
import com.pitang.projetomovie.projetomovie.repository.FilmeRepository;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeRepository filmeRepository;

    private MovieService movieService = new MovieService();

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAll(Pageable pageable){

        Page<Filme> filmePage = filmeRepository.findAll(pageable);
        return new ResponseEntity<>(filmePage, HttpStatus.OK);

    }



    @Transactional(rollbackFor = Exception.class)
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> postFilme(){

        return new ResponseEntity<>(filmeRepository.saveAll(movieService.salvar()),HttpStatus.ACCEPTED);

    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> putFilme(@RequestParam(name = "id",required = false) long id, Filme filme){

            return new ResponseEntity(filmeRepository.save(filme), HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteFilme(@RequestParam(name = "id", required = false) long id){

            filmeRepository.deleteById(id);

            return new ResponseEntity(filmeRepository.findAll(), HttpStatus.OK);

    }

    public FilmeRepository getFilmeRepository() {
        return filmeRepository;
    }

    public void setFilmeRepository(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }
}

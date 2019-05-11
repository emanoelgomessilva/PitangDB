package com.pitang.projetomovie.projetomovie.controller;

import com.pitang.projetomovie.projetomovie.models.Filme;
import com.pitang.projetomovie.projetomovie.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("/filmes2")
public class FilmeCotroller2 {


    @Autowired
    private FilmeRepository filmeRepository;

    @RequestMapping(value = "find/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getById(@PathVariable(value = "id") long id){

        Filme filme = filmeRepository.findById(id).get();
        return  new ResponseEntity<>(filme, HttpStatus.OK);

    }

    @RequestMapping(value = "findt/{titulo}",method = RequestMethod.GET)
    public ResponseEntity<?> getByTitle(@PathVariable(value = "titulo") String titulo){

        Filme filme = filmeRepository.findByTitulo(titulo).get();
        return  new ResponseEntity<>(filme, HttpStatus.OK);

    }

}

package com.pitang.projetomovie.projetomovie.controller;

import com.pitang.projetomovie.projetomovie.models.Filme;
import com.pitang.projetomovie.projetomovie.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/filmes2")
public class FilmeCotroller2 {

    @Autowired
    private FilmeRepository filmeRepository;

    @RequestMapping(value = "/find/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getById(@PathVariable(value = "id") long id){

        Filme filme = filmeRepository.findById(id).get();
        return  new ResponseEntity<>(filme, HttpStatus.OK);

    }

    @RequestMapping(value = "findt/{titulo}",method = RequestMethod.GET)
    public ResponseEntity<?> getByTitle(Pageable pageable, @PathVariable String titulo){

        Page<Filme> filme = filmeRepository.findByTituloContainingIgnoreCase(pageable,titulo);
        return  new ResponseEntity<>(filme, HttpStatus.OK);

    }

}

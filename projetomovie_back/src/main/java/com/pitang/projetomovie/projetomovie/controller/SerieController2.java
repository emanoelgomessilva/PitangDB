package com.pitang.projetomovie.projetomovie.controller;

import com.pitang.projetomovie.projetomovie.models.Serie;
import com.pitang.projetomovie.projetomovie.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/series2")
public class SerieController2 {

    @Autowired
    private SerieRepository serieRepository;

    @RequestMapping(value = "/find/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getById(@PathVariable(value = "id") long id){

        Serie serie = serieRepository.findById(id).get();
        return  new ResponseEntity<>(serie, HttpStatus.OK);

    }

    @RequestMapping(value = "findt/{titulo}",method = RequestMethod.GET)
    public ResponseEntity<?> getByTitle(Pageable pageable, @PathVariable String titulo){

        Page<Serie> serie = serieRepository.findByTituloContainingIgnoreCase(pageable,titulo);
        return  new ResponseEntity<>(serie, HttpStatus.OK);

    }

}

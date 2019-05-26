package com.pitang.projetomovie.projetomovie.controller;

import com.pitang.projetomovie.projetomovie.models.Pessoa;
import com.pitang.projetomovie.projetomovie.models.Serie;
import com.pitang.projetomovie.projetomovie.repository.PessoaRepository;
import com.pitang.projetomovie.projetomovie.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/pessoas2")
public class PessoaController2 {

    @Autowired
    private PessoaRepository pessoaRepository;

    @RequestMapping(value = "/find/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getById(@PathVariable(value = "id") long id){

        Pessoa pessoa = pessoaRepository.findById(id).get();
        return  new ResponseEntity<>(pessoa, HttpStatus.OK);

    }

    @RequestMapping(value = "findn/{nome}",method = RequestMethod.GET)
    public ResponseEntity<?> getByName(Pageable pageable, @PathVariable String nome){

        Page<Pessoa> pessoa = pessoaRepository.findByNomeContainingIgnoreCase(pageable,nome);
        return  new ResponseEntity<>(pessoa, HttpStatus.OK);

    }

}

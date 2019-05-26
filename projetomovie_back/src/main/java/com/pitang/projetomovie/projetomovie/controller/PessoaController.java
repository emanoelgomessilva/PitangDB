package com.pitang.projetomovie.projetomovie.controller;

import com.pitang.projetomovie.projetomovie.models.Pessoa;
import com.pitang.projetomovie.projetomovie.models.PessoaDTO;
import com.pitang.projetomovie.projetomovie.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAll(Pageable pageable){

        Page<Pessoa> pessoaPage = pessoaRepository.findAll(pageable);
        return new ResponseEntity<>(pessoaPage, HttpStatus.OK);

    }


    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> putPessoa(@RequestParam(name = "id",required = false) long id, PessoaDTO pessoa){

        Pessoa pessoaSave = pessoaRepository.findById(id).get();
        pessoaSave.setNome(pessoa.getName());
        pessoaSave.setPais(pessoa.getPlace_of_birth());

        return new ResponseEntity(pessoaRepository.save(pessoaSave), HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePessoa(@RequestParam(name = "id", required = false) long id){

        pessoaRepository.deleteById(id);

        return new ResponseEntity(pessoaRepository.findAll(), HttpStatus.OK);

    }

}

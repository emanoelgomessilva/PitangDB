package com.pitang.projetomovie.projetomovie.controller;

import com.pitang.projetomovie.projetomovie.Infraestrutura.MovieService;
import com.pitang.projetomovie.projetomovie.Infraestrutura.SerieService;
import com.pitang.projetomovie.projetomovie.models.Filme;
import com.pitang.projetomovie.projetomovie.models.Serie;
import com.pitang.projetomovie.projetomovie.models.SerieDTO;
import com.pitang.projetomovie.projetomovie.repository.FilmeRepository;
import com.pitang.projetomovie.projetomovie.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/series")
public class SerieController {

    @Autowired
    private SerieRepository serieRepository;

    private SerieService serieService = new SerieService();

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAll(Pageable pageable){

        Page<Serie> filmePage = serieRepository.findAll(pageable);
        return new ResponseEntity<>(filmePage, HttpStatus.OK);

    }

    @Transactional(rollbackFor = Exception.class)
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> postSerie(){

        return new ResponseEntity<>(serieRepository.saveAll(serieService.salvar()),HttpStatus.ACCEPTED);

    }

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public ResponseEntity<?> putSerie(@RequestParam(name = "id",required = false) long id, SerieDTO serie){

        Serie serieSave = serieRepository.findById(id).get();

        serieSave.setTitulo(serie.getName());
        serieSave.setDescricao(serie.getOverview());

        return new ResponseEntity(serieRepository.save(serieSave), HttpStatus.OK);

    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteSerie(@RequestParam(name = "id", required = false) long id){

        serieRepository.deleteById(id);

        return new ResponseEntity(serieRepository.findAll(), HttpStatus.OK);

    }

    public SerieRepository getSerieRepository() {
        return serieRepository;
    }

    public void setSerieRepository(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

}

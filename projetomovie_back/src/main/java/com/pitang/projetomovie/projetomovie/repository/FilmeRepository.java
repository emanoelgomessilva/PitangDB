package com.pitang.projetomovie.projetomovie.repository;

import com.pitang.projetomovie.projetomovie.models.Filme;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FilmeRepository extends JpaRepository<Filme,Long> {

    Page<Filme> findByTituloContainingIgnoreCase(Pageable page, String titulo);

}

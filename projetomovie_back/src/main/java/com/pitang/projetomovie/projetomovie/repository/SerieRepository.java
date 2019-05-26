package com.pitang.projetomovie.projetomovie.repository;

import com.pitang.projetomovie.projetomovie.models.Serie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SerieRepository extends JpaRepository<Serie,Long> {

    Page<Serie> findByTituloContainingIgnoreCase(Pageable page, String titulo);

}

package com.pitang.projetomovie.projetomovie.repository;

import com.pitang.projetomovie.projetomovie.models.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SerieRepository extends JpaRepository<Serie,Long> {

}

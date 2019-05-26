package com.pitang.projetomovie.projetomovie.repository;

import com.pitang.projetomovie.projetomovie.models.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa,Long> {

    Page<Pessoa> findByNomeContainingIgnoreCase(Pageable page, String nome);

}

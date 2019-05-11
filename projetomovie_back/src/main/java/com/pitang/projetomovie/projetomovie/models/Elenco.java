package com.pitang.projetomovie.projetomovie.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Elenco {

    private List<PessoaDTO> cast = new ArrayList<PessoaDTO>();

    public List<PessoaDTO> getCast() {
        return cast;
    }

    public void setCast(List<PessoaDTO> cast) {
        this.cast = cast;
    }
}

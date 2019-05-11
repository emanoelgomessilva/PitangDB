package com.pitang.projetomovie.projetomovie.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.URL;

import javax.persistence.Column;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmeDTO implements Serializable {

    private String backdrop_path;
    private long budget;
    private long id;
    private List<GeneroDTO> genres = new ArrayList<GeneroDTO>();
    private List<LocalDTO> production_countries = new ArrayList<LocalDTO>();
    private List<PessoaDTO> cast = new ArrayList<PessoaDTO>();
    private String original_language;
    private String overview;
    private Date release_date;
    private long runtime;
    private String title;

    public List<PessoaDTO> getCast() {
        return cast;
    }

    public void setCast(List<PessoaDTO> cast) {
        this.cast = cast;
    }

    public String isBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public long getBudget() {
        return budget;
    }

    public void setBudget(long budget) {
        this.budget = budget;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public List<GeneroDTO> getGenres() {
        return genres;
    }

    public void setGenres(List<GeneroDTO> genres) {
        this.genres = genres;
    }

    public List<LocalDTO> getProduction_countries() {
        return production_countries;
    }

    public void setProduction_countries(List<LocalDTO> production_countries) {
        this.production_countries = production_countries;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public long getRuntime() {
        return runtime;
    }

    public void setRuntime(long runtime) {
        this.runtime = runtime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "FilmeDto{" +
                "title='" + title + '\'' +
                ", backdrop_path=" + backdrop_path +'\''+
                ", id=" + id +'\''+
                ", budget=" + budget + '\'' +
                '}';
    }

}

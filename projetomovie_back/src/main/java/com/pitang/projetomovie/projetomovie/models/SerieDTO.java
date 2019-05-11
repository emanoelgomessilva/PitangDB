package com.pitang.projetomovie.projetomovie.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SerieDTO {

    private String name;
    private String backdrop_path;
    private long id;
    private List<GeneroDTO> genres = new ArrayList<GeneroDTO>();
    private List<String> origin_country = new ArrayList<String>();
    private List<String> languages = new ArrayList<String>();
    private String overview;
    private Date first_air_date;
    private List<Integer> episode_run_time = new ArrayList<Integer>();
    private List<TemporadaDTO> seasons = new ArrayList<TemporadaDTO>();
    private List<PessoaDTO> cast = new ArrayList<PessoaDTO>();

    public List<PessoaDTO> getCast() {
        return cast;
    }

    public void setCast(List<PessoaDTO> cast) {
        this.cast = cast;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<GeneroDTO> getGenres() {
        return genres;
    }

    public void setGenres(List<GeneroDTO> genres) {
        this.genres = genres;
    }

    public List<String> getOrigin_country() {
        return origin_country;
    }

    public void setOrigin_country(List<String> origin_country) {
        this.origin_country = origin_country;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Date getFirst_air_date() {
        return first_air_date;
    }

    public void setFirst_air_date(Date first_air_date) {
        this.first_air_date = first_air_date;
    }

    public List<Integer> getEpisode_run_time() {
        return episode_run_time;
    }

    public void setEpisode_run_time(List<Integer> episode_run_time) {
        this.episode_run_time = episode_run_time;
    }

    public List<TemporadaDTO> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<TemporadaDTO> seasons) {
        this.seasons = seasons;
    }
}

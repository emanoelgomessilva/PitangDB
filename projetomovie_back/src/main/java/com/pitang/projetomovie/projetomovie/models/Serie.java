package com.pitang.projetomovie.projetomovie.models;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_series")
public class Serie extends Programa {

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name="serie_has_temporadas", joinColumns=
            {@JoinColumn(name="serie_id")}, inverseJoinColumns=
            {@JoinColumn(name="temporada_id")})
    private List<Temporada> temporadas;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name="serie_has_idioma", joinColumns=
            {@JoinColumn(name="serie_id")}, inverseJoinColumns=
            {@JoinColumn(name="idioma_id")})
    private List<Idioma> idiomas;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name="serie_has_episodio_duracao", joinColumns=
            {@JoinColumn(name="serie_id")}, inverseJoinColumns=
            {@JoinColumn(name="episodio_duracao_id")})
    private List<EpisodioDuracao> episodioDuracao;

    public List<EpisodioDuracao> getEpisodioDuracao() {
        return episodioDuracao;
    }

    public void setEpisodioDuracao(List<EpisodioDuracao> episodioDuracao) {
        this.episodioDuracao = episodioDuracao;
    }

    public List<Temporada> getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(List<Temporada> temporadas) {
        this.temporadas = temporadas;
    }

    public List<Idioma> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<Idioma> idiomas) {
        this.idiomas = idiomas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Serie serie = (Serie) o;

        if (temporadas != null ? !temporadas.equals(serie.temporadas) : serie.temporadas != null) return false;
        if (idiomas != null ? !idiomas.equals(serie.idiomas) : serie.idiomas != null) return false;
        return episodioDuracao != null ? episodioDuracao.equals(serie.episodioDuracao) : serie.episodioDuracao == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (temporadas != null ? temporadas.hashCode() : 0);
        result = 31 * result + (idiomas != null ? idiomas.hashCode() : 0);
        result = 31 * result + (episodioDuracao != null ? episodioDuracao.hashCode() : 0);
        return result;
    }
}

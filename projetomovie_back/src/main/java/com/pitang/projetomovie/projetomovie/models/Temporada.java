package com.pitang.projetomovie.projetomovie.models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "tb_temporada")
public class Temporada implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "tp_cl_air_date")
    private String air_date;

    @Column(name = "tp_cl_episode_count")
    private long episode_count;

    @Column(name = "tp_cl_name")
    private String name;

    @Column(name = "tp_cl_season_number")
    private int season_number;

    @Column(name = "tp_cl_poster_path")
    private String poster_path;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAir_date() {
        return air_date;
    }

    public void setAir_date(String air_date) {
        this.air_date = air_date;
    }

    public long getEpisode_count() {
        return episode_count;
    }

    public void setEpisode_count(long episode_count) {
        this.episode_count = episode_count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeason_number() {
        return season_number;
    }

    public void setSeason_number(int season_number) {
        this.season_number = season_number;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Temporada temporada = (Temporada) o;

        if (id != temporada.id) return false;
        if (episode_count != temporada.episode_count) return false;
        if (season_number != temporada.season_number) return false;
        if (air_date != null ? !air_date.equals(temporada.air_date) : temporada.air_date != null) return false;
        if (name != null ? !name.equals(temporada.name) : temporada.name != null) return false;
        return poster_path != null ? poster_path.equals(temporada.poster_path) : temporada.poster_path == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (air_date != null ? air_date.hashCode() : 0);
        result = 31 * result + (int) (episode_count ^ (episode_count >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + season_number;
        result = 31 * result + (poster_path != null ? poster_path.hashCode() : 0);
        return result;
    }
}

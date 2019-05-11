package com.pitang.projetomovie.projetomovie.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_episodio_duracao")
public class EpisodioDuracao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "lc_cl_name")
    private long duracao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDuracao() {
        return duracao;
    }

    public void setDuracao(long duracao) {
        this.duracao = duracao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EpisodioDuracao that = (EpisodioDuracao) o;

        if (id != that.id) return false;
        return duracao == that.duracao;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (duracao ^ (duracao >>> 32));
        return result;
    }
}

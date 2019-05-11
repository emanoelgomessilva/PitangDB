package com.pitang.projetomovie.projetomovie.models;

import com.pitang.projetomovie.projetomovie.Infraestrutura.IObjectPersistent;

import javax.persistence.*;

@Entity
@Table(name="tb_filme_pessoa")
public class FilmePessoa implements IObjectPersistent<FilmePessoaPK> {

    @EmbeddedId
    private FilmePessoaPK filmePessoaPK;

    @MapsId("programaId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Programa programa;

    @MapsId("localId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Pessoa pessoa;

    public FilmePessoaPK getId() {
        return filmePessoaPK;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilmePessoa that = (FilmePessoa) o;

        if (filmePessoaPK != null ? !filmePessoaPK.equals(that.filmePessoaPK) : that.filmePessoaPK != null)
            return false;
        if (programa != null ? !programa.equals(that.programa) : that.programa != null) return false;
        return pessoa != null ? pessoa.equals(that.pessoa) : that.pessoa == null;
    }

}

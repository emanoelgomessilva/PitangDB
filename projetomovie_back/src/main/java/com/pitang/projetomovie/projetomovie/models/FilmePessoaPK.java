package com.pitang.projetomovie.projetomovie.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
public class FilmePessoaPK implements Serializable {

    @Column(name = "flp_cl_programa_id")
    private long programaId;

    @Column(name = "flp_cl_pessoa_id")
    private long pessoaId;

    public long getProgramaId() {
        return programaId;
    }

    public void setProgramaId(long programaId) {
        this.programaId = programaId;
    }

    public long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(long pessoaId) {
        this.pessoaId = pessoaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilmePessoaPK that = (FilmePessoaPK) o;

        if (programaId != that.programaId) return false;
        return pessoaId == that.pessoaId;
    }

    @Override
    public int hashCode() {
        int result = (int) (programaId ^ (programaId >>> 32));
        result = 31 * result + (int) (pessoaId ^ (pessoaId >>> 32));
        return result;
    }
}

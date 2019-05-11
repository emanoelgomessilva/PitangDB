package com.pitang.projetomovie.projetomovie.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_genero")
public class Genero implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "ge_cl_genero_id")
    private long genero_id;

    @Column(name = "ge_cl_name")
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getGenero_id() {
        return genero_id;
    }

    public void setGenero_id(long genero_id) {
        this.genero_id = genero_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Genero genero = (Genero) o;

        if (id != genero.id) return false;
        if (genero_id != genero.genero_id) return false;
        return name != null ? name.equals(genero.name) : genero.name == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (genero_id ^ (genero_id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}

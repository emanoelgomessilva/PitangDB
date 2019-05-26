package com.pitang.projetomovie.projetomovie.models;

import com.pitang.projetomovie.projetomovie.Infraestrutura.IObjectPersistent;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Programa implements IObjectPersistent<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "backdrop")
    private String backdrop;

    @Column(name = "pr_cl_titulo")
    private String titulo;

    @Size(min = 0,max = 5000)
    @Column(name = "pr_cl_descricao")
    private String descricao;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name="programa_has_pais", joinColumns=
            {@JoinColumn(name="programa_id")}, inverseJoinColumns=
            {@JoinColumn(name="local_id")})
    private List<Local> pais;

    @Column(name = "pr_cl_lingua")
    private String lingua;

    @Column(name = "pr_cl_ano")
    private Date ano;

    @Column(name = "pr_cl_duracao")
    private long duracao;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name="programa_has_generos", joinColumns=
            {@JoinColumn(name="programa_id")}, inverseJoinColumns=
            {@JoinColumn(name="genero_id")})
    private List<Genero> generos;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name="programa_has_pessoas", joinColumns=
            {@JoinColumn(name="programa_id")}, inverseJoinColumns=
            {@JoinColumn(name="pessoa_id")})
    private List<Pessoa> pessoas;

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Local> getPais() {
        return pais;
    }

    public void setPais(List<Local> pais) {
        this.pais = pais;
    }

    public String getLingua() {
        return lingua;
    }

    public void setLingua(String lingua) {
        this.lingua = lingua;
    }

    public Date getAno() {
        return ano;
    }

    public void setAno(Date ano) {
        this.ano = ano;
    }

    public long getDuracao() {
        return duracao;
    }

    public void setDuracao(long duracao) {
        this.duracao = duracao;
    }

    public String getBackdrop() {
        return backdrop;
    }

    public void setBackdrop(String backdrop) {
        this.backdrop = backdrop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Programa programa = (Programa) o;

        if (id != programa.id) return false;
        if (duracao != programa.duracao) return false;
        if (backdrop != null ? !backdrop.equals(programa.backdrop) : programa.backdrop != null) return false;
        if (titulo != null ? !titulo.equals(programa.titulo) : programa.titulo != null) return false;
        if (descricao != null ? !descricao.equals(programa.descricao) : programa.descricao != null) return false;
        if (pais != null ? !pais.equals(programa.pais) : programa.pais != null) return false;
        if (lingua != null ? !lingua.equals(programa.lingua) : programa.lingua != null) return false;
        if (ano != null ? !ano.equals(programa.ano) : programa.ano != null) return false;
        if (generos != null ? !generos.equals(programa.generos) : programa.generos != null) return false;
        return pessoas != null ? pessoas.equals(programa.pessoas) : programa.pessoas == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (backdrop != null ? backdrop.hashCode() : 0);
        result = 31 * result + (titulo != null ? titulo.hashCode() : 0);
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (pais != null ? pais.hashCode() : 0);
        result = 31 * result + (lingua != null ? lingua.hashCode() : 0);
        result = 31 * result + (ano != null ? ano.hashCode() : 0);
        result = 31 * result + (int) (duracao ^ (duracao >>> 32));
        result = 31 * result + (generos != null ? generos.hashCode() : 0);
        result = 31 * result + (pessoas != null ? pessoas.hashCode() : 0);
        return result;
    }
}

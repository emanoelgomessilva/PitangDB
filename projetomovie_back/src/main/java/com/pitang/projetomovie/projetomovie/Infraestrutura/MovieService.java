package com.pitang.projetomovie.projetomovie.Infraestrutura;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.pitang.projetomovie.projetomovie.models.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class MovieService {

    List<Filme> filmes = new ArrayList<Filme>();

    public List<Filme> salvar()

    {

        List<String> filmesids = Arrays.asList("299534", "299537", "456740", "537915", "299536", "287947",
                "438650", "99861", "495925", "24428", "450465", "445629",
                "535167", "284054", "543103", "284053", "576393", "920",
                "166428", "329996", "487297", "485811", "447404", "283995",
                "324857");

        List<FilmeDTO> filmeDTO = new ArrayList<>();

        for (String i : filmesids) {

            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String id = i;
            String url = "https://api.themoviedb.org/3/movie/{id}?api_key=1e2275a4e15b7a25e2696092a41cfa1e";
            String url1 = "https://api.themoviedb.org/3/movie/{id}/credits?api_key=1e2275a4e15b7a25e2696092a41cfa1e";

            RestTemplate restTemplateFilme = new RestTemplate();
            RestTemplate restTemplateFilme1 = new RestTemplate();
            ObjectMapper mapperFilme = new ObjectMapper();
            ObjectMapper mapperFilme1 = new ObjectMapper();

            String retornoFilme = restTemplateFilme.getForObject(url, String.class, id);
            String retornoFilme1 = restTemplateFilme1.getForObject(url1, String.class, id);
            FilmeDTO mapeamentoFilme;
            Elenco elencoFilme = new Elenco();

            {
                try {
                    mapeamentoFilme = mapperFilme.readValue(retornoFilme, FilmeDTO.class);
                    elencoFilme = mapperFilme1.readValue(retornoFilme1, Elenco.class);
                    mapeamentoFilme.setCast(elencoFilme.getCast());
                    filmeDTO.add(mapeamentoFilme);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        for (FilmeDTO filme : filmeDTO) {

            Filme filmeSave = new Filme();
            filmeSave.setTitulo(filme.getTitle());
            filmeSave.setDescricao(filme.getOverview());
            filmeSave.setAno(filme.getRelease_date());
            filmeSave.setLingua(filme.getOriginal_language());
            filmeSave.setDuracao(filme.getRuntime());
            filmeSave.setBackdrop(filme.getBackdrop_path());

            List<Pessoa> pessoas = new ArrayList<Pessoa>();

            for (PessoaDTO pessoaDTO : filme.getCast()) {

                Pessoa pessoa = new Pessoa();
                pessoa.setNome(pessoaDTO.getName());
                pessoa.setAltura("1,80");
                pessoa.setGenero(pessoaDTO.getGender());
                pessoa.setPais("us");
                pessoa.setBackdrop(pessoaDTO.getProfile_path());

                pessoas.add(pessoa);

            }

            filmeSave.setPessoas(pessoas);

            List<Genero> generos = new ArrayList<Genero>();

            for (GeneroDTO generoDTO : filme.getGenres()) {

                Genero genero = new Genero();
                genero.setName(generoDTO.getName());
                genero.setGenero_id(generoDTO.getId());

                generos.add(genero);

            }

            filmeSave.setGeneros(generos);

            List<Local> locals = new ArrayList<Local>();

            for (LocalDTO localDTO : filme.getProduction_countries()) {

                Local local = new Local();
                local.setName(localDTO.getName());
                locals.add(local);

            }

            filmeSave.setPais(locals);
            filmes.add(filmeSave);

        }

        return filmes;

    }

}



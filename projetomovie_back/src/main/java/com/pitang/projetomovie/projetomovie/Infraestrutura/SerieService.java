package com.pitang.projetomovie.projetomovie.Infraestrutura;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pitang.projetomovie.projetomovie.models.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class SerieService {

    List<Serie> series = new ArrayList<Serie>();

    public List<Serie> salvar()

    {

        List<String> seriesids = Arrays.asList("1399", "63926", "60735", "1412", "46261", "69050", "12609",
                "31910", "1416", "46952", "1622", "1434", "456", "62688", "63174",
                "88052", "48866", "4614", "86816", "17610", "86836", "17610",
                "85844", "1403", "54155");

        List<SerieDTO> serieDTO = new ArrayList<>();

        for (String i : seriesids) {

            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String id = i;
            String url = "https://api.themoviedb.org/3/tv/{id}?api_key=1e2275a4e15b7a25e2696092a41cfa1e";
            String url1 = "https://api.themoviedb.org/3/tv/{id}/credits?api_key=1e2275a4e15b7a25e2696092a41cfa1e";

            RestTemplate restTemplateSerie = new RestTemplate();
            RestTemplate restTemplateSerie1 = new RestTemplate();
            ObjectMapper mapperSerie = new ObjectMapper();
            ObjectMapper mapperSerie1 = new ObjectMapper();

            String retornoSerie = restTemplateSerie.getForObject(url, String.class, id);
            String retornoSerie1 = restTemplateSerie1.getForObject(url1, String.class, id);
            SerieDTO mapeamentoSerie;
            Elenco elencoSerie = new Elenco();

            {
                try {
                    mapeamentoSerie = mapperSerie.readValue(retornoSerie, SerieDTO.class);
                    elencoSerie = mapperSerie1.readValue(retornoSerie1, Elenco.class);
                    mapeamentoSerie.setCast(elencoSerie.getCast());
                    serieDTO.add(mapeamentoSerie);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        for (SerieDTO serie : serieDTO) {

            Serie serieSave = new Serie();
            serieSave.setTitulo(serie.getName());
            if(!serie.getOverview().equals(null)) {
                serieSave.setDescricao(serie.getOverview());
            }else{
                serieSave.setDescricao("Default");
            }
            serieSave.setAno(serie.getFirst_air_date());

            List<Pessoa> pessoas = new ArrayList<Pessoa>();

            for (PessoaDTO pessoaDTO : serie.getCast()) {

                Pessoa pessoa = new Pessoa();
                pessoa.setNome(pessoaDTO.getName());
                pessoa.setAltura("1,80");
                pessoa.setGenero(pessoaDTO.getGender());
                pessoa.setPais("us");

                pessoas.add(pessoa);

            }

            serieSave.setPessoas(pessoas);

            List<Temporada> temporadas = new ArrayList<Temporada>();

            for (TemporadaDTO temporadaDTO : serie.getSeasons()) {

                Temporada temporada = new Temporada();
                temporada.setAir_date(temporadaDTO.getAir_date());
                temporada.setEpisode_count(temporadaDTO.getEpisode_count());
                temporada.setName(temporadaDTO.getName());
                temporada.setPoster_path(temporadaDTO.getPoster_path());
                temporada.setSeason_number(temporadaDTO.getSeason_number());

                temporadas.add(temporada);

            }

            serieSave.setTemporadas(temporadas);

            List<Genero> generos = new ArrayList<Genero>();

            for (GeneroDTO generoDTO : serie.getGenres()) {

                Genero genero = new Genero();
                genero.setName(generoDTO.getName());
                genero.setGenero_id(generoDTO.getId());

                generos.add(genero);

            }

            serieSave.setGeneros(generos);

            List<Local> locals = new ArrayList<Local>();

            for (String localDTO : serie.getOrigin_country()) {

                Local local = new Local();
                local.setName(localDTO);
                locals.add(local);

            }

            serieSave.setPais(locals);

            List<EpisodioDuracao> episodioDuracaos = new ArrayList<EpisodioDuracao>();

            for (long duracao : serie.getEpisode_run_time()) {

                EpisodioDuracao episodioDuracao = new EpisodioDuracao();
                episodioDuracao.setDuracao(duracao);
                episodioDuracaos.add(episodioDuracao);

            }

            serieSave.setEpisodioDuracao(episodioDuracaos);

            List<Idioma> idiomas = new ArrayList<Idioma>();

            for (String idioma : serie.getLanguages()) {

                Idioma idioma1 = new Idioma();
                idioma1.setName(idioma);
                idiomas.add(idioma1);

            }

            serieSave.setIdiomas(idiomas);

            series.add(serieSave);

        }

        return series;

    }

}

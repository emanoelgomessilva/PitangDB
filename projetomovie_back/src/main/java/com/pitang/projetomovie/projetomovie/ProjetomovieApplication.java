package com.pitang.projetomovie.projetomovie;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pitang.projetomovie.projetomovie.Infraestrutura.MovieService;
import com.pitang.projetomovie.projetomovie.controller.FilmeController;
import com.pitang.projetomovie.projetomovie.models.*;
import com.pitang.projetomovie.projetomovie.repository.FilmeRepository;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.TimeUnit;


@SpringBootApplication
public class ProjetomovieApplication {

	public static void main(String[] args) {
        SpringApplication.run(ProjetomovieApplication.class, args);
    }
}

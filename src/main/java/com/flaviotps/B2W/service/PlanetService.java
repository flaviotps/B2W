package com.flaviotps.B2W.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flaviotps.B2W.model.PlanetModel;
import com.flaviotps.B2W.model.SwApiResponse;
import com.flaviotps.B2W.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class PlanetService {


    @Autowired
    PlanetRepository planetRepository;


    public List<PlanetModel> findAll() {
        List<PlanetModel> planets = (List<PlanetModel>) planetRepository.findAll();
        for (PlanetModel p : planets) {
            p.setAparicoes(String.valueOf(getAparicoes(p.getNome())));
        }

        return planets;
    }

    public void save(PlanetModel planetModel) {
        planetRepository.save(planetModel);
    }

    public PlanetModel findById(String id) {
        PlanetModel planetModel = planetRepository.findById(id).get();
        planetModel.setAparicoes(String.valueOf(getAparicoes(planetModel.getNome())));
        return planetModel;
    }

    public PlanetModel findByNome(String nome) {
        PlanetModel planetModel = planetRepository.findByNome(nome);
        planetModel.setAparicoes(String.valueOf(getAparicoes(nome)));
        return planetModel;
    }

    public void deleteById(String id) {
        planetRepository.deleteById(id);
    }

    public int getAparicoes(String name) {


        String rootEndPoint = "https://swapi.co/api/planets/?search=" + name;

        RestTemplate rt = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);


        ResponseEntity<String> res = rt.exchange(rootEndPoint, HttpMethod.GET, entity, String.class);

        ObjectMapper objectMapper = new ObjectMapper();

        SwApiResponse response = null;


        try {
            response = objectMapper.readValue(res.getBody(), SwApiResponse.class);
            if (response != null && response.getResults() != null && response.getResults().size() > 0) {
                return response.getResults().get(0).getFilms().size();
            } else return 0;

        } catch (IOException e) {

            e.printStackTrace();
            return 0;
        }


    }

}

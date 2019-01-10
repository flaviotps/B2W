package com.flaviotps.B2W.controller;

import com.flaviotps.B2W.Util.Constants;
import com.flaviotps.B2W.model.PlanetModel;
import com.flaviotps.B2W.service.PlanetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Api(value = "API REST - PLANETAS")
public class PlanetController {

    @Autowired
    PlanetService planetService;

    @ApiOperation(value = Constants.LIST_ALL)
    @GetMapping(value = {"/", "/planets"})
    @ResponseStatus(HttpStatus.OK)
    public List<PlanetModel> getAllPlanets() {
        return planetService.findAll();
    }


    @ApiOperation(value = Constants.LIST_BY_ID)
    @GetMapping("/planets/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PlanetModel getPlanetById(@PathVariable("id") String id) {
        return planetService.findById(id);
    }

    @ApiOperation(value = Constants.LIST_BY_NAME)
    @GetMapping("/planets/find/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public PlanetModel getPlanetByName(@PathVariable("nome") String nome) {
        return planetService.findByNome(nome);

    }

    @ApiOperation(value = Constants.CREATE)
    @PostMapping("/planets")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPlanet(@RequestBody PlanetModel planetModel) {
        planetService.save(planetModel);
    }

    @ApiOperation(value = Constants.UPDATE)
    @PutMapping("/planets")
    @ResponseStatus(HttpStatus.OK)
    public void updatePlanet(@RequestBody PlanetModel planetModel) {
        planetService.save(planetModel);
    }

    @ApiOperation(value = Constants.DELETE)
    @DeleteMapping("/planets/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePlanetById(@PathVariable("id") String id) {
        planetService.deleteById(id);
    }


}

package com.flaviotps.B2W.repository;


import com.flaviotps.B2W.model.PlanetModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends MongoRepository<PlanetModel, String> {
    PlanetModel findByNome(String name);

}

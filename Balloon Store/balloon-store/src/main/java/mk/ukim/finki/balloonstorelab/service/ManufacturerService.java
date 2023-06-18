package mk.ukim.finki.balloonstorelab.service;

import mk.ukim.finki.balloonstorelab.model.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface ManufacturerService {

    List<Manufacturer> findAll();

   Optional<Manufacturer> findById(Long manufacturerId);

}

package mk.ukim.finki.balloonstorelab.service;

import mk.ukim.finki.balloonstorelab.model.Balloon;

import java.util.List;
import java.util.Optional;

public interface BalloonService {

    List<Balloon> listAll();

    List<Balloon> searchByNameOrDescription(String text);

    Balloon saveBallon(String name, String description, Long manufacturerId);

    void deleteById(Long id);

    Optional<Balloon> findById(Long id);
}

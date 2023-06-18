package mk.ukim.finki.balloonstorelab.service.impl;

import mk.ukim.finki.balloonstorelab.model.Balloon;
import mk.ukim.finki.balloonstorelab.model.Manufacturer;
import mk.ukim.finki.balloonstorelab.repository.BalloonRepository;
import mk.ukim.finki.balloonstorelab.repository.ManufacturerRepository;
import mk.ukim.finki.balloonstorelab.service.BalloonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BalloonServiceImpl implements BalloonService {
    private final ManufacturerRepository manufacturerRepository;

    private final BalloonRepository balloonRepository;

    public BalloonServiceImpl(ManufacturerRepository manufacturerRepository, BalloonRepository balloonRepository) {
        this.manufacturerRepository = manufacturerRepository;
        this.balloonRepository = balloonRepository;
    }

    @Override
    public List<Balloon> listAll() {
        return balloonRepository.findAllBalloons();
    }

    @Override
    public List<Balloon> searchByNameOrDescription(String text) {
        return balloonRepository.findAllByNameOrDescription(text);
    }

    @Override
    public Balloon saveBallon(String name, String description, Long manufacturerId) {
        if (name == null || name.isEmpty() || description == null || description.isEmpty() && manufacturerId == null){
            return null;
        }
        if (this.manufacturerRepository.findById(manufacturerId) == null){
            return null;
        }
        Manufacturer manufacturer = this.manufacturerRepository.findById(manufacturerId).get();
        Balloon balloon = new Balloon(name,description,manufacturer);
        return this.balloonRepository.save(balloon);



    }

    @Override
    public void deleteById(Long id) {
        this.balloonRepository.deleteById(id);
    }

    @Override
    public Optional<Balloon> findById(Long id) {
        return this.balloonRepository.findById(id);
    }


}

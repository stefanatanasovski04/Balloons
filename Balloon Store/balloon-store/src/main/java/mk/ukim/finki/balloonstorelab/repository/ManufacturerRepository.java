package mk.ukim.finki.balloonstorelab.repository;

import mk.ukim.finki.balloonstorelab.model.Manufacturer;
import mk.ukim.finki.balloonstorelab.bootstrap.DataHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ManufacturerRepository {

    public List<Manufacturer> findAll(){
        return DataHolder.manufacturerList;
    }

    public Optional<Manufacturer> findById(Long id){
        return DataHolder.manufacturerList.stream().filter(i->i.getId().equals(id)).findFirst();
    }
}

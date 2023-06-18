package mk.ukim.finki.balloonstorelab.repository;

import mk.ukim.finki.balloonstorelab.model.Balloon;
import mk.ukim.finki.balloonstorelab.bootstrap.DataHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class BalloonRepository {

    public List<Balloon> findAllBalloons(){
        return DataHolder.balloonList;
    }

    public List<Balloon> findAllByNameOrDescription(String text){
        return DataHolder.balloonList.stream().filter(i->
                i.getName().contains(text) || i.getDescription().contains(text))
                .collect(Collectors.toList());
    }

    public Balloon save(Balloon b){
        if (b == null || b.getName() == null || b.getName().isEmpty()){
            return null;
        }
        DataHolder.balloonList.removeIf(i->i.getName().equals(b.getName()));
        DataHolder.balloonList.add(b);
        return b;
    }

    public void deleteById(Long id){
        DataHolder.balloonList.removeIf(i -> i.getId().equals(id));
    }

    public Optional<Balloon> findById(Long id){
        return DataHolder.balloonList.stream().filter(i-> i.getId().equals(id)).findFirst();
    }

}

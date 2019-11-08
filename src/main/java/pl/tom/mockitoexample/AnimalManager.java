package pl.tom.mockitoexample;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalManager {

    private AnimalRepo animalRepo;

    public AnimalManager(AnimalRepo animalRepo) {
        this.animalRepo = animalRepo;
    }

    public List<Animal> getAnimals(){
        List<Animal> list = new ArrayList<>();
        animalRepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    public Animal addAnimal(Animal animal){
        return animalRepo.save(animal);
    }

    @EventListener(ApplicationReadyEvent.class) // uruchominie metody po starcie aplikacji
    public void fillDB() {
        addAnimal(new Animal("cat"));
        addAnimal(new Animal("dog"));
    }
}

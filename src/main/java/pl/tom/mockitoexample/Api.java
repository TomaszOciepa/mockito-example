package pl.tom.mockitoexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
public class Api {

    private AnimalManager animalManager;

    @Autowired
    public Api(AnimalManager animalManager) {
        this.animalManager = animalManager;
    }

    @GetMapping("/animals")
    public Iterable<Animal> getAnimals(){
        return animalManager.getAnimals();
    }

    @PostMapping("/animals")
    public void addAnimals(@RequestBody Animal animal){
        animalManager.addAnimal(animal);
    }
}

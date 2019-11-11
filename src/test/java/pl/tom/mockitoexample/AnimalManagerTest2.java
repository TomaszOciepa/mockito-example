package pl.tom.mockitoexample;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class AnimalManagerTest2 {

    @Mock
    AnimalRepo animalRepo;

    @InjectMocks
    AnimalManager animalManager;

    @Before
    public void init(){
        given(animalRepo.findAll()).willReturn(prepareMockData());
    }

    @Test
    public void getAnimals() {
        //when
        List<Animal> animals = animalManager.getAnimals();
        //then
        Assert.assertThat(animals, Matchers.hasSize(3));
    }

    private List<Animal> prepareMockData() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("cat"));
        animals.add(new Animal("dog"));
        animals.add(new Animal("monkey"));
        return animals;
    }
}
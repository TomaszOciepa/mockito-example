package pl.tom.mockitoexample;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AnimalManagerTest {

    @Test
    public void getAnimals() {
        //given
        AnimalManager animalManager = mock(AnimalManager.class);
        when(animalManager.getAnimals()).thenReturn(prepareMockData());
        //when
        List<Animal> animals = animalManager.getAnimals();
        //then
        Assert.assertThat(animals, Matchers.hasSize(3));
    }

    //BDD
    @Test
    public void getAnimals_withBDD() {
        //given
        AnimalManager animalManager = mock(AnimalManager.class);
        given(animalManager.getAnimals()).willReturn(prepareMockData());
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

    @Test
    public void addAnimal() {
        //given
        AnimalManager animalManager = mock(AnimalManager.class);
        given(animalManager.addAnimal(Mockito.any(Animal.class))).willReturn(new Animal("dog"));
        //when
        Animal animal = animalManager.addAnimal(new Animal());
        //then
        Assert.assertEquals(animal.getName(), "dog");
    }
}
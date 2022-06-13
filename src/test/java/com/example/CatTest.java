package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    private Cat cat;

    @Mock
    Feline feline;

    @Before
    public void getCat() {
        this.cat = new Cat(feline);
    }

    @Test
    public void getSoundReturnsMeow() {
        assertEquals("Должен возвращать Мяу","Мяу",cat.getSound());
    }

    @Test
    public void whenCatGetFoodThenFelineEatMeat() throws Exception {
        cat.getFood();
        Mockito.verify(feline).eatMeat();
    }
}
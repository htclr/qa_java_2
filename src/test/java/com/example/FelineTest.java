package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {

    Feline feline = new Feline();

    @Test
    public void eatMeatShouldReturnMeatList() throws Exception {
        assertEquals("Должен есть мясо",List.of("Животные", "Птицы", "Рыба"),feline.eatMeat());
    }

    @Test
    public void getFamilyShouldReturnCat() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensWithoutParametersSholudReturnOne() {
        assertEquals("По умолчанию должен быть 1",1,feline.getKittens());
    }

    @Test
    public void getFiveKittensShouldReturnFive() {
        assertEquals("Должно быть 5",5,feline.getKittens(5));
    }
}
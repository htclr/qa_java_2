package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class LionTest {
    private final String sex;
    private final boolean hasMane;
    private final Feline feline;

    public LionTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
        this.feline = Mockito.mock(Feline.class);
    }
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                { "Самец", true},
                { "Самка", false}
        };
    }

    @Test
    public void whenLionGetKittensThenFelineGetKittens() throws Exception {
        Lion lion = new Lion("Самка", feline);
        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void doesHaveManeDependsOnSex() throws Exception {
        Lion lion = new Lion(sex, feline);
        assertEquals(hasMane, lion.doesHaveMane());
    }

    @Test
    public void lionWithInvalidSexThrowsException(){
        try {
            Lion lion = new Lion("Ошибка", feline);
            assertTrue("Ожидаемого исключения при создании льва с несуществующим полом не произошло", false);
        } catch (Exception exception){
            assertEquals("Используйте допустимые значения пола животного - самец или самка",exception.getMessage());
        }
    }

    @Test
    public void lionGetFoodShouldPassPredatorToFelineGetFood() throws Exception {
        Lion lion = new Lion("Самка", feline);
        lion.getFood();
        Mockito.verify(feline).getFood("Хищник");
    }
}
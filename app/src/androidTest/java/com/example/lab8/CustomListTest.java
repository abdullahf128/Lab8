package com.example.lab8;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;


    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }
}

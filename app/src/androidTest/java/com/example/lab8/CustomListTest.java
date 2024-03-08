package com.example.lab8;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.content.Context;

import androidx.test.InstrumentationRegistry;
import androidx.test.core.app.ApplicationProvider;

import org.junit.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    public CustomList MockCityList(){
        Context context = ApplicationProvider.getApplicationContext(); // Use a mock context
        list = new CustomList(context, new ArrayList<>());
        return list;

    }

    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    public void hasCityTest() {
        list = MockCityList();

        City cityToAdd = new City("SampleCity", "SampleProvince");
        list.addCity(cityToAdd);

        assertTrue(list.hasCity("SampleCity"));
        assertFalse(list.hasCity("NonExistentCity"));

    }

    @Test
    public void deleteCityTest() {
        list = MockCityList();

        City cityToDelete = new City("ToDeleteCity", "ToDeleteProvince");
        list.addCity(cityToDelete);

        assertTrue(list.hasCity("ToDeleteCity"));

        list.deleteCity("ToDeleteCity");

        assertFalse(list.hasCity("ToDeleteCity"));

        assertEquals(0, list.getCount());
    }


    @Test
    public void countCitiesTest() {
        list = MockCityList();

        list.addCity(new City("City1", "Province1"));
        list.addCity(new City("City2", "Province2"));
        list.addCity(new City("City3", "Province3"));

        assertEquals(3, list.countCities());
    }

    

}

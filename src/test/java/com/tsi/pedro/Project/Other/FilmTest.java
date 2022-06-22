package com.tsi.pedro.Project.Other;

import com.tsi.pedro.Project.Film;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmTest {

    @Test
    public void testGetFilm(){
        Film testFilm = new Film("title","description" ,2006 ,0.54 ,86 ,20.99 , "PG", "deleted");
        testFilm.setFilm_id(1);
        Assertions.assertEquals(1, testFilm.getFilm_id(), "id not found.");
    }
    @Test
    public void testSetFilm_id(){
        Film testFilm = new Film("title","description" ,2006 ,0.54 ,86 ,20.99 , "PG", "deleted");
        testFilm.setFilm_id(1);
        Assertions.assertEquals(1, testFilm.getFilm_id(), "id not set.");
    }
    @Test
    public void testGetTitle(){
        Film testFilm = new Film("title","description" ,2006 ,0.54 ,86 ,20.99 , "PG", "deleted");
        Assertions.assertEquals("title", testFilm.getTitle(), "title not found.");
    }
    @Test
    public void testSetTitle(){
        Film testFilm = new Film("title","description" ,2006 ,0.54 ,86 ,20.99 , "PG", "deleted");
        testFilm.setTitle("testfilm");
        Assertions.assertEquals("testfilm", testFilm.getTitle(), "title not set.");
    }
    @Test
    public void testGetDesc(){
        Film testFilm = new Film("title","description" ,2006 ,0.54 ,86 ,20.99 , "PG", "deleted");
        Assertions.assertEquals("description", testFilm.getDescription(), "desc not found.");
    }
    @Test
    public void testSetDesc(){
        Film testFilm = new Film("title","description" ,2006 ,0.54 ,86 ,20.99 , "PG", "deleted");
        testFilm.setDescription("descriptiontest");
        Assertions.assertEquals("descriptiontest", testFilm.getDescription(), "desc not set.");
}
    @Test
    public void testGetRelease(){
        Film testFilm = new Film("title","description" ,2006 ,0.54 ,86 ,20.99 , "PG", "deleted");
        Assertions.assertEquals(2006, testFilm.getRelease_year(), "release year not found.");
    }
    @Test
    public void testSetRelease(){
        Film testFilm = new Film("title","description" ,2006 ,0.54 ,86 ,20.99 , "PG", "deleted");
        testFilm.setRelease_year(2009);
        Assertions.assertEquals(2009, testFilm.getRelease_year(), "release year not set.");
    }

    @Test
    public void testGetRentalRate(){
        Film testFilm = new Film("title","description" ,2006 ,0.54 ,86 ,20.99 , "PG", "deleted");
        Assertions.assertEquals(0.54, testFilm.getRental_rate(), "rental price not found.");
    }
    @Test
    public void testSetRentalRate(){
        Film testFilm = new Film("title","description" ,2006 ,0.54 ,86 ,20.99 , "PG", "deleted");
        testFilm.setRental_rate(0.99);
        Assertions.assertEquals(0.99, testFilm.getRental_rate(), "rental rate not set.");
    }
    @Test
    public void testGetLength(){
        Film testFilm = new Film("title","description" ,2006 ,0.54 ,86 ,20.99 , "PG", "deleted");
        Assertions.assertEquals(86, testFilm.getLength(), "length not found.");
    }
    @Test
    public void testSetLength(){
        Film testFilm = new Film("title","description" ,2006 ,0.54 ,86 ,20.99 , "PG", "deleted");
        testFilm.setLength(90);
        Assertions.assertEquals(90, testFilm.getLength(), "length not set.");
    }

    @Test
    public void testGetReplaceCost(){
        Film testFilm = new Film("title","description" ,2006 ,0.54 ,86 ,20.99 , "PG", "deleted");
        Assertions.assertEquals(20.99, testFilm.getReplacement_cost(), "replacement cost not found.");
    }
    @Test
    public void testSetReplaceCost(){
        Film testFilm = new Film("title","description" ,2006 ,0.54 ,86 ,20.99 , "PG", "deleted");
        testFilm.setReplacement_cost(21.21);
        Assertions.assertEquals(21.21, testFilm.getReplacement_cost(), "replacement cost not set.");
    }
    @Test
    public void testGetRating(){
        Film testFilm = new Film("title","description" ,2006 ,0.54 ,86 ,20.99 , "PG", "deleted");
        Assertions.assertEquals("PG", testFilm.getRating(), "rating not found.");
    }
    @Test
    public void testSetRating(){
        Film testFilm = new Film("title","description" ,2006 ,0.54 ,86 ,20.99 , "PG", "deleted");
        testFilm.setRating("PG13");
        Assertions.assertEquals("PG13", testFilm.getRating(), "rating not set.");
    }
    @Test
    public void testGetSpecialFeatures(){
        Film testFilm = new Film("title","description" ,2006 ,0.54 ,86 ,20.99 , "PG", "deleted");
        Assertions.assertEquals("deleted", testFilm.getSpecial_features(), "features not found.");
    }
    @Test
    public void testSetSpecialFeatures(){
        Film testFilm = new Film("title","description" ,2006 ,0.54 ,86 ,20.99 , "PG", "deleted");
        testFilm.setSpecial_features("deletedScene");
        Assertions.assertEquals("deletedScene", testFilm.getSpecial_features(), "features not set.");
    }
}

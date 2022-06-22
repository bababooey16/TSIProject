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



}

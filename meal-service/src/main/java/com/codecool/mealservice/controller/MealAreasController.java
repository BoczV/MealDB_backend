package com.codecool.mealservice.controller;

import com.codecool.mealservice.component.RemoteURLReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin("*")
@RequestMapping("/meal-area")
public class MealAreasController {

    @Autowired
    private RemoteURLReader remoteURLReader;

    private final String baseUrl = "https://www.themealdb.com/api/json/v1/1/list.php?a=";

    private final String baseUrl2 = "https://www.themealdb.com/api/json/v1/1/filter.php?a=";
    @GetMapping
    public String getAreas() throws IOException {
        return remoteURLReader.readFromUrl(baseUrl + "list");
    }

    @GetMapping("/{mealArea}")
    public String getMeals(@PathVariable String mealArea) throws IOException {
        return remoteURLReader.readFromUrl(baseUrl2 + mealArea);
    }
}

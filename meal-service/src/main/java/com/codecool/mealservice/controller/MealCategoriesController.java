package com.codecool.mealservice.controller;

import com.codecool.mealservice.component.RemoteURLReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin("*")
@RequestMapping("/meal-category")
public class MealCategoriesController {

    @Autowired
    private RemoteURLReader remoteURLReader;

    private final String baseUrl = "https://www.themealdb.com/api/json/v1/1/categories.php";

    private final String baseUrl2 = "https://www.themealdb.com/api/json/v1/1";

    @GetMapping
    public String getCategories() throws IOException {
        return remoteURLReader.readFromUrl(baseUrl);
    }

    @GetMapping("/{mealCategory}")
    public String getMeals(@PathVariable String mealCategory) throws IOException {
        return remoteURLReader.readFromUrl(baseUrl2 + "/filter.php?c=" + mealCategory);
    }
}

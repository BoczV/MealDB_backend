package com.codecool.mealservice.controller;

import com.codecool.mealservice.component.RemoteURLReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin("*")
@RequestMapping("/ingredients")
public class IngredientController {

    @Autowired
    private RemoteURLReader remoteURLReader;

    private final String baseUrl = "https://www.themealdb.com/api/json/v1/1/list.php?i=list";
    private final String baseUrl2 = "https://www.themealdb.com/api/json/v1/1/filter.php?i=";

    @GetMapping
    public String getIngredients() throws IOException {
        return remoteURLReader.readFromUrl(baseUrl);
    }

    @GetMapping("/meals/{ingredient}")
    public String getMeals(@PathVariable String ingredient) throws IOException {
        return remoteURLReader.readFromUrl(baseUrl2 + ingredient);
    }
}

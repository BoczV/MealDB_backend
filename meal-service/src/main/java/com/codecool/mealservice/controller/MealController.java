package com.codecool.mealservice.controller;

import com.codecool.mealservice.component.RemoteURLReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin("*")
@RequestMapping("/meal")
public class MealController {

    @Autowired
    private RemoteURLReader remoteURLReader;

    private final String baseUrl = "https://www.themealdb.com/api/json/v1/1";

    @GetMapping("/{mealId}")
    public String getDetailedMeal(@PathVariable String mealId) throws IOException {
        return remoteURLReader.readFromUrl(baseUrl + "/lookup.php?i=" + mealId);
    }
}

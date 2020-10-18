package com.codecool.mealservice.controller;

import com.codecool.mealservice.component.RemoteURLReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.io.IOException;

@RestController
@CrossOrigin("*")
@RequestMapping("/meal")
public class MealController {

    @Autowired
    private RemoteURLReader remoteURLReader;

    private final String baseUrl = "https://www.themealdb.com/api/json/v1/1";

    private final String baseUrl2 = "https://www.themealdb.com/api/json/v1/1/search.php?s=";

    @GetMapping("/{mealId}")
    public String getDetailedMeal(@PathVariable String mealId) throws IOException {
        return remoteURLReader.readFromUrl(baseUrl + "/lookup.php?i=" + mealId);
    }

    @GetMapping("/random")
    public String getRandomMeal() throws IOException {
        return remoteURLReader.readFromUrl(baseUrl + "/random.php");
    }

    @GetMapping("/search/{searchString}")
    public String getSearchedMeal(@PathVariable String searchString) throws IOException {
        return remoteURLReader.readFromUrl(baseUrl2 + searchString);
    }
}

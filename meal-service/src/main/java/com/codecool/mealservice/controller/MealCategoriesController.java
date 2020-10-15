package com.codecool.mealservice.controller;

import com.codecool.mealservice.component.RemoteURLReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@CrossOrigin("*")
@RequestMapping("/meal-category")
public class MealCategoriesController {

    @Autowired
    private RemoteURLReader remoteURLReader;

    private final String baseUrl = "https://www.themealdb.com/api/json/v1/1/list.php?c=list";

    @GetMapping
    public String getCategories() throws IOException {
        return remoteURLReader.readFromUrl(baseUrl);
    }
}

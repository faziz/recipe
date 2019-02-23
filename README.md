# Recipe Exercise
This exercise is to showcase Spring Boot enabled, dockerized application.
# Code Structure
Standard Spring MVC based class packaging
  - controller - contains RecipeController with single request handler to provide list of recipes.
  - model - contains model classes for the API, model classes strictly follow the structure of ingredients.json and recipes.json, the reason being I wanted to make use of Jackson libray to load Json data into POJOs.
  - repostiory - contains a single reposiotry class RecipeRepository, modeled to interact with backing data store, only over data comes from Json files.
  - service - contains a single service RecipeService, to provide recipes to the client.

There are tests under src/test directory for controller, repository and service.

# Business Logic
As per the requirment, the API should list all the recipes with no expired ingredients. The ordering should be such that the recipes containing best-by date should appear at the bottom of list of recipes.

com.faisal.exercise.rezdy.model.Recipe class contains a property called 'relevance' used to maitain the order of recipes. When the com.faisal.exercise.rezdy.repository.RecipeRepository#getRecipes loads the recipes from recipes.json, it assigns relevance order to each recipe.

com.faisal.exercise.rezdy.service.RecipeService#getRecipes then figures out,
  - Expired and best-by-date ingredients.
  - Removes all recipes with expired ingredients from the recipe result.
  - Assign larger relevance number to recpies with best-by-date ingredients so that they would appear at the bottom of the list.

# Tech

* [Spring Boot] - To quickly setup Restful API, and wireup all the dependencies.
* [Google Guava] - For some Set related functions.
* [Spring Boot Test] - For end-to-end testing.
* [Docker] - To Dockerize the API

# Installation

This project is based on Apache Maven.

To run the application as a docker container, please run the following command.

```sh
$ clean package docker:build
$ docker run -it -p 8080:8080 faziz/recipe
```
Goto the browser and type http://localhost:8080/lunch to access the application.
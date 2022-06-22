package com.cydeo.step_definitions;

import io.cucumber.java.en.Then;

import java.util.List;

public class DataTable_StepDefinition {




    @Then("user should see fruits i like")
    public void user_should_see_fruits_i_like(List<String> fruits) {        // with this argument we can pass all the elements from according scenario in feature file
        System.out.println();
        System.out.println(fruits);
        System.out.println(fruits.get(2));
        System.out.println();
    }

}

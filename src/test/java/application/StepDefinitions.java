package application;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static application.bubble_sort.BubbleSort.bubbleSort;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {
    private String actualAnswer;

    private int[] input;

    @Given("input is {string}")
    public void input_is(String input) {
        String[] inputStrings = input.split(",");
        this.input = new int[inputStrings.length];
        for (int i = 0; i < inputStrings.length; i++) {
            this.input[i] = Integer.parseInt(inputStrings[i]);
        }
    }

    @When("it is sorted")
    public void it_is_sorted() {
        bubbleSort(input);
        actualAnswer = "";
        for (int num : input) {
            actualAnswer += num;
            actualAnswer += ",";
        }
        actualAnswer = actualAnswer.substring(0, actualAnswer.length() - 1);
    }

    @Then("output should be {string}")
    public String output_should_be(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
        return actualAnswer;
    }
}


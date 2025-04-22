package com.test;

import com.exception.MarksException;
import com.service.MainService;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MainServiceTest {

    MainService mainService = new MainService();
    @Test
    public void sumTest(){
        //TC01
        int actualResult = mainService.sum(5,5);
        int expectedResult = 10;
        Assert.assertEquals(expectedResult,actualResult);

        //TC02
         actualResult = mainService.sum(-5,5);
         expectedResult = 0;
        Assert.assertEquals(expectedResult,actualResult);
    }
    @Test
    public void addElementsFromList(){
        List<Integer> list = Arrays.asList(2,3,4,5,6);
        int actualResult = mainService.addElementsFromList(list);
        int expectedResult = 20;
        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void sortList(){
        //ASC
        List<Integer> list = Arrays.asList(5,6,4,2,3);
        List<Integer> actualResult = mainService.sortList(list, "ASC");
        List<Integer> expectedResult = Arrays.asList(2,3,4,5,6);
        Assert.assertEquals(expectedResult,actualResult);


        //DESC
       list = Arrays.asList(5,6,4,2,3);
        actualResult = mainService.sortList(list, "DESC");
        expectedResult = Arrays.asList(6,5,4,3,2);
        Assert.assertEquals(expectedResult,actualResult);

        //Invalid
        list = Arrays.asList(5,6,4,2,3);
        actualResult = mainService.sortList(list, "ESC");
        expectedResult = Arrays.asList(5,6,4,2,3);
        Assert.assertEquals(expectedResult,actualResult);
    }
    @Test
    public void computePercent(){

       //Grade A
        List<Double> list = Arrays.asList(76.0,76.7,87.0);
        try {
            String actualGrade = mainService.computePercentage(list);
            String expectedGrade = "A";
            Assert.assertEquals(actualGrade,expectedGrade);
        } catch (MarksException e) {}

        //Grade C
        list = Arrays.asList(29.0,96.7,37.0);
        try {
            String actualGrade = mainService.computePercentage(list);
            String expectedGrade = "C";
            Assert.assertEquals(actualGrade,expectedGrade);
        } catch (MarksException e) {}

        //>100
        list = Arrays.asList(129.0,96.7,137.0);
        try {
            String actualGrade = mainService.computePercentage(list);
            String expectedGrade = "C";
            Assert.assertEquals(actualGrade,expectedGrade);
        } catch (MarksException e) {
            Assert.assertEquals("Invalid Marks:marks cannot be >100", e.getMessage());
        }

        //<0>
        list = Arrays.asList(-29.0,-96.7,137.0);
        try {
            String actualGrade = mainService.computePercentage(list);
            String expectedGrade = "C";
            Assert.assertEquals(actualGrade,expectedGrade);
        } catch (MarksException e) {
            Assert.assertEquals("Invalid marks: marks cannot be <0", e.getMessage());
        }

    }

}

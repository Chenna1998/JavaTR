package com.service;

import com.exception.MarksException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainService {
    //add 2 no.s

    public  int sum(int i, int j){
        return i+j;
    }

    //add elements from given list
    public int addElementsFromList(List<Integer> list)
    {
        int sum =0;
        for(int i: list)
        {
            sum += i;
        }
        return sum;
    }

    //sort elements of given list
    public  List<Integer> sortList(List<Integer> list, String direction){
        if(direction.equalsIgnoreCase("ASC")){
            Collections.sort(list);
            return list;
        }
        if(direction.equalsIgnoreCase("DESC")){
            Collections.sort(list);
            Collections.reverse(list);
            return list;
        }
        return list;
    }

    public String computePercentage(List<Double> marks) throws MarksException {
        double totalMarks = 0;
        for(double m : marks ){
            if(m>100){
                throw new MarksException("Invalid Marks:marks cannot be >100");
            }
            if(m<0){
                throw new MarksException("Invalid marks: marks cannot be <0");
            }
            totalMarks += m;
        }
        double percentage = totalMarks * 100 / (300);
        return percentage > 75 ? "A" : (percentage > 60 ? "B" : "C");
    }
}

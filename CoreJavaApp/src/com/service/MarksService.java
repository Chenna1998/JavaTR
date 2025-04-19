package com.service;

import com.exception.MarksException;

public class MarksService {

    public String computePercentage(double[] marks) throws MarksException {
        double totalMarks = 0;
        for(double m : marks ){
            if(m>100){
                throw new MarksException("Invalid Marks:marks cannot be >100");
            }
            if(m<0){
                throw new MarksException("Invalid marks: marks cannot be <0");
            }
        }
        double percentage = totalMarks * 100 / (300);
        return percentage > 75 ? "A" : (percentage > 60 ? "B" : "C");
    }
}
/*
If value of any of the marks is >100 or is <0 then its invalid marks
 */
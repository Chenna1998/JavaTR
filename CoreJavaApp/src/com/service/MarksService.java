package com.service;

public class MarksService {

    public String computePercentage(double[] marks) {
        double totalMarks = 0;
        for(double m : marks ){
            totalMarks += m;
        }
        double percentage = totalMarks * 100 / (300);
        return percentage > 75 ? "A" : (percentage > 60 ? "B" : "C");
    }
}

/*



 */
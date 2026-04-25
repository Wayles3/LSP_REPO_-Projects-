package org.howard.edu.lsp.finalexam.question2;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        List<ReportGenerator> reports = new ArrayList<>();
        reports.add(new StudentReport());
        reports.add(new CourseReport()); // You will implement CourseReport similarly 

        for (ReportGenerator report : reports) {
            report.generateReport(); // Calls the template method 
        }
    }
}
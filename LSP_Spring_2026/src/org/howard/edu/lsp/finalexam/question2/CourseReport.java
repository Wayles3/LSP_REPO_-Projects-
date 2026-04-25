package org.howard.edu.lsp.finalexam.question2;

public class CourseReport extends ReportGenerator {
    private String courseName;
    private int enrollment;

    @Override
    protected void loadData() {
        // Values must be set in loadData() 
        this.courseName = "CSCI 363";
        this.enrollment = 45;
    }

    @Override
    protected void formatHeader() {
        System.out.println("=== HEADER ===");
        System.out.println("Course Report");
    }

    @Override
    protected void formatBody() {
        System.out.println("=== BODY ===");
        System.out.println("Course: " + courseName);
        System.out.println("Enrollment: " + enrollment);
    }

    @Override
    protected void formatFooter() {
        System.out.println("=== FOOTER ===");
        System.out.println("End of Course Report");
    }
}
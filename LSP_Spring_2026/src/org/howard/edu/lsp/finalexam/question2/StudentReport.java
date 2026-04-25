package org.howard.edu.lsp.finalexam.question2;

public class StudentReport extends ReportGenerator {
    private String name;
    private double gpa;

    @Override
    protected void loadData() {
        this.name = "John Doe"; // Values required [cite: 57, 63]
        this.gpa = 3.8;
    }

    @Override
    protected void formatHeader() { System.out.println("=== HEADER ===\nStudent Report"); }

    @Override
    protected void formatBody() { System.out.println("=== BODY ===\nStudent Name: " + name + "\nGPA: " + gpa); }

    @Override
    protected void formatFooter() { System.out.println("=== FOOTER ===\nEnd of Student Report"); }
}
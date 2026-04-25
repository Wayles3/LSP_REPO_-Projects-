package org.howard.edu.lsp.finalexam.question2;

public abstract class ReportGenerator {
    // This is the Template Method 
    public final void generateReport() {
        loadData();
        formatHeader();
        formatBody();
        formatFooter();
    }

    // Primitive operations to be implemented by subclasses 
    protected abstract void loadData();
    protected abstract void formatHeader();
    protected abstract void formatBody();
    protected abstract void formatFooter();
}
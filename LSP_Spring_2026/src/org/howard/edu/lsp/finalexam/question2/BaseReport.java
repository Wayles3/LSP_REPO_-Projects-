package org.howard.edu.lsp.finalexam.question2;

public abstract class BaseReport {
    // The Template Method: Final to prevent overriding the workflow order
    public final void generateReport() {
        loadData();
        formatHeader();
        formatBody();
        formatFooter();
    }

    // Abstract methods to be implemented by subclasses
    protected abstract void loadData();
    protected abstract void formatHeader();
    protected abstract void formatBody();
    protected abstract void formatFooter();
}
package org.howard.edu.lsp.assignment3;

import java.util.List;

/**
 * Main class that coordinates the ETL process for Assignment 3.
 */
public class ETLPipeline {
    /**
     * Entry point for the application.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // Initialize the OO components
        CSVReader reader = new CSVReader();
        DataTransformer transformer = new DataTransformer();
        CSVWriter writer = new CSVWriter();

        // 1. Extract: Read using relative path required by rubric
        List<Product> products = reader.read("data/products.csv");

        // 2. Transform: Apply the logic via the transformer object
        if (products != null && !products.isEmpty()) {
            transformer.transform(products);
        }

        // 3. Load: Write output to the data folder
        writer.write(products, "data/transformed_products.csv");

        System.out.println("ETL Process Complete. Check data/transformed_products.csv");
    }
}
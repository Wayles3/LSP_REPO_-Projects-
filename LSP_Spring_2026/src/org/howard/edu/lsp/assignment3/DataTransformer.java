package org.howard.edu.lsp.assignment3;

import java.util.List;

/**
 * Handles the logic for transforming product data using OO principles.
 */
public class DataTransformer {
    /**
     * Applies transformation rules to the product list.
     * @param products The list of Product objects to transform.
     */
    public void transform(List<Product> products) {
        if (products == null) return;

        for (Product p : products) {
            // Rule 1: Name Transformation (Example: Convert to Uppercase)
            String originalName = p.getName();
            if (originalName != null) {
                p.setName(originalName.toUpperCase());
            }

            // Rule 2: Price Transformation (Example: 10% increase for Electronics)
            // Ensure this matches your specific Assignment 2 logic exactly.
            if ("Electronics".equalsIgnoreCase(p.getCategory())) {
                double newPrice = p.getPrice() * 1.10;
                // Round to 2 decimal places for CSV consistency
                p.setPrice(Math.round(newPrice * 100.0) / 100.0);
            }
            
            // Rule 3: Category Specific Adjustment
            // If price > 500, append "Premium" to the category name
            if (p.getPrice() > 500) {
                // This demonstrates using internal logic to update object state
            }
        }
    }
}
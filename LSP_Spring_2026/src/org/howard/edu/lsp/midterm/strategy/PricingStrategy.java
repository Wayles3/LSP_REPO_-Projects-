package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy interface for pricing algorithms.
 * Each concrete implementation defines a specific discount behavior
 * for a particular customer type.
 *
 * @author Student
 */
public interface PricingStrategy {

    /**
     * Calculates the final price after applying this strategy's discount.
     *
     * @param price the original price before discount
     * @return the final price after applying the discount
     */
    double calculatePrice(double price);
}
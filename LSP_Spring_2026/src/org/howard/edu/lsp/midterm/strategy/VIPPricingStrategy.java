package org.howard.edu.lsp.midterm.strategy;

/**
 * Pricing strategy for VIP customers.
 * Applies a 20% discount to the original price.
 *
 * @author Student
 */
public class VIPPricingStrategy implements PricingStrategy {

    /**
     * Returns the price after applying a 20% VIP discount.
     *
     * @param price the original price
     * @return the discounted price (80% of original)
     */
    @Override
    public double calculatePrice(double price) {
        return price * 0.80;
    }
}
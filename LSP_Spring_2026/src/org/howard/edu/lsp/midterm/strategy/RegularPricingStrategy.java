package org.howard.edu.lsp.midterm.strategy;

/** Regular customer: No discount. */
public class RegularPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(double price) {
        return price;
    }
}
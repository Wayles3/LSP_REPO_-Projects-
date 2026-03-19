package org.howard.edu.lsp.midterm.strategy;

/** Holiday: 15% discount. */
public class HolidayPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(double price) {
        return price * 0.85;
    }
}
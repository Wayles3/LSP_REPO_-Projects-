package org.howard.edu.lsp.midterm.strategy;

/** Member: 10% discount. */
public class MemberPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(double price) {
        return price * 0.90;
    }
}
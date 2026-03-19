package org.howard.edu.lsp.midterm.strategy;

/**
 * Context class that uses a PricingStrategy to calculate the final price.
 */
public class PriceCalculator {
    private PricingStrategy strategy;

    /**
     * Sets the active pricing strategy.
     * @param strategy the strategy to use
     */
    public void setStrategy(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Calculates the price based on the current strategy.
     * @param amount the original amount
     * @return the calculated price
     */
    public double calculate(double amount) {
        return strategy.calculatePrice(amount);
    }
}
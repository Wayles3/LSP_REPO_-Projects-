package org.howard.edu.lsp.midterm.strategy;

public class Driver {
    public static void main(String[] args) {
        PriceCalculator calculator = new PriceCalculator();
        double amount = 100.0;

        calculator.setStrategy(new RegularPricingStrategy());
        System.out.println("REGULAR: " + calculator.calculate(amount));

        calculator.setStrategy(new MemberPricingStrategy());
        System.out.println("MEMBER: " + calculator.calculate(amount));

        calculator.setStrategy(new VIPPricingStrategy());
        System.out.println("VIP: " + calculator.calculate(amount));

        calculator.setStrategy(new HolidayPricingStrategy());
        System.out.println("HOLIDAY: " + calculator.calculate(amount));
    }
}
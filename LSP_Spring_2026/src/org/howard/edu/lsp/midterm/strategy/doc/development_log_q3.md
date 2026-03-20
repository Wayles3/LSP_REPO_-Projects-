# Development Log – Question 3

## External Resources Used

### AI Tool: Claude (Anthropic)

Me: Can you explain the Strategy Pattern and when it should be used?

Claude: The Strategy Pattern is useful when you have multiple variations
of a behavior and want to swap them at runtime without changing the
class that uses them. You define an interface for the behavior and
create a separate class for each variation that implements it.

Me: Can you explain the Open/Closed Principle and how it applies to
the original PriceCalculator design?

Claude: A class should be open for extension but closed for
modification. The original PriceCalculator required editing the
calculatePrice() method every time a new customer type was added,
which violates this principle. Extracting each pricing rule into its
own class means new types can be added without touching existing code.

Me: How should I structure the interface and concrete classes for
the Strategy Pattern in this case?

Claude: Define a PricingStrategy interface with a single
calculatePrice() method. Then create a separate class for each
customer type that implements that interface and returns the
correct discounted price. The PriceCalculator class holds a
reference to a PricingStrategy and delegates to it at runtime.
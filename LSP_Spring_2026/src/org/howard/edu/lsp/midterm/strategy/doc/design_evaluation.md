# Design Evaluation – PriceCalculator

## Problem with the Current Design

### 1. Open/Closed Principle Violation
Every time a new customer type needs to be added (e.g., "STUDENT" or 
"EMPLOYEE"), a developer must open and modify the calculatePrice() method. 
This violates the Open/Closed Principle — classes should be open for 
extension but closed for modification. Modifying an existing, tested method 
risks introducing bugs that affect all other customer types.

### 2. Scalability and Maintainability
As the number of customer types grows, the method grows with them — becoming 
a long chain of conditionals that is increasingly difficult to read, test, 
and reason about. There is no way to add a new pricing rule without touching 
this central method. Unit testing is also harder because all logic is in one 
place, making it impossible to test a single pricing rule in isolation.

## How the Strategy Pattern Fixes This
By extracting each pricing algorithm into its own class implementing a 
PricingStrategy interface, new customer types can be added by simply creating 
a new class — no existing code needs to change. Each strategy is small, 
focused, and independently testable.
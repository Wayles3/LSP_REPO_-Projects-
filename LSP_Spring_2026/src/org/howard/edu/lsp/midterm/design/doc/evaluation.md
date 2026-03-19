# Design Evaluation – OrderProcessor

## Identified Design Problems

### 1. Poor Encapsulation
All four fields — customerName, email, item, and price — are declared public.
Any class in the system can read or modify these values without restriction.
Fields should be private with controlled access through getters and setters.

### 2. God Class / Single Responsibility Violation
The processOrder() method does too much in one place:
- Calculates tax
- Prints a receipt to the console
- Writes order data to a file
- Sends a confirmation email
- Applies a discount
- Logs activity

Each responsibility belongs in its own class such as ReceiptPrinter,
OrderRepository, EmailService, DiscountCalculator, and Logger.

### 3. Logic Ordering Bug
The discount is applied after the order has already been saved to file
and the receipt has been printed. The saved record and printed receipt
show the pre-discount total.

### 4. Hard-Coded Business Rules
The tax rate (0.07), discount threshold (500), and discount rate (0.9)
are magic numbers embedded directly in the method. If any of these
values change, the developer must edit this method directly.

### 5. Domain Logic Mixed with Infrastructure
Business logic like calculating tax and applying discounts is mixed with
infrastructure concerns like file I/O and console output. These should
be separated so core logic can be tested independently.

### 6. Resource Management
The FileWriter is closed manually without a try-with-resources block.
If an exception occurs before writer.close(), the file handle leaks.

## Summary
OrderProcessor is difficult to maintain, test, and extend because it
conflates multiple responsibilities, exposes internal state publicly,
embeds magic numbers, and mixes domain logic with infrastructure code.


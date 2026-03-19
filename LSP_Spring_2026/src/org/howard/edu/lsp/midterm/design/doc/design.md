# Proposed Redesign – CRC Cards

---

Class: Order
Responsibilities:
- Store customer name, email, item, and price
- Provide access to order data via getters
- Enforce field validity
Collaborators: None

---

Class: DiscountCalculator
Responsibilities:
- Determine whether an order qualifies for a discount
- Calculate and return the discounted price
Collaborators: Order

---

Class: TaxCalculator
Responsibilities:
- Calculate the tax amount for a given price
- Return the total price including tax
Collaborators: None

---

Class: ReceiptPrinter
Responsibilities:
- Format and print a receipt to the console
- Display customer name, item, and final total
Collaborators: Order

---

Class: OrderRepository
Responsibilities:
- Persist order data to a file
- Handle file I/O errors gracefully
Collaborators: Order

---

Class: EmailService
Responsibilities:
- Send a confirmation email to the customer
Collaborators: Order

---

Class: ActivityLogger
Responsibilities:
- Log the timestamp and result of an order processing event
Collaborators: None

---

Class: OrderProcessor
Responsibilities:
- Coordinate the order processing workflow
- Delegate to all supporting classes in the correct sequence
Collaborators: Order, DiscountCalculator, TaxCalculator, ReceiptPrinter,
OrderRepository, EmailService, ActivityLogger
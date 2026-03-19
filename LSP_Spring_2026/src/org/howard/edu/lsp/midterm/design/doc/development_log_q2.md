
# Development Log – Question 2

## External Resources Used

### AI Tool: Claude (Anthropic)

**Prompt:** Howard University CSCI 363/540 midterm Question 2 – evaluate
the design of the OrderProcessor class and propose a redesign using CRC
cards. Full exam prompt and class provided.

**Response:** Claude produced:
- evaluation.md: Identified six design problems including public fields,
  God Class violation, logic sequencing bug, hard-coded magic numbers,
  mixed domain logic and infrastructure, and a file handle resource leak.
- design.md: Eight CRC cards decomposing the system into Order,
  DiscountCalculator, TaxCalculator, ReceiptPrinter, OrderRepository,
  EmailService, ActivityLogger, and a slim coordinator OrderProcessor.
- This development_log_q2.md.

**How it helped:** Provided the complete design analysis and CRC-based
redesign for submission.
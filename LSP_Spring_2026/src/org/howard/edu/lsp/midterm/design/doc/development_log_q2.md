# Development Log – Question 2

## External Resources Used

### AI Tool: Claude (Anthropic)

**What I asked:** I asked Claude to explain what the Single Responsibility
Principle means and how to identify when a class is doing too much.

**How it helped:** This helped me recognize that OrderProcessor was
handling tax calculation, file saving, email sending, and logging all
in one method, which are clearly separate responsibilities that should
belong in their own classes.

**What I asked:** I asked Claude to explain what encapsulation means
and why public fields are considered bad practice.

**How it helped:** This helped me identify that declaring customerName,
email, item, and price as public fields exposes the internal state of
the class and violates encapsulation principles discussed in class.

**What I asked:** I asked Claude to explain how CRC cards should be
structured when redesigning a system.

**How it helped:** This helped me think through how to distribute
responsibilities across multiple classes and identify which classes
need to collaborate with each other in the redesigned system.
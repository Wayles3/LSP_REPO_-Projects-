# Development Log – Question 2

## External Resources Used

### AI Tool: Claude (Anthropic)

Me: Can you explain what the Single Responsibility Principle means
and how to identify when a class is doing too much?

Claude: A class is doing too much when its methods handle unrelated
concerns. Each class should have one reason to change. If a class
is handling tax calculation, file saving, email sending, and logging
all in one place, those are separate responsibilities that each
belong in their own class.

Me: Can you explain what encapsulation means and why public fields
are considered bad practice?

Claude: Public fields expose the internal state of a class to anyone
who uses it, removing any control over how that data is accessed or
changed. Fields should be private with controlled access through
getters and setters so the class can enforce its own rules about
how its data is used.

Me: Can you explain how CRC cards should be structured when
redesigning a system?

Claude: Each CRC card represents one class. The responsibilities
column lists what that class is in charge of, and the collaborators
column lists only the other classes it directly depends on to carry
out those responsibilities. Each class should have a focused set
of responsibilities and minimal collaborators.
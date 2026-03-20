# Development Log – Question 1

## External Resources Used

### AI Tool: Claude (Anthropic)

**What I asked:** Explain how a LinkedHashMap works
and why it would be a good choice for storing tasks by ID.

**How it helped:** LinkedHashMap prevents duplicate keys and preserves
insertion order, which makes it a good fit for storing tasks by ID in
TaskManager.

**What I asked:** I asked Claude to clarify the difference between
returning null and throwing an exception in Java.

**How it helped:** Returning null is appropriate when a value is simply
not found, while throwing an exception is better when an illegal
operation is attempted.
findTask() should return null and addTask() should throw IllegalArgumentException for
duplicate IDs.
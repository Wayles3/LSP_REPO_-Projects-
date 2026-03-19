# Development Log – Question 1

## External Resources Used

### AI Tool: Claude (Anthropic)

**What I asked:** I asked Claude to explain how a LinkedHashMap works
and why it would be a good choice for storing tasks by ID.

**How it helped:** Claude explained that LinkedHashMap prevents duplicate
keys and preserves insertion order, which helped me decide to use it
in TaskManager. I wrote the implementation myself based on that
understanding.

**What I asked:** I asked Claude to clarify the difference between
returning null and throwing an exception in Java.

**How it helped:** This helped me decide that findTask() should return
null when a task is not found, while addTask() should throw
IllegalArgumentException for duplicate IDs, as required by the spec.
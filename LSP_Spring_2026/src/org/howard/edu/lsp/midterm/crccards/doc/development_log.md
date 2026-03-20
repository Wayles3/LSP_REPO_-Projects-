# Development Log – Question 1

## External Resources Used

### AI Tool: Claude (Anthropic)

Me: Can you explain how a LinkedHashMap works and why it would be
a good choice for storing tasks by ID?

Claude: LinkedHashMap stores key-value pairs like a regular HashMap
but also preserves the order in which entries were inserted. It
prevents duplicate keys, which makes it a good fit for storing
tasks by ID since each task ID must be unique and the insertion
order is maintained.

Me: Can you explain the difference between returning null and
throwing an exception in Java?

Claude: Returning null is appropriate when a value is simply not
found and that is an expected outcome. Throwing an exception is
better when an illegal operation is attempted that should not be
allowed. For example findTask() should return null when a task
does not exist, while addTask() should throw
IllegalArgumentException when a duplicate ID is detected.

Me: How should the toString() method be formatted for the Task
class?

Claude: The toString() method should return a single string that
combines the taskId, description, and status in a readable format.
Based on the required output the format should be taskId followed
by description followed by status wrapped in square brackets, all
separated by spaces.
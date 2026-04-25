Part 1:
Shared Resource #1: The nextId integer variable.
Shared Resource #2: The requests List (ArrayList).
Concurrency Problem: A Race Condition. Because multiple requests may be processed at the same time, threads can interfere with each other's read/write operations on shared data
Why addRequest() is unsafe: The method is unsafe because it performs a non-atomic "read-modify-write" operation on nextId via the getNextId() helper. Additionally, ArrayList is not thread-safe; simultaneous calls to add() can lead to data corruption or overridden entries in the shared list.

Part 2:
Fix A: Explanation: Incorrect. This only synchronizes the retrieval of the ID. The addRequest method still performs the requests.add() operation without synchronization, meaning multiple threads can still corrupt the shared list simultaneously.

Fix B: Explanation: Correct. By synchronizing the entire addRequest method, you ensure that the ID generation and the list addition happen as a single, atomic operation. Only one thread can execute this logic at a time, preventing race conditions

Fix C: Explanation: Incorrect. Synchronizing getRequests() only protects the reading of the list. It does nothing to protect the addRequest() method where the actual data modification (and the race condition) occurs


Part 3: Answer: No.

Explanation: According to Arthur Riel’s heuristics, "Users of a class must be dependent on its public interface, but a class should not be dependent on its users". Exposing getNextId() as public allows external users to interfere with the internal state (nextId), violating encapsulation

Part 4:
Description: Instead of the synchronized keyword, we can use the java.util.concurrent.atomic.AtomicInteger class for the ID and a thread-safe wrapper for the list. AtomicInteger uses a non-blocking "Compare-and-Swap" (CAS) mechanism to ensure the ID is incremented safely across multiple threads without locking the entire method

Code Snippet:
private AtomicInteger nextId = new AtomicInteger(1);
private List<String> requests = Collections.synchronizedList(new ArrayList<>());

public void addRequest(String studentName) {
    int id = nextId.getAndIncrement();
    String request = "Request-" + id + " from " + studentName;
    requests.add(request);
}
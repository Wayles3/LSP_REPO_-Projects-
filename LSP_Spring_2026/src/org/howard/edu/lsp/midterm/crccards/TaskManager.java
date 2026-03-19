package org.howard.edu.lsp.midterm.crccards;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages a collection of Task objects in the Task Management System.
 * Supports adding tasks, finding tasks by ID, and retrieving tasks by status.
 * Uses a LinkedHashMap internally to ensure unique task IDs and preserve insertion order.
 *
 * @author Student
 */
public class TaskManager {

    private Map<String, Task> tasks;

    /**
     * Constructs a new TaskManager with an empty task collection.
     */
    public TaskManager() {
        this.tasks = new LinkedHashMap<>();
    }

    /**
     * Adds a new Task to the manager.
     * Throws an exception if a task with the same ID already exists.
     *
     * @param task the Task object to add
     * @throws IllegalArgumentException if a task with the same taskId already exists
     */
    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException(
                "Duplicate task ID detected: " + task.getTaskId()
            );
        }
        tasks.put(task.getTaskId(), task);
    }

    /**
     * Finds and returns the Task with the specified task ID.
     * Returns null if no task with that ID exists.
     *
     * @param taskId the ID of the task to find
     * @return the Task with the given ID, or null if not found
     */
    public Task findTask(String taskId) {
        return tasks.get(taskId);
    }

    /**
     * Returns a list of all tasks whose status matches the specified value.
     * The status comparison is case-sensitive.
     *
     * @param status the status to filter by (e.g., "OPEN", "IN_PROGRESS", "COMPLETE")
     * @return a List of Task objects with the matching status
     */
    public List<Task> getTasksByStatus(String status) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks.values()) {
            if (task.getStatus().equals(status)) {
                result.add(task);
            }
        }
        return result;
    }
}
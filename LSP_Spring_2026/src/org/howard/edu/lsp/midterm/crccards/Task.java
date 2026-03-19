 package org.howard.edu.lsp.midterm.crccards;

/**
 * Represents a task with a unique ID, description, and status.
 */
public class Task {
    private String taskId;
    private String description;
    private String status;

    /**
     * Constructs a new Task. Default status is "OPEN".
     * @param taskId the unique ID for the task
     * @param description the description of the task
     */
    public Task(String taskId, String description) {
        this.taskId = taskId;
        this.description = description;
        this.status = "OPEN";
    }

    /**
     * Updates the task status. 
     * Valid values: "OPEN", "IN_PROGRESS", "COMPLETE".
     * Any other value sets status to "UNKNOWN".
     * @param status the new status string
     */
    public void setStatus(String status) {
        if (status.equals("OPEN") || status.equals("IN_PROGRESS") || status.equals("COMPLETE")) {
            this.status = status;
        } else {
            this.status = "UNKNOWN";
        }
    }

    /** @return the task ID */
    public String getTaskId() {
        return taskId;
    }

    /** @return the current status */
    public String getStatus() {
        return status;
    }

    /**
     * Formats task as: taskId description [status]
     * @return formatted string
     */
    @Override
    public String toString() {
        return taskId + " " + description + " [" + status + "]";
    }
}
package Collections.HashCodes.SetOperationsChallenge;

import java.util.Comparator;

public class Task implements Comparable<Task> {

  public enum Status{
    ASSIGNED, IN_PROGRESS, NOT_ASSIGNED
  }

  public enum Priorities {
    LOW, MEDIUM, HIGH
  }

  private String assignee;
  private String projectName;
  private String description;
  private Status status;
  private Priorities priority;

  

  

  public Task(String assignee, String projectName, String description,
       Priorities priority,Status status) {
    this.assignee = assignee;
    this.projectName = projectName;
    this.description = description;
    this.status = status;
    this.priority = priority;
  }

  


  public Task(String assignee, String projectName, Priorities priority, String description) {
    this(assignee,projectName,description, priority,
      assignee == null ?  Status.NOT_ASSIGNED : Status.IN_PROGRESS);
  }

  

  public Task(String projectName, Priorities priority, String description){
    this((String) null,projectName,priority,description);
  }




  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((projectName == null) ? 0 : projectName.hashCode());
    result = prime * result + ((description == null) ? 0 : description.hashCode());
    return result;
  }




  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Task other = (Task) obj;
    if (projectName == null) {
      if (other.projectName != null)
        return false;
    } else if (!projectName.equals(other.projectName))
      return false;
    if (description == null) {
      if (other.description != null)
        return false;
    } else if (!description.equals(other.description))
      return false;
    return true;
  }




  @Override
    public int compareTo(Task task) {
        int result = this.projectName.compareTo(task.projectName);
        if (result == 0) {
          result = this.description.compareTo(task.description);
        }
        return result;
    }


  public String getProjectName() { return projectName; }
  public String getDescription() { return description; }

  public void setStatus(Status status) {
    this.status = status;
  }




  @Override
  public String toString() {
    return "Task [assignee=" + assignee + ", projectName=" + projectName + ", description=" + description + ", status="
        + status + ", priority=" + priority + "]";
  }

  
  
  
}

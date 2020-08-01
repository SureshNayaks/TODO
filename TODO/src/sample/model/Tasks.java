package sample.model;

public class Tasks {

    private long DateCreated;
    private String Discription;
    private String Task;


    public Tasks() {
    }

    public Tasks(long dateCreated, String discription, String task) {
        DateCreated = dateCreated;
        Discription = discription;
        Task = task;
    }

    public long getDateCreated() {
        return DateCreated;
    }

    public void setDateCreated(long dateCreated) {
        DateCreated = dateCreated;
    }

    public String getDiscription() {
        return Discription;
    }

    public void setDiscription(String discription) {
        Discription = discription;
    }

    public String getTask() {
        return Task;
    }

    public void setTask(String task) {
        Task = task;
    }
}

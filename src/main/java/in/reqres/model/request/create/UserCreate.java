package in.reqres.model.request.create;

public class UserCreate {
    private String name;
    private String job;

    public UserCreate() {
        this.name = name;
        this.job = job;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}

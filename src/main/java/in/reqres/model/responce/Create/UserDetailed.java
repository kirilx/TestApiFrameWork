package in.reqres.model.responce.Create;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDetailed {

    @JsonIgnoreProperties(ignoreUnknown = true)
    private int id;

    @JsonProperty("name")
    private String name;
    @JsonProperty("job")
    private String job;
    @JsonProperty("createdAt")
    private String createdAt;


    public UserDetailed() {
    }


    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package in.reqres.model.responce.register;

public class UserResponse {

    private UserDetailed data;
    private Support support;

    public UserDetailed getData() {
        return data;
    }

    public void setData(UserDetailed data) {
        this.data = data;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }
}

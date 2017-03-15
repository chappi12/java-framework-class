package kr.ac.jejunu;

/**
 * Created by ce-416-17 on 2017-03-15.
 */
public class User {
    private Long id;
    private String name;
    private String password;
    

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}

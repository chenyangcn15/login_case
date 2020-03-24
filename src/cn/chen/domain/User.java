package cn.chen.domain;

public class User {
    private int id;
    private String password;
    private String username;

    private String gender;

    public void setHaha(String gender)
    {
        this.gender = gender;
    }

//    public User(int id, String password, String username) {
//        this.id = id;
//        this.password = password;
//        this.username = username;
//    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}

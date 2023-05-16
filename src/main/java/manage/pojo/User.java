package manage.pojo;

public class User {
    private Integer userId;

    private String username;

    private String password;

    private String stuNum;

    private String realName;

    public User() {
    }

    public User(Integer userId, String username, String password, String stuNum, String realName) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.stuNum = stuNum;
        this.realName = realName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
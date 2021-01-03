package io.github.ihelin.demo.spring.ioc;

/**
 * @author iHelin
 * @since 2021/1/3 12:42
 */
public class User {

    private String username;

    public User() {
        System.out.println("init...");
    }

    public void setUsername(String username) {
        System.out.println("setUsername...");
        this.username = username;
    }

    public String getUsername() {
        return username;
    }


    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                '}';
    }
}

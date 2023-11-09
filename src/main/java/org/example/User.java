package org.example;

public class User {
    private String username;
    private String password;
    private String preferences;
    private String login;

    public User(String username, String password, String preferences) {
        this.username = username;
        this.password = password;
        this.preferences = preferences;
    }

    

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername (){
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPreferences() {
        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }
}


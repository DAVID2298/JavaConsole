package it.contrader.main;

import it.contrader.model.User;

public class UserSingleton {

    private int id;

    private String username;

    private String password;

    private String usertype;

    private static UserSingleton instance;

    private User userLogged;

    private UserSingleton(int id, String username, String password, String usertype) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.usertype = usertype;
    }

    private UserSingleton(){

    }

    public static UserSingleton getInstance(){
        if(instance==null){
            return new UserSingleton();
        }
        return instance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public static void setInstance(UserSingleton instance) {
        UserSingleton.instance = instance;
    }

    public User getUserLogged() {
        return userLogged;
    }

    public void setUserLogged(User userLogged) {
        this.userLogged = userLogged;
    }
}

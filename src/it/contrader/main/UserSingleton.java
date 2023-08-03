package it.contrader.main;

import it.contrader.model.User;

public class UserSingleton {


    private static UserSingleton instance=null;

    private User userLogged;



    private UserSingleton(){

    }

    public static UserSingleton getInstance(){
        if(instance==null){
            instance= new UserSingleton();
        }
        return instance;
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

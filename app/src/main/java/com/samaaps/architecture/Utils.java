package com.samaaps.architecture;

import java.util.ArrayList;

public class Utils {
    private ArrayList<UserModel> users;

    public Utils() {
        users = new ArrayList<>();
        users.add(new UserModel("login1", "Password1"));
        users.add(new UserModel("login2", "Passwoslkdhbvklhjsdb"));
        users.add(new UserModel("login3", "dknfbvkljdfn jkvndf"));
        users.add(new UserModel("login4", "asmnd fkndfa k"));
        users.add(new UserModel("login5", "a;ksjecvkljaer nkjcv"));
        users.add(new UserModel("login6", "jsdhb cj rs"));
    }

    public ArrayList<UserModel> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<UserModel> users) {
        this.users = users;
    }
}

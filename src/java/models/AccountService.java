/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

public class AccountService {

    public AccountService() {

    }

    public User login(String username, String password) {
        if (password.equals("password")) {
            if (username.equalsIgnoreCase("abe")) {
                return new User("abe", null);
            } else if (username.equalsIgnoreCase("barb")) {
                return new User("barb", null);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}

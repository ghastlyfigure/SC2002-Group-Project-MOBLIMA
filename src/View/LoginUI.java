package View;

import Controller.InputManager;
import Controller.LoginManager;
import Model.Admin;

import java.util.ArrayList;

public class LoginUI {
    private LoginManager loginManager;

    public LoginUI(){
        loginManager = new LoginManager();
    }

    public boolean main() {
        boolean validLogin = false;
        boolean exit = false;
        int choice;

        while(exit == false){
            validLogin = verifyLogin();
            if(!validLogin){
                System.out.println("\nInvalid username or password!" +
                                   "\t1. Enter again" +
                                   "\t2. Exit");
                choice = InputManager.getInt();
                if(choice == 2){
                    exit = true;
                }
            }
            else{
                System.out.println("You have logged in successfully.\n\n");
                return true;
            }
        }

        return false;
    }
    public boolean verifyLogin() {
        String username, password;
        System.out.println("\nPlease enter username: ");
        username = InputManager.getString();
        System.out.println("Please enter password: ");
        password = InputManager.getString();

        ArrayList<Admin> adminList = loginManager.read();
        for(int i = 0; i < adminList.size(); i++){
            if(!username.equals(adminList.get(i).getUsername()) ||
               !password.equals(adminList.get(i).getPassword())){
                return false;
            }
        }
        return true;
    }
}
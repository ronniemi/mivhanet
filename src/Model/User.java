package Model;

public class User extends Person{
    String address;
    String phone;
    String mail;
    String userName;
    String password;
    Boolean status;
    MySystemModel controller;

    public void updateStatus(boolean status){};
    public String getUserName(){return null;}
    public String getPassword(){return null;}
    public void changePassword(String newPassword){};
}

package Model;

public abstract class User extends Person{
    String address;
    String phone;
    String mail;
    String userName;
    String password;
    Boolean status;

    public User(String id, String name, String address, String phone, String mail, String userName, String password, Boolean status) {
        super(id, name);
        this.address = address;
        this.phone = phone;
        this.mail = mail;
        this.userName = userName;
        this.password = password;
        this.status = status;
    }

    public String getUserName(){return userName;}
    public String getName(){return name;}
    public String getPassword(){return password;}
    public void changePassword(String newPassword){}
    public abstract String getRole();
}

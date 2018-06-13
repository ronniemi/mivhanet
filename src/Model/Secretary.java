package Model;

import java.util.HashSet;

public class Secretary extends User{

    public Secretary(String id, String name, String address, String phone, String mail, String userName, String password, Boolean status) {
        super(id, name, address, phone, mail, userName, password, status);
    }

    @Override
    public String getRole() {
        return "Secretary";
    }
}

package model;

/**
 *
 * @author admin
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String user_fullname;
    private String user_email;
    private String user_phone;
    private String user_address;
    private int role_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User(int id, String username, String password, String user_fullname, String user_email, String user_phone, String user_address, int role_id) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.user_fullname = user_fullname;
        this.user_email = user_email;
        this.user_phone = user_phone;
        this.user_address = user_address;
        this.role_id = role_id;
    }

    public User() {
    }

    public String getUser_fullname() {
        return user_fullname;
    }

    public void setUser_fullname(String user_fullname) {
        this.user_fullname = user_fullname;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public User(String username, String password, String user_fullname, String user_email, String user_phone, String user_address, int role_id) {
        this.username = username;
        this.password = password;
        this.user_fullname = user_fullname;
        this.user_email = user_email;
        this.user_phone = user_phone;
        this.user_address = user_address;
        this.role_id = role_id;
    }

    public User(String username, String password, int role) {
        this.username = username;
        this.password = password;
        this.role_id = role;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
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

    public int getRoleId() {
        return role_id;
    }

    public void setRoleId(int role_id) {
        this.role_id = role_id;
    }

}

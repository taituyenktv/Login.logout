package entity;

public class Account {
    private String username;
    private String password;
    private String email;

    public String getUsename() {
        return username;
    }

    public void setUsename(String usename) {
        this.username = usename;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Account(String usename, String password, String email) {
        this.username = usename;
        this.password = password;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Account{" +
                " Tên đăng nhập: " + username +
                ", Mật khẩu: " + password +
                ", Thư điện tử: " + email +
                '}';
    }
}

package handle;

import entity.Account;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CheckHandle {
    public void emailRegex(Scanner sc, String email) {

        String regexPattern = "^(?=.{1,30}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        while (!Pattern.compile(regexPattern)
                .matcher(email)
                .matches()) {
            System.out.println("Mời bạn nhập đúng theo định dạng của email:" +
                    "(example@gmail.com)");
            email = sc.nextLine();
        }
    }

    public void checkEmail(Scanner sc, ArrayList<Account> accounts, String email) {

        for (Account e : accounts) {
            if (e.getEmail().equalsIgnoreCase(String.valueOf(email))) {
                System.out.println("Email này đã được sử dụng mới nhập email khác.");
                email = sc.nextLine();
            }
        }
    }

    public void checkUsername(Scanner sc, ArrayList<Account> accounts, String username) {

        for (Account e : accounts) {
            if (e.getUsename().equalsIgnoreCase(String.valueOf(username))) {

                System.out.println("Tài khoản này đã được sử dụng mới nhập Tài khoản khác.");
                username = sc.nextLine();
            }

        }
    }

    public void checkPassword(Scanner sc, String password) {
        // (?=.*[A-Z]) mặc định có 1 chứ hoa, (?=.*[-.,_;]) phải có 1 ký tự đặc biệt .{7,15} có từ 7~15 ký tự
        String regexPattern = "^(?=.*[A-Z]).(?=.*[-.,_;]).{7,15}$";

        while (!Pattern.compile(regexPattern).matcher(password).matches()) {
            System.out.println("Mời bạn nhập mật khẩu đúng theo định dạng của mật khẩu :" +
                    "(Mật khẩu  từ 7 đến 15 ký tự, chứa ít nhất 1 ký tự in hoa, 1 ký tự đặc biệt (. , - _ ;) ");
            password = sc.nextLine();

        }

    }


}



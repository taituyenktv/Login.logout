package handle;

import entity.Account;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountHandle {

    public Account creatAccount(Scanner sc, ArrayList<Account> accounts) {
        CheckHandle checkHandle = new CheckHandle();


        System.out.println("Mời bạn nhập tên đăng nhập: ");
        String user = sc.nextLine();
        checkHandle.checkUsername(sc, accounts, user);

        System.out.println("Mời bạn nhập mật khẩu đăng nhập: ");
        String password = sc.nextLine();
        checkHandle.checkPassword(sc, password);

        System.out.println("Mời bạn nhập email đăng nhập: ");
        String email = sc.nextLine();
        checkHandle.emailRegex(sc, email);
        checkHandle.checkEmail(sc, accounts, email);

        return new Account(user, password, email);

    }

    public Account upDateUser(Scanner sc, Account account, ArrayList<Account> accounts) {
        CheckHandle checkHandle = new CheckHandle();
        System.out.println("Mời bạn nhập tài khoản mới: ");
        String newUser = sc.nextLine();
        checkHandle.checkUsername(sc, accounts, newUser);
        account.setUsename(newUser);
        return account;
    }

    public Account upDateEmail(Scanner sc, ArrayList<Account> accounts, Account account) {
        CheckHandle checkHandle = new CheckHandle();
        System.out.println("Mời bạn nhập email mới: ");
        String newEmail = sc.nextLine();
        checkHandle.checkEmail(sc, accounts, newEmail);
        account.setEmail(newEmail);
        return account;
    }

    public Account upDatePass(Scanner sc, Account account) {
        CheckHandle checkHandle = new CheckHandle();
        System.out.println("Mời bạn nhập mật khẩu mới: ");
        String newPassword = sc.nextLine();
        checkHandle.checkPassword(sc, newPassword);
        account.setPassword(newPassword);
        return account;
    }
}

import entity.Account;
import handle.AccountHandle;
import handle.LoginHandle;
import show.Menu;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<>();
// Khởi tạo tài khoản có sẵn
        Account account1 = new Account("taituyen1","Taituyen1","taituyen1@gmail.com");
        accounts.add(account1);
        Account account2 = new Account("taituyen2","Taituyen2","taituyen2@gmail.com");
        accounts.add(account2);
        Account account3 = new Account("taituyen3","Taituyen3","taituyen3@gmail.com");
        accounts.add(account3);


        Menu menu = new Menu();
        menu.choseMenu(sc, accounts);

    }
}

package show;

import entity.Account;
import handle.AccountHandle;
import handle.LoginHandle;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public void menu() {
        System.out.println("=========== ĐĂNG NHẬP TÀI KHOẢN =========");
        System.out.println("1. Đăng nhập " + "\n" +
                "2. Đăng ký "+ "\n" +
                "3. Thoát ");
        System.out.println("Mời bạn chọn");
    }

    public void accountManagement() {
        System.out.println("=========== QUẢN LÝ TÀI KHOẢN =========");
        System.out.println("" +
                "1. Thay đổi Tên đăng nhập\n" +
                "2. Thay đổi email\n" +
                "3. Thay đổi mật khẩu\n" +
                "4. Đăng xuất (Sau khi đăng xuất quay về mục yêu cầu đăng nhập hoặc đăng ký)\n" +
                "0. Thoát chương trình");
        System.out.println("Mời bạn chọn");

    }


    public void choseMenu(Scanner sc, ArrayList<Account> accounts) {
        AccountHandle accountHandle = new AccountHandle();
        LoginHandle loginHandle = new LoginHandle();
        do {
            menu();
            int choose = 0;
            try {
                choose = Integer.parseInt(sc.nextLine());

            } catch (Exception e) {
                do {
                    System.out.println("Bạn nhập sai định dạng dữ liệu mời nhập lại kiểu số");

                    break;


                } while (choose != 1 && choose != 2 && choose != 3);
            }
            if (choose == 3) break;
            if (choose < 0 || choose > 3) System.out.println("Bạn hãy chọn 1, 2 hoặc 3.");
            switch (choose) {
                case 1:
                    loginHandle.login(accounts, sc);
                    break;
                case 2:

                    accountHandle.creatAccount(sc, accounts);
                    break;
            }

        }
        while (true);
    }
}



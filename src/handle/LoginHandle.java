package handle;

import entity.Account;
import io.grpc.internal.JsonUtil;
import show.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginHandle {
    public String login(ArrayList<Account> accounts, Scanner sc) {
        String userName = "";
        String password = "";
        Account accountOut;
        do {
//            System.out.println("Tên đăng nhập chưa chính xác mời bạn kiểm tra lại");

            System.out.println("Mời bạn nhập tài khoản:");
            userName = sc.nextLine();

            System.out.println("Mời bạn nhập mật khẩu:");
            password = sc.nextLine();

            accountOut = checkAccount(sc, userName, password, accounts);
        } while (accountOut == null);

        accountManage(accounts, sc, accountOut);

        return "Tài khoản không tồn tại!";

    }

    public Account checkAccount(Scanner sc, String userName, String password, ArrayList<Account> accounts) {
//        CheckHandle checkHandle = new CheckHandle();
        for (Account a : accounts) {

            if (a.getUsename().equalsIgnoreCase(userName)) {

                if(a.getPassword().equals(password)) {

                    return a;

                } else {
                    do {
                        System.out.println("1. Đăng nhập lại " + "\n" +
                                "2. Quên mật khẩu ");

                        System.out.println("Mời bạn chọn:");

                        int passwordchoose = 0;

                        try {
                            passwordchoose = Integer.parseInt(sc.nextLine());

                        } catch (Exception e) {
                            do {
                                System.out.println("Bạn nhập sai định dạng dữ liệu mời nhập lại kiểu số");
                                try {
                                    passwordchoose = Integer.parseInt(sc.nextLine());
                                }catch (Exception q){break;}
                            } while (passwordchoose != 1 && passwordchoose != 2 && passwordchoose != 3);
                        }
//                        if (passwordchoose == 3) return;
                        if (passwordchoose == 1) {
                            System.out.println("Mời bạn nhập lại tài khoản:");
                            userName = sc.nextLine();

                            System.out.println("Mời bạn nhập  mật khẩu:");
                            password = sc.nextLine();
                        } else if (passwordchoose == 2) {

                            Account account = forgotPassword(sc, accounts);
                            System.out.println("Mời bạn nhập Mật khẩu mới");
                            password = sc.nextLine();
                            inPutUpdatePSByemail(account, sc,password);


                        }
                    } while (a.getUsename().equalsIgnoreCase(userName) && a.getPassword().equals(password));

                    return a;
                }
            }
        }
        return null;
    }

    public void accountManage(ArrayList<Account> accounts, Scanner sc, Account a) {
        Menu menu = new Menu();

        int chosseManagement = 0;
        do {
            menu.accountManagement();
            try {
                chosseManagement = Integer.parseInt(sc.nextLine());
                if (chosseManagement < 0 || chosseManagement > 4) {
                    System.out.println("Mời chọn lại ");
                }

            } catch (Exception e) {
                do {

                    System.out.println("Bạn nhập sai định dạng dữ liệu mời nhập lại kiểu số");

                    break;
                } while (chosseManagement != 0 && chosseManagement != 1 && chosseManagement != 2 && chosseManagement != 3 && chosseManagement != 4);

            }
        } while (chosseManagement != 0 && chosseManagement != 1 && chosseManagement != 2 && chosseManagement != 3 && chosseManagement != 4);

        if (chosseManagement == 4) return;
        if (chosseManagement == 0) return;
        AccountHandle accountHandle = new AccountHandle();
        if (chosseManagement == 1) {
            accountHandle.upDateUser(sc, a, accounts);

        } else if (chosseManagement == 2) {
            accountHandle.upDateEmail(sc, accounts, a);

        } else if (chosseManagement == 3) {
            accountHandle.upDatePass(sc, a);
        }
    }

    public Account forgotPassword(Scanner sc, ArrayList<Account> accounts) {

        System.out.println("Mời bạn nhập email :");
        String email = sc.nextLine();
        for (Account p : accounts) {
            while (p.getEmail().equalsIgnoreCase(String.valueOf(email))) {
                return p;
            }
        }
        return null;
    }

    public boolean upDatePasswordByEmail(Account account, String password) {
        if (account == null) return false;
        else {
            account.setPassword(password);

            return true;
        }
    }

    public boolean inPutUpdatePSByemail(Account account, Scanner sc,String newPassword) {
        CheckHandle checkHandle = new CheckHandle();
        checkHandle.checkPassword(sc, newPassword);
        LoginHandle loginHandle = new LoginHandle();
        boolean checkUP = loginHandle.upDatePasswordByEmail(account, newPassword);
        if (checkUP) {
            System.out.println("Cập nhật Mật khẩu thành công.");
        } else System.out.println("Không tìm thấy tài khoản cần cập nhật.");

        return checkUP;
    }


}


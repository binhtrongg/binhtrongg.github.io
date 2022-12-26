package app_login.frontend;
import app_login.backend.controller.UserController;
import app_login.backend.request.UpdateEmailRequest;
import app_login.backend.request.UpdatePasswordRequest;
import app_login.backend.request.UpdateUserNameRequest;
import java.util.Scanner;
public class Ui {
    public static UserController userController = new UserController();
    public static void run() {
        Scanner sc = new Scanner(System.in);
        int option;
        boolean isQuitMenuLogin = false;
        while (!isQuitMenuLogin) {
            showMenu();
            try {
                System.out.print("Hãy nhập lựa chọn của bạn: ");
                option = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Lựa chọn không hợp lệ. Hãy chọn lại! ");
                continue;
            }
            switch (option) {
                case 1 -> {
                    System.out.println("Nhập email:");
                    String email = sc.nextLine();
                    System.out.println("Nhập password");
                    String password = sc.nextLine();
                    if (userController.checkLogin(email, password)) {
                        int menuOption;
                        boolean isQuitMenuUser = false;
                        while (!isQuitMenuUser) {
                            showUserMenu();
                            try {
                                System.out.print("Hãy nhập lựa chọn của bạn: ");
                                menuOption = Integer.parseInt(sc.nextLine());
                            } catch (Exception e) {
                                System.out.println("Lựa chọn không hợp lệ. Hãy chọn lại! ");
                                continue;
                            }
                            switch (menuOption) {
                                case 1 -> {
                                    System.out.println("Nhập username cần thay đổi");
                                    String updateUsername = sc.nextLine();
                                    UpdateUserNameRequest updateUserNameRequest = new UpdateUserNameRequest(email, updateUsername);
                                    userController.updateUsername(updateUserNameRequest);
                                    System.out.println("Đổi Username thành công");
                                }
                                case 2 -> {
                                    System.out.println("Nhập email cần thay đổi");
                                    String emailUpdate = sc.nextLine();
                                    if (userController.checkEmailExist(emailUpdate)) {
                                        System.out.println("Email đã tồn tại,hãy nhập lại");
                                    } else {
                                        UpdateEmailRequest updateEmailRequest = new UpdateEmailRequest(email, emailUpdate);
                                        userController.updateEmail(updateEmailRequest);
                                        System.out.println("Đổi email  thành công");
                                    }
                                }
                                case 3 -> {
                                    System.out.println("Nhập mật khẩu mới");
                                    String newPassword = sc.nextLine();
                                    UpdatePasswordRequest updatePassword = new UpdatePasswordRequest(email, newPassword);
                                    userController.updatePassword(updatePassword);
                                    System.out.println("Đổi mật khẩu thành công");
                                }
                                case 4 -> isQuitMenuUser = true;
                                case 5 -> {
                                    System.out.println("bai bai");
                                    isQuitMenuUser = true;
                                    isQuitMenuLogin = true;
                                }
                            }
                        }
                    } else {
                        System.out.println("Thông tin tài khoản hoặc mật khẩu không chính xác,Hãy đăng nhập lại");
                    }
                }
                case 2 -> {
                    System.out.println("ĐĂNG KÍ TÀI KHOẢN");
                    System.out.println("Nhập username");
                    String username = sc.nextLine();
                    System.out.println("Nhập email đăng kí");
                    String emailSignup = sc.nextLine();
                    if (userController.checkEmailExist(emailSignup)) {
                        System.out.println("Email đã tồn tại,hãy nhập lại");
                    } else if (!userController.checkEmailRegex(emailSignup)) {
                        System.out.println("Email cần đúng định dạng,hãy nhập lại");
                    } else {
                        System.out.println("nhập mật khẩu");
                        String passwordSignup = sc.nextLine();
                        if (!userController.checkPassRegex(passwordSignup)) {
                            System.out.println("Mật khẩu từ 7-15 kí tự");
                        } else {
                            System.out.println("Đăng kí thành công");
                            userController.AddUser(username, emailSignup, passwordSignup);
                        }
                    }
                }
                case 3 -> {
                    System.out.println("QUÊN MẬT KHẨU");
                    System.out.println("Nhập email");
                    String email = sc.nextLine();
                    if (userController.checkEmailExist(email)) {
                        System.out.println("Nhập mật khẩu mới");
                        String newPassword = sc.nextLine();
                        UpdatePasswordRequest updatePassword = new UpdatePasswordRequest(email, newPassword);
                        userController.updatePassword(updatePassword);
                        System.out.println("Cập nhật mật khẩu thành công");
                    } else {
                        System.out.println("Không có tài khoản nào có email " + email);
                    }
                }
            }
        }
    }
    public static void showMenu() {
        System.out.println("1 - Đăng nhập");
        System.out.println("2 - Đăng ký");
        System.out.println("3 - Quên mật khẩu");
    }
    public static void showUserMenu() {
        System.out.println("1 - Thay đổi username");
        System.out.println("2 - Thay đổi email");
        System.out.println("3 - Thay đổi mật khẩu");
        System.out.println("4 - Đăng xuất");
        System.out.println("5 - Thoát");
    }
}

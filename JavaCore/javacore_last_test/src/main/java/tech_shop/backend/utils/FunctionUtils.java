package tech_shop.backend.utils;

import tech_shop.backend.model.*;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Pattern;

public class FunctionUtils {
    public static boolean checkEmailRegex(String emailSignup) {
        String emailRegex = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        Pattern p = Pattern.compile(emailRegex);
        return p.matcher(emailSignup).find();
    }

    public static boolean checkPassRegex(String passwordSignup) {
        String passwordRegex = "^[a-zA-Z0-9]{7,15}$";
        Pattern p = Pattern.compile(passwordRegex);
        return p.matcher(passwordSignup).find();
    }

    public static String currency(int price) {
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        return currencyVN.format(price);
    }

    public static void productsInfor(List<Product> list) {
        System.out.printf(" %42s %n", "DANH SÁCH SẢN PHẨM");
        System.out.printf("------------------------------------------------------------------------%n");
        System.out.printf("| %-2s | %-23s | %s | %s | %-12s |%n", "ID", "TÊN", "THƯƠNG HIỆU", "SỐ LƯỢNG", "GIÁ");
        System.out.printf("------------------------------------------------------------------------%n");
        list.forEach(System.out::println);
        System.out.printf("------------------------------------------------------------------------%n");
    }

    public static void userInfor(User user) {
        System.out.println("THÔNG TIN CÁ NHÂN");
        System.out.printf("--------------------------------------------------------------------------------------------%n");
        System.out.printf("| %-2s | %-23s | %-23s | %-11s | %-17s |%n", "ID", "NAME", "EMAIL", "PHONENUMBER", "ADDRESS");
        System.out.printf("--------------------------------------------------------------------------------------------%n");
        System.out.println(user);
        System.out.printf("--------------------------------------------------------------------------------------------%n");
    }

    public static void productInfor(Product product) {
        System.out.printf("-----------------------------------------------------------------------%n");
        System.out.printf("| %-2s | %-23s | %-10s | %s | %-12s |%n", "ID", "TÊN", "THƯƠNG HIỆU", "SỐ lƯỢNG", "GIÁ");
        System.out.printf("-----------------------------------------------------------------------%n");
        System.out.println(product);
        System.out.printf("-----------------------------------------------------------------------%n");
    }

    public static void usersInfor(List<User> list) {
        System.out.printf(" %42s %n", "DANH SÁCH KHÁCH HÀNG");
        System.out.printf("--------------------------------------------------------------------------------------------%n");
        System.out.printf("| %-2s | %-23s | %-23s | %-11s | %-17s |%n", "ID", "NAME", "EMAIL", "PHONENUMBER", "ADDRESS");
        System.out.printf("--------------------------------------------------------------------------------------------%n");
        list.forEach(System.out::println);
        System.out.printf("--------------------------------------------------------------------------------------------%n");
    }

    public static void cartInfor(List<CartItem> cartItems) {
        System.out.printf(" %42s %n", "THÔNG TIN GIỎ HÀNG");
        System.out.printf("----------------------------------------------------------------------------------------%n");
        System.out.printf("| %-2s | %-23s | %-10s | %s | %-12s | %s |%n", "ID", "NAME", "BRAND", "QUANTITY", "PRICE", "QUANTITYONCART");
        System.out.printf("----------------------------------------------------------------------------------------%n");
        cartItems.forEach((System.out::println));
        System.out.printf("----------------------------------------------------------------------------------------%n");
    }

    public static void historyInfor(List<HistoryTran> historyTrans) {
        System.out.printf(" %35s %n", "LỊCH SỬ GIAO DỊCH");
        System.out.printf("-------------------------------------------------------------%n");
        System.out.printf("| %-20s | %-15s | %-16s |%n", "THỜI GIAN", "BIẾN ĐỘNG SỐ DƯ", "NỘI DUNG");
        System.out.printf("-------------------------------------------------------------%n");
        historyTrans.forEach((System.out::println));
        System.out.printf("-------------------------------------------------------------%n");
    }

    public static void OderInfor(List<Order> orders) {
        for (Order oder : orders) {
            List<CartItem> cartItems = oder.getCart();
            System.out.print("\n                      THÔNG TIN ĐƠN HÀNG");
            System.out.println("\n---------------------------------------------------------------");
            System.out.println("\tMã Đơn Hàng : " + oder.getId());
            System.out.println("\tThông Tin Người Nhận :");
            System.out.println("\t+Tên Khách Hàng : " + oder.getName());
            System.out.println("\t+Số Điện Thoại : " + oder.getPhone());
            System.out.println("\t+Email : " + oder.getEmail());
            System.out.println("\t+Địa Chỉ : " + oder.getAddress());
            System.out.println("Chi Tiết Đơn Hàng : ");
            System.out.println("---------------------------------------------------------------");
            System.out.printf("| %-2s | %-25s | %s | %-15s |\n", "Id", "Tên", "Số lượng", "Đơn Giá");
            System.out.println("---------------------------------------------------------------");
            for (CartItem item : cartItems) {
                System.out.printf("| %-2d | %-25s | %-8d | %-15s |\n", item.getProduct().getId(), item.getProduct().getName(), item.getQuantityOnCart(), FunctionUtils.currency(item.getProduct().getPrice()));
            }
            System.out.println("---------------------------------------------------------------");
            System.out.printf("| %-59s |%n", "Tổng giá trị đơn hàng: " + currency(totalOderMoney(oder)));
            System.out.println("---------------------------------------------------------------");
            System.out.printf("| %-28s | %-27s |%n", "Thời Gian : " + oder.getTime(), "Trạng Thái : " + oder.getOrderStatus());
            System.out.println("---------------------------------------------------------------");
        }
    }

    public static void totalMoneyInfo(int money) {
        System.out.printf("| %-84s |%n", "Tổng Giá Trị Đơn Hàng " + currency(money));
        System.out.printf("----------------------------------------------------------------------------------------%n");
    }

    public static int  totalOderMoney(Order order) {
        List<CartItem> cart = order.getCart();
        return cart.stream()
                .map(item -> item.getQuantityOnCart() * item.getProduct().getPrice())
                .mapToInt(a -> a)
                .sum();
    }

    public static String verifyCode() {
        String alpha = "abcdefghijklmnopqrstuvwxyz"; // a-z
        String alphaUpperCase = alpha.toUpperCase(); // A-Z
        String digits = "0123456789"; // 0-9
        String ALPHA_NUMERIC = alpha + alphaUpperCase + digits;
        StringBuilder sb = new StringBuilder();
        int verifyCode = 6;
        for (int i = 0; i < verifyCode; i++) {
            int number = randomNumber(0, ALPHA_NUMERIC.length() - 1);
            char ch = ALPHA_NUMERIC.charAt(number);
            sb.append(ch);
        }

        return sb.toString();
    }

    public static int randomNumber(int min, int max) {
        Random generator = new Random();
        return generator.nextInt((max - min) + 1) + min;
    }

    public static String getDate() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy  HH:mm"));
    }
    public static String salesDate(){
        LocalDate localDate=LocalDate.now();
        return localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public static void feedbackInfor(List<Feedback>feedbacks) {
        System.out.println("\nPHẢN HỒI CỦA KHÁCH HÀNG");
        System.out.println("------------------------------------------------------------");
        System.out.printf(" %-20s  %-15s  %s %n", "KHÁCH HÀNG", "ĐƠN HÀNG", "NỘI DUNG PHẢN HỒI");
        System.out.printf("-------------------------------------------------------------%n");
        feedbacks.forEach((System.out::println));
        System.out.printf("-------------------------------------------------------------%n");
    }

    public static String salesM() {
        LocalDate localDate=LocalDate.now();
        return localDate.format(DateTimeFormatter.ofPattern("MM/yyyy"));
    }
}

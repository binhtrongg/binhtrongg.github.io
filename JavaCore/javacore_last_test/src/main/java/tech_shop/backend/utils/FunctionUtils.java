package tech_shop.backend.utils;

import tech_shop.backend.model.CartItem;
import tech_shop.backend.model.Product;
import tech_shop.backend.model.User;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Pattern;

public class FunctionUtils {
    public static boolean checkEmailRegex(String emailSignup) {
        String emailRegex="^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        Pattern p = Pattern.compile(emailRegex);
        return p.matcher(emailSignup).find();
    }
    public static boolean checkPassRegex(String passwordSignup) {
        String passwordRegex="^[a-zA-Z0-9]{7,15}$";
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
        System.out.printf("-----------------------------------------------------------------------%n");
        System.out.printf("| %-2s | %-23s | %-10s | %s | %-12s |%n", "ID", "NAME", "BRAND", "QUANTITY", "PRICE");
        System.out.printf("-----------------------------------------------------------------------%n");
        list.forEach(System.out::println);
        System.out.printf("-----------------------------------------------------------------------%n");
    }
    public static void userInfor(User user){
        System.out.println("THÔNG TIN CÁ NHÂN");
        System.out.printf("--------------------------------------------------------------------------------------------%n");
        System.out.printf("| %-2s | %-23s | %-23s | %-11s | %-17s |%n","ID","NAME","EMAIL","PHONENUMBER","ADDRESS");
        System.out.printf("--------------------------------------------------------------------------------------------%n");
        System.out.println(user);
        System.out.printf("--------------------------------------------------------------------------------------------%n");
    }

    public static void productInfor(Product product) {
        System.out.printf("-----------------------------------------------------------------------%n");
        System.out.printf("| %-2s | %-23s | %-10s | %s | %-12s |%n", "ID", "NAME", "BRAND", "QUANTITY", "PRICE");
        System.out.printf("-----------------------------------------------------------------------%n");
        System.out.println(product);
        System.out.printf("-----------------------------------------------------------------------%n");
    }
    public static void usersInfor(List<User> list) {
        System.out.printf(" %42s %n","DANH SÁCH KHÁCH HÀNG");
        System.out.printf("--------------------------------------------------------------------------------------------%n");
        System.out.printf("| %-2s | %-23s | %-23s | %-11s | %-17s |%n", "ID", "NAME", "EMAIL", "PHONENUMBER","ADDRESS");
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
    public static void totalMoneyInfo(int money){
        System.out.printf("| %-84s |%n","Tổng Giá Trị Đơn Hàng "+currency(money));
        System.out.printf("----------------------------------------------------------------------------------------%n");
    }
    public static String verifyCode() {
        String alpha = "abcdefghijklmnopqrstuvwxyz"; // a-z
        String alphaUpperCase = alpha.toUpperCase(); // A-Z
        String digits = "0123456789"; // 0-9
        String ALPHA_NUMERIC = alpha + alphaUpperCase + digits;
        StringBuilder sb = new StringBuilder();
        int verifyCode=6;
        for (int i = 0; i < verifyCode; i++) {
            int number =randomNumber(0, ALPHA_NUMERIC.length() - 1);
            char ch = ALPHA_NUMERIC.charAt(number);
            sb.append(ch);
        }

        return sb.toString();
    }
    public static int randomNumber (int min, int max){
        Random generator=new Random();
        return generator.nextInt((max - min) + 1) + min;
    }
}

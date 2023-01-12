package tech_shop.frontend;

import tech_shop.backend.controller.*;
import tech_shop.backend.exception.NotFoundException;
import tech_shop.backend.model.CartItem;
import tech_shop.backend.model.Product;
import tech_shop.backend.request.CreatAccountRequest;
import tech_shop.backend.request.CreatProductRequest;
import tech_shop.backend.utils.FunctionUtils;

import java.util.List;
import java.util.Scanner;

public class View {
    static final UserController userController = new UserController();
    static final AdminController adminController = new AdminController();
    static final ProductController productController = new ProductController();
    static final CartController cartController = new CartController();
    static final EpayController epayController = new EpayController();

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int option;
        boolean isQuit = false;
        while (!isQuit) {
            showMenu();
            try {
                System.out.print("Nhập lựa chọn : ");
                option = Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                System.out.println("Lựa Chọn Không Hợp Lệ");
                continue;
            }
            switch (option) {
                case 1 -> guestUi();
                case 2 -> applogin();
                case 3 -> signupUi();
                case 4 -> forgotPassword();
                case 5 -> isQuit = true;
            }
        }
    }
    private static void guestUi() {
        Scanner scanner = new Scanner(System.in);
        int choose;
        boolean isQuitGuest = false;
        while (!isQuitGuest) {
            menuGuest();
            try {
                System.out.print("Nhập lựa chọn : ");
                choose = Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                System.out.println("Lựa Chọn Không Hợp Lệ");
                continue;
            }
            switch (choose) {
                case 1 -> {
                    FunctionUtils.productsInfor(productController.products());
                    warning();
                }
                case 2 -> searchUi();
                case 3 -> isQuitGuest = true;
            }
        }
    }

    private static void userUi(String email) {
        Scanner scanner = new Scanner(System.in);
        int option;
        boolean isQuit = false;
        while (!isQuit) {
            userController.getname(email);
            userMenu();
            try {
                System.out.print("Nhập lựa chọn : ");
                option = Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                System.out.println("Lựa Chọn Không Hợp Lệ");
                continue;
            }
            switch (option) {
                case 1 -> FunctionUtils.productsInfor(productController.products());
                case 2 -> searchUserUi(email);
                case 3 -> cartUi(email);
                case 4 -> epay(email);
                case 5 -> updateProfile(email);
                case 6 -> isQuit = true;
            }
        }
    }
//    giao diện tìm kiếm của khách
    private static void searchUi() {
        Scanner scanner = new Scanner(System.in);
        int option;
        boolean isQuitSearchMenu = false;
        while (!isQuitSearchMenu) {
            searchMenu();
            try {
                System.out.print("Nhập lựa chọn : ");
                option = Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                System.out.println("Lựa Chọn Không Hợp Lệ");
                continue;
            }
            switch (option) {
                case 1 -> findById();
                case 2 -> findByName();
                case 3 -> findByPrice();
                case 4 -> isQuitSearchMenu = true;
            }
        }
    }
//    giao diện tìm kiếm của khách
    private static void findById() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập Id cần tìm kiếm : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        try {
            Product product = productController.findProductById(id);
            FunctionUtils.productInfor(product);
            warning();
        } catch (NotFoundException notFoundException) {
            System.out.println("Không Có Sản Phẩm Nào Có Id " + id);
        }
    }
//    Giao diện tìm Kiếm khi Đăng Nhập
    private static void searchUserUi(String email) {
        Scanner scanner = new Scanner(System.in);
        int option;
        boolean isQuitSearchMenu = false;
        while (!isQuitSearchMenu) {
            searchMenu();
            try {
                System.out.print("Nhập lựa chọn : ");
                option = Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                System.out.println("Lựa Chọn Không Hợp Lệ");
                continue;
            }
            switch (option) {
                case 1 -> findByIdToAdd(email);
                case 2 -> findByName();
                case 3 -> findByPrice();
                case 4 -> isQuitSearchMenu = true;
            }
        }
    }
//    tìm Sản phẩm theo id(kèm chức năng thêm vào giỏ hàng)
    private static void findByIdToAdd(String email) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập Id cần tìm kiếm : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        try {
            Product product = productController.findProductById(id);
            FunctionUtils.productInfor(product);
            addToCart(id,email, product);
        } catch (NotFoundException notFoundException) {
            System.out.println("Không Có Sản Phẩm Nào Có Id " + id);
        }
    }
//    Thêm sản phẩm vào giỏ
    public static void addToCart(int id,String email, Product product) {
        Scanner scanner = new Scanner(System.in);
        int option;
        boolean isQuit = false;
        while (!isQuit) {
            addToCartMenu();
            try {
                System.out.print("Nhập lựa chọn : ");
                option = Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                System.out.println("Lựa Chọn Không Hợp Lệ");
                continue;
            }
            switch (option) {
                case 1 -> {
                    System.out.print("Nhập Số Lượng Muốn Thêm : ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();
                    boolean checkQuantity = cartController.checkQuantity(product, quantity);
                    if (checkQuantity) {
                        System.out.println("Số Lượng Sản Phẩm Trong Shop Không Đủ");
                    } else {
                        CartItem cartItem = new CartItem(email, product, quantity);
                        cartController.addItemToCart(id,cartItem);
                        System.out.println("Thêm Sản Phẩm Vào Giỏ Hàng Thành Công");
                        isQuit = true;
                    }
                }
                case 2 -> isQuit = true;
            }
        }
    }
//    tìm kiếm theo tên sản Phẩm
    private static void findByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên sản phẩm cần tìm kiếm : ");
        String name = scanner.nextLine();
        try {
            List<Product> products = productController.findProDuctByName(name);
            FunctionUtils.productsInfor(products);
            warning();
        } catch (NotFoundException notFoundException) {
            System.out.println("Không Có Sản Phẩm Nào Có Tên " + name);
        }
    }
//    tìm kiếm theo mức giá(lọc từ mức a-b)
    private static void findByPrice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hãy nhập khoảng giá bạn cần tìm");
        System.out.print("Từ : ");
        int minPrice = scanner.nextInt();
        System.out.print("Đến : ");
        int maxPrice = scanner.nextInt();
        List<Product> products = productController.findProductByPrice(minPrice, maxPrice);
        if (products.isEmpty()) {
            System.out.println("Không Có Sản Phẩm Nào Có Mức Giá Từ " + minPrice + " Đến " + maxPrice);
        } else {
            FunctionUtils.productsInfor(products);
            warning();
        }
    }
//    Giao diện giỏ hàng
    private static void cartUi(String email) {
        Scanner scanner = new Scanner(System.in);
        int option;
            if (cartController.cart(email).isEmpty()) {
                System.out.println("Giỏ Hàng Đang Trống..");
            } else {
                FunctionUtils.cartInfor(cartController.cart(email));
                FunctionUtils.totalMoneyInfo(cartController.getTotalMoney(email));
                cartMenu();
                System.out.print("Nhập Lựa Chọn : ");
                option=scanner.nextInt();
                switch (option) {
                    case 1 -> deleteCartItem();
                    case 2 -> {
                        deleteAllItem(email);
                        System.out.println("Đã Xóa Tất Cả Sản Phẩm Khỏi Giỏ");
                    }
                    case 3 ->updateQuantityonCart();
                    case 4 ->purchase(email);
                }
            }

    }

    private static void updateQuantityonCart() {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Nhập Id Cần Cập Nhật Số Lượng : ");
        int id=scanner.nextInt();
        System.out.print("Nhập Số Lượng Cần Cập Nhật : ");
        int quantityOnCart=scanner.nextInt();
        try {
            cartController.updateQuantityOnCart(id,quantityOnCart);
            System.out.println("Cập Nhật Số Lượng Thành Công");
        }catch (NotFoundException e){
            System.out.println("Không Có Sản Phẩm Nào Có Id "+id+" Trong Giỏ Hàng");
        }
    }

    //    xóa sản phẩm khỏi giỏ hàng
    private static void deleteCartItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập Id Cần Xóa Từ Giỏ Hàng : ");
        int id = scanner.nextInt();
        cartController.deleteCartItem(id);
        System.out.println("Đã Xóa Sản Phẩm Có Id " + id + " Khỏi Giỏ Hàng");
    }
//    xóa tất cả sản phẩm khỏi giỏ
    private static void deleteAllItem(String email) {
        cartController.deleteAllItem(email);
    }
//    thanh toán đơn hàng(sử dụng ví hoặc tiền mặt)
    private static void purchase(String email) {
        Scanner scanner = new Scanner(System.in);
        int option=0;
        purchaseMenu();
        try {
            System.out.print("Nhập lựa chọn : ");
            option = Integer.parseInt(scanner.nextLine());
        }catch (Exception e){
            System.out.println("Lựa Chọn Không Hợp Lệ");
        }
        switch (option) {
            case 1 -> {
//                sử dụng ví
                int moneyInEpay = epayController.getMoney(email);
                int totalCartMoney = cartController.getTotalMoney(email);
                if (moneyInEpay < totalCartMoney) {
                    System.out.println("Thanh Toán Thất Bại,Số Dư Ví Không Đủ,Vui Lòng Nạp Thêm Hoặc Chọn Phương Thức Thanh Toán Khác");
                } else {
                    String verifyCode = FunctionUtils.verifyCode();
                    System.out.println("Mã Xác Nhận : " + verifyCode);
                    System.out.print("Nhập Lại Mã Xác Nhận : ");
                    String verify = scanner.nextLine();
                    if (verify.equals(verifyCode)){
                        System.out.println("Thanh Toán Thành Công,Đơn Hàng sẽ Được Giao Tới Địa Chỉ : " + userController.getAddress(email) + " Trong Vài Ngày Tới,Hãy Giữ Liên Lạc Với Shop");
                        epayController.withdraw(email, cartController.getTotalMoney(email));
                        deleteAllItem(email);
                    }
                    else {
                        System.out.println("Thanh Toán Thất Bại,Mã Xác Nhận Không Đúng");
                    }
                }
            }
            case 2 ->
//                    sử dụng tiền mặt
                    System.out.println("Thanh Toán Thành Công,Đơn Hàng sẽ Được Giao Tới Địa Chỉ : " + userController.getAddress(email) + " Trong Vài Ngày Tới,Hãy Giữ Liên Lạc Với Shop Và Chuẩn Bị Sẵn Tiền Mặt");
        }
    }
//    ví điện tử
    private static void epay(String email) {
        epayLogin(email);
    }
//    đăng nhập ví
    private static void epayLogin(String email) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập Mật Khẩu Ví : ");
        String epassword = scanner.nextLine();
        String verifyCode = FunctionUtils.verifyCode();
        System.out.println("Mã Xác Nhận : " + verifyCode);
        System.out.print("Nhập Lại Mã Xác Nhận : ");
        String verify = scanner.nextLine();
        boolean checkElogin = epayController.checkELogin(email, epassword);
        if (verifyCode.equals(verify) && checkElogin) {
            epayui(email);
        } else {
            System.out.println("Đăng Nhập Thất Bại");
        }
    }
//    giao diện ví
    private static void epayui(String email) {
        Scanner scanner = new Scanner(System.in);
        int option;
        boolean isquit = false;
        while (!isquit) {
            System.out.println("\nSố Dư : " + FunctionUtils.currency(epayController.getMoney(email)));
            epayMenu();
            try {
                System.out.print("Nhập Lựa Chọn : ");
                option = Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                System.out.println("Lựa Chọn Không Hợp Lệ");
                continue;
            }
            switch (option) {
                case 1 -> {
//                    nạp tiền
                    System.out.print("Nhập Số Tiền Muốn Nạp : ");
                    int money = scanner.nextInt();
                    scanner.nextLine();
                    String verifyCode = FunctionUtils.verifyCode();
                    System.out.println("Mã Xác Nhận : " + verifyCode);
                    System.out.print("Nhập Mã Xác Nhận : ");
                    String verify = scanner.nextLine();
                    if (verifyCode.equals(verify)) {
                        epayController.updateMoney(email, money);
                        System.out.println("Nạp Thành Công " + FunctionUtils.currency(money));
                    } else {
                        System.out.println("Nạp Tiền Thất Bại,Hãy Nhập Đúng Mã Xác Thực");
                    }
                }
                case 2 -> {
//                    rút tiền
                    System.out.print("Nhập Số Tiền Muốn Rút : ");
                    int money = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhập Tên Ngân Hàng : ");
                    String bank = scanner.nextLine();
                    System.out.print("Nhập Số Tài Khoản : ");
                    String stk = scanner.nextLine();
                    System.out.print("Nhập Tên Chủ Tài Khoản : ");
                    String name = scanner.nextLine();
                    String verifyCode = FunctionUtils.verifyCode();
                    System.out.println("Mã Xác Nhận : " + verifyCode);
                    System.out.print("Nhập Mã Xác Nhận : ");
                    String verify = scanner.nextLine();
                    if (verifyCode.equals(verify)) {
                        epayController.withdraw(email, money);
                        System.out.println("Đã Rút Thành Công Số Tiền " + FunctionUtils.currency(money) + " Vào stk " + stk + "-" + bank + "-" + name);
                    } else {
                        System.out.println("Rút Tiền Thất Bại");
                    }
                }
                case 3 -> isquit = true;
            }
        }
    }
//    giao diện đổi thông tin user
    private static void updateProfile(String email) {
        Scanner scanner = new Scanner(System.in);
        int option;
        boolean isQuit = false;
        while (!isQuit) {
            FunctionUtils.userInfor(userController.getUser(email));
            profileMenu();
            try {
                System.out.print("Nhập Lựa Chọn : ");
                option = Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                System.out.println("Lựa Chọn Không Hợp Lệ");
                continue;
            }
            switch (option) {
                case 1 -> updatePassword(email);
                case 2 -> updatePhoneNumber(email);
                case 3 -> updateAddress(email);
                case 4 -> isQuit = true;
            }
        }
    }
//đổi địa chỉ
    private static void updateAddress(String email) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập Địa Chỉ Mới : ");
        String newAddress = scanner.nextLine();
        userController.updateAddress(email, newAddress);
        System.out.println("Đổi Địa Chỉ Thành Công");
    }
//đổi số điện thoại
    private static void updatePhoneNumber(String email) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập Số Điện Thoại Mới : ");
        String newPhoneNumber = scanner.nextLine();
        userController.updatePhoneNumber(email, newPhoneNumber);
        System.out.println("Đổi Số Điện Thoại Thành Công");
    }
//đổi mật khẩu
    private static void updatePassword(String email) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập Mật Khẩu Mới : ");
        String newPassword = scanner.nextLine();
        userController.updatePassword(email, newPassword);
        System.out.println("Đổi Mật Khẩu Thành Công");
    }

    private static void applogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n-----ĐĂNG NHẬP-----");
        System.out.print("Nhập Email : ");
        String email = scanner.nextLine();
        System.out.print("Nhập Password : ");
        String password = scanner.nextLine();
        boolean userLogin = userController.userLogin(email, password);
        boolean adminLogin = adminController.adminLogin(email, password);
        if (userLogin || adminLogin) {
            if (userLogin) {
                userUi(email);
            } else {
                adminUi();
            }
        } else {
            System.out.println("Thông Tin Tài Khoản Hoặc Mật Khẩu Không Chính Xác");
        }
    }
//giao diện admin
    private static void adminUi() {
        Scanner scanner = new Scanner(System.in);
        int option;
        boolean isQuit = false;
        while (!isQuit) {
            adminMenu();
            try {
                System.out.print("Nhập lựa chọn : ");
                option = Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                System.out.println("Lựa Chọn Không Hợp Lệ");
                continue;
            }
            switch (option) {
                case 1 -> deleteUser();
                case 2 -> creatProduct();
                case 3 -> deleteProduct();
                case 4 -> updateProduct();
                case 5 -> isQuit = true;
            }
        }
    }
//    thay đổi số lượng sản phẩm
    private static void updateProduct() {
        Scanner scanner = new Scanner(System.in);
        FunctionUtils.productsInfor(productController.products());
        System.out.print("Nhập Id Sản Phẩm Cần Thay Đổi Số Lượng");
        int id = scanner.nextInt();
        try {
            System.out.print("Nhập Số Lượng Sản Phẩm Cần Cập Nhật : ");
            int quantity = scanner.nextInt();
            productController.updateProductQuantity(id, quantity);
            System.out.println("Cập Nhật Số Lượng Sản Phẩm Thành Công");
        } catch (NotFoundException e) {
            System.out.println("Không Có Sản Phẩm Nào Có Id " + id);
        }
    }
//xóa sản phẩm
    private static void deleteProduct() {
        Scanner scanner = new Scanner(System.in);
        FunctionUtils.productsInfor(productController.products());
        System.out.println("Xóa Sản Phẩm");
        System.out.print("Nhập id Sản Phẩm Cần Xóa : ");
        int id = scanner.nextInt();
        try {
            productController.deleteProduct(id);
            System.out.println("Đã Xóa Thành Công Sản Phẩm Có Id " + id);
        } catch (NotFoundException n) {
            System.out.println("Không Có Sản Phẩm Nào Có Id " + id);
        }
    }
//thêm sản phẩm
    private static void creatProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Thêm Sản Phẩm");
        System.out.print("Nhập Tên Sản Phẩm : ");
        String name = scanner.nextLine();
        System.out.print("Nhập Thương Hiệu : ");
        String brand = scanner.nextLine();
        System.out.print("Nhập Số Lượng : ");
        int quantity = scanner.nextInt();
        System.out.print("Nhập Giá : ");
        int price = scanner.nextInt();
        CreatProductRequest creatProductRequest = new CreatProductRequest(name, brand, quantity, price);
        productController.creatProduct9(creatProductRequest);
        System.out.println("Thêm Sản Phẩm Thành Công");
    }

    private static void deleteUser() {
        FunctionUtils.usersInfor(userController.allUser());
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập Id User Cần Xóa :");
        int id = scanner.nextInt();
        userController.deleteUser(id);
        System.out.println("Đã Xóa User Có Id " + id);
    }
//    Đăng Kí
    private static void signupUi() {
        Scanner sc = new Scanner(System.in);
        boolean isQuitSignup = false;
        while (!isQuitSignup) {
            System.out.println("ĐĂNG KÍ TÀI KHOẢN");
            System.out.print("Nhập Tên : ");
            String name = sc.nextLine();
            System.out.print("Nhập email đăng kí : ");
            String emailSignup = sc.nextLine();
            if (userController.checkEmailExist(emailSignup)) {
                System.out.println("Email đã tồn tại,hãy nhập lại");
            } else if (!FunctionUtils.checkEmailRegex(emailSignup)) {
                System.out.println("Email cần đúng định dạng,hãy nhập lại");
            } else {
                System.out.print("Nhập mật khẩu : ");
                String passwordSignup = sc.nextLine();
                if (!FunctionUtils.checkPassRegex(passwordSignup)) {
                    System.out.println("Mật khẩu từ 7-15 kí tự");
                } else {
                    System.out.println("Đăng kí thành công");
                    CreatAccountRequest creatAccountRequest = new CreatAccountRequest(name, emailSignup, passwordSignup);
                    userController.creatUser(creatAccountRequest);
                    isQuitSignup = true;
                }
            }
        }
    }
//    Quên Mật Khẩu
    private static void forgotPassword() {
        Scanner sc=new Scanner(System.in);
        System.out.println("QUÊN MẬT KHẨU");
        System.out.print("Nhập Email : ");
        String email = sc.nextLine();
        if (userController.checkEmailExist(email)) {
            System.out.print("Nhập Mật Khẩu Mới");
            String newPassword = sc.nextLine();
            userController.updatePassword(email,newPassword);
            System.out.println("Cập Nhật Mật Khẩu Thành Công");
        } else {
            System.out.println("Không Có Tài Khoản Nào Có Email " + email);
        }
    }
    private static void showMenu() {
        System.out.println("\n---------- WELCOME TO TECHSHOP ----------");
        System.out.println("| 1 - Khách                             |");
        System.out.println("| 2 - Đăng Nhập                         |");
        System.out.println("| 3 - Đăng Kí                           |");
        System.out.println("| 4 - Quên Mật Khẩu                     |");
        System.out.println("| 5 - Thoát                             |");
        System.out.println("-----------------------------------------");
    }

    private static void menuGuest() {
        System.out.println("\n********* GUEST MENU *********");
        System.out.println("1 - Xem Danh Sách Sản Phẩm");
        System.out.println("2 - Tìm Kiếm ");
        System.out.println("3 - Trở Lại");
    }

    private static void searchMenu() {
        System.out.println("\n********* TÌM KIẾM SẢN PHẨM *********");
        System.out.println("1 - Theo Id");
        System.out.println("2 - Theo Tên");
        System.out.println("3 - Theo Mức Giá ");
        System.out.println("4 - Trở Lại");
    }

    private static void userMenu() {
        System.out.printf("| %-38s|%n", "1 - Xem Thông Tin Sản Phẩm");
        System.out.printf("| %-38s|%n", "2 - Tìm Kiếm Sản Phẩm");
        System.out.printf("| %-38s|%n", "3 - Xem Giỏ Hàng");
        System.out.printf("| %-38s|%n", "4 - Ví TechPay");
        System.out.printf("| %-38s|%n", "5 - Thông Tin Cá Nhân");
        System.out.printf("| %-38s|%n", "6 - Đăng Xuất");
        System.out.println("-----------------------------------------");
    }

    private static void cartMenu() {
        System.out.println("1 - Xóa Sản Phẩm Khỏi Giỏ Hàng");
        System.out.println("2 - Xóa Tất Cả Sản Phẩm Khỏi Giỏ Hàng");
        System.out.println("3 - Cập Nhật Số Lượng Sản Phẩm");
        System.out.println("4 - Mua Hàng ");
    }
    private static void addToCartMenu() {
        System.out.println("1 - Thêm Vào Giỏ Hàng");
        System.out.println("2 - Quay Lại");
    }
    private static void epayMenu() {
        System.out.println("1 - Nạp Tiền Vào Ví");
        System.out.println("2 - Rút Tiền");
        System.out.println("3 - Trở Lại");
    }
    private static void adminMenu() {
        System.out.println("\nXIN CHÀO ADMIN");
        System.out.println("1 - Xóa User");
        System.out.println("2 - Thêm Sản Phẩm");
        System.out.println("3 - Xóa Sản Phẩm");
        System.out.println("4 - Cập Nhật Thông Tin Sản Phẩm");
        System.out.println("5 - Đăng Xuất");
    }
    private static void profileMenu() {
        System.out.println("Cập Nhật Thông Tin");
        System.out.println("1 - Đổi Mật Khẩu");
        System.out.println("2 - Đổi Số Điện Thoại");
        System.out.println("3 - Đổi Địa Chỉ");
        System.out.println("4 - Trở Lại");
    }
    private static void warning() {
        System.out.println("VUI LÒNG ĐĂNG NHẬP ĐỂ DỬ DỤNG NHIỀU CHỨ NĂNG HƠN");
    }
    private static void purchaseMenu() {
        System.out.println("Chọn Phương Thức Thanh Toán : ");
        System.out.println("1 - Sử Dụng Ví TechPay");
        System.out.println("2 - Thanh Toán Khi Nhận Hàng");
        System.out.println("3 - Trở Lại");
    }
}
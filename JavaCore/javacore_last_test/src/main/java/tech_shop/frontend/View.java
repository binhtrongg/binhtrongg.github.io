package tech_shop.frontend;

import tech_shop.backend.controller.*;
import tech_shop.backend.exception.NotFoundException;
import tech_shop.backend.model.*;
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
    static final OrderController orderController = new OrderController();

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int option;
        boolean isQuit = false;
        while (!isQuit) {
            showMenu();
            try {
                System.out.print("Nhập lựa chọn : ");
                option = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
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
            } catch (Exception e) {
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
            System.out.println("\n\t    Welcome " + userController.getname(email));
            ;
            userMenu();
            try {
                System.out.print("Nhập lựa chọn : ");
                option = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Lựa Chọn Không Hợp Lệ");
                continue;
            }
            switch (option) {
                case 1 -> FunctionUtils.productsInfor(productController.products());
                case 2 -> searchUserUi(email);
                case 3 -> cartUi(email);
                case 4 -> orderStatus(email);
                case 5 -> epay(email);
                case 6 -> updateProfile(email);
                case 7 -> isQuit = true;
            }
        }
    }

    private static void orderStatus(String email) {
        Scanner scanner = new Scanner(System.in);
        int option;
        boolean isQuit = false;
        while (!isQuit) {
            orderMenu(email);
            try {
                System.out.print("Nhập lựa chọn : ");
                option = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Lựa Chọn Không Hợp Lệ");
                continue;
            }
            switch (option) {
                case 1 -> {
                    if (orderController.getOrder(email).isEmpty()) {
                        System.out.println("Không Có Đơn Hàng Chờ Xác Nhận");
                    } else {
                        oderOption(email);
                    }
                }
                case 2 -> {
                    if (orderController.getOrderDelivering(email).isEmpty()) {
                        System.out.println("Không Có Đơn Hàng Đang Giao");
                    } else {
                        orderDelivering(email);
                    }
                }
                case 3 -> {
                    if (orderController.getOrderCancel(email).isEmpty()) {
                        System.out.println("Không Có Đơn Hàng Đã Hủy");
                    } else {
                        FunctionUtils.OderInfor(orderController.getOrderCancel(email));
                    }
                }
                case 4 -> {
                    if (orderController.getOrderReiceved(email).isEmpty()) {
                        System.out.println("Không Có Đơn Hàng Đã Nhận");
                    } else {
                        orderReiceved(email);
                    }
                }
                case 5 -> isQuit = true;
            }
        }
    }

    private static void orderReiceved(String email) {
        Scanner scanner = new Scanner(System.in);
        int option;
        boolean isQuit = false;
        while (!isQuit) {
            FunctionUtils.OderInfor(orderController.getOrderReiceved(email));
            reMenu();
            try {
                System.out.print("\nNhập lựa chọn : ");
                option = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Lựa Chọn Không Hợp Lệ");
                continue;
            }
            switch (option) {
                case 1 -> {
                    feedback(email);
                    isQuit=true;
                }
                case 2 -> isQuit = true;
            }
        }
    }

    private static void feedback(String email) {
        Scanner scanner = new Scanner(System.in);
        boolean isCancel = false;
        int code = 0;
        while (!isCancel) {
            try {
                System.out.print("Feedback Cho Đơn Hàng Số : ");
                code = Integer.parseInt(scanner.nextLine());
                try {
                    orderController.findOrByid(code);
                    isCancel = true;
                } catch (NotFoundException e) {
                    System.out.println("Không Có Đơn Hàng Nào Có Mã " + code + ",Hãy Kiểm Tra Lại");
                }
            } catch (Exception e) {
                System.out.println("Mã Đơn Hàng Không Hợp Lệ,Hãy Nhập lại");
            }
        }
        System.out.print("Nội Dung FeedBack : ");
        String fb=scanner.nextLine();
        Feedback feedback=new Feedback(userController.getname(email),code,fb);
        orderController.creatFeedback(feedback);
        System.out.println("Gửi Feedback Thành Công");
    }

    private static void reMenu() {
        System.out.print("1.Gửi Feedback");
        System.out.println("\t\t2.Quay Lại");
    }

    private static void oderOption(String email) {
        Scanner scanner = new Scanner(System.in);
        int option;
        boolean isQuit = false;
        while (!isQuit) {
            FunctionUtils.OderInfor(orderController.getOrder(email));
            cancelMenu();
            try {
                System.out.print("\nNhập lựa chọn : ");
                option = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Lựa Chọn Không Hợp Lệ");
                continue;
            }
            switch (option) {
                case 1 -> {
                    cancelOrd(email);
                    isQuit = true;
                }
                case 2 -> isQuit = true;
            }
        }
    }

    private static void cancelOrd(String email) {
        Scanner scanner = new Scanner(System.in);
        boolean isCancel = false;
        while (!isCancel) {
            try {
                System.out.print("Nhập Mã Đơn Hàng Cần Hủy : ");
                int code = Integer.parseInt(scanner.nextLine());
                try {
                    orderController.cancelOrder(code);
                    System.out.println("Hủy Đơn Hàng Thành Công");
                    isCancel = true;
                } catch (NotFoundException e) {
                    System.out.println("Không Có Đơn Hàng Nào Có Mã " + code + ",Hãy Kiểm Tra Lại");
                }
            } catch (Exception e) {
                System.out.println("Mã Đơn Hàng Không Hợp Lệ,Hãy Nhập lại");
            }
        }
        orderController.getOrder(email).clear();
    }

    private static void orderDelivering(String email) {
        Scanner scanner = new Scanner(System.in);
        int option;
        boolean isQuit = false;
        while (!isQuit) {
            FunctionUtils.OderInfor(orderController.getOrderDelivering(email));
            reicevedMenu();
            try {
                System.out.print("\nNhập lựa chọn : ");
                option = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Lựa Chọn Không Hợp Lệ");
                continue;
            }
            switch (option) {
                case 1 -> {
                    reiceved(email);
                    isQuit = true;
                }
                case 2 -> isQuit = true;
            }
        }
    }

    private static void reiceved(String email) {
        Scanner scanner = new Scanner(System.in);
        boolean isReiceved = false;
        while (!isReiceved) {
            try {
                System.out.print("Bạn Đã Nhận Đơn Hàng Số : ");
                int code = Integer.parseInt(scanner.nextLine());
                try {
                    orderController.receivedOrd(code);
                    System.out.println("Thông Báo Nhận Hàng Thành Công");
                    isReiceved = true;
                } catch (NotFoundException e) {
                    System.out.println("Không Có Đơn Hàng Nào Có Mã " + code + ",Hãy Kiểm Tra Lại");
                }
            } catch (Exception e) {
                System.out.println("Mã Đơn Hàng Không Hợp Lệ,Hãy Nhập lại");
            }
        }
        orderController.getOrder(email).clear();
    }

    private static void reicevedMenu() {
        System.out.print("1.Đã Nhận Được Hàng");
        System.out.println("\t\t2.Quay Lại");
    }

    private static void orderMenu(String email) {
        System.out.println("\nTRẠNG THÁI ĐƠN HÀNG");
        System.out.println("1.Đơn Hàng Chờ Phê Duyệt(" + orderController.getOrder(email).size() + ")");
        System.out.println("2.Đơn Hàng Đang Giao(" + orderController.getOrderDelivering(email).size() + ")");
        System.out.println("3.Đơn Hàng Đã Hủy(" + orderController.getOrderCancel(email).size() + ")");
        System.out.println("4.Đơn Hàng Đã Nhận(" + orderController.getOrderReiceved(email).size() + ")");
        System.out.println("5.Quay Lại");
    }

    private static void cancelMenu() {
        System.out.print("1.Hủy Đơn Hàng");
        System.out.print("\t2.Quay Lại");
    }

    private static void creatOrder(String email) {
        Order order = new Order(orderController.getIdoder(), email, cartController.cart(email), userController.getUser(email).getName(), userController.getUser(email).getPhoneNumber(), userController.getAddress(email), FunctionUtils.getDate(), OrderStatus.CHỜ_PHÊ_DUYỆT);
        orderController.creatOrder(order);
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
            } catch (Exception e) {
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
        boolean isFind=false;
        while (!isFind) {
            try {
                System.out.print("Nhập Id cần tìm kiếm : ");
                int id = Integer.parseInt(scanner.nextLine());
                try {
                    Product product = productController.findProductById(id);
                    FunctionUtils.productInfor(product);
                    warning();
                    isFind=true;
                } catch (NotFoundException notFoundException) {
                    System.out.println("Không Có Sản Phẩm Nào Có Id " + id);
                }
            } catch (Exception e) {
                System.out.println("Id Không Hợp Lệ");
            }
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
            } catch (Exception e) {
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
        boolean isId = false;
        while (!isId) {
            try {
                System.out.print("Nhập Id cần tìm kiếm : ");
                int id = Integer.parseInt(scanner.nextLine());
                try {
                    Product product = productController.findProductById(id);
                    FunctionUtils.productInfor(product);
                    addToCart(id, email, product);
                    isId = true;
                } catch (NotFoundException notFoundException) {
                    System.out.println("Không Có Sản Phẩm Nào Có Id " + id + " ,Vui Lòng Nhập Lại");
                }
            } catch (Exception e) {
                System.out.println("Id Không Hợp Lệ,Vui Lòng Nhập Lại");
            }
        }

    }

    //    Thêm sản phẩm vào giỏ
    public static void addToCart(int id, String email, Product product) {
        Scanner scanner = new Scanner(System.in);
        int option;
        boolean isQuit = false;
        while (!isQuit) {
            addToCartMenu();
            try {
                System.out.print("Nhập lựa chọn : ");
                option = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Lựa Chọn Không Hợp Lệ");
                continue;
            }
            switch (option) {
                case 1 -> {
                    boolean isCorrect=false;
                    while (!isCorrect){
                        System.out.print("Nhập Số Lượng Muốn Thêm : ");
                        int quantity = scanner.nextInt();
                        scanner.nextLine();
                        boolean checkQuantity = cartController.checkQuantity(product, quantity);
                        if (checkQuantity) {
                            System.out.println("Số Lượng Sản Phẩm Trong Shop Không Đủ");
                        } else {
                            CartItem cartItem = new CartItem(email, product, quantity);
                            cartController.addItemToCart(id, cartItem);
                            System.out.println("Thêm Sản Phẩm Vào Giỏ Hàng Thành Công");
                            isCorrect=true;
                        }
                    }
                }
                case 2 -> isQuit = true;
            }
        }
    }

    //    tìm kiếm theo tên sản Phẩm
    private static void findByName() {
        Scanner scanner = new Scanner(System.in);
        boolean isNameCorrect=false;
        while (!isNameCorrect){
            System.out.print("Nhập tên sản phẩm cần tìm kiếm : ");
            String name = scanner.nextLine();
            try {
                List<Product> products = productController.findProDuctByName(name);
                FunctionUtils.productsInfor(products);
                warning();
                isNameCorrect=true;
            } catch (NotFoundException notFoundException) {
                System.out.println("Không Có Sản Phẩm Nào Có Tên " + name);
            }
        }
    }

    //    tìm kiếm theo mức giá(lọc từ mức a-b)
    private static void findByPrice() {
        Scanner scanner = new Scanner(System.in);
        try {
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
        } catch (Exception e) {
            System.out.println("Giá Tiền Không Hợp Lệ");
        }
    }

    //    Giao diện giỏ hàng
    private static void cartUi(String email) {
        Scanner scanner = new Scanner(System.in);
        int option;
        boolean isquit = false;
            if (cartController.cart(email).isEmpty()) {
                System.out.println("Giỏ Hàng Đang Trống..");
            } else {
                while (!isquit) {
                FunctionUtils.cartInfor(cartController.cart(email));
                FunctionUtils.totalMoneyInfo(cartController.getTotalMoney(email));
                cartMenu();
                System.out.print("Nhập Lựa Chọn : ");
                option = scanner.nextInt();
                switch (option) {
                    case 1 -> {
                        deleteCartItem();
                        isquit=true;
                    }
                    case 2 -> {
                        deleteAllItem(email);
                        System.out.println("Đã Xóa Tất Cả Sản Phẩm Khỏi Giỏ");
                        isquit=true;
                    }
                    case 3 -> updateQuantityonCart();
                    case 4 -> purchase(email);
                    case 5 -> isquit = true;
                }
            }
        }
    }

    private static void updateQuantityonCart() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập Id Cần Cập Nhật Số Lượng : ");
        int id = scanner.nextInt();
        System.out.print("Nhập Số Lượng Cần Cập Nhật : ");
        int quantityOnCart = scanner.nextInt();
        try {
            cartController.updateQuantityOnCart(id, quantityOnCart);
            System.out.println("Cập Nhật Số Lượng Thành Công");
        } catch (NotFoundException e) {
            System.out.println("Không Có Sản Phẩm Nào Có Id " + id + " Trong Giỏ Hàng");
        }
    }

    //    xóa sản phẩm khỏi giỏ hàng
    private static void deleteCartItem() {
        int id;
        Scanner scanner = new Scanner(System.in);
        boolean isDeleteOk=false;
        while (!isDeleteOk){
            try {
                System.out.print("Nhập Id Cần Xóa Từ Giỏ Hàng : ");
                id=scanner.nextInt();
                try {
                    cartController.deleteCartItem(id);
                    System.out.println("Đã Xóa Sản Phẩm Có Id " + id + " Khỏi Giỏ Hàng");
                    isDeleteOk=true;
                }catch (NotFoundException notFoundException){
                    System.out.println("Không Có Id "+id+" Trong Giỏ Hàng");
                }
            }catch (Exception e){
                System.out.println("Id Không Hợp Lệ");
            }
        }
    }

    //    xóa tất cả sản phẩm khỏi giỏ
    private static void deleteAllItem(String email) {
        cartController.deleteAllItem(email);
    }

    //    thanh toán đơn hàng(sử dụng ví hoặc tiền mặt)
    private static void purchase(String email) {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        purchaseMenu();
        try {
            System.out.print("Nhập lựa chọn : ");
            option = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
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
                    if (verify.equals(verifyCode)) {
                        System.out.println("Thanh Toán Thành Công,Xem Chi Tiết Tại Mục 'Trạng Thái Đơn Hàng'");
                        epayController.withdraw(email, cartController.getTotalMoney(email));
                        creatOrder(email);
                        HistoryTran historyTran = new HistoryTran(email, FunctionUtils.getDate(), -totalCartMoney, HistoryStatus.THANHTOÁNĐƠNHÀNG);
                        epayController.creatHistory(historyTran);
                        deleteAllItem(email);
                    } else {
                        System.out.println("Thanh Toán Thất Bại,Mã Xác Nhận Không Đúng");
                    }
                }
            }
            case 2 ->
//                    sử dụng tiền mặt
            {
                System.out.println("Thành Công,Theo Dõi Tiến Trình Tại 'Trạng Thái Đơn Hàng'");
                creatOrder(email);
                deleteAllItem(email);
            }
        }
    }

    //    ví điện tử
    private static void epay(String email) {
        epayLogin(email);
    }

    //    đăng nhập ví
    private static void epayLogin(String email) {
        Scanner scanner = new Scanner(System.in);
        boolean isPassECorrect = false;
        while (!isPassECorrect) {
            System.out.print("Nhập Mật Khẩu Ví : ");
            String epassword = scanner.nextLine();
            boolean checkElogin = epayController.checkELogin(email, epassword);
            if (checkElogin) {
                epayui(email);
                isPassECorrect = true;
            } else {
                System.out.println("Đăng Nhập Thất Bại");
            }
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
            } catch (Exception e) {
                System.out.println("Lựa Chọn Không Hợp Lệ");
                continue;
            }
            switch (option) {
                case 1 -> {
//                    nạp tiền
                    System.out.print("Nhập Số Tiền Muốn Nạp : ");
                    int money = scanner.nextInt();
                    scanner.nextLine();

                    boolean isCodeCorrect = false;
                    while (!isCodeCorrect) {
                        String verifyCode = FunctionUtils.verifyCode();
                        System.out.println("Mã Xác Nhận : " + verifyCode);
                        System.out.print("Nhập Mã Xác Nhận : ");
                        String verify = scanner.nextLine();
                        if (verifyCode.equals(verify)) {
                            epayController.updateMoney(email, money);
                            System.out.println("Nạp Thành Công " + FunctionUtils.currency(money));
                            HistoryTran historyTran = new HistoryTran(email, FunctionUtils.getDate(), +money, HistoryStatus.NẠPTIỀN);
                            epayController.creatHistory(historyTran);
                            isCodeCorrect = true;
                        } else {
                            System.out.println("Nạp Tiền Thất Bại,Hãy Nhập Đúng Mã Xác Thực");
                        }
                    }
                }
                case 2 -> {
//                    rút tiền
                    System.out.print("Nhập Số Tiền Muốn Rút : ");
                    int money = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Chọn Ngân Hàng Bạn Sử Dụng : ");
                    Bank bank = null;
                    int optioN;
                    boolean isQuit = false;
                    while (!isQuit) {
                        bank();
                        try {
                            System.out.print("\nNhập lựa chọn : ");
                            optioN = Integer.parseInt(scanner.nextLine());
                        } catch (Exception e) {
                            System.out.println("Lựa Chọn Không Hợp Lệ");
                            continue;
                        }
                        switch (optioN) {
                            case 1 -> {
                                bank = Bank.BIDV;
                                isQuit = true;
                            }
                            case 2 -> {
                                bank = Bank.VIETCOMBANK;
                                isQuit = true;
                            }
                            case 3 -> {
                                bank = Bank.VIETINBANK;
                                isQuit = true;
                            }
                            case 4 -> {
                                bank = Bank.MBANK;
                                isQuit = true;
                            }
                            case 5 -> {
                                bank = Bank.AGRIBANK;
                                isQuit = true;
                            }

                            case 6 -> {
                                bank = Bank.TECHCOMBANK;
                                isQuit = true;
                            }
                            case 7 -> {
                                bank = Bank.VPBANK;
                                isQuit = true;
                            }
                            case 8 -> {
                                bank = Bank.TPBANK;
                                isquit = true;
                            }
                        }
                    }
                    System.out.println("Ngân Hàng : " + bank);
                    System.out.print("Nhập Số Tài Khoản : ");
                    String stk = scanner.nextLine();
                    System.out.println("Tên Chủ Tài Khoản : " + userController.getname(email));
                    boolean isVerifyCodeCorrect = false;
                    while (!isVerifyCodeCorrect) {
                        String verifyCode = FunctionUtils.verifyCode();
                        System.out.println("Mã Xác Nhận : " + verifyCode);
                        System.out.print("Nhập Mã Xác Nhận : ");
                        String verify = scanner.nextLine();
                        if (verify.equals(verifyCode)) {
                            isVerifyCodeCorrect = true;
                        } else {
                            System.out.println("Mã Xác Thực Không Chính Xác,Hãy NHập Lại");
                        }
                    }
                    epayController.withdraw(email, money);
                    System.out.println("Đã Rút Thành Công Số Tiền " + FunctionUtils.currency(money));
                    HistoryTran historyTran = new HistoryTran(email, FunctionUtils.getDate(), -money, HistoryStatus.RÚTTIỀN);
                    epayController.creatHistory(historyTran);
                }
                case 3 -> FunctionUtils.historyInfor(epayController.getHistory(email));
                case 4 -> isquit = true;
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
            } catch (Exception e) {
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
        boolean isLogin = false;
        while (!isLogin) {
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
                isLogin = true;
            } else {
                System.out.println("Thông Tin Tài Khoản Hoặc Mật Khẩu Không Chính Xác,Hãy Đăng Nhập Lại");
            }
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
            } catch (Exception e) {
                System.out.println("Lựa Chọn Không Hợp Lệ");
                continue;
            }
            switch (option) {
                case 1 -> userManagement();
                case 2 -> productManagement();
                case 3 -> orderManagement();
                case 4 -> sales();
                case 5 -> isQuit = true;
            }
        }
    }

    private static void sales() {
        Scanner scanner = new Scanner(System.in);
        int option;
        boolean isQuit = false;
        while (!isQuit) {
            salesMenu();
            try {
                System.out.print("Nhập lựa chọn : ");
                option = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Lựa Chọn Không Hợp Lệ");
                continue;
            }
            switch (option){
                case 1->salesDay();
                case 2->salesM();
                case 3->isQuit=true;
            }
        }
    }

    private static void salesM() {
        System.out.println("Doanh Số Tháng "+FunctionUtils.salesM());
        System.out.println("Số Đơn Hàng Bán Được : "+orderController.getCountM());
        System.out.println("Tổng Doanh Số : "+FunctionUtils.currency(orderController.getMoneyM()));
    }

    private static void salesDay() {
        System.out.println("Doanh Số Ngày "+FunctionUtils.salesDate());
        System.out.println("Số Đơn Hàng Bán Được : "+orderController.getCount());
        System.out.println("Tổng Doanh Số : "+FunctionUtils.currency(orderController.getMoneyD()));
    }

    private static void salesMenu() {
        System.out.println("\nTHỐNG KÊ DOANH SỐ");
        System.out.println("1.Doanh Số Hôm Nay");
        System.out.println("2.Doanh Số Tháng Này");
        System.out.println("3.Quay Lại");
    }

    private static void orderManagement() {
        Scanner scanner = new Scanner(System.in);
        int option;
        boolean isQuit = false;
        while (!isQuit) {
            orderManagementMenu();
            try {
                System.out.print("Nhập lựa chọn : ");
                option = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Lựa Chọn Không Hợp Lệ");
                continue;
            }
            switch (option){
                case 1->approveOr();
                case 2->FunctionUtils.feedbackInfor(orderController.getfeedback());
                case 3->isQuit=true;
            }
        }
    }

    private static void approveOr() {
        Scanner scanner = new Scanner(System.in);
        int option;
        boolean isQuit = false;
        if(orderController.getOr().isEmpty()){
            System.out.println("Không Có Đơn Hàng Nào Chờ Phê Duyệt");
        }
        else {
            while (!isQuit) {
                FunctionUtils.OderInfor(orderController.getOr());
                approveOrMenu();
                try {
                    System.out.print("Nhập lựa chọn : ");
                    option = Integer.parseInt(scanner.nextLine());
                } catch (Exception e) {
                    System.out.println("Lựa Chọn Không Hợp Lệ");
                    continue;
                }
                switch (option){
                    case 1->{
                        orderController.approveAll();
                        System.out.println("Phê Duyệt Đơn Hàng Thành Công");
                    }
                    case 2->isQuit=true;
                }
            }
        }
    }

    private static void approveOrMenu() {
        System.out.print("1.Phê Duyệt Tất Cả");
        System.out.println("\t\t2.Quay Lại");
    }

    private static void orderManagementMenu() {
        System.out.println("\nQUẢN LÍ ĐƠN HÀNG");
        System.out.println("1.Phê Duyệt Đơn Hàng");
        System.out.println("2.Feedback Của Khách Hàng");
        System.out.println("3.Quay Lại");
    }

    private static void productManagement() {
        Scanner scanner = new Scanner(System.in);
        int option;
        boolean isQuit = false;
        while (!isQuit) {
            productManagementMenu();
            try {
                System.out.print("Nhập lựa chọn : ");
                option = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Lựa Chọn Không Hợp Lệ");
                continue;
            }
            switch (option) {
                case 1 -> FunctionUtils.productsInfor(productController.products());
                case 2 -> creatProduct();
                case 3 -> deleteProduct();
                case 4 -> updateProductManagement();
                case 5 -> isQuit = true;
            }
        }
    }

    private static void updateProductManagement() {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        boolean isQuit = false;
        while (!isQuit) {
            updateProductMenu();
            try {
                System.out.print("Nhập lựa chọn : ");
                option = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Lựa Chọn Không Hợp Lệ");
            }
            switch (option) {
                case 1 -> updatePrice();
                case 2 -> updateQuantity();
                case 3 -> isQuit = true;
            }
        }
    }

    private static void updatePrice() {
        Scanner scanner = new Scanner(System.in);
        int id = 0;
        int price;
        boolean isIdCorrect = false;
        while (!isIdCorrect) {
            try {
                System.out.print("Nhập Id Sản Phẩm Cần Thay Đổi Giá : ");
                id = Integer.parseInt(scanner.nextLine());
                try {
                    productController.findProductById(id);
                    isIdCorrect = true;
                } catch (NotFoundException e) {
                    System.out.println("Không Có Sản Phẩm Nao Có Id " + id);
                }
            } catch (Exception e) {
                System.out.println("Id Không Hợp Lệ,Hãy Nhập Lại");
            }
        }
        boolean isPriceCorrect = false;
        while (!isPriceCorrect) {
            try {
                System.out.print("Nhập Giá Mới : ");
                price = Integer.parseInt(scanner.nextLine());
                isPriceCorrect = true;
                productController.updatePrice(id, price);
                System.out.println("Cập Nhật Giá Sản Phẩm Thành Công");
            } catch (Exception e) {
                System.out.println("Giá Không Hợp Lệ,Hãy Nhập Lại");
            }
        }
    }

    private static void updateProductMenu() {
        System.out.println("\n1 - Cập Nhật Giá");
        System.out.println("2 - Cập Nhật Số Lượng ");
        System.out.println("3 - Trở Lại");
    }

    private static void productManagementMenu() {
        System.out.println("\n1 - Thông Tin Sản Phẩm");
        System.out.println("2 - Thêm Sản Phẩm");
        System.out.println("3 - Xóa Sản Phẩm");
        System.out.println("4 - Cập Nhật Thông Tin Sản Phẩm ");
        System.out.println("5 - Trở Lại");
    }

    private static void userManagement() {
        Scanner scanner = new Scanner(System.in);
        int option;
        boolean isQuit = false;
        while (!isQuit) {
            userManagementMenu();
            try {
                System.out.print("Nhập lựa chọn : ");
                option = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Lựa Chọn Không Hợp Lệ");
                continue;
            }
            switch (option) {
                case 1 -> FunctionUtils.usersInfor(userController.allUser());
                case 2 -> deleteUser();
                case 3 -> isQuit = true;
            }
        }
    }

    private static void userManagementMenu() {
        System.out.println("\n------------QUẢN LÍ NGƯỜI DÙNG-----------");
        System.out.println("| 1 - Xem Thông Tin Người Dùng          |");
        System.out.println("| 2 - Xóa Người Dùng                    |");
        System.out.println("| 3 - Trở Lại                           |");
        System.out.println("-----------------------------------------");
    }

    //        thay đổi số lượng sản phẩm
    private static void updateQuantity() {
        Scanner scanner = new Scanner(System.in);
        int id = 0;
        int quantity;
        boolean isIdCorrect = false;
        while (!isIdCorrect) {
            try {
                System.out.print("Nhập Id Sản Phẩm Cần Thay Đổi Giá : ");
                id = Integer.parseInt(scanner.nextLine());
                try {
                    productController.findProductById(id);
                    isIdCorrect = true;
                } catch (NotFoundException e) {
                    System.out.println("Không Có Sản Phẩm Nao Có Id " + id);
                }
            } catch (Exception e) {
                System.out.println("Id Không Hợp Lệ,Hãy Nhập Lại");
            }
        }
        boolean isQuantityCorrect = false;
        while (!isQuantityCorrect) {
            try {
                System.out.print("Nhập Số Lượng mới : ");
                quantity = Integer.parseInt(scanner.nextLine());
                isQuantityCorrect = true;
                productController.updateProductQuantity(id, quantity);
                System.out.println("Cập Nhật Số Lượng Phẩm Thành Công");
            } catch (Exception e) {
                System.out.println("Số Lượng Không Hợp Lệ,Hãy Nhập Lại");
            }
        }
    }

    //xóa sản phẩm
    private static void deleteProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Xóa Sản Phẩm");
        boolean isDeleTeProduct = false;
        while (!isDeleTeProduct) {
            try {
                System.out.print("Nhập id Sản Phẩm Cần Xóa : ");
                int id = Integer.parseInt(scanner.nextLine());
                try {
                    productController.deleteProduct(id);
                    System.out.println("Đã Xóa Thành Công Sản Phẩm Có Id " + id);
                    isDeleTeProduct = true;
                } catch (NotFoundException n) {
                    System.out.println("Không Có Sản Phẩm Nào Có Id " + id + ",Vui Lòng Nhập Lại");
                }
            } catch (Exception e) {
                System.out.println("Id Không Hợp Lệ,Hãy Nhập Lại");
            }
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
        int quantity = 0;
        boolean isQuantity = false;
        while (!isQuantity) {
            try {
                System.out.print("Nhập Số Lượng : ");
                quantity = Integer.parseInt(scanner.nextLine());
                isQuantity = true;
            } catch (Exception e) {
                System.out.println("Số Lượng Không Hợp Lệ,Hãy Nhập Lại");
            }
        }
        int price = 0;
        boolean isPrice = false;
        while (!isPrice) {
            try {
                System.out.print("Nhập Giá : ");
                price = Integer.parseInt(scanner.nextLine());
                isPrice = true;
            } catch (Exception e) {
                System.out.println("Giá Không Hợp Lệ,Hãy Nhập Lại");
            }
        }
        CreatProductRequest creatProductRequest = new CreatProductRequest(name, brand, quantity, price);
        productController.creatProduct9(creatProductRequest);
        System.out.println("Thêm Sản Phẩm Thành Công");
    }

    private static void deleteUser() {
        Scanner scanner = new Scanner(System.in);
        boolean IsDeleteUser = false;
        while (!IsDeleteUser) {
            try {
                System.out.print("Nhập Id User Cần Xóa :");
                int id = Integer.parseInt(scanner.nextLine());
                try {
                    userController.deleteUser(id);
                    System.out.println("Đã Xóa User Có Id " + id);
                    IsDeleteUser = true;
                } catch (NotFoundException e) {
                    System.out.println("Không Có User Nào Có Id " + id + ",Vui Lòng Nhập Lại");
                }
            } catch (Exception e) {
                System.out.println("Id Không Hợp Lệ,Vui Lòng Nhập Lại");
            }
        }
    }

    //    Đăng Kí
    private static void signupUi() {
        Scanner sc = new Scanner(System.in);
        System.out.println("ĐĂNG KÍ TÀI KHOẢN");
        System.out.print("Nhập Tên : ");
        String name = sc.nextLine();
        String emailSignup = null;
        boolean isEmail = false;
        while (!isEmail) {
            System.out.print("Nhập email đăng kí : ");
            emailSignup = sc.nextLine();
            if (userController.checkEmailExist(emailSignup)) {
                System.out.println("Email đã tồn tại,hãy nhập lại");
            } else if (!FunctionUtils.checkEmailRegex(emailSignup)) {
                System.out.println("Email cần đúng định dạng,hãy nhập lại");
            } else {
                isEmail = true;
            }
        }
        boolean isPassword = false;
        while (!isPassword) {
            System.out.print("Nhập mật khẩu : ");
            String passwordSignup = sc.nextLine();
            if (!FunctionUtils.checkPassRegex(passwordSignup)) {
                System.out.println("Mật khẩu từ 7-15 kí tự");
            } else {
                System.out.println("Đăng kí thành công");
                CreatAccountRequest creatAccountRequest = new CreatAccountRequest(name, emailSignup, passwordSignup);
                userController.creatUser(creatAccountRequest);
                isPassword = true;
            }
        }
    }

    //    Quên Mật Khẩu
    private static void forgotPassword() {
        Scanner sc = new Scanner(System.in);
        System.out.println("QUÊN MẬT KHẨU");
        System.out.print("Nhập Email : ");
        String email = sc.nextLine();
        if (userController.checkEmailExist(email)) {
            System.out.print("Nhập Mật Khẩu Mới : ");
            String newPassword = sc.nextLine();
            userController.updatePassword(email, newPassword);
            System.out.println("Cập Nhật Mật Khẩu Thành Công");
        } else {
            System.out.println("Tài Khoản Không Tồn Tại Trong Hệ Thống");
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
        System.out.println("\n----------------GUEST--------------------");
        System.out.println("| 1 - Xem Danh Sách Sản Phẩm            |");
        System.out.println("| 2 - Tìm Kiếm                          |");
        System.out.println("| 3 - Trở Lại                           |");
        System.out.println("-----------------------------------------");
    }

    private static void searchMenu() {
        System.out.println("\n-----------TÌM KIẾM SẢN PHẨM-------------");
        System.out.println("| 1 - Theo Id                           |");
        System.out.println("| 2 - Theo Tên                          |");
        System.out.println("| 3 - Theo Mức Giá                      |");
        System.out.println("| 4 - Trở Lại                           |");
        System.out.println("-----------------------------------------");
    }

    private static void userMenu() {
        System.out.println("-----------------------------------------");
        System.out.printf("| %-38s|%n", "1 - Xem Thông Tin Sản Phẩm");
        System.out.printf("| %-38s|%n", "2 - Tìm Kiếm Sản Phẩm");
        System.out.printf("| %-38s|%n", "3 - Xem Giỏ Hàng");
        System.out.printf("| %-38s|%n", "4 - Trạng Thái Đơn Hàng");
        System.out.printf("| %-38s|%n", "5 - Ví TechPay");
        System.out.printf("| %-38s|%n", "6 - Thông Tin Cá Nhân");
        System.out.printf("| %-38s|%n", "7 - Đăng Xuất");
        System.out.println("-----------------------------------------");
    }

    private static void cartMenu() {
        System.out.println("1 - Xóa Sản Phẩm Khỏi Giỏ Hàng");
        System.out.println("2 - Xóa Tất Cả Sản Phẩm Khỏi Giỏ Hàng");
        System.out.println("3 - Cập Nhật Số Lượng Sản Phẩm");
        System.out.println("4 - Mua Hàng ");
        System.out.println("5 - Trở Lại");
    }

    private static void addToCartMenu() {
        System.out.println("1 - Thêm Vào Giỏ Hàng");
        System.out.println("2 - Quay Lại");
    }

    private static void epayMenu() {
        System.out.println("1 - Nạp Tiền Vào Ví");
        System.out.println("2 - Rút Tiền");
        System.out.println("3 - Lịch Sử Giao Dịch");
        System.out.println("4 - Trở Lại");
    }

    private static void adminMenu() {
        System.out.println("\n----------------ADMIN--------------------");
        System.out.println("| 1 - Quản Lí Người Dùng                |");
        System.out.println("| 2 - Quản Lí Sản Phẩm                  |");
        System.out.println("| 3 - Quản Lí Đơn Hàng                  |");
        System.out.println("| 4 - Báo Cáo Doanh Số                  |");
        System.out.println("| 5 - Đăng Xuất                         |");
        System.out.println("-----------------------------------------");
    }

    private static void profileMenu() {
        System.out.println("\n-----------CẬP NHẬT THÔNG TIN------------");
        System.out.println("| 1 - Đổi Mật Khẩu                      |");
        System.out.println("| 2 - Đổi Số Điện Thoại                 |");
        System.out.println("| 3 - Đổi Địa Chỉ                       |");
        System.out.println("| 4 - Trở Lại                           |");
        System.out.println("-----------------------------------------");
    }

    private static void warning() {
        System.out.println("VUI LÒNG ĐĂNG NHẬP ĐỂ DỬ DỤNG NHIỀU CHỨC NĂNG HƠN");
    }

    private static void purchaseMenu() {
        System.out.println("Chọn Phương Thức Thanh Toán : ");
        System.out.println("1 - Sử Dụng Ví TechPay");
        System.out.println("2 - Thanh Toán Khi Nhận Hàng");
        System.out.println("3 - Trở Lại");
    }

    private static void bank() {
        System.out.print("1.BIDV");
        System.out.print("\t2.VIETCOMBANK");
        System.out.print("\t3.VIETINBANK");
        System.out.print("\t4.MBBANK");
        System.out.print("\t5.AGRIBANK");
        System.out.print("\t6.TECHCOMBANK");
        System.out.print("\t7.TPBANK");
        System.out.print("\t8.VPBANK");
    }
}
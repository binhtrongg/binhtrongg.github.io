import model.CongNhan;
import model.XuongSanXuat;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger(Main.class);
        LogicHandle.danhSachCongNhan.getDanhSach().add(new CongNhan("tran van a","Thai binh","012231223",5));
        LogicHandle.danhSachCongNhan.getDanhSach().add(new CongNhan("nguyen thi c","nam dinh","3237271327",3));

        LogicHandle.dsXuongSanXuat.getDanhSach().add(new XuongSanXuat("xuong ha nam","ok",10.5));
        LogicHandle.dsXuongSanXuat.getDanhSach().add(new XuongSanXuat("xuong nam dinh","ok",10.5));

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("----- Quản lý công nhân và xưởng sản xuất -----");
            System.out.println("1. Nhập danh sách công nhân mới");
            System.out.println("2. In ra danh sách các công nhân đã có");
            System.out.println("3. Nhập danh sách xưởng sản xuất");
            System.out.println("4. In ra danh sách xưởng đã có");
            System.out.println("5. Lập bảng danh sách chấm công cho từng công nhân và in danh sách ra màn hình");
            System.out.println("6. Sắp xếp danh sách Bảng danh sách chấm công");
            System.out.println("    a. Theo tên công nhân");
            System.out.println("    b. Theo xưởng");
            System.out.println("7. Lập bảng kê thu nhập cho mỗi công nhân trong tháng");
            System.out.println("0. Thoát");
            System.out.print("Mời bạn chọn chức năng: ");
            choice = LogicHandle.readSoLuong(scanner,"Chức Năng");

            switch (choice) {
                case 1 -> LogicHandle.nhapDanhSachCongNhan(scanner);
                case 2 -> LogicHandle.danhSachCongNhan.inDanhSach("Công Nhân");
                case 3 -> LogicHandle.nhapDanhSachXuongSanXuat(scanner);
                case 4 -> LogicHandle.dsXuongSanXuat.inDanhSach("Xưởng Sản Xuất");
                case 5 -> {
                    LogicHandle.chamCong(scanner);
                    LogicHandle.dsChamCong.inDanhSach("Chấm Công");
                }
                case 6 -> {
                    System.out.println("Bạn muốn sắp xếp danh sách theo:");
                    System.out.println("a. Theo tên công nhân");
                    System.out.println("b. Theo xưởng");
                    System.out.print("Mời bạn chọn: ");
                    String option = scanner.nextLine();
                    if (option.equals("a")) {
                        LogicHandle.dsChamCong.sapXepTheoTenCongNhan();
                        System.out.println("Đã sắp xếp danh sách theo tên công nhân.");
                        LogicHandle.dsChamCong.inDanhSach("Chấm Công");
                    } else if (option.equals("b")) {
                        LogicHandle.dsChamCong.sapXepTheoTenXuong();
                        System.out.println("Đã sắp xếp danh sách theo tên xưởng.");
                        LogicHandle.dsChamCong.inDanhSach("Chấm Công");
                    } else {
                        System.out.println("Lựa chọn không hợp lệ!");
                    }
                }
                case 7 -> LogicHandle.inTongLuong();
                case 8 -> System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }

            System.out.println();

        } while (choice != 0);

        scanner.close();
    }
}

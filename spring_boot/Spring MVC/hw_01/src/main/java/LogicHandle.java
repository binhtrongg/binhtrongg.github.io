import model.ChamCong;
import model.CongNhan;
import model.DanhSach;
import model.XuongSanXuat;
import org.apache.log4j.Logger;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LogicHandle {
    static Logger log=Logger.getLogger(LogicHandle.class);
    static DanhSach<CongNhan> danhSachCongNhan = new DanhSach<>();
    static DanhSach<XuongSanXuat> dsXuongSanXuat = new DanhSach<>();
    static DanhSach<ChamCong> dsChamCong = new DanhSach<>();

    public static void nhapDanhSachCongNhan(Scanner scanner) {
        System.out.print("Nhập số lượng công nhân: ");
        int soLuongCongNhan = readSoLuong(scanner, "Số Lượng");
        for (int i = 0; i < soLuongCongNhan; i++) {
            System.out.println("Nhập thông tin công nhân thứ " + (i + 1) + ":");
            System.out.print("Họ tên: ");
            String hoTen = scanner.nextLine();
            System.out.print("Địa chỉ: ");
            String diaChi = scanner.nextLine();
            System.out.print("Số điện thoại: ");
            String soDienThoai = scanner.nextLine();
            int bacTho = 0;
            boolean isValid = false;
            do {
                System.out.print("Bậc thợ: ");
                try {
                    bacTho = scanner.nextInt();
                    scanner.nextLine();
                    if (bacTho < 1 || bacTho > 7) {
                        System.out.println("Bậc thợ phải > 0 và <=7. Vui lòng nhập lại!");
                        continue;
                    }
                    isValid = true;
                } catch (Exception e) {
                    System.out.println("Bậc thợ không hợp lệ. Vui lòng nhập lại!");
                    scanner.nextLine();
                }
            } while (!isValid);
            CongNhan congNhan = new CongNhan(hoTen, diaChi, soDienThoai, bacTho);
            danhSachCongNhan.themDoiTuong(congNhan);
            System.out.println("Đã Thêm CN Vào DS");
        }
    }

    public static void nhapDanhSachXuongSanXuat(Scanner scanner) {
        System.out.print("Nhập số lượng xưởng: ");
        int soLuongXuong = readSoLuong(scanner, "số lượng");
        for (int i = 0; i < soLuongXuong; i++) {
            System.out.println("Nhập Thông tin xưởng thứ " + (i + 1));
            System.out.print("tên xưởng: ");
            String tenXuong = scanner.nextLine();
            System.out.print("Nhập Mô Tả: ");
            String moTa = scanner.nextLine();
            double hsCongViec = 0;
            boolean isValid = false;
            do {
                System.out.print("Nhập Hệ Số Công Việc: ");
                try {
                    hsCongViec = scanner.nextDouble();
                    scanner.nextLine();
                    if (hsCongViec < 1 || hsCongViec > 20) {
                        System.out.println("Hệ Số Công Việc phải > 0 và <=20. Vui lòng nhập lại!");
                        continue;
                    }
                    isValid = true;
                } catch (Exception e) {
                    System.out.println("Hệ Số Công Việc không hợp lệ. Vui lòng nhập lại!");
                    scanner.nextLine();
                }
            } while (!isValid);
            XuongSanXuat xuongSanXuat = new XuongSanXuat(tenXuong, moTa, hsCongViec);
            dsXuongSanXuat.themDoiTuong(xuongSanXuat);
            System.out.println("Đã thêm Xưởng Vào Danh Sách");
        }
    }

    public static int readSoLuong(Scanner scanner, String type) {
        int soLuong = 0;
        boolean isValid = false;
        do {
            try {
                String input = scanner.nextLine();
                soLuong = Integer.parseInt(input);
                if (soLuong < 1) {
                    System.out.println(type + " phải lớn hơn 0. Vui lòng nhập lại!");
                    System.out.print("Nhập " + type + ": ");
                } else {
                    isValid = true;
                }
            } catch (NumberFormatException e) {
                System.out.println(type + " không hợp lệ. Vui lòng nhập lại!");
                System.out.print("Nhập " + type + ": ");
            }
        } while (!isValid);
        return soLuong;
    }

    public static void chamCong(Scanner scanner) {
        int idCongNhan = 0;
        int idXuong;
        XuongSanXuat xuongSanXuat = null;
        CongNhan congNhan = null;
        boolean validCongNhan = false;
        boolean validXuong = false;
        while (!validCongNhan) {
            System.out.print("Nhập Mã Công Nhân: ");
            idCongNhan = readSoLuong(scanner, "Mã Công Nhân");
            congNhan = timCongNhanTheoId(idCongNhan);
            if (congNhan == null) {
                System.out.println("Công Nhân Không Tồn Tại, Vui Lòng Nhập Lại");
            } else {
                validCongNhan = true;
            }
        }
        while (!validXuong) {
            System.out.print("Nhập Mã Xưởng: ");
            idXuong = readSoLuong(scanner, "Mã Xưởng");
            xuongSanXuat = timXuongSanXuatTheoMa(idXuong);

            if (xuongSanXuat == null) {
                System.out.println("Xưởng Không Tồn Tại, Vui Lòng Nhập Lại");
            } else {
                validXuong = true;
            }
        }
        // Kiểm tra số ngày làm việc tại xưởng mới có vượt quá 30 không
        System.out.print("Nhập Số Ngày Làm Việc Tại Xưởng: ");
        int soNgayLamViec = readSoLuong(scanner, "Số Ngày");
        int tongSoNgay = tongSoNgayLamViec(idCongNhan);
        if (tongSoNgay + soNgayLamViec > 30) {
            System.out.println("Tổng số ngày làm việc của " + "'" + congNhan.getHoTen() + "'" + " đang là " + tongSoNgay + " ngày,Không ai làm " + (tongSoNgay + soNgayLamViec) + " ngày 1 tháng cả");
        } else {
            ChamCong chamCong = new ChamCong(congNhan, xuongSanXuat, soNgayLamViec);
            dsChamCong.getDanhSach().add(chamCong);
            System.out.println("Chấm Công Thành Công");
        }
    }

    public static CongNhan timCongNhanTheoId(int idCongNhan) {
        for (CongNhan congNhan : danhSachCongNhan.getDanhSach()) {
            if (congNhan.getId() == idCongNhan) {
                return congNhan;
            }
        }
        return null;
    }

    public static XuongSanXuat timXuongSanXuatTheoMa(int idXuongSanXuat) {
        for (XuongSanXuat xuongSanXuat : dsXuongSanXuat.getDanhSach()) {
            if (xuongSanXuat.getId() == idXuongSanXuat) {
                return xuongSanXuat;
            }
        }
        return null;
    }

    public static void inTongLuong() {
        Map<Integer, Double> tongThuNhapCongNhanMap = new HashMap<>();
        for (ChamCong cc : dsChamCong.getDanhSach()) {
            CongNhan cn = cc.getCongNhan();
            double luong = cc.tinhTongLuong();
            int idCongNhan = cn.getId();
            if (!tongThuNhapCongNhanMap.containsKey(idCongNhan)) {
                tongThuNhapCongNhanMap.put(idCongNhan, luong);
            } else {
                double tongThuNhap = tongThuNhapCongNhanMap.get(idCongNhan);
                tongThuNhap += luong;
                tongThuNhapCongNhanMap.put(idCongNhan, tongThuNhap);
            }
        }
        for (Map.Entry<Integer, Double> entry : tongThuNhapCongNhanMap.entrySet()) {
            int idCongNhan = entry.getKey();
            double tongThuNhap = entry.getValue();
            CongNhan cn = timCongNhanTheoId(idCongNhan);
            log.debug("Mã công nhân: " + cn.getId() + ",Tên công nhân: " + cn.getHoTen() + ",Thu nhập: " + formatVND(tongThuNhap));
            System.out.println("Mã công nhân: " + cn.getId() + ",Tên công nhân: " + cn.getHoTen() + ",Thu nhập: " + formatVND(tongThuNhap));
        }
    }

    public static int tongSoNgayLamViec(int idCongNhan) {
        int tongSoNgay = 0; // Biến tính tổng số ngày làm việc của nhân viên
        for (ChamCong cc : dsChamCong.getDanhSach()) {
            if (cc.getCongNhan().getId() == idCongNhan) {
                tongSoNgay += cc.getSoNgayLamViec();
            }
        }
        return tongSoNgay;
    }
    public static String formatVND(double number) {
        DecimalFormat df = new DecimalFormat("#,### VND");
        return df.format(number);
    }
}


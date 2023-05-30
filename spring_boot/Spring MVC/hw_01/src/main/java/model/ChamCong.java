package model;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChamCong {
    CongNhan congNhan;
    XuongSanXuat xuongSanXuat;
    int soNgayLamViec;

    @Override
    public String toString() {
        return "Mã Công Nhân: " + congNhan.getId() +
                ",Tên Công Nhân: " + congNhan.getHoTen() +
                ",Nơi Làm Việc: " + xuongSanXuat.getTenXuong() +
                ",Số Ngày Làm Việc: " + soNgayLamViec;
    }

    public double tinhTongLuong(){
        double hsCongViec=xuongSanXuat.getHeSoCongViec();
        double bacTho=congNhan.getBacTho();
        return 450000*bacTho*hsCongViec*(soNgayLamViec)/22;
    }
}

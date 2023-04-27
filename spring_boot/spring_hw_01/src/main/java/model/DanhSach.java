package model;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
@Data
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DanhSach<T> {
    List<T> danhSach;

    public DanhSach() {
        danhSach = new ArrayList<>();
    }

    public void themDoiTuong(T doiTuong) {
        danhSach.add(doiTuong);
    }

    public void inDanhSach(String type) {
        System.out.println("Danh Sách " + type + ": ");
        for (T doiTuong : danhSach) {
            System.out.println(doiTuong.toString());
        }
    }

    public void sapXepTheoTenCongNhan() {
        danhSach.sort(Comparator.comparing(o -> {
            if (o instanceof ChamCong) {
                String ten = ((ChamCong) o).getCongNhan().getHoTen();
                int lastSpaceIndex = ten.lastIndexOf(' ');
                if (lastSpaceIndex != -1) { // nếu tìm thấy dấu cách
                    return ten.substring(lastSpaceIndex + 1).toLowerCase();
                }
                return ten.toLowerCase();
            }
            return null;
        }));
    }


    public void sapXepTheoTenXuong() {
        danhSach.sort(Comparator.comparing(o -> {
            if (o instanceof ChamCong) {
                return ((ChamCong) o).getXuongSanXuat().getTenXuong().toLowerCase();
            }
            return null;
        }));
    }

}

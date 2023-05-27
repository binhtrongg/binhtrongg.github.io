package model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class XuongSanXuat {
    static int count=100;
    int id;
    String tenXuong;
    String moTa;
    double heSoCongViec;

    public XuongSanXuat(String tenXuong,String moTa,double heSoCongViec) {
        this.id=++count;
        this.tenXuong=tenXuong;
        this.moTa=moTa;
        this.heSoCongViec=heSoCongViec;
    }
}

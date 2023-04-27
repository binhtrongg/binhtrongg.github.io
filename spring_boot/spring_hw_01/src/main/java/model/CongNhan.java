package model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CongNhan {
    static int count =1000;
    int id;
    String hoTen;
    String diaChi;
    String soDt;
    int bacTho;

    public CongNhan(String hoTen,String diaChi,String soDt,int bacTho){
        this.id=++count;
        this.hoTen=hoTen;
        this.diaChi=diaChi;
        this.soDt=soDt;
        this.bacTho=bacTho;
    }

}

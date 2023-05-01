package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import statics.Clientlever;

import java.util.InputMismatchException;
import java.util.Scanner;

@Data
@AllArgsConstructor

public class Customer extends Person {
    private int id;
    private Clientlever level;
    private static int AUTO_ID = 10000;

    public Customer() {
        this.id = AUTO_ID;
        AUTO_ID++;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ",  phone='" + phone + '\'' +
                ",  level=" + level +
                '}';
    }

    public void inputInfo() {
        super.inputInfo();
        System.out.println("Nhập đơn vị khách hàng: ");
        System.out.println("1.Cá nhân");
        System.out.println("2.Đại diện đơn vị hành chính");
        System.out.println("3. Đại diện đơn vị kinh doanh");

        int choice;
        do {
            try {
                choice = new Scanner(System.in).nextInt();
                if (choice >=1 && choice <= 3) break;
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.println("Vui lòng nhập số từ 1 tới 3");
            }
        }while (true);
        switch (choice) {
            case 1:
                this.setLevel(Clientlever.ca_nhan);
                break;
            case 2:
                this.setLevel(Clientlever.dai_dien_don_vi_hanh_chinh);
                break;
            case 3:
                this.setLevel(Clientlever.dai_dien_don_vi_kinh_doanh);
                break;
        }
    }
}

package tech_shop.backend.repository;

import tech_shop.backend.database.EpayDataBase;
import tech_shop.backend.database.UserDatabase;
import tech_shop.backend.model.Epay;
import tech_shop.backend.model.User;
import tech_shop.backend.utils.FileUtils;

import java.util.List;

public class EpayRepository {
    public List<Epay> findAllEpay() {
        return EpayDataBase.epays;
    }

    public void updateMoey(String email, int money) {
        for (Epay epay:EpayDataBase.epays) {
            if (epay.getEmail().equalsIgnoreCase(email)){
                epay.setMoney(epay.getMoney()+money);
            }
        }
        FileUtils.saveDataToFile("epay.json",EpayDataBase.epays);
    }

    public void withdraw(String email, int money) {
        for (Epay epay:EpayDataBase.epays) {
            if (epay.getEmail().equalsIgnoreCase(email)){
                epay.setMoney(epay.getMoney()-money);
            }
        }
        FileUtils.saveDataToFile("epay.json",EpayDataBase.epays);
    }
}

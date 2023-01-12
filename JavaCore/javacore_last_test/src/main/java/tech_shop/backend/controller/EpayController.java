package tech_shop.backend.controller;

import tech_shop.backend.service.EpayService;

public class EpayController {
    static final EpayService epayService=new EpayService();
    public boolean checkEpayinvalid(String email) {
       return epayService.checkEpayInvalid(email);
    }
    public boolean checkELogin(String email, String epassword) {
        return epayService.checkELogin(email,epassword);

    }

    public int getMoney(String email) {
       return epayService.getMoney(email);
    }

    public void updateMoney(String email, int money) {
        epayService.updateMoney(email,money);
    }

    public void withdraw(String email, int money){
        epayService.withdraw(email,money);
    }

}

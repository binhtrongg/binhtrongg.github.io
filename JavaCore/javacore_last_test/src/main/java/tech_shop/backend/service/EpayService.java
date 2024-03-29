package tech_shop.backend.service;
import tech_shop.backend.model.Epay;
import tech_shop.backend.model.HistoryTran;
import tech_shop.backend.repository.EpayRepository;

import java.util.ArrayList;
import java.util.List;

public class EpayService {
    static final EpayRepository epayRepository = new EpayRepository();
    List<Epay>epays=epayRepository.findAllEpay();
    List<HistoryTran>history=epayRepository.historyTrans();
    public boolean checkEpayInvalid(String email) {
        for (Epay epay:epays) {
            if (epay.getEmail().equalsIgnoreCase(email)){
                return true;
            }
        }
        return false;
    }

    public boolean checkELogin(String email, String epassword) {
        for (Epay epay:epays) {
            if (epay.getEmail().equalsIgnoreCase(email)&&epay.getPassword().equalsIgnoreCase(epassword)){
                return true;
            }
        }
        return false;
    }

    public int getMoney(String email) {
        for (Epay epay:epays) {
            if (epay.getEmail().equals(email)){
                return epay.getMoney();
            }
        }
        return 0;
    }

    public void updateMoney(String email, int money) {
        epayRepository.updateMoey(email,money);
    }

    public void withdraw(String email, int money) {
        epayRepository.withdraw(email,money);
    }

    public void creatHistory(HistoryTran historyTran) {
        epayRepository.creatHistory(historyTran);
    }

    public List<HistoryTran> getHistory(String email) {
        List<HistoryTran>historyTrans=new ArrayList<>();
        for (HistoryTran historyTran:history) {
            if (historyTran.getEmail().equalsIgnoreCase(email)){
                historyTrans.add(historyTran);
            }
        }
        return historyTrans;
    }
}

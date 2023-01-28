package tech_shop.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Epay {
    private String email;
    private int money;
    private String password;
    HistoryTran historyTran;
}

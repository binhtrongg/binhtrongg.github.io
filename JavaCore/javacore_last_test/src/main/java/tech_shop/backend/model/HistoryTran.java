package tech_shop.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech_shop.backend.utils.FunctionUtils;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HistoryTran {
    private String email;
    private String time;
    private int money;
    private HistoryStatus historyStatus;

    @Override
    public String toString() {
        return String.format("| %-20s | %-15s | %-16s |",time,FunctionUtils.currency(money),historyStatus);
    }
}

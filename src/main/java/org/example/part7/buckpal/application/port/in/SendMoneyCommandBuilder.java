package org.example.part7.buckpal.application.port.in;

import lombok.Setter;
import org.example.part7.buckpal.domain.Account.AccountId;
import org.example.part7.buckpal.domain.Money;

@Setter
public class SendMoneyCommandBuilder {
    private AccountId sourceAccountId;
    private AccountId targetAccountId;
    private Money money;

    public SendMoneyCommandBuilder() {
    }

    public SendMoneyCommand build() {
        return new SendMoneyCommand(sourceAccountId, targetAccountId, money);
    }
}

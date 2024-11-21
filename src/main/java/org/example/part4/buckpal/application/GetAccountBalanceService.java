package org.example.part4.buckpal.application;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.example.part4.buckpal.application.port.in.GetAccountBalanceQuery;
import org.example.part4.buckpal.application.port.in.SendMoneyCommand;
import org.example.part4.buckpal.application.port.in.SendMoneyUseCase;
import org.example.part4.buckpal.application.port.out.AccountLock;
import org.example.part4.buckpal.application.port.out.LoadAccountPort;
import org.example.part4.buckpal.application.port.out.UpdateAccountStatePort;
import org.example.part4.buckpal.domain.Account;
import org.example.part4.buckpal.domain.Account.AccountId;
import org.example.part4.buckpal.domain.Money;

@AllArgsConstructor
public class GetAccountBalanceService implements GetAccountBalanceQuery {
    private final LoadAccountPort loadAccountPort;

    @Override
    public Money getAccountBalance(AccountId accountId) {
        Account account = loadAccountPort.loadAccount(accountId, LocalDateTime.now());
        return account.calculateBalance();
    }
}

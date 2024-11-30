package org.example.part6.buckpal.application;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.example.part6.buckpal.application.port.in.GetAccountBalanceQuery;
import org.example.part6.buckpal.application.port.out.LoadAccountPort;
import org.example.part6.buckpal.domain.Account;
import org.example.part6.buckpal.domain.Account.AccountId;
import org.example.part6.buckpal.domain.Money;

@AllArgsConstructor
public class GetAccountBalanceService implements GetAccountBalanceQuery {
    private final LoadAccountPort loadAccountPort;

    @Override
    public Money getAccountBalance(AccountId accountId) {
        Account account = loadAccountPort.loadAccount(accountId, LocalDateTime.now());
        return account.calculateBalance();
    }
}
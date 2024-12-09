package org.example.part7.buckpal.application.port.in;

import org.example.part7.buckpal.domain.Account.AccountId;
import org.example.part7.buckpal.domain.Money;

public interface GetAccountBalanceQuery {
    Money getAccountBalance(AccountId accountId);
}

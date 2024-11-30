package org.example.part6.buckpal.application.port.in;

import org.example.part6.buckpal.domain.Account.AccountId;
import org.example.part6.buckpal.domain.Money;

public interface GetAccountBalanceQuery {
    Money getAccountBalance(AccountId accountId);
}

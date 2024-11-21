package org.example.part5.buckpal.application.port.in;

import org.example.part5.buckpal.domain.Account.AccountId;
import org.example.part5.buckpal.domain.Money;

public interface GetAccountBalanceQuery {
    Money getAccountBalance(AccountId accountId);
}

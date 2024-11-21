package org.example.part4.buckpal.application.port.in;

import org.example.part4.buckpal.domain.Account.AccountId;
import org.example.part4.buckpal.domain.Money;

public interface GetAccountBalanceQuery {
    Money getAccountBalance(AccountId accountId);
}

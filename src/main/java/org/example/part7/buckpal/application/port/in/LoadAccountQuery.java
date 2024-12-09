package org.example.part7.buckpal.application.port.in;

import java.util.List;
import org.example.part7.buckpal.domain.Account;
import org.example.part7.buckpal.domain.Account.AccountId;

public interface LoadAccountQuery {
    Account getAccount(AccountId accountId);
}

package org.example.part6.buckpal.application.port.in;

import java.util.List;
import org.example.part6.buckpal.domain.Account;
import org.example.part6.buckpal.domain.Account.AccountId;
import org.example.part6.buckpal.domain.Money;

public interface ListAccountQuery {
    List<Account> getAccounts();
}

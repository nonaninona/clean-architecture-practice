package org.example.part6.buckpal.application.port.out;

import java.time.LocalDateTime;
import org.example.part6.buckpal.domain.Account;
import org.example.part6.buckpal.domain.Account.AccountId;

public interface LoadAccountPort {
    Account loadAccount(AccountId accountId, LocalDateTime timestamp);
}

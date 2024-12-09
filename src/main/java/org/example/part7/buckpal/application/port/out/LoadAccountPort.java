package org.example.part7.buckpal.application.port.out;

import java.time.LocalDateTime;
import org.example.part7.buckpal.domain.Account.AccountId;
import org.example.part7.buckpal.domain.Account;

public interface LoadAccountPort {
    Account loadAccount(AccountId accountId, LocalDateTime timestamp);
}

package org.example.part5.buckpal.application.port.out;

import java.time.LocalDateTime;
import org.example.part5.buckpal.domain.Account;
import org.example.part5.buckpal.domain.Account.AccountId;

public interface LoadAccountPort {
    Account loadAccount(AccountId accountId, LocalDateTime timestamp);
}

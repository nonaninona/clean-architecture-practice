package org.example.part7.buckpal.application.port.in;

import org.example.part7.buckpal.domain.Account;

public interface CreateAccountUseCase {
    Account createAccount(CreateAccountCommand command);
}

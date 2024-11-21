package org.example.part5.buckpal.application.port.in;

import org.example.part5.buckpal.domain.Account;

public interface CreateAccountUseCase {
    Account createAccount(CreateAccountCommand command);
}

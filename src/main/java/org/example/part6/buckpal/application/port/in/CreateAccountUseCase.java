package org.example.part6.buckpal.application.port.in;

import org.example.part6.buckpal.application.port.in.CreateAccountCommand;
import org.example.part6.buckpal.domain.Account;

public interface CreateAccountUseCase {
    Account createAccount(CreateAccountCommand command);
}

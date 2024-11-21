package org.example.part5.buckpal.application.port.in;

import org.example.part5.buckpal.application.port.in.SendMoneyCommand;
import org.example.part5.buckpal.domain.Money;

public interface SendMoneyUseCase {
    boolean sendMoney(SendMoneyCommand command);
}

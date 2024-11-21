package org.example.part4.buckpal.application.port.in;

import org.example.part4.buckpal.domain.Money;

public interface SendMoneyUseCase {
    boolean sendMoney(SendMoneyCommand command);
}

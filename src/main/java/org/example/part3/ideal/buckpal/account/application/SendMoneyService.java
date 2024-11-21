package org.example.part3.ideal.buckpal.account.application;

import org.example.part3.function.buckpal.account.AccountRepositoryImpl;
import org.example.part3.ideal.buckpal.account.application.port.in.SendMoneyUseCase;
import org.example.part3.ideal.buckpal.account.application.port.out.LoadAccountPort;

public class SendMoneyService implements SendMoneyUseCase {
    private final LoadAccountPort loadAccountPort;

    public SendMoneyService(LoadAccountPort loadAccountPort) {
        this.loadAccountPort = loadAccountPort;
    }
}

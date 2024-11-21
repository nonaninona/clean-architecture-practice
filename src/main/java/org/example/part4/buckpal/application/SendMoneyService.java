package org.example.part4.buckpal.application;

import lombok.AllArgsConstructor;
import org.example.part4.buckpal.application.port.in.SendMoneyCommand;
import org.example.part4.buckpal.application.port.in.SendMoneyUseCase;
import org.example.part4.buckpal.application.port.out.AccountLock;
import org.example.part4.buckpal.application.port.out.LoadAccountPort;
import org.example.part4.buckpal.application.port.out.UpdateAccountStatePort;
import org.example.part4.buckpal.domain.Money;

@AllArgsConstructor
public class SendMoneyService implements SendMoneyUseCase {
    private final LoadAccountPort loadAccountPort;
    private final UpdateAccountStatePort updateAccountStatePort;
    private final AccountLock accountLock;

    @Override
    public boolean sendMoney(SendMoneyCommand command) {
        //TODO : 비즈니스 규칙 검증
        //TODO : 모델 상태 조작
        //TODO : 출력 값 반환
        return true;
    }
}

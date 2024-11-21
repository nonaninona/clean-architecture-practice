package org.example.part4.buckpal.application;

import javax.security.auth.login.AccountNotFoundException;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.example.part4.buckpal.application.port.in.SendMoneyCommand;
import org.example.part4.buckpal.application.port.in.SendMoneyUseCase;
import org.example.part4.buckpal.application.port.out.AccountLock;
import org.example.part4.buckpal.application.port.out.LoadAccountPort;
import org.example.part4.buckpal.application.port.out.UpdateAccountStatePort;
import org.example.part4.buckpal.domain.Account;
import org.example.part4.buckpal.domain.Account.AccountId;
import org.example.part4.buckpal.domain.Money;
import org.springframework.dao.DataAccessException;

@AllArgsConstructor
public class SendMoneyService implements SendMoneyUseCase {
    private final LoadAccountPort loadAccountPort;
    private final UpdateAccountStatePort updateAccountStatePort;
    private final AccountLock accountLock;

    @Override
    public boolean sendMoney(SendMoneyCommand command) {
        //TODO : 비즈니스 규칙 검증
        //비즈니스 로직 검증을 엔티티가 아니라 유스케이스에서 하는 경우
//        requireAccountExist(command.getSourceAccountId());
//        requireAccountExist(command.getTargetAccountId());
        //TODO : 모델 상태 조작
        //TODO : 출력 값 반환
        return true;
    }

//    private void requireAccountExist(@NonNull Account.AccountId targetAccountId) throws Exception {
//        Account account = loadAccountPort.getAccount(targetAccountId);
//        if(account == null) {
//            throw new Exception("no account");
//        }
//    }
}

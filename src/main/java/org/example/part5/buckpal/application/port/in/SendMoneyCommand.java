package org.example.part5.buckpal.application.port.in;

import static java.util.Objects.requireNonNull;

import javax.validation.ConstraintViolationException;
import lombok.Getter;
import lombok.NonNull;
import org.example.part5.buckpal.domain.Account.AccountId;
import org.example.part5.buckpal.domain.Money;
import org.example.part5.common.SelfValidating;

@Getter
public class SendMoneyCommand extends SelfValidating<SendMoneyCommand> {
    @NonNull
    private final AccountId sourceAccountId;
    @NonNull
    private final AccountId targetAccountId;
    @NonNull
    private final Money money;

    public SendMoneyCommand(
            AccountId sourceAccountId,
            AccountId targetAccountId,
            Money money) {
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.money = money;
        //Java Bean Validation을 쓰지 않은 경우
//        requireNonNull(sourceAccountId);
//        requireNonNull(targetAccountId);
//        requireNonNull(money);
        requireGreaterThan(money, 0);
        this.validateSelf();
    }

    private void requireGreaterThan(Money money, int value) {
        if(!money.isGreaterThan(Money.of(value))) {
            throw new ConstraintViolationException("SendMoneyCommand : money has to be greater than ZERO", null);
        }
    }
}

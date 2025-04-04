package org.example.part7.buckpal.domain;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.part7.buckpal.domain.AcitivityWindow;
import org.example.part7.buckpal.domain.Activity;
import org.example.part7.buckpal.domain.Money;

@AllArgsConstructor
@Getter
public class Account {
    private AccountId id;
    private Money baselineBalance;
    private AcitivityWindow activityWindow;

    public Money calculateBalance() {
        return Money.add(baselineBalance, activityWindow.calculateBalance(this.id));
    }

    public static Account withoutId(
            Money baselineBalance,
            AcitivityWindow activityWindow
    ) {
        return new Account(null, baselineBalance, activityWindow);
    }

    public static Account widthId(
            AccountId accountId,
            Money baselineBalance,
            AcitivityWindow activityWindow
    ) {
        return new Account(accountId, baselineBalance, activityWindow);
    }

    //출금
    public boolean withdraw(Money money, AccountId targetAccountId) {
        if(!mayWithdraw(money)) {
            return false;
        }

        Activity widthdrawal = new Activity(
                this.id,
                this.id,
                targetAccountId,
                LocalDateTime.now(),
                money
        );
        this.activityWindow.addActivity(widthdrawal);
        return true;
    }

    private boolean mayWithdraw(Money money) {
        //money.negate() => 부호 반전 즉, add가 아닌 minus로 이해하면 됨
        return Money.add(this.calculateBalance(), money.negate()).isNegative();
    }

    //입금
    public boolean deposit(Money money, AccountId sourceAccountId) {
        Activity activity = new Activity(
                this.id,
                sourceAccountId,
                this.id,
                LocalDateTime.now(),
                money
        );
        this.activityWindow.addActivity(activity);
        return true;
    }

    @AllArgsConstructor
    public static class AccountId {
        private Long value;

        public Long getValue() {
            return value;
        }
    }
}

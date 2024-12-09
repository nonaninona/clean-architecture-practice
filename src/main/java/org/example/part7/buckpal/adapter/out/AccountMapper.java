package org.example.part7.buckpal.adapter.out;

import java.util.ArrayList;
import java.util.List;
import org.example.part7.buckpal.adapter.out.AccountJpaEntity;
import org.example.part7.buckpal.adapter.out.ActivityJpaEntity;
import org.example.part7.buckpal.domain.Account;
import org.example.part7.buckpal.domain.Account.AccountId;
import org.example.part7.buckpal.domain.AcitivityWindow;
import org.example.part7.buckpal.domain.Activity;
import org.example.part7.buckpal.domain.Activity.ActivityId;
import org.example.part7.buckpal.domain.Money;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    Account mapToDomainEntity(
            AccountJpaEntity account,
            List<org.example.part7.buckpal.adapter.out.ActivityJpaEntity> activities,
            Long withdrawalBalance,
            Long depositBalance
    ) {
        Money baselineBalance = Money.subtract(
                Money.of(depositBalance),
                Money.of(withdrawalBalance));

        return Account.widthId(
                new AccountId(account.getId()),
                baselineBalance,
                mapToActivityWindow(activities)
        );
    }

    AcitivityWindow mapToActivityWindow(List<org.example.part7.buckpal.adapter.out.ActivityJpaEntity> activities) {
        List<Activity> mappedActivities = new ArrayList<>();

        for (org.example.part7.buckpal.adapter.out.ActivityJpaEntity activity : activities) {
            mappedActivities.add(new Activity(
                    new ActivityId(activity.getId()),
                    new AccountId(activity.getOwnerAccountId()),
                    new AccountId(activity.getSourceAccountId()),
                    new AccountId(activity.getTargetAccountId()),
                    activity.getTimestamp(),
                    Money.of(activity.getAmount())));
        }

        return new AcitivityWindow(mappedActivities);
    }

    org.example.part7.buckpal.adapter.out.ActivityJpaEntity mapToJpaEntity(Activity activity) {
        return new ActivityJpaEntity(
                activity.getId() == null ? null : activity.getId().getValue(),
                activity.getTimestamp(),
                activity.getOwnerAccountId().getValue(),
                activity.getSourceAccountId().getValue(),
                activity.getTargetAccountId().getValue(),
                activity.getMoney().getAmount().longValue()
        );
    }
}

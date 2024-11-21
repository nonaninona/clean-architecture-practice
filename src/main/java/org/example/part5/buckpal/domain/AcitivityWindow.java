package org.example.part5.buckpal.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.example.part5.buckpal.domain.Account;
import org.example.part5.buckpal.domain.Activity;
import org.example.part5.buckpal.domain.Money;

public class AcitivityWindow {
    private List<Activity> activities;

    public AcitivityWindow(List<Activity> activities) {
        this.activities = activities;
    }

    public AcitivityWindow(Activity ...activities) {
        this.activities = new ArrayList<>(Arrays.asList(activities));
    }

    public LocalDateTime getStartTimestamp() {
        return activities.stream()
                .min(Comparator.comparing(Activity::getTimestamp))
                .orElseThrow(IllegalStateException::new)
                .getTimestamp();
    }

    public Money calculateBalance(Account.AccountId accountId) {
        Money depositBalance = activities.stream()
                .filter(a -> a.getTargetAccountId().equals(accountId))
                .map(aa -> aa.getMoney())
                .reduce(Money.ZERO, Money::add);
        Money withdrawalBalance = activities.stream()
                .filter(a -> a.getSourceAccountId().equals(accountId))
                .map(aa -> aa.getMoney())
                .reduce(Money.ZERO, Money::add);
        return depositBalance.minus(withdrawalBalance);
    }

    public List<Activity> getActivities() {
        return Collections.unmodifiableList(activities);
    }

    public void addActivity(Activity activity) {
        this.activities.add(activity);
    }
}

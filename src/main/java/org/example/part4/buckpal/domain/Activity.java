package org.example.part4.buckpal.domain;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import org.example.part4.buckpal.domain.Account.AccountId;

@Getter
public class Activity {
    private ActivityId id;
    @NonNull
    private final Account.AccountId ownerAccountId;
    @NonNull
    private final Account.AccountId sourceAccountId;
    @NonNull
    private final Account.AccountId targetAccountId;
    @NonNull
    private final LocalDateTime timestamp;
    @NonNull
    private final Money money;

    public Activity(
            @NonNull AccountId ownerAccountId,
            @NonNull AccountId sourceAccountId,
            @NonNull AccountId targetAccountId,
            @NonNull LocalDateTime timestamp,
            @NonNull Money money) {
        this.ownerAccountId = ownerAccountId;
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.timestamp = timestamp;
        this.money = money;
    }

    @AllArgsConstructor
    public static class ActivityId {
        private final Long value;
    }
}

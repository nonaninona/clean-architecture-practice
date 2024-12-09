package org.example.part7.buckpal.adapter.in;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.part7.buckpal.domain.Account.AccountId;
import org.example.part7.buckpal.domain.AcitivityWindow;
import org.example.part7.buckpal.domain.Money;

@AllArgsConstructor
@Getter
public class AccountResource {
    private AccountId id;
    private Money baselineBalance;
    private AcitivityWindow activityWindow;
}

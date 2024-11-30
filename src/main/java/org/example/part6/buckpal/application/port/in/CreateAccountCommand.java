package org.example.part6.buckpal.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.part6.buckpal.domain.Account.AccountId;
import org.example.part6.buckpal.domain.AcitivityWindow;
import org.example.part6.buckpal.domain.Money;

@AllArgsConstructor
@Getter
@Setter
public class CreateAccountCommand {
    private AccountId id;
    private Money baselineBalance;
    private AcitivityWindow activityWindow;
}

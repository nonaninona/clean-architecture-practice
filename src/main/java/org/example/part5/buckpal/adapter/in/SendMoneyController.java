package org.example.part5.buckpal.adapter.in;

import java.math.BigInteger;
import lombok.RequiredArgsConstructor;
import org.example.part5.buckpal.application.port.in.SendMoneyUseCase;
import org.example.part5.buckpal.application.port.in.SendMoneyCommand;
import org.example.part5.buckpal.domain.Account.AccountId;
import org.example.part5.buckpal.domain.Money;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SendMoneyController {
    private final SendMoneyUseCase sendMoneyUseCase;

    @PostMapping("/accounts/sned/{sourceAccountId}/{targetAccountId}/{amount}")
    void sendMoney(
            @PathVariable("sourceAccountId") Long sourceAccountId,
            @PathVariable("targetAccountId") Long targetAccountId,
            @PathVariable("amount") Long amount
    ) {
        sendMoneyUseCase.sendMoney(
                new SendMoneyCommand(
                        new AccountId(sourceAccountId),
                        new AccountId(targetAccountId),
                        new Money(BigInteger.valueOf(amount))
                )
        );
    }
}

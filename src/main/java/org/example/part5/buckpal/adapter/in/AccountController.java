package org.example.part5.buckpal.adapter.in;

import java.math.BigInteger;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.part5.buckpal.application.port.in.CreateAccountCommand;
import org.example.part5.buckpal.application.port.in.CreateAccountUseCase;
import org.example.part5.buckpal.application.port.in.ListAccountQuery;
import org.example.part5.buckpal.application.port.in.LoadAccountQuery;
import org.example.part5.buckpal.application.port.in.SendMoneyCommand;
import org.example.part5.buckpal.domain.Account;
import org.example.part5.buckpal.domain.Money;
import org.example.part5.buckpal.application.port.in.GetAccountBalanceQuery;
import org.example.part5.buckpal.application.port.in.SendMoneyUseCase;
import org.example.part5.buckpal.domain.Account.AccountId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//adapter니까 package-private 쌉가능
@RestController
@RequiredArgsConstructor
class AccountController {
    private final GetAccountBalanceQuery getAccountBalanceQuery;
    private final ListAccountQuery listAcountsQuery;
    private final LoadAccountQuery loadAcountQuery;

    private final SendMoneyUseCase sendMoneyUseCase;
    private final CreateAccountUseCase createAccountUseCase;

    @GetMapping("/accounts")
    List<AccountResource> listAccounts() {
        List<Account> accounts = listAcountsQuery.getAccounts();
        return accounts.stream()
                .map(a -> new AccountResource(a.getId(), a.getBaselineBalance(), a.getActivityWindow()))
                .toList();
    }

    @GetMapping("/accounts/{accountId}")
    AccountResource getAccount(@PathVariable("accountId") Long accountId) {
        Account account = loadAcountQuery.getAccount(new AccountId(accountId));
        return new AccountResource(
                account.getId(),
                account.getBaselineBalance(),
                account.getActivityWindow()
        );
    }

    @GetMapping("/accounts/{accountId}")
    long getAccountBalance(@PathVariable("accountId") Long accountId) {
        Money money = getAccountBalanceQuery.getAccountBalance(new AccountId(accountId));
        return money.getAmount().longValue();
    }

    @PostMapping("/accounts")
    AccountResource createAccount(@RequestBody AccountResource account) {
        Account a = createAccountUseCase.createAccount(
                new CreateAccountCommand(
                        account.getId(),
                        account.getBaselineBalance(),
                        account.getActivityWindow()
                )
        );
        return new AccountResource(a.getId(), a.getBaselineBalance(), a.getActivityWindow());
    }

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

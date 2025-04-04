package org.example.part7.buckpal.adapter.out;

import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.part7.buckpal.domain.Account.AccountId;
import org.example.part7.buckpal.application.port.out.LoadAccountPort;
import org.example.part7.buckpal.application.port.out.UpdateAccountStatePort;
import org.example.part7.buckpal.domain.Account;
import org.example.part7.buckpal.domain.Activity;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AccountPersistenceAdapter implements LoadAccountPort, UpdateAccountStatePort {
    private final AccountRepository accountRepository;
    private final ActivityRepository activityRepository;
    private final AccountMapper accountMapper;

    @Override
    public Account loadAccount(AccountId accountId, LocalDateTime baselineDate) {
        AccountJpaEntity account = accountRepository.findById(accountId.getValue())
                .orElseThrow(EntityNotFoundException::new);

        List<ActivityJpaEntity> activities =
                activityRepository.findByOwnerSince(accountId.getValue(), baselineDate);

        Long withdrawalBalance = orZero(activityRepository.getDepositBalanceUntil(
                accountId.getValue(),
                baselineDate
        ));

        Long depositBalance = orZero(activityRepository.getDepositBalanceUntil(
                accountId.getValue(),
                baselineDate
        ));

        return accountMapper.mapToDomainEntity(
                account,
                activities,
                withdrawalBalance,
                depositBalance
        );
    }

    private Long orZero(Long value) {
        return value == null ? 0L : value;
    }


    @Override
    public void updateActivities(Account account) {
        for(Activity activity : account.getActivityWindow().getActivities()) {
            if(activity.getId() == null) {
                activityRepository.save(accountMapper.mapToJpaEntity(activity));
            }
        }
    }
}

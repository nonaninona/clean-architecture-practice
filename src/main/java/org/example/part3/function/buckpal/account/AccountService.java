package org.example.part3.function.buckpal.account;

public class AccountService {
    //인커밍 포트(web adapter와 상호작용하는)는 어디있고
    //아웃고잉 포트(persistence adapter와 상호작용하는)는 어딨나요??

    //이렇게 영속성 계층에 의존해버려도 막을 수가 없지롱
    private final AccountRepositoryImpl accountRepository;

    public AccountService(AccountRepositoryImpl accountRepository) {
        this.accountRepository = accountRepository;
    }
}

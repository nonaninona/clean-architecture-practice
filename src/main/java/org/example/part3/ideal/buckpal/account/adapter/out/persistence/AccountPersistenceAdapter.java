package org.example.part3.ideal.buckpal.account.adapter.out.persistence;

class AccountPersistenceAdapter {
    //난 LoadAccountPort나 UpdateAccountStatePort를 구현해
    //어차피 application 내부에서 나를 호출하려면 해당 인터페이스들을 통하기 때문에,
    //난 package-private이어도 상관없어.

    //만약 내가 key-value에서 RDBMS로 교체되어도, 그냥 해당 포트들을 재구현하면 돼.
}

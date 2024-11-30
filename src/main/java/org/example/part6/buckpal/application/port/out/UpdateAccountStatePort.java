package org.example.part6.buckpal.application.port.out;

import org.example.part6.buckpal.domain.Account;

public interface UpdateAccountStatePort {
    void updateActivities(Account account);
}

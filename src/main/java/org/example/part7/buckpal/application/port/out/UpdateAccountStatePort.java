package org.example.part7.buckpal.application.port.out;

import org.example.part7.buckpal.domain.Account;

public interface UpdateAccountStatePort {
    void updateActivities(Account account);
}

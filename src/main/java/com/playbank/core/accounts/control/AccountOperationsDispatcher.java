package com.playbank.core.accounts.control;

import com.playbank.core.accounts.control.managers.*;
import com.playbank.core.accounts.exceptions.AccountException;
import com.playbank.core.accounts.exceptions.AccountOperationException;
import com.playbank.core.accounts.operations.AccountOperation;

import java.util.HashSet;
import java.util.Set;

public class AccountOperationsDispatcher {
    private Set<AccountOperationManager> operationManagers = new HashSet<>();

    public void init() {
        addManager(new DepositManager())
        .addManager(new WithdrawManager())
        .addManager(new TransferManager())
        .addManager(new InterestManager());
    }

    public void dispatch(AccountOperation operation) {
        operationManagers.forEach(manager -> {
            if (manager.supports(operation)) {
                try {
                    manager.execute(operation);
                } catch (AccountOperationException ex) {
                    ex.printStackTrace();
                    // TODO: do a proper exception management
                } catch (AccountException ex) {
                    ex.printStackTrace();
                    // TODO: do a proper exception management
                }
            }
        });
    }

    public Set<AccountOperationManager> getOperationManagers() {
        return operationManagers;
    }

    public AccountOperationsDispatcher addManager(AccountOperationManager manager) {
        this.operationManagers.add(manager);

        return this;
    }

    public AccountOperationsDispatcher removeManager(AccountOperationManager manager) {
        this.operationManagers.remove(manager);

        return this;
    }
}

package com.playbank.core.accounts.control.managers;

import com.playbank.core.accounts.exceptions.InsufficientBalanceException;
import com.playbank.core.accounts.exceptions.InvalidBalanceException;
import com.playbank.core.accounts.operations.AccountOperation;
import com.playbank.core.accounts.operations.TransferAccountOperation;

public class TransferManager implements AccountOperationManager {
    private WithdrawManager withdrawManager = new WithdrawManager();
    private DepositManager depositManager = new DepositManager();

    @Override
    public boolean supports(AccountOperation operation) {
        return operation instanceof TransferAccountOperation;
    }

    @Override
    public void execute(AccountOperation operation) throws InsufficientBalanceException, InvalidBalanceException {
        if (operation.isCompleted()) return;

        TransferAccountOperation transferAccountOperation = (TransferAccountOperation)operation;


        withdrawManager.execute(transferAccountOperation.getWithdrawAccountOperation());

        depositManager.execute(transferAccountOperation.getDepositAccountOperation());
    }
}

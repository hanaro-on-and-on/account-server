package com.project.hana_on_and_on_account_server.account.service;

import com.project.hana_on_and_on_account_server.account.domain.Account;
import com.project.hana_on_and_on_account_server.account.domain.AccountTransaction;
import com.project.hana_on_and_on_account_server.account.domain.enumType.AccountTransactionType;
import com.project.hana_on_and_on_account_server.account.dto.AccountDebitRequest;
import com.project.hana_on_and_on_account_server.account.dto.AccountGetResponse;
import com.project.hana_on_and_on_account_server.account.exception.AccountNotFoundException;
import com.project.hana_on_and_on_account_server.account.repository.AccountRepository;
import com.project.hana_on_and_on_account_server.account.repository.AccountTransactionRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountTransactionRepository accountTransactionRepository;

    public List<AccountGetResponse> getUserAccountList(Long userId) {
        List<Account> accountList = accountRepository.findByUserUserId(userId);
        return accountList.stream().map(AccountGetResponse::fromEntity).toList();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void processAccountDebit(AccountDebitRequest accountDebitRequest){
        Account senderAccount = accountRepository.findByAccountNumber(accountDebitRequest.senderAccountNumber())
                .orElseThrow(AccountNotFoundException::new);

        Account receiverAccount = accountRepository.findByAccountNumber(accountDebitRequest.receiverAccountNumber())
                .orElseThrow(AccountNotFoundException::new);


        AccountTransaction senderAccountTransaction = AccountTransaction.builder()
                .accountTransactionTypeCd(AccountTransactionType.TRANSFER.getProperty())
                .account(senderAccount)
                .senderNm(accountDebitRequest.senderNm())
                .senderAccountNumber(accountDebitRequest.senderAccountNumber())
                .receiverNm(accountDebitRequest.receiverNm())
                .receiverAccountNumber(accountDebitRequest.receiverAccountNumber())
                .oldBalance(senderAccount.getBalance())
                .newBalance(senderAccount.getBalance() - accountDebitRequest.amount())
                .amount(-accountDebitRequest.amount())
                .description(accountDebitRequest.description())
                .build();

        AccountTransaction receiverAccountTransaction = AccountTransaction.builder()
                .accountTransactionTypeCd(AccountTransactionType.TRANSFER.getProperty())
                .account(receiverAccount)
                .senderNm(accountDebitRequest.senderNm())
                .senderAccountNumber(accountDebitRequest.senderAccountNumber())
                .receiverNm(accountDebitRequest.receiverNm())
                .receiverAccountNumber(accountDebitRequest.receiverAccountNumber())
                .oldBalance(receiverAccount.getBalance())
                .newBalance(receiverAccount.getBalance() + accountDebitRequest.amount())
                .amount(accountDebitRequest.amount())
                .description(accountDebitRequest.description())
                .build();

        // 계좌 잔액 수정
        senderAccount.minusAmount(accountDebitRequest.amount());
        receiverAccount.plusAmount(accountDebitRequest.amount());

        // 계좌 이체 정보 저장
        accountTransactionRepository.save(senderAccountTransaction);
        accountTransactionRepository.save(receiverAccountTransaction);
    }
}

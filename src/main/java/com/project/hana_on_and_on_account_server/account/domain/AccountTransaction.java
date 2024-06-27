package com.project.hana_on_and_on_account_server.account.domain;

import com.project.hana_on_and_on_account_server.common.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "account_transactions")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountTransaction extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountTransactionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(name = "account_transaction_type_cd")
    private String accountTransactionTypeCd;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "old_balance")
    private Long oldBalance;

    @Column(name = "new_balance")
    private Long newBalance;

    // targetNm 대신 sender, reciever로 변경
    @Column(name = "sender_nm")
    private String senderNm;

    @Column(name = "sender_account_number")
    private String senderAccountNumber;

    @Column(name = "receiver_nm")
    private String receiverNm;

    @Column(name = "receiver_account_number")
    private String receiverAccountNumber;

    @Column(name = "description", length = 300)
    private String description;

    @Builder
    public AccountTransaction(Account account,
        String accountTransactionTypeCd, Long amount, Long oldBalance, Long newBalance,
        String senderNm, String senderAccountNumber,
        String receiverNm, String receiverAccountNumber,
        String description) {
        this.account = account;
        this.accountTransactionTypeCd = accountTransactionTypeCd;
        this.amount = amount;
        this.oldBalance = oldBalance;
        this.newBalance = newBalance;
        this.senderNm = senderNm;
        this.senderAccountNumber = senderAccountNumber;
        this.receiverNm = receiverNm;
        this.receiverAccountNumber = receiverAccountNumber;
        this.description = description;
    }
}

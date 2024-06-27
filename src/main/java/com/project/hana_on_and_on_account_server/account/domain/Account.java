package com.project.hana_on_and_on_account_server.account.domain;

import com.project.hana_on_and_on_account_server.account.domain.enumType.AccountType;
import com.project.hana_on_and_on_account_server.common.domain.BaseEntity;
import com.project.hana_on_and_on_account_server.common.exception.ValueInvalidException;
import com.project.hana_on_and_on_account_server.user.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "accounts")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "account_number", length = 200)
    private String accountNumber;

    @Column(name = "account_type_cd")
    private String accountTypeCd;

    @Column(name = "account_alias", length = 50)
    private String accountAlias;

    @Column(name = "balance")
    private Long balance;

    public void setAccountTypeCd(AccountType accountType){
        this.accountTypeCd = accountType.getProperty();
    }

    public void plusAmount(Long amount) {
        this.balance += amount;
    }

    public void minusAmount(Long amount) {
        if(this.balance < amount) throw new ValueInvalidException();
        this.balance -= amount;
    }

    @Builder
    public Account(User user, String accountNumber,
        AccountType accountType, String accountAlias, Long balance) {
        this.user = user;
        this.accountNumber = accountNumber;
        this.accountTypeCd = accountType.toString();
        this.accountAlias = accountAlias;
        this.balance = balance;
    }
}

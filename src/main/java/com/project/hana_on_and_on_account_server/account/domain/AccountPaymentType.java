package com.project.hana_on_and_on_account_server.account.domain;

import lombok.Getter;

/**
 * 결제 타입
 * TRANSFER 계좌이체
 * CARD 카드결제
 */
@Getter
public enum AccountPaymentType {
    TRANSFER("TRANSFER"),
    CARD("CARD");
    private final String property;

    AccountPaymentType(String property) {
        this.property = property;
    }
}

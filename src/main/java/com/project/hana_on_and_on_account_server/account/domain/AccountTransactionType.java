package com.project.hana_on_and_on_account_server.account.domain;

import lombok.Getter;

/**
 * 거래 타입
 * FOOD 요식
 * TRANSPORT 교통
 * SHOPPING 쇼핑
 * TRANSFER 계좌 이체
 * INTEREST 이자
 */
@Getter
public enum AccountTransactionType {

    FOOD("FOOD"),
    TRANSFER("TRANSFER"),
    SHOPPING("SHOPPING"),
    TRANSPORT("TRANSPORT");
    private final String property;

    AccountTransactionType(String property) {
        this.property = property;
    }
}
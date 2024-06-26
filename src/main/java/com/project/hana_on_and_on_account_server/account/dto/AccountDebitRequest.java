package com.project.hana_on_and_on_account_server.account.dto;

public record AccountDebitRequest(String senderNm, String senderAccountNumber, String receiverNm, String receiverAccountNumber, String description, Long amount) {
}

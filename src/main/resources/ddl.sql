
DROP TABLE IF EXISTS account_transactions CASCADE;
DROP TABLE IF EXISTS accounts CASCADE;
DROP TABLE IF EXISTS account_transaction_type CASCADE;
DROP TABLE IF EXISTS account_type CASCADE;
DROP TABLE IF EXISTS users CASCADE;


CREATE TABLE users (
  user_id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  password VARCHAR,
  deleted_yn BOOLEAN,
  created_at TIMESTAMP(6) NOT NULL DEFAULT now(),
  updated_at TIMESTAMP(6) NOT NULL DEFAULT now()
);

CREATE TABLE account_type (
  account_type_cd VARCHAR(50),
  deleted_yn BOOLEAN DEFAULT FALSE,
  created_at TIMESTAMP(6) NOT NULL DEFAULT now(),
  updated_at TIMESTAMP(6) NOT NULL DEFAULT now(),
  PRIMARY KEY (account_type_cd)
);

CREATE TABLE accounts (
  account_id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  user_id BIGINT,
  account_number VARCHAR(200),
  account_type_cd VARCHAR(50),
  account_alias VARCHAR(50),
  balance BIGINT,
  deleted_yn BOOLEAN DEFAULT FALSE,
  created_at TIMESTAMP(6) NOT NULL DEFAULT now(),
  updated_at TIMESTAMP(6) NOT NULL DEFAULT now(),
  FOREIGN KEY (user_id) REFERENCES users(user_id),
  FOREIGN KEY (account_type_cd) REFERENCES account_type(account_type_cd)
);

CREATE TABLE account_transaction_type (
  account_transaction_type_cd VARCHAR(50),
  deleted_yn BOOLEAN DEFAULT FALSE,
  created_at TIMESTAMP(6) NOT NULL DEFAULT now(),
  updated_at TIMESTAMP(6) NOT NULL DEFAULT now(),
  PRIMARY KEY (account_transaction_type_cd)
);

CREATE TABLE account_transactions (
  account_transaction_id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  account_id BIGINT,
  account_transaction_type_cd VARCHAR(50),
  amount BIGINT,
  old_balance BIGINT,
  new_balance BIGINT,
  sender_nm VARCHAR,
  sender_account_number VARCHAR,
  receiver_nm VARCHAR,
  receiver_account_number VARCHAR,
  description VARCHAR(300),
  deleted_yn BOOLEAN DEFAULT FALSE,
  created_at TIMESTAMP(6) NOT NULL DEFAULT now(),
  updated_at TIMESTAMP(6) NOT NULL DEFAULT now(),
  FOREIGN KEY (account_id) REFERENCES accounts(account_id),
  FOREIGN KEY (account_transaction_type_cd) REFERENCES account_transaction_type(account_transaction_type_cd)
);

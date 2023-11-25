CREATE TABLE tb_transactions(
    id SERIAL PRIMARY KEY,
    amount DOUBLE PRECISION NOT NULL,
    payer_id BIGINT NOT NULL,
    payee_id BIGINT NOT NULL,
    timestamp_trasaction DATE NOT NULL
);
ALTER TABLE tb_transactions ADD CONSTRAINT fk_picpay_01 FOREIGN KEY (payer_id) REFERENCES tb_user(id);

ALTER TABLE tb_transactions ADD CONSTRAINT fk_picpay_02 FOREIGN KEY (payee_id) REFERENCES tb_user(id);
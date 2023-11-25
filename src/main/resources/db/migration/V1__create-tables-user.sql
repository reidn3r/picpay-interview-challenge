CREATE TABLE tb_user(
    id SERIAL PRIMARY KEY,
    firstName TEXT NOT NULL,
    lastName TEXT NOT NULL,
    cpf TEXT NOT NULL,
    email TEXT NOT NULL,
    password TEXT NOT NULL,
    balance DOUBLE PRECISION NOT NULL,
    userType TEXT NOT NULL
);

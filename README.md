# PicPay Simplificado - [Desafio Back-end](https://github.com/PicPay/picpay-desafio-backend)

## Sobre o Projeto
Este é o desafio técnico proposto pelo PicPay para o processo seletivo. O objetivo é implementar uma plataforma de pagamentos simplificada com funcionalidades RESTful para transferências entre usuários e lojistas, garantindo requisitos de negócio como validações, notificações e operações transacionais.

A solução foi desenvolvida utilizando **Java 17** e **Spring Boot**, seguindo boas práticas de código, como responsabilidades únicas, injeção de dependências e separação de camadas. Também inclui a configuração de um banco de dados com **Docker**.
---

## Funcionalidades Implementadas
- **Cadastro de usuários e lojistas** (restrições de unicidade para CPF e email).
- **Transferências entre usuários e lojistas**:
  - Validação de saldo antes da transferência.
  - Consulta a um serviço externo para autorização.
  - Notificações de recebimento simuladas via serviço externo.
- **Tratamento de erros** com uma classe para gestão de exceções.

---

## Tecnologias Utilizadas
- **Java 17**
- **Spring Boot**
- **Spring Data JPA** para persistência de dados.
- **Jakarta Validation** para validações.
- **Lombok** para reduzir boilerplate.
- **Docker** para configuração do banco de dados.
- **PostgreSQL** para armazenamento dos dados.

---

## Estrutura do Projeto
- **Controller:** Gerencia as requisições HTTP.
- **Service:** Contém a lógica de negócio.
- **Repository:** Abstração de acesso ao banco de dados.
- **ControllerExceptionHandler:** Tratamento de erros personalizados.
- **Model:** Representação das entidades do banco de dados.
- **DTO:** Objetos de transferência de dados.

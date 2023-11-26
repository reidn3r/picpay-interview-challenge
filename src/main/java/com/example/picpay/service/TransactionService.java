package com.example.picpay.service;

import com.example.picpay.DTO.TransactionDTO;
import com.example.picpay.model.Transaction.TransactionModel;
import com.example.picpay.model.User.UserModel;
import com.example.picpay.repository.TransactionReporitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Service
public class TransactionService {
    @Autowired
    private UserService userService;

    @Autowired
    private TransactionReporitory transactionReporitory;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private NotificationService notificationService;

    public TransactionModel createTransaction(TransactionDTO transaction) throws Exception{
        if(transaction.payee_id() == transaction.payer_id()) throw new Exception("A transacao deve ser feita entre usuarios diferentes");
        UserModel payer = this.userService.findUserById(transaction.payer_id());
        UserModel payee = this.userService.findUserById(transaction.payee_id());

        userService.validateTransaction(payer, transaction.amount());

        //Verificação com serviço externo
        boolean isAuthorized = authorizeTransaction(payer, transaction.amount());
        if(!isAuthorized){
            throw new Exception("Transacao nao autorizada");
        }

        TransactionModel newTransaction = new TransactionModel(transaction, payer, payee);

        //Atualiza saldo do pagador e recebedor
        payer.setBalance(payer.getBalance().subtract(transaction.amount()));
        payee.setBalance(payee.getBalance().add(transaction.amount()));

        userService.saveUser(payer);
        userService.saveUser(payee);

        //Serviço de notificação
        this.notificationService.sendNotification(payer, "Pagamento feito com sucesso");
        this.notificationService.sendNotification(payee, "Pagamento recebido com sucesso");

        //Registra transação
        return transactionReporitory.save(newTransaction);
    }

    public boolean authorizeTransaction(UserModel payer, BigDecimal amount){
        //Http GET: Serviço de autorização
        ResponseEntity<Map> response = restTemplate.getForEntity("https://run.mocky.io/v3/5794d450-d2e2-4412-8131-73d0293ac1cc", Map.class);
        return response.getStatusCode() == HttpStatus.OK && response.getBody().get("message").equals("Autorizado");
    }
}

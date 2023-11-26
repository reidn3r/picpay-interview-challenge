package com.example.picpay.service;

import com.example.picpay.DTO.NotificationDTO;
import com.example.picpay.model.User.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {
    @Autowired
    private RestTemplate restTemplate;

    public void sendNotification(UserModel user, String message) throws Exception{
        String email = user.getEmail();
        NotificationDTO NotificationBodyRequest = new NotificationDTO(email, message);
        ResponseEntity<Object> response = restTemplate.postForEntity("https://run.mocky.io/v3/54dc2cf1-3add-45b5-b5a9-6bf7e7f1f4a6", NotificationBodyRequest, Object.class);
        if(!(response.getStatusCode() == HttpStatus.OK)){
            throw new Exception("Erro ao enviar notificacao");
        }
    }
}

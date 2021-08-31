package com.leniorko.LearnignWebSockets.Controllers;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

import com.leniorko.LearnignWebSockets.Models.ClientChatConfigModel;
import com.leniorko.LearnignWebSockets.Models.SimpleMessageModel;

@Controller
public class MessageController {

	@Autowired
	private SimpMessagingTemplate messagingTemplate;

	AtomicInteger idIncrementer = new AtomicInteger();
	
  @MessageMapping("/send")
  public void greeting(@Payload SimpleMessageModel data) {
	  
	  data.setNextID(idIncrementer.addAndGet(1));
	  
    messagingTemplate.convertAndSend("/chat/receive", data);
  }
  
  @SubscribeMapping("/chat/receive")
  public void sendNextId() {
	  ClientChatConfigModel clientChatConfigModel = new ClientChatConfigModel(idIncrementer.get());
	  messagingTemplate.convertAndSend("/chat/setup", clientChatConfigModel);
  }
}

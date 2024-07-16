package com.porto.ai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/poem")
public class PoemController {
    private final ChatClient chatClient;

    public PoemController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping
    public String gerarPoema() {
        return chatClient
                .prompt()
                .user("Crie um poema sobre tecnologia")
                .call()
                .content();
    }
}

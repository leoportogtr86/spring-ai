package com.porto.ai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/component")
public class ReactComponentController {
    private final ChatClient chatClient;

    public ReactComponentController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping
    public String generateComponent(@RequestParam String text) {
        return chatClient
                .prompt()
                .user("Gere apenas o código de um componente react com a seguinte especificação: " + text)
                .call()
                .content();
    }
}

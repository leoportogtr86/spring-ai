package com.porto.ai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/translate")
public class TranslationController {
    private final ChatClient chatClient;

    public TranslationController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping
    public String traduzir(@RequestParam String texto) {
        return chatClient
                .prompt()
                .user("Traduza para pt-br: " + texto)
                .call()
                .content();
    }
}

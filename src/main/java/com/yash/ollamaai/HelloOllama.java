package com.yash.ollamaai;


import org.springframework.ai.ollama.OllamaChatClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloOllama {

    private final OllamaChatClient ollamaChatClient;

    @Autowired
    public HelloOllama(OllamaChatClient ollamaChatClient) {
        this.ollamaChatClient = ollamaChatClient;
    }

    @GetMapping("/ai/helloollama")
    public String generate(@RequestParam(value = "message", defaultValue = "Tell me a joke on love") String message) {
        return ollamaChatClient.call(message);
    }
}

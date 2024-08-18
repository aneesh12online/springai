package com.aneesh.springai.springaidemo.controller;

import com.aneesh.springai.springaidemo.models.ChatInput;
import com.aneesh.springai.springaidemo.models.ChatOutput;
import com.aneesh.springai.springaidemo.service.OpenAIService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private final OpenAIService openAIService;

    public ChatController(OpenAIService openAIService) {
        this.openAIService = openAIService;
    }

    @PostMapping("/chatmessage")
    public ChatOutput chat(@RequestBody ChatInput chatInput){
        //ChatOutput chatOutput= openAIService.getResponse(chatInput) ;
        return  new ChatOutput("Hello! How can I assist you today?");
    }
}

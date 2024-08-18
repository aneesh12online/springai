package com.aneesh.springai.springaidemo.service;

import com.aneesh.springai.springaidemo.models.ChatInput;
import com.aneesh.springai.springaidemo.models.ChatOutput;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

@Service
public class OpenAIService {
private final ChatClient chatClient;

    public OpenAIService(ChatClient.Builder chatClientBuilder ) {
        this.chatClient = chatClientBuilder.build();
    }

    public ChatOutput getResponse(ChatInput chatInput){
        PromptTemplate promptTemplate= new PromptTemplate(chatInput.input());
        Prompt prompt = promptTemplate.create();
        ChatClient.ChatClientPromptRequest chatClientPromptRequest=  chatClient.prompt(prompt);
         ChatClient.ChatClientRequest.CallPromptResponseSpec callPromptResponseSpec= chatClientPromptRequest.call();
        ChatResponse chatResponse= callPromptResponseSpec.chatResponse();
        return new ChatOutput(chatResponse.getResult().getOutput().getContent());

    }
}

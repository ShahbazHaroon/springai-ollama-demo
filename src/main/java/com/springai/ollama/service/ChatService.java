/*
 * @author Muhammad Ubaid Ur Raheem Ahmad AKA Shahbaz Haroon
 * Email: shahbazhrn@gmail.com
 * Cell: +923002585925
 * GitHub: https://github.com/ShahbazHaroon
 */

package com.springai.ollama.service;

import com.springai.ollama.exception.ServiceUnavailableException;
import com.springai.ollama.response.ChatResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.ChatClient;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class ChatService {

    private final ChatClient chatClient;

    public ChatResponse generateAsQueryParameter(String promptMessage) {
        log.info("ChatService >>> generateAsQueryParameter called");
        try {
            final String llamaResponse = chatClient.call(promptMessage);
            return new ChatResponse().setMessage(llamaResponse);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("An error occurred during chat generation", e);
            throw new ServiceUnavailableException("An error occurred during chat generation");
        }
    }

    public ChatResponse generateAsPathVariable(String topic) {
        log.info("ChatService >>> generateAsPathVariable called");
        try {
            final String llamaResponse = chatClient.call(topic);
            return new ChatResponse().setMessage(llamaResponse);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("An error occurred during chat generation", e);
            throw new ServiceUnavailableException("An error occurred during chat generation");
        }
    }
}
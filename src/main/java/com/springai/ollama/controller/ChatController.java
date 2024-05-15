/*
 * @author Muhammad Ubaid Ur Raheem Ahmad AKA Shahbaz Haroon
 * Email: shahbazhrn@gmail.com
 * Cell: +923002585925
 * GitHub: https://github.com/ShahbazHaroon
 */

package com.springai.ollama.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springai.ollama.constant.AppConstant;
import com.springai.ollama.exception.MissingInputException;
import com.springai.ollama.request.ChatRequest;
import com.springai.ollama.response.ChatResponse;
import com.springai.ollama.service.ChatService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(AppConstant.REQUEST_MAPPING)
public class ChatController {

    private final ObjectMapper objectMapper;

    private final ChatService chatService;

    @GetMapping("/v1/ai/status")
    public ResponseEntity<String> rootPageCheck(@Value("${spring.application.name}") String appName) {
        log.info("ChatController >>> rootPageCheck method called");
        //Check input parameter
        if (!StringUtils.hasText(appName)) {
            throw new MissingInputException(AppConstant.INPUT_PARAMETER_VALIDATION);
        }
        return new ResponseEntity<>(appName + " is up and running!", HttpStatus.OK);
    }

    @PostMapping("/v1/ai/generate")
    public ResponseEntity<ChatResponse> generate(
            @RequestBody final ChatRequest chatRequest) {
        log.info("ChatController >>> generate method called");
        //Check input parameter
        if (!StringUtils.hasText(chatRequest.getPromptMessage())) {
            throw new MissingInputException(AppConstant.INPUT_PARAMETER_VALIDATION);
        }
        try {
            //Convert the ChatRequest object to JSON
            String requestBody = objectMapper.writeValueAsString(chatRequest.getPromptMessage());
            final ChatResponse serviceResponse = chatService.generate(requestBody);
            return ResponseEntity.status(HttpStatus.OK).body(serviceResponse);
        } catch (JsonProcessingException e) {
            log.error("An error occurred during Convert the ChatRequest object to JSON", e);
            throw new RuntimeException(e);
        }
    }
}
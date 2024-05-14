/*
 * @author Muhammad Ubaid Ur Raheem Ahmad AKA Shahbaz Haroon
 * Email: shahbazhrn@gmail.com
 * Cell: +923002585925
 * GitHub: https://github.com/ShahbazHaroon
 */

package com.springai.ollama.controller;

import com.springai.ollama.constant.AppConstant;
import com.springai.ollama.exception.MissingInputException;
import com.springai.ollama.exception.ServiceUnavailableException;
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

    private final ChatService chatService;

    @GetMapping("/v1/ai/status")
    public ResponseEntity<String> rootPageCheck(@Value("${spring.application.name}") String appName) {
        log.info("ChatController >>> rootPageCheck called");
        //Check input parameter
        if (!StringUtils.hasText(appName)) {
            throw new MissingInputException(AppConstant.INPUT_PARAMETER_VALIDATION);
        }
        return new ResponseEntity<>(appName + " is up and running!", HttpStatus.OK);
    }

    @GetMapping("/v1/ai/generate")
    public ResponseEntity<ChatResponse> generateAsQueryParameter(
            @RequestParam(value = "promptMessage", defaultValue = "Why is the sky blue?")
            String promptMessage) {
        log.info("ChatController >>> generateAsQueryParameter called");
            final ChatResponse serviceResponse = chatService.generateAsQueryParameter(promptMessage);
            return ResponseEntity.status(HttpStatus.OK).body(serviceResponse);
    }

    @GetMapping("/v1/ai/generate/{topic}")
    public ResponseEntity<ChatResponse> generateAsPathVariable(@PathVariable String topic) {
        log.info("ChatController >>> generateAsPathVariable called");
        //Check input parameter
        if (!StringUtils.hasText(topic)) {
            throw new MissingInputException(AppConstant.INPUT_PARAMETER_VALIDATION);
        }
        final ChatResponse serviceResponse = chatService.generateAsPathVariable(topic);
        return ResponseEntity.status(HttpStatus.OK).body(serviceResponse);
    }
}
package com.feng.faiagent.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.InMemoryChatMemoryRepository;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component
@Slf4j
public class LoveApp {
    private static final String CHAT_MEMORY_CONVERSATION_ID_KEY = "chatId";
    private static final String CHAT_MEMORY_RETRIEVE_SIZE_KEY = "precedenceSize";
    private final ChatClient chatClient;

    private static final String SYSTEM_PROMPT = "扮演深耕";

    public LoveApp(ChatModel dashscopeChatModel) {
        InMemoryChatMemoryRepository chatMemory = new InMemoryChatMemoryRepository();

        // 修正：使用正确的构造函数参数
        chatClient = ChatClient.builder(dashscopeChatModel)
                .defaultSystem(SYSTEM_PROMPT)
                .defaultAdvisors()
                .build();
    }
    public String doChat(String message, String chatId) {
        // 在类中手动添加
        final Logger log = LoggerFactory.getLogger(LoveApp.class);
        ChatResponse response = chatClient
                .prompt()
                .user(message)
                .advisors(spec -> spec.param(CHAT_MEMORY_CONVERSATION_ID_KEY, chatId)
                        .param(CHAT_MEMORY_RETRIEVE_SIZE_KEY, 10))
                .call()
                .chatResponse();
        String content = response.getResult().getOutput().getText();
        log.info("content: {}", content);
        return content;
    }


}



package com.feng.faiagent.demo.Invoke;

import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.model.ChatModel;
import jakarta.annotation.Resource;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Spring Ai框架调用ai模型
 */
@Component
public class SpringAiInvoke implements CommandLineRunner {

    @Resource
    private ChatModel dashscopeChatModel;

    @Override
    public void run(String... args) throws Exception {
        AssistantMessage assistantMessage = dashscopeChatModel.call(new Prompt("你好，我是你的好朋友"))
                .getResult()
                .getOutput();
        System.out.println(assistantMessage.getText());
    }
}

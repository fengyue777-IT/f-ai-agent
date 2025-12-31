package com.feng.faiagent.demo.Invoke;

import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.model.chat.ChatLanguageModel;

public class LangChainAiInvoke {
    public static void main(String[] args) {
        ChatLanguageModel qwenModel = QwenChatModel.builder()
                .apiKey("sk-0505b5ab01bb47eeb7d274120540f744")
                .modelName("qwen-max")
                .build();
        }
}

package com.feng.faiagent.demo.Invoke;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;

import java.util.HashMap;
import java.util.Map;

public class HttpAiInvoke {

    public static void main(String[] args) {
        String apiKey = TestApiKey.API_KEY; // 从环境变量获取API密钥
        String url = "https://dashscope.aliyuncs.com/api/v1/services/aigc/text-generation/generation";

        // 构建请求体数据
        Map<String, Object> requestData = new HashMap<>();
        requestData.put("model", "qwen-plus");

        Map<String, Object> input = new HashMap<>();
        Map<String, String> systemMessage = new HashMap<>();
        systemMessage.put("role", "system");
        systemMessage.put("content", "You are a helpful assistant.");

        Map<String, String> userMessage = new HashMap<>();
        userMessage.put("role", "user");
        userMessage.put("content", "你是谁？");

        input.put("messages", new Object[]{systemMessage, userMessage});
        requestData.put("input", input);

        Map<String, String> parameters = new HashMap<>();
        parameters.put("result_format", "message");
        requestData.put("parameters", parameters);

        // 发送POST请求
        HttpResponse response = HttpRequest.post(url)
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .body(JSONUtil.toJsonStr(requestData))
                .execute();

        // 输出响应结果
        System.out.println("Status: " + response.getStatus());
        System.out.println("Response Body: " + response.body());
    }
}



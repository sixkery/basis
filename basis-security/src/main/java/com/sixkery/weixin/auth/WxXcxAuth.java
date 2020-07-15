package com.sixkery.weixin.auth;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sixkery.weixin.constant.WxConst;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.Map;

/**
 * 使用code换取session_key和openid
 *
 * @author maoning
 */
public class WxXcxAuth {

    private int retryCounter;

    public Code2SessionOutDto code2Session(String appid, String secret, String code) throws IOException, WxXcxAuthException {
        HttpClient http = HttpClients.createDefault();
        String uri = String.format(WxConst.uri_code2Session, appid, secret, code);

        ObjectMapper objectMapper = new ObjectMapper();
        HttpResponse response = http.execute(new HttpGet(uri));
        HttpEntity httpEntity = response.getEntity();

        // 字节流转成Map对象
        Map<String, String> reqResult = objectMapper.readValue(httpEntity.getContent(), new TypeReference<Map<String, String>>() {
                });

        if (!reqResult.containsKey("errcode")) {
            // 最终返回一个Java对象
            return objectMapper.readValue(objectMapper.writer().writeValueAsString(reqResult), Code2SessionOutDto.class);
        }

        // 错误码，请求成功时不返回
        String errCode = reqResult.get("errcode");

        // 系统繁忙，触发重试机制
        if ("-1".equals(errCode)) {
            if (retryCounter <= 3) {
                retryCounter++;
                return code2Session(appid, secret, code);
            }
        }

        throw new WxXcxAuthException(errCode, reqResult.get("errmsg"));
    }

}

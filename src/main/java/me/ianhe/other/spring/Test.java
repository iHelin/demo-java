package me.ianhe.other.spring;

import com.alibaba.druid.support.json.JSONUtils;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author iHelin
 * @date 2019-03-28 16:50
 */
public class Test {

    public static void main(String[] args) {
        String url = "https://oapi.dingtalk.com/robot/send?access_token=7b03d3b4ffd7ac35c81991f4bf0cdb4ff8a18c9d28efd2d710d631a2f64ad61b";
        Map<String, Object> params = new HashMap<>();
        params.put("msgtype", "text");
        Map<String, Object> contentMap = new HashMap<>();
        contentMap.put("content", "hi");
        params.put("text", contentMap);

        RestTemplate restTemplate = new RestTemplate();
        String s = restTemplate.postForObject(url, JSONUtils.toJSONString(params), String.class);
        System.out.println(s);
    }
}

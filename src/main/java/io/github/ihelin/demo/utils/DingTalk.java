package io.github.ihelin.demo.utils;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author iHelin
 * @since 2019-03-28 16:50
 */
public class DingTalk {

    private static final String SIGN = "SECb84365c590c77868c69f7bdac8600759ff457301166e672078b59b383d609b8d";
    private static final String TOKEN = "5c48f9fe08ba0af65c08def326421f0fd1c54de1e97652d63cb3a05bace2641d";
    private static final String URL = "https://oapi.dingtalk.com/robot/send?access_token={1}&timestamp={2}&sign={3}";

    private DingTalk() {
    }

    public static void main(String[] args) throws MalformedURLException, URISyntaxException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        DingTalk.say("hello");
    }

    public static String say(String words) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        Long timestamp = System.currentTimeMillis();
        String sign = sign();

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Map<String, Object> body = new HashMap<>();
        body.put("msgtype", "text");
        Map<String, Object> contentMap = new HashMap<>();
        contentMap.put("content", words);
        body.put("text", contentMap);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(URL, request, String.class, TOKEN, timestamp, sign);
        return responseEntity.getBody();
    }


    private static String sign() throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        Long timestamp = System.currentTimeMillis();
        String stringToSign = timestamp + "\n" + SIGN;
        byte[] bytesToSign = stringToSign.getBytes(StandardCharsets.UTF_8);
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(SIGN.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
        byte[] signData = mac.doFinal(bytesToSign);
        String sign = URLEncoder.encode(new String(Base64.encodeBase64(signData)), "UTF-8");
        return sign;
    }
}

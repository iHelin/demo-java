package io.github.ihelin.demo.other.okhttp;

import okhttp3.*;

import java.io.IOException;

/**
 * @author iHelin
 * @since 2019-05-20 13:54
 */
public class Demo {

    private final OkHttpClient client = new OkHttpClient();

    private static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    public static void main(String[] args) throws IOException {
        Demo demo = new Demo();
        String result = demo.runGet("http://112.74.203.130");
        System.out.println(result);
    }


    private String runGet(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    private String runPost(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}

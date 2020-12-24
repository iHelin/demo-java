package io.github.ihelin.demo.other.fastjson;

import com.alibaba.fastjson.JSON;

public class Main {

    public static void main(String[] args) {
        Object parse = JSON.parse("{\"name\": \"何霖\"}");
        System.out.println(parse);
    }

}

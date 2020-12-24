package io.github.ihelin.demo.test;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author iHelin
 * @since 2018/2/28 09:56
 */
public class SensitiveWordUtil {

    public static Map getSensitiveWordMap() {
        //读取敏感词库
        Set<String> keyWordSet = readSensitiveWordFile();
        //将敏感词库加入到HashMap中
        return addSensitiveWordToHashMap(keyWordSet);
    }

    /**
     * 读取敏感词库，将敏感词放入HashSet中，构建一个DFA算法模型
     *
     * @param sensitiveWordSet
     */
    private static Map<String, String> addSensitiveWordToHashMap(Set<String> sensitiveWordSet) {
        //初始化敏感词容器，减少扩容操作
        Map<String, String> sensitiveWordMap = new HashMap(sensitiveWordSet.size());
        Map currentMap;
        Map<String, String> newWordMap;
        for (String sensitiveWord : sensitiveWordSet) {
            currentMap = sensitiveWordMap;
            for (int i = 0; i < sensitiveWord.length(); i++) {
                //转换成char型
                char keyChar = sensitiveWord.charAt(i);
                Object wordMap = currentMap.get(keyChar);
                if (wordMap != null) {        //如果存在该key，直接赋值
                    currentMap = (Map) wordMap;
                } else {     //不存在则构建一个map，同时将isEnd设置为0，因为它不是最后一个
                    newWordMap = new HashMap<>();
                    newWordMap.put("isEnd", "0");     //不是最后一个
                    currentMap.put(keyChar, newWordMap);
                    currentMap = newWordMap;
                }
                if (i == sensitiveWord.length() - 1) {
                    currentMap.put("isEnd", "1");    //最后一个
                }
            }
        }
        return sensitiveWordMap;
    }

    /**
     * 读取敏感词库中的内容，将内容添加到set集合中
     *
     * @return
     */
    private static Set<String> readSensitiveWordFile() {
        Set<String> sensitiveWordSet = new HashSet<>();
        File file = new File("demo/sensitiveWord.txt");
        try (InputStreamReader read = new InputStreamReader(new FileInputStream(file))) {
            BufferedReader bufferedReader = new BufferedReader(read);
            String txt;
            while ((txt = bufferedReader.readLine()) != null) {    //读取文件，将文件内容放入到set中
                sensitiveWordSet.add(txt);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sensitiveWordSet;
    }
}

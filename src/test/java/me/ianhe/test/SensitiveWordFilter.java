package me.ianhe.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author iHelin
 * @since 2018/2/27 17:42
 */
public class SensitiveWordFilter {

    public static int minMatchType = 1;      //最小匹配规则
    public static int maxMatchType = 2;      //最大匹配规则

    /**
     * 判断文字是否包含敏感字符
     *
     * @param txt       文字
     * @param matchType 匹配规则1：最小匹配规则，2：最大匹配规则
     * @return
     */
    public boolean containsSensitiveWord(String txt, int matchType) {
        boolean flag = false;
        for (int i = 0; i < txt.length(); i++) {
            int matchFlag = this.getSensitiveWordLength(txt, i, matchType); //判断是否包含敏感字符
            if (matchFlag > 0) {    //大于0存在，返回true
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 获取文本中的敏感词
     *
     * @param txt       文本字符串
     * @param matchType 匹配规则1：最小匹配规则，2：最大匹配规则
     * @return
     */
    public Set<String> getSensitiveWord(String txt, int matchType) {
        Set<String> sensitiveWordSet = new HashSet<>();
        for (int i = 0; i < txt.length(); i++) {
            int length = getSensitiveWordLength(txt, i, matchType);    //判断是否包含敏感字符
            if (length > 0) {    //存在,加入list中
                sensitiveWordSet.add(txt.substring(i, i + length));
                i = i + length - 1;    //减1的原因，是因为for会自增
            }
        }
        return sensitiveWordSet;
    }

    /**
     * 替换敏感字字符
     *
     * @param txt
     * @param matchType
     * @param replaceChar
     * @return
     */
    public String replaceSensitiveWord(String txt, int matchType, String replaceChar) {
        String resultTxt = txt;
        Set<String> set = getSensitiveWord(txt, matchType);     //获取所有的敏感词
        Iterator<String> iterator = set.iterator();
        String word;
        String replaceString;
        while (iterator.hasNext()) {
            word = iterator.next();
            replaceString = getReplaceChars(replaceChar, word.length());
            resultTxt = resultTxt.replaceAll(word, replaceString);
        }
        return resultTxt;
    }

    /**
     * 获取替换字符串
     *
     * @param replaceChar
     * @param length
     * @return
     */
    private String getReplaceChars(String replaceChar, int length) {
        StringBuilder resultReplace = new StringBuilder(replaceChar);
        for (int i = 1; i < length; i++) {
            resultReplace.append(replaceChar);
        }
        return resultReplace.toString();
    }

    /**
     * 检查文字中是否包含敏感字符，如果存在，则返回敏感词字符的长度，不存在返回0
     *
     * @param txt
     * @param beginIndex
     * @param matchType
     * @return
     */
    private int getSensitiveWordLength(String txt, int beginIndex, int matchType) {
        /*敏感词结束标识位：用于敏感词只有1位的情况*/
        boolean flag = false;
        /*匹配标识数默认为0*/
        int matchFlag = 0;
        char word;
        Map currentMap = SensitiveWordUtil.getSensitiveWordMap();
        for (int i = beginIndex; i < txt.length(); i++) {
            word = txt.charAt(i);
            currentMap = (Map) currentMap.get(word);
            if (currentMap != null) {
                //存在，则判断是否为最后一个
                matchFlag++;     //找到相应key，匹配标识+1
                if ("1".equals(currentMap.get("isEnd"))) {
                    //如果为最后一个匹配规则,结束循环，返回匹配标识数
                    flag = true;       //结束标志位为true
                    if (SensitiveWordFilter.minMatchType == matchType) {
                        //最小规则，直接返回,最大规则还需继续查找
                        break;
                    }
                }
            } else {     //不存在，直接返回
                break;
            }
        }
        if (matchFlag < 2 || !flag) {
            matchFlag = 0;
        }
        return matchFlag;
    }

    public static void main(String[] args) {
        SensitiveWordFilter filter = new SensitiveWordFilter();
        String string = "太多的伤感情怀也许只局限于饲养基地习近平 荧幕习近平中的情节，主人公尝试着去用某种方式渐渐的很潇洒地释自杀指南怀那些自己经历的伤感。"
                + "然后法轮功 我们的扮演的角色就是跟随着主人公的喜红客联盟 怒哀乐而过于牵强的把自己的情感也附加于银幕情节中，然后感动就流泪，";
        System.out.println("待检测语句字数：" + string.length());
        long beginTime = System.currentTimeMillis();
        Set<String> set = filter.getSensitiveWord(string, 1);
        long endTime = System.currentTimeMillis();
        System.out.println("语句中包含敏感词的个数为：" + set.size() + "。包含：" + set);
        System.out.println("总共消耗时间为：" + (endTime - beginTime) + "ms");
        System.out.println(filter.replaceSensitiveWord(string, 1, "*"));
        System.out.println(filter.containsSensitiveWord(string, 1));
        System.out.println(SensitiveWordFilter.class.getClassLoader().getResource("").getPath());
    }
}

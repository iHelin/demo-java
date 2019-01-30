package me.ianhe.lib.commons.lang3;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author iHelin
 * @since 2017/5/12 14:36
 */
public class StringUtilTest {

    /**
     * 字符串测试
     *
     * @author iHelin
     * @since 2017/5/12 14:37
     */
    public static void stringUtilTest() {
        //首字母大写
        System.out.println(StringUtils.capitalize("string"));
        //是否为数字
        System.out.println(StringUtils.isNumeric("12355.12"));
        //截取
        System.out.println(StringUtils.left("string", 3));
        //某字符或字符串出现次数
        System.out.println(StringUtils.countMatches("abcdaaa", 'a'));//4
        System.out.println(StringUtils.countMatches("abcdaaa", "ab"));//1
        //随机字母
        System.out.println(RandomStringUtils.randomAlphabetic(4));
        //随机字母或者数字
        System.out.println(RandomStringUtils.randomAlphanumeric(6));
        //随机数字，可用于手机验证码等
        System.out.println(RandomStringUtils.randomNumeric(4));
        System.out.println(RandomStringUtils.random(4, false, true));
    }

    public static void main(String[] args) {
        stringUtilTest();
    }

}

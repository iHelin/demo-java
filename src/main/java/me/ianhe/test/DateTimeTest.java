package me.ianhe.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.*;

/**
 * 日期先关测试
 *
 * @author iHelin
 * @since 2017/11/20 16:38
 */
public class DateTimeTest {

    public static void main(String[] args) throws ParseException {
        DateFormat aa = DateFormat.getDateInstance();
        Date date1; // 开始日期
        Date date2; // 结束日期
        date1 = aa.parse("2009-10-01");
        date2 = aa.parse("2010-08-01");
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        // 定义集合存放月份
        List<String> list = new ArrayList<>();
        // 添加第一个月，即开始时间
        list.add("2009-10");
        c1.setTime(date1);
        c2.setTime(date2);
        while (c1.compareTo(c2) < 0) {
            c1.add(Calendar.MONTH, 1);// 开始日期加一个月直到等于结束日期为止
            Date ss = c1.getTime();
            String str = aa.format(ss);
            str = str.substring(0, str.lastIndexOf("-"));
            list.add(str);
        }
        // 存放入数组
        String[] str = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            str[i] = list.get(i);
        }
        System.out.println(Arrays.toString(str));

    }

}

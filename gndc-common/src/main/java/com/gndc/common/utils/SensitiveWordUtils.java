package com.gndc.common.utils;

import org.apache.commons.lang.StringUtils;

import java.util.*;
import java.util.Map.Entry;

/**
 * 过滤敏感词，并把敏感词替换成*
 *
 * @author WWX
 */
public class SensitiveWordUtils {

    static ArrayList<String> first = new ArrayList<String>();
    static String[] sortFirst;
    static char[] charFirst;
    static HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
    static HashMap<String, String[]> sortMap = new HashMap<String, String[]>();
    static HashMap<String, char[]> charMap = new HashMap<String, char[]>();

    static ArrayList<String> temp;
    static String key, value;
    int length;

    /**
     * 带参数的构造函数
     *
     * @param keys     敏感词
     * @param tContent 需要过滤的内容
     */
    public SensitiveWordUtils(List<String> keys, String tContent) {

        for (String k : keys) {
            if (k.length() <= tContent.length()) {
                if (!first.contains(k.substring(0, 1))) {
                    first.add(k.substring(0, 1));
                }
                length = k.length();
                for (int i = 1; i < length; i++) {
                    key = k.substring(0, i);
                    value = k.substring(i, i + 1);
                    if (i == 1 && !first.contains(key)) {
                        first.add(key);
                    }

                    // 有，添加
                    if (map.containsKey(key)) {
                        if (!map.get(key).contains(value)) {
                            map.get(key).add(value);
                        }
                    }
                    // 没有添加
                    else {
                        temp = new ArrayList<String>();
                        temp.add(value);
                        map.put(key, temp);
                    }
                }
            }
        }
        sortFirst = first.toArray(new String[first.size()]);
        Arrays.sort(sortFirst); // 排序

        charFirst = new char[first.size()];
        for (int i = 0; i < charFirst.length; i++) {
            charFirst[i] = first.get(i).charAt(0);
        }
        Arrays.sort(charFirst); // 排序

        String[] sortValue;
        ArrayList<String> v;
        Entry<String, ArrayList<String>> entry;
        Iterator<Entry<String, ArrayList<String>>> iter = map.entrySet()
                .iterator();
        while (iter.hasNext()) {
            entry = (Entry<String, ArrayList<String>>) iter.next();
            v = (ArrayList<String>) entry.getValue();
            sortValue = v.toArray(new String[v.size()]);
            Arrays.sort(sortValue); // 排序
            sortMap.put(entry.getKey(), sortValue);
        }

        char[] charValue;
        iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            entry = (Entry<String, ArrayList<String>>) iter.next();
            v = (ArrayList<String>) entry.getValue();
            charValue = new char[v.size()];
            for (int i = 0; i < charValue.length; i++) {
                charValue[i] = v.get(i).charAt(0);
            }
            Arrays.sort(charValue); // 排序
            charMap.put(entry.getKey(), charValue);
        }
    }

    public static String replace(String content, List<String> keys) {
        for (String k : keys) {
            if (StringUtils.isNotBlank(content) && content.indexOf(k) >= 0) {
                String str = "";
                for (int m = 1; m <= k.length(); m++) {
                    str = str + "*";
                }
                content = content.replace(k, str);
            }
        }
        return content;

    }

    public static void main(String[] args) {
        List<String> keys = new ArrayList<String>();
        keys.add("专业加的分");
        keys.add("专业助");
        keys.add("专业代写");
        keys.add("专业代");
        keys.add("专业办理");
        keys.add("专业办sdf");
        keys.add("手机");
        String tContent = "fuck";
        //SensitiveWordUtils a = new SensitiveWordUtils(keys, tContent);
        //String bString = new SensitiveWordUtils(keys, tContent).replace(tContent, tContent.length());
        String bString = SensitiveWordUtils.replace(tContent, keys);
        System.out.println(bString);
    }

    /**
     * 把敏感词替换成*
     *
     * @param content 需要过滤的内容
     * @return 过滤完后的符合要求的内容
     */
    public String replace(String content, int lengthContent) {
        String r = null, f, c = content;
        String replacedword = content;
        char g;
        char[] temps;
        int length = c.length();
        if (length == lengthContent) {
            for (int i = 0; i < length - 1; i++) {
                g = c.charAt(i);
                // 二分查找
                if (Arrays.binarySearch(charFirst, g) > -1) {
                    tag:
                    for (int j = i + 1; j < length; j++) {
                        f = c.substring(i, j);
                        g = c.charAt(j);
                        temps = charMap.get(f);
                        if (temps == null) { // 找到了
                            System.out.println("ok");
                            r = f;
                            String str = "";
                            for (int m = 1; m <= r.length(); m++) {
                                str = str + "*";
                            }
                            replacedword = c.replace(r, str);
                            c = replacedword;
                            break tag;
                        }
                        // 二分查找
                        if (Arrays.binarySearch(temps, g) > -1) {
                            if (j == length - 1) {
                                // print("find!");
                                //System.out.println("find!");
                                r = c.substring(i, j + 1);
                                String str = "";
                                for (int m = 1; m <= r.length(); m++) {
                                    str = str + "*";
                                }
                                replacedword = c.replace(r, str);
                                c = replacedword;
                                break tag;
                            }
                        } else { // 没有找到了
                            break;
                        }
                    }
                }
            }
        }

        return replacedword;
    }
}
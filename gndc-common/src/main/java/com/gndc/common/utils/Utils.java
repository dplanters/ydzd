package com.gndc.common.utils;

import java.util.*;
import java.util.regex.Pattern;

public class Utils {
    /**
     * 获取随机数
     *
     * @param min
     * @param max
     * @return
     */
    public static int getRandom(int min, int max) {
        // int a = (int) (Math.random() * (44) + 23); //产生的[23,67)的随机数
        return (int) (Math.random() * (max - min) + min);
    }

    /**
     * 获取随机数从1开始,格式10000000-99999999
     *
     * @param number
     * @return
     */
    public static int getRandom(int number) {
        int max = 9;
        int min = 1;
        for (int i = 1; i < number; i++) {
            min = min * 10;
            max = max * 10 + 9;
        }
        return getRandom(min, max);
    }

    public static String getRandomStr(int length) {
        String base = "abcdefghijklmnpqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 获取sessionid
     *
     * @return
     */
    public static String getSessionid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static boolean isNullOrEmpty(List<?> list) {
        if (list == null || list.size() == 0) {
            return true;
        }

        return false;
    }

    public static boolean isNullOrEmpty(Object[] array) {
        if (array == null || array.length == 0) {
            return true;
        }

        return false;
    }

    public static boolean isNullOrEmpty(String value) {
        if (value == null || value.isEmpty()) {
            return true;
        }

        return false;
    }

    public static String ListToString(List<?> list, String sep) {
        StringBuffer sb = new StringBuffer();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object obj = list.get(i);
                if (obj == null) {
                    continue;
                }
                if (obj instanceof String) {
                    if (obj.toString().trim().isEmpty()) {
                        continue;
                    }
                    sb.append(obj.toString());
                } else {
                    sb.append(obj);
                }
                sb.append(sep);
            }
        }
        return sb.toString();
    }

    /**
     * List转换SQL String
     *
     * @param list
     * @param sep
     * @return
     */
    public static String ListToSqlString(List<?> list, String sep) {
        StringBuffer sb = new StringBuffer();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object obj = list.get(i);
                if (obj == null) {
                    continue;
                }
                if (obj instanceof String) {
                    if (obj.toString().trim().isEmpty()) {
                        continue;
                    }
                    sb.append("'" + obj.toString() + "'");
                } else {
                    sb.append(obj);
                }
                sb.append(sep);
            }
        }
        if (sb.length() > 0) {
            sb.delete(sb.length() - 1, sb.length());
        }
        return sb.toString();
    }

    /**
     * 获取字符串中某段数据
     *
     * @param str
     * @param beginStr
     * @param endStr
     * @return
     */
    public static String getValue(String str, String beginStr, String endStr) {
        if (isNullOrEmpty(str) || isNullOrEmpty(beginStr) || isNullOrEmpty(endStr)) {
            return null;
        }
        int beginIndex = str.indexOf(beginStr);
        if (beginIndex <= 0) {
            return null;
        }
        beginIndex = beginIndex + beginStr.length();
        int endIndex = str.indexOf(endStr, beginIndex);
        if (endIndex <= 0) {
            return null;
        }
        return str.substring(beginIndex, endIndex);
    }

    /**
     * 去除内容里的标签
     *
     * @param content
     * @return
     */
    public static String removeTag(String content_html) {
        if (content_html == null)
            return null;
        String htmlStr = content_html; // 含html标签的字符串
        String textStr = "";
        Pattern p_script;
        java.util.regex.Matcher m_script;
        Pattern p_style;
        java.util.regex.Matcher m_style;
        Pattern p_html;
        java.util.regex.Matcher m_html;
        try {
            // 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
            String regEx_script = "<script[^>]*?>|</script[^>]*?>";
            // 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
            String regEx_style = "<style[^>]*?>|</style[^>]*?>";
            // 定义p标签的正则表达式{或<p[^>]*?>[\\s\\S]*?<\\/p>
            String regEx_p = "<p[^>]*?>|</p[^>]*?>";
            // 定义img标签的正则表达式{或<img[^>]*?>[\\s\\S]*?<\\/img>
            String regEx_img = "<img[^>]*?>|</img[^>]*?>";
            // 定义br标签的正则表达式{或<br[^>]*?>[\\s\\S]*?<\\/br>
            String regEx_br = "<br[^>]*?>|<br/[^>]*?>";
            // 定义h1标签的正则表达式{或<h1[^>]*?>[\\s\\S]*?<\\/h1>
            String regEx_h1 = "<h1[^>]*?>|</h1[^>]*?>";
            // 定义a标签的正则表达式{或<a[^>]*?>[\\s\\S]*?<\\/h1>
            String regEx_a = "<a[^>]*?>|</a[^>]*?>";
            // 定义div标签的正则表达式{或<div[^>]*?>[\\s\\S]*?<\\/h1>
            String regEx_div = "<div[^>]*?>|</div[^>]*?>";
            // 定义span标签的正则表达式{或<span[^>]*?>[\\s\\S]*?<\\/h1>
            String regEx_span = "<span[^>]*?>|</span[^>]*?>";
            // String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
            p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
            m_script = p_script.matcher(htmlStr);
            htmlStr = m_script.replaceAll(""); // 过滤script标签
            p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
            m_style = p_style.matcher(htmlStr);
            htmlStr = m_style.replaceAll(""); // 过滤style标签
            // p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
            // m_html = p_html.matcher(htmlStr);
            // htmlStr = m_html.replaceAll(""); // 过滤html标签
            p_html = Pattern.compile(regEx_p, Pattern.CASE_INSENSITIVE);
            m_html = p_html.matcher(htmlStr);
            htmlStr = m_html.replaceAll(""); // 过滤p标签
            p_html = Pattern.compile(regEx_img, Pattern.CASE_INSENSITIVE);
            m_html = p_html.matcher(htmlStr);
            htmlStr = m_html.replaceAll(""); // 过滤img标签
            p_html = Pattern.compile(regEx_br, Pattern.CASE_INSENSITIVE);
            m_html = p_html.matcher(htmlStr);
            htmlStr = m_html.replaceAll(""); // 过滤br标签
            p_html = Pattern.compile(regEx_h1, Pattern.CASE_INSENSITIVE);
            m_html = p_html.matcher(htmlStr);
            htmlStr = m_html.replaceAll(""); // 过滤h1标签
            p_html = Pattern.compile(regEx_a, Pattern.CASE_INSENSITIVE);
            m_html = p_html.matcher(htmlStr);
            htmlStr = m_html.replaceAll(""); // 过滤a标签
            p_html = Pattern.compile(regEx_div, Pattern.CASE_INSENSITIVE);
            m_html = p_html.matcher(htmlStr);
            htmlStr = m_html.replaceAll(""); // 过滤div标签
            p_html = Pattern.compile(regEx_span, Pattern.CASE_INSENSITIVE);
            m_html = p_html.matcher(htmlStr);
            htmlStr = m_html.replaceAll(""); // 过滤span标签

            textStr = htmlStr;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return textStr;// 返回文本字符串
    }

    // 将Action=del&id=123"，解析出Action:del,id:123存入map中
    public static Map<String, String> URLRequest(String strUrlParam) {
        Map<String, String> mapRequest = new HashMap<String, String>();
        if (strUrlParam == null) {
            return mapRequest;
        }
        // 每个键值为一组 www.2cto.com
        String[] arrSplit = strUrlParam.split("[&]");
        for (String strSplit : arrSplit) {
            String[] arrSplitEqual = null;
            arrSplitEqual = strSplit.split("[=]");
            // 解析出键值
            if (arrSplitEqual.length > 1) {
                // 正确解析
                mapRequest.put(arrSplitEqual[0], arrSplitEqual[1]);

            } else {
                if (arrSplitEqual[0] != "") {
                    // 只有参数没有值，不加入
                    mapRequest.put(arrSplitEqual[0], "");
                }
            }
        }
        return mapRequest;
    }

    /**
     * 生成用户名
     *
     * @return
     * @Description
     */
    public static String getUserName() {
        return "hj_" + Utils.getRandom(4) + "" + Utils.getRandom(6);
    }

    public static String hideMobile(String str) {
        str = str.replaceAll("(\\w{3})\\w{4}(\\w{4})", "$1****$2");
        return str;
    }

    public static String hideCardId(String str) {
        str = str.replaceAll("(\\d{4})\\d{10}(\\w{4})", "$1*****$2");
        return str;
    }

    public static void main(String[] args) {
        String aString = Utils.removeTag(
                "<span><p>该方法电饭锅和国际化和客</div>户来看过看过后过得好地方广东省高房价和科技科技税点好高好几节课是东莞市高各环节大杀四方尴尬花滑及交互是收购价和</p><p></p><p><a id='simg' href='http://'><img src='http://172.23.30.8:6066/static/umeditor/jsp/upload/20160721/6381469095252118.jpg'  height='277' width='500'/></a></p><p>体育局就看看两件套图框要尽快尽快了基里连科hi可立克发一份图理解和鹤发童颜电影天堂很快就可来看看的同仁堂的公交卡利是人人都他很惊讶</p><p></p>");
        System.out.println(aString);
    }

}

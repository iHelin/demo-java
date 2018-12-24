package me.ianhe.ocr;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 有道ocr
 *
 * @author iHelin
 * @date 2018-12-04 15:33
 */
public class OCRDemoForHttp {

    static Logger logger = LoggerFactory.getLogger(OCRDemoForHttp.class);

    public static void main(String[] args) throws Exception {
        Map<String, String> map = new HashMap<>();
        String url = "http://openapi.youdao.com/ocrapi";
        String appKey = "5d438e597821458d";
        String appSecret = "TBnJUcTXeZSlHAmrNaHhlts5HcvE4Kz5";
        String detectType = "10012";
        String imageType = "1";
        String langType = "en";
        String docType = "json";
        String salt = String.valueOf(System.currentTimeMillis());
        String img = getImageStr("/Users/iHelin/Downloads/1.png");

        map.put("appKey", appKey);
        map.put("img", img);
        map.put("detectType", detectType);
        map.put("imageType", imageType);
        map.put("langType", langType);
        map.put("salt", salt);
        map.put("docType", docType);
        String sign = md5(appKey + img + salt + appSecret);
        map.put("sign", sign);
        String result = requestOCRForHttp(url, map);
        System.out.println(result);
    }

    public static String requestOCRForHttp(String url, Map<String, String> requestParams) throws Exception {
        String result;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        /*HttpPost*/
        HttpPost httpPost = new HttpPost(url);
        List<BasicNameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("appKey", requestParams.get("appKey")));
        params.add(new BasicNameValuePair("img", requestParams.get("img")));
        params.add(new BasicNameValuePair("detectType", requestParams.get("detectType")));
        params.add(new BasicNameValuePair("imageType", requestParams.get("imageType")));
        params.add(new BasicNameValuePair("langType", requestParams.get("langType")));
        params.add(new BasicNameValuePair("salt", requestParams.get("salt")));
        params.add(new BasicNameValuePair("sign", requestParams.get("sign")));
        params.add(new BasicNameValuePair("docType", requestParams.get("docType")));
        httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
        /*HttpResponse*/
        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
        try {
            HttpEntity httpEntity = httpResponse.getEntity();
            result = EntityUtils.toString(httpEntity, "utf-8");
            EntityUtils.consume(httpEntity);
        } finally {
            try {
                if (httpResponse != null) {
                    httpResponse.close();
                }
            } catch (IOException e) {
                logger.info("## release resouce error ##" + e);
            }
        }
        return result;
    }

    /**
     * 获得图片的Base64编码
     *
     * @param imgFile
     * @return
     */
    public static String getImageStr(String imgFile) {//将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        InputStream in;
        byte[] data = null;
        //读取图片字节数组
        try {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //对字节数组Base64编码
        return Base64.encode(data);//返回Base64编码过的字节数组字符串
    }

    /**
     * 生成32位MD5摘要
     *
     * @param string
     * @return
     */
    public static String md5(String string) {
        if (string == null) {
            return null;
        }
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};
        byte[] btInput = string.getBytes();
        try {
            /* 获得MD5摘要算法的 MessageDigest 对象 */
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            /* 使用指定的字节更新摘要 */
            mdInst.update(btInput);
            /* 获得密文 */
            byte[] md = mdInst.digest();
            /* 把密文转换成十六进制的字符串形式 */
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;
            for (byte byte0 : md) {
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}

package com.java.internet;

import sun.net.www.http.HttpClient;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author weilc
 * @description
 * @className HttpTest
 * @date 2020-07-03
 */
public class HttpTest {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://www.liaoxuefeng.com/wiki/1252599548343744/1319099982413858");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setUseCaches(false);
        conn.setConnectTimeout(5000);
        conn.setRequestProperty("Accept","*/*");
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; MSIE 11; Windows NT 5.1)");
        conn.connect();
        if (conn.getResponseCode() != 200) {
            System.out.println("bad requese");
        }
    }
}

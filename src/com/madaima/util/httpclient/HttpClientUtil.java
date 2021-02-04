package com.madaima.util.httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;
import java.time.Duration;

/**
 * @author JiaBin.Wang
 * @className HttpClintUtil
 * @date 2020/9/16 5:06 下午
 * @deacription httpclient二次封装
 * 代码参考的：https://blog.csdn.net/weixin_34082695/article/details/88755312
 **/
public class HttpClientUtil {

    /**
     * 连接超时
     */
    private static final Integer CONNECT_TIME_OUT = 5000;
    /**
     * 读取超时时间
     */
    private static final Integer READ_TIME_OUT = 5000;
    /**
     * 设置连接超时时间
     */
    static HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofMillis(CONNECT_TIME_OUT)).build();

    /**
     * 普通的Get请求
     * @param url url地址
     * @return 结果
     * @throws InterruptedException 异常
     * @throws IOException 异常
     */
    public static String doGet(String url) throws InterruptedException, IOException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .timeout(Duration.ofMillis(READ_TIME_OUT))
                .build();
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    /**
     * Get请求
     * @param url 地址
     * @param headers header
     * @return 结果
     * @throws InterruptedException 异常
     * @throws IOException 异常
     */
    public static String doGet(String url, String... headers) throws InterruptedException, IOException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .headers(headers)
                .timeout(Duration.ofMillis(READ_TIME_OUT))
                .build();
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    /**
     * 同步下载文件
     * @param url 地址
     * @throws InterruptedException 异常
     * @throws IOException 异常
     */
    public static void downloadFile(String url, String downloadPath) throws InterruptedException, IOException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        client.send(request, HttpResponse.BodyHandlers.ofFile(Paths.get(System.getenv().get("HOME") + "/" + downloadPath)));
    }

    /**
     * 异步下载文件
     * @param url URL地址
     * @param downloadPath 文件保存地址
     */
    public static void downloadFileAsync(String url, String downloadPath) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofFile(Paths.get(System.getenv().get("HOME") + "/" + downloadPath)))
                .thenApply(HttpResponse::body);
    }
}

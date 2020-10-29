package io.github.kimmking.netty.server;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class Client {

    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
//        HttpGet httpGet = new HttpGet("http://www.baidu.com");
        HttpGet httpGet = new HttpGet("http://localhost:8801");
        CloseableHttpResponse response = httpclient.execute(httpGet);
        try {
            response = httpclient.execute(httpGet);
            System.out.println(response);
        } finally {
            response.close();
        }
    }
}

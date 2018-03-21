package com.chenkx.universal.modular.job.Util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpClientFactory {
    protected final static Logger logger = LoggerFactory.getLogger(HttpClientFactory.class);

    public static String callByJsonHttpPost(String url, String reqJson) {
        String body = null;
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-type", "text/json;charset=UTF-8");
        httpPost.setHeader("Connection", "close");
        try {
            // StringEntity
            httpPost.setEntity(new StringEntity(reqJson));
            // 发送请求
            HttpResponse httpresponse = httpClient.execute(httpPost);
            // 获取返回数据
            HttpEntity entity = httpresponse.getEntity();
            body = EntityUtils.toString(entity, "UTF-8");
            logger.info("向" + url + "发起HTTP,JSON请求,返回值为:" + body);
            // 释放返回数据
            if (entity != null) {
                EntityUtils.consume(entity);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (httpPost != null && httpClient != null
                        && httpClient.getConnectionManager() != null) {
                    httpPost.releaseConnection();
                    httpClient.getConnectionManager().shutdown();
                    httpClient = null;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return body;
    }
}

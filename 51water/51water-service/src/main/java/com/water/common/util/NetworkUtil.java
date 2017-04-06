package com.water.common.util;

import com.alibaba.druid.util.StringUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

/**
 * @Package: com.water.common.util
 * @Description: TODO
 * @date:2016年01月11日
 * @author: Homvee.Tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2016, DMall All Rights Reserved.
 */
public class NetworkUtil {

    private static final Logger  LOGGER = LoggerFactory.getLogger(NetworkUtil.class);

    public static String sendData(String url){
        Map<String,String> params = null;
        return sendData(url,params);
    }
    public static String sendData(String url,Map<String,String> params){
        return sendData(url,params,Consts.UTF_8);
    }
    public static String sendData(String url,Map<String,String> params,Charset charset){
        return sendData(url,params,charset,1000*120);
    }
    public static String sendData(String url,Map<String,String> params,Integer timeout){
        return sendData(url,params,Consts.UTF_8,timeout);
    }

    public static String sendData(String url,Map<String,String> params,Charset charset,Integer timeout){
        if(StringUtils.isEmpty(url) ||  charset == null || timeout == null){
            LOGGER.info("发送数据参数错误URL[{}],charset[{}],timeout[{}]",url,charset,timeout);
            return null;
        }
        Response response = null;
        if(params == null || params.size() == 0){
            try {
                response = Request.Post(url).execute();
                if(response.returnResponse().getStatusLine().getStatusCode() == 200 ){
                    return response.returnContent().asString(charset);
                }else{
                    throw new HttpResponseException(
                            response.returnResponse().getStatusLine().getStatusCode(),
                            response.returnResponse().getStatusLine().getReasonPhrase());
                }
            } catch (IOException e) {
                LOGGER.error("发送数据URL[{}],charset[{}],timeout[{}]异常", url, charset, timeout, e);
            }
            return null;
        }

        Map<String,NameValuePair> formMap = Maps.transformEntries(params, new Maps.EntryTransformer<String, String, NameValuePair>() {
            @Override
            public NameValuePair transformEntry(String key, String val) {
                return new BasicNameValuePair(key,val);
            }
        });

        List<NameValuePair> formParams = Lists.newArrayList(formMap.values());
        try {
            response = Request.Post(url).bodyForm(formParams,charset).execute();
            if(response.returnResponse().getStatusLine().getStatusCode() == 200 ){
                return response.returnContent().asString(charset);
            }else{
                throw new HttpResponseException(
                        response.returnResponse().getStatusLine().getStatusCode(),
                        response.returnResponse().getStatusLine().getReasonPhrase());
            }
        } catch (IOException e) {
            LOGGER.error("发送数据data[{}],URL[{}],charset[{}],timeout[{}]异常", params, url, charset, timeout, e);
        }
        return null;

    }
    public static String sendData(String data,String url){
        return  sendData(data,url,ContentType.TEXT_PLAIN);
    }
    public static String sendData(String data,String url,ContentType conentType){
        return  sendData(data,url,conentType,Consts.UTF_8);
    }
    public static String sendData(String data,String url,ContentType conentType,Charset charset){
        return  sendData(data,url,conentType,charset,1000*120);
    }
    public static String sendData(String data,String url,ContentType conentType,Integer timeout){
        return  sendData(data,url,conentType,Consts.UTF_8,timeout);
    }
    public static String sendData(String data,String url,ContentType conentType,Charset charset,Integer timeout){
        if(conentType == null || StringUtils.isEmpty(url) || StringUtils.isEmpty(data) || charset == null || timeout == null){
            LOGGER.info("发送数据参数错误data[{}],URL[{}],conentType[{}],charset[{}],timeout[{}]",data,url,conentType,charset,timeout);
            return null;
        }
        Response response = null;
        try {
            response = Request.Get(url).body(new StringEntity(data,  conentType.withCharset(charset))).connectTimeout(timeout).execute();
            if(response.returnResponse().getStatusLine().getStatusCode() == 200 ){
                return response.returnContent().asString(charset);
            }else{
                throw new HttpResponseException(
                        response.returnResponse().getStatusLine().getStatusCode(),
                        response.returnResponse().getStatusLine().getReasonPhrase());
            }
        } catch (IOException e) {
            LOGGER.error("发送数据data[{}],URL[{}],conentType[{}],charset[{}],timeout[{}]异常", data, url, conentType, charset,timeout, e);
        }
        return null;
    }

}

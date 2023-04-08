package com.sustech.cloud_storage.util;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class OSSConfig implements InitializingBean {

    @Value("${aliyun.keyid}")
    private String keyId;
    @Value("${aliyun.keysecret}")
    private String keySecret;

    @Value("${aliyun.endpoint}")
    private String endPoint;

    @Value("${aliyun.bucketname}")
    private String bucketName;

    public static String KEY_ID;
    public static String KEY_SECRET;
    public static String END_POINT;
    public static String BUCKET_NAME;


    @Override
    public void afterPropertiesSet() throws Exception {
        KEY_ID=keyId;
        KEY_SECRET=keySecret;
        BUCKET_NAME=bucketName;
        END_POINT=endPoint;
    }
}

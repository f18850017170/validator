package com.hqsf;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hqsf.dto.invoke.request.AbsRequest;
import com.hqsf.dto.invoke.request.PreCreateRequest;
import com.hqsf.enumcode.XmdzfTradeType;
import com.hqsf.utils.CustomExclusionStrategy;
import com.hqsf.utils.sign.SignContextFactory;
import com.hqsf.utils.validation.ValidatorContextFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.List;

public class SimpleTest {
    @Test
    public void demo() throws IOException {
        System.out.println("this is a demo");
        PreCreateRequest request = new PreCreateRequest();
        request.setOutTradeNo("123456789");
        request.setTradeType(XmdzfTradeType.NATIVE);
        List<String> validate = ValidatorContextFactory.buildRequiredValidatorContext().validate(request, AbsRequest.class);
        System.out.println(validate);
        String sign = SignContextFactory.buildSimpleSignContext().sign(request, AbsRequest.class);
        System.out.println(sign);
        System.out.println(request);
        HttpClient http = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("http://payfront.zc.st.meituan.com/api/common/location");
        Gson gson = new GsonBuilder().setExclusionStrategies(new CustomExclusionStrategy()).create();
        String json = gson.toJson(request);
        post.setEntity(new StringEntity(json, Charset.forName("UTF-8")));
        HttpResponse httpResponse = http.execute(post);
        HttpEntity entity = httpResponse.getEntity();
        String string = EntityUtils.toString(entity, "UTF-8");
        System.out.println(string);
    }
}

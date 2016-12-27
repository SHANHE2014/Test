package com.zhangq.android.mylibrary.httpBiz;


import com.zhangq.android.mylibrary.TestBean;

import java.util.List;
import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by zhangqiang on 16/6/14.
 * Description:
 */
public interface IUserAddressRequest {
    @GET(RequestDefaultConfig.method_DeliveryTemplate)
    List<TestBean> getUserAddressList(@QueryMap Map<String, String> params);
}

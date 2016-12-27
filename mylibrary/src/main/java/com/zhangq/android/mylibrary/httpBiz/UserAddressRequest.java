package com.zhangq.android.mylibrary.httpBiz;

import android.util.Log;

import com.zhangq.android.mylibrary.TestBean;

import java.util.List;
import java.util.Map;

import retrofit2.Retrofit;

/**
 * Created by zhangqiang on 16/6/14.
 */
public class UserAddressRequest {


    public void test(Map<String, String> params) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(RequestDefaultConfig.SERVER_ADDRESS)
                .build();
        IUserAddressRequest req = retrofit.create(IUserAddressRequest.class);
        List<TestBean> list = req.getUserAddressList(params);

        if (list == null) {
            Log.i("-----", "test: null");
        } else {
            Log.i("-----", "test: " + list.size());
        }
    }

}

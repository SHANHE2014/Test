package com.zhangq.android.mylibrary.httpBiz;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback.CommonCallback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


/**
 * @author zhangQ
 * @date 2015-12-18
 * @description 网络请求
 */
@SuppressWarnings("unused")
public class MyXRequest {
    private final static String TAG = MyXRequest.class.getSimpleName();
    private boolean debug = false;

    public void postRequest(Map<String, String> valuepairs,
                            final OnHttpListener httpListener) {

        RequestParams params = getHttpParams(valuepairs);


        x.http().post(params, new CommonCallback<String>() {

            @Override
            public void onCancelled(CancelledException e) {
                if (debug) {
                    Log.i(TAG, "post onCancelled");
                }
            }

            @Override
            public void onError(Throwable arg0, boolean resultCode) {
                if (debug) {
                    Log.i(TAG, "post onError");
                }
                httpListener.onFailed(null, -1);
            }

            @Override
            public void onFinished() {
            }

            @Override
            public void onSuccess(String result) {
                if (debug) {
                    Log.i(TAG, result);
                }
                try {
                    httpListener.onSuccess(new JSONObject(result), 0);
                } catch (JSONException e) {
                    e.printStackTrace();
                    httpListener.onFailed(null, -1);
                } catch (Exception e) {
                    e.printStackTrace();
                    httpListener.onFailed(null, -1);
                }
            }
        });

    }

    /**
     */
    private void postRequest(HashMap<String, String> valuepairs,
                             final OnHttpListener httpListener, final int tag) {
        RequestParams params = getHttpParams(valuepairs);

        x.http().post(params, new CommonCallback<String>() {

            @Override
            public void onCancelled(CancelledException e) {
                if (debug) {
                    Log.i(TAG, "post onCancelled");
                }
            }

            @Override
            public void onError(Throwable arg0, boolean resultCode) {
                if (debug) {
                    Log.i(TAG, "post onError");
                }
                httpListener.onFailed(null, -1);
            }

            @Override
            public void onFinished() {
            }

            @Override
            public void onSuccess(String result) {
                if (debug) {
                    Log.i(TAG, result);
                }
                try {
                    httpListener.onSuccess(new JSONObject(result), tag);
                } catch (JSONException e) {
                    e.printStackTrace();
                    httpListener.onFailed(null, -1);
                } catch (Exception e) {
                    e.printStackTrace();
                    httpListener.onFailed(null, -1);
                }
            }
        });

    }

    private RequestParams getHttpParams(
            Map<String, String> valuepairs) {
        valuepairs = addSign(valuepairs);

        RequestParams params = new RequestParams(RequestDefaultConfig.SERVER_ADDRESS);
        StringBuilder sb = new StringBuilder();
        sb.append(RequestDefaultConfig.SERVER_ADDRESS);
        for (Entry<String, String> entry : valuepairs.entrySet()) {
            params.addBodyParameter(entry.getKey(), entry.getValue());
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
            sb.append("&");
        }
        if (debug) {
            Log.i(TAG, sb.toString());
        }
        // params.setSslSocketFactory(sslSocketFactory);
        return params;
    }

    /**
     * 添加签名
     */
    private Map<String, String> addSign(
            Map<String, String> valuepairs) {
        String sign = null;
        try {
            sign = RequestUtils.getSignature(valuepairs, RequestDefaultConfig.SIGNKEY);
        } catch (IOException e) {
            e.printStackTrace();
        }
        valuepairs.put("sign", sign);
        return valuepairs;
    }

    public void register(OnHttpListener httpListener, String phone,
                         String password, String yanzheng, String udid) {
        HashMap<String, String> map = new HashMap<>();
        map.put("method", RequestDefaultConfig.method_Register);
        map.put("pid", RequestDefaultConfig.PID);
        map.put("phone", phone);
        map.put("password", password);
        map.put("udid", udid);
        map.put("vcode", yanzheng);

        postRequest(map, httpListener);
    }


    public void setDebug(boolean debug) {
        this.debug = debug;
    }
}

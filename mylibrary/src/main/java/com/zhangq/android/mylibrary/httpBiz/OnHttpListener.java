package com.zhangq.android.mylibrary.httpBiz;

import org.json.JSONObject;

/**
 *
 */
public interface OnHttpListener {
    int REQUEST_SUCCESS = 0;
    int REQUEST_FAIL = -1;

    void onSuccess(JSONObject json, int resultCode);

    void onFailed(JSONObject json, int resultCode);
}

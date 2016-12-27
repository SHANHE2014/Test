package com.zhangq.android.mylibrary.utils;

import android.content.Context;
import android.os.Environment;
import android.util.Base64;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * 文件存写工具beta版
 *
 * @author zhangQ
 * @date 2015-12-30
 * @description 文件存写工具(简易版)
 */
@SuppressWarnings("unused")
public class FileUtil {
    private final static String TAG = FileUtil.class.getSimpleName();

    private FileUtil() {
    }

    public static boolean existsSdcard() {
        return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
    }

    public static void saveFile(String dataPath, String fileName, String data) {
        if (!existsSdcard()) {
            Log.i(TAG, "没有SD卡！");
            return;
        }
        if (data == null) {
            Log.i(TAG, "data==null");
            return;
        }
        File file = new File(dataPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(file, fileName);
        FileOutputStream outputStream = null;
        PrintStream ps = null;
        try {
            outputStream = new FileOutputStream(file);
            ps = new PrintStream(outputStream);
            ps.println(data);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static String readFile(String dataPath, String fileName) {
        String result = null;
        File file = new File(dataPath + fileName);
        FileInputStream fis = null;
        InputStreamReader reader = null;
        try {
            fis = new FileInputStream(file);
            reader = new InputStreamReader(fis);
            StringBuffer sb = new StringBuffer();
            char[] buffer = new char[1024];
            int len;
            while ((len = reader.read(buffer)) >= 0) {
                sb.append(buffer, 0, len);
            }
            result = sb.toString().trim();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return result;
    }

    public static String readFileWithBase64(String dataPath, String fileName) {
        String result = null;
        File file = new File(dataPath + fileName);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) >= 0) {
                outStream.write(buffer, 0, len);
            }
            byte[] outData = outStream.toByteArray();
            result = new String(Base64.encode(outData, Base64.DEFAULT));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return result;
    }

    public String getFromAssets(Context context, String fileName) {
        String result = null;
        try {
            InputStreamReader inputReader = new InputStreamReader(context
                    .getResources().getAssets().open(fileName));
            StringBuffer sb = new StringBuffer();
            char[] buffer = new char[1024];
            int len;
            while ((len = inputReader.read(buffer)) >= 0) {
                sb.append(buffer, 0, len);
            }
            result = sb.toString().trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}

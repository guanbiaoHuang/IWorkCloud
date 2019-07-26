package com.iworkcloud.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

public class UploadUtils {

    public static void uploadIcon(String path, HttpServletRequest request, InputStream is) {
        OutputStream os = null;
        try {
            byte[] flush = new byte[1024];
            int len = -1;
            os = new FileOutputStream(new File(path));
            while ((len = is.read(flush)) != -1) {
                os.write(flush, 0, len);
                os.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != os)
                    os.close();
                if (null != is)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

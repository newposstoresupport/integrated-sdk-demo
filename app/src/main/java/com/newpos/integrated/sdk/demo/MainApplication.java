package com.newpos.integrated.sdk.demo;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import com.pos.device.SDKManager;
import com.pos.device.SDKManagerCallback;

/**
 * @ClassName : MainApplication
 * @Author : zhouqiang(1376359644@qq.com)
 * @Email : newpos@newpostech.com
 * @Date : 2025/5/17-12:21
 * @Version : 1.0
 * @Description :
 * @website : <a href="https://www.newpostech.com/">...</a>
 */
public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //TODO step3
        // Call our SDKManager to initialize, and then you can develop related business
        // 1.If you initialize in your application, be sure to apply the application
        // to the manifest.
        // 2.Or you can initialize it before calling any interface. We recommend initializing
        // it in the application to facilitate building an integrated project.
        SDKManager.init(this, new SDKManagerCallback() {
            @Override
            public void onFinish() {
                Log.w("SDK", "init sdk success");
            }
        });
    }
}

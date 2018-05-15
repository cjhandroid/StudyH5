package study.com.studyh5.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.JavascriptInterface;

import com.tbruyelle.rxpermissions2.RxPermissions;

import study.com.studyh5.base.BaseActivity;

/**
 * Created by cjh_it on 18-5-15
 */
public class WelcomeActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        webView.addJavascriptInterface(new JumpJs(), "jumpJs");
        webView.loadUrl("file:///android_asset/html/welcome_launch.html");
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions
                .request(Manifest.permission.READ_PHONE_STATE)
                .subscribe(granted -> {
                    if (granted) { // Always true pre-M
                        // I can control the camera now
                    } else {
                        // Oups permission denied
                    }
                });
    }

    public class JumpJs extends Object {

        @JavascriptInterface
        public void jump2MainAct() {
            startActivity(new Intent(mAct, MainActivity.class));
            finish();
        }
    }

}

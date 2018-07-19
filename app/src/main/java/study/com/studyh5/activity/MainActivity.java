package study.com.studyh5.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.jaeger.library.StatusBarUtil;

import study.com.studyh5.base.BaseActivity;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        webView.loadUrl("file:///android_asset/html/main/main_frame.html");
    }

    @Override
    protected void initStatusBar() {
        super.initStatusBar();
        StatusBarUtil.setTransparent(this);
    }
}

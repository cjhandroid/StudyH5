package study.com.studyh5.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import study.com.studyh5.base.BaseActivity;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        webView.loadUrl("file:///android_asset/html/main/main_frame.html");
    }
}

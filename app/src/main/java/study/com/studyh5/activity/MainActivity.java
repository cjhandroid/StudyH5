package study.com.studyh5.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.JavascriptInterface;

import com.blankj.utilcode.utils.FileUtils;
import com.blankj.utilcode.utils.LogUtils;

import org.reactivestreams.Subscription;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import study.com.studyh5.base.BaseActivity;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        webView.addJavascriptInterface(new FetchData(), "fetchData");
        webView.loadUrl("file:///android_asset/html/main/main_frame.html");
    }


    public class FetchData extends Object {
        @JavascriptInterface
        public void fetchRecommendToday() {
            Observable.just("data/main_ktrecommend/ktrecommend_today.json")
                    .map(MainActivity.this::jsonStr)
                    .compose(rxSchedulerHelper2())
                    .subscribe(new Observer<String>() {

                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(String s) {
                            LogUtils.e(s);
                            webView.loadUrl("javascript:parseRecommendTodayData("+ s +")");
                        }

                        @Override
                        public void onError(Throwable t) {
                            t.printStackTrace();
                        }

                        @Override
                        public void onComplete() {
                        }
                    });
        }
    }

    private String jsonStr(String filePath) {
        try {
            InputStreamReader reader = new InputStreamReader(getAssets().open(filePath));
            BufferedReader bufferedReader = new BufferedReader(reader);
            StringBuilder buffer = new StringBuilder("");
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
                buffer.append("\n");
            }
            return buffer.toString();

        }catch (Exception e){
            return filePath;
        }
    }

}

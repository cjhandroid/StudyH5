package study.com.studyh5;

import android.app.Application;

import com.blankj.utilcode.utils.Utils;
import com.tencent.smtt.sdk.QbSdk;

public class H5Application extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        QbSdk.initX5Environment(getApplicationContext(),  null);
        Utils.init(this);

    }
}

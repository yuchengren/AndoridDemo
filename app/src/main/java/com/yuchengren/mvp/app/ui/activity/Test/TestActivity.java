package com.yuchengren.mvp.app.ui.activity.Test;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.yuchengren.mvp.R;
import com.yuchengren.mvp.util.CompressUtils;

/**
 * Created by yuchengren on 2017/12/28.
 */

public class TestActivity extends AppCompatActivity implements View.OnClickListener {

	private Button btn_test;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);

		btn_test = findViewById(R.id.btn_test);
		btn_test.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.btn_test:
				Log.e("btn_test", CompressUtils.INSTANCE.uncompressString("H4sIAAAAAAAAAD2Myw3AMAhDF6JSaCCQnej+1xryOTyMBfbHTck4HqYWC46XemihYWCSBTNGLY08\n" +
						"    RzpfzosJ7OoAmRVwupRkM3DvIPul/gb0eL+7lsrOrS6WH2wqmLS1AAAA"));
//				testDeadLock();
//				testWaitNotify();
//				toSelfSetting(this);
				break;
			default:
				break;
		}

	}

	public static void toSelfSetting(Context context) {
		Intent mIntent = new Intent();
		mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		if (Build.VERSION.SDK_INT >= 9) {
			mIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
			mIntent.setData(Uri.fromParts("package", context.getPackageName(), null));
		} else if (Build.VERSION.SDK_INT <= 8) {
			mIntent.setAction(Intent.ACTION_VIEW);
			mIntent.setClassName("com.android.settings", "com.android.setting.InstalledAppDetails");
			mIntent.putExtra("com.android.settings.ApplicationPkgName", context.getPackageName());
		}
		context.startActivity(mIntent);
	}

	/**
	 * 死锁范例
	 */
	private void testDeadLock() {
		DeadRunnable deadRunnable1 = new DeadRunnable();
		deadRunnable1.flag = 1;
		DeadRunnable deadRunnable2 = new DeadRunnable();
		deadRunnable2.flag = 2;
		new Thread(deadRunnable1).start();
		new Thread(deadRunnable2).start();
	}

	/**
	 * 生产者消费者模式 wait notify
	 */
	private void testWaitNotify(){
		Source source = new Source();
		new Thread(new Producer(source)).start();
		new Thread(new Consumer(source)).start();
	}

}

package com.leavesc.databinding_demo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;

import com.leavesc.databinding_demo.databinding.ActivityMain6Binding;
import com.leavesc.databinding_demo.databinding.ViewStubBinding;
import com.leavesc.databinding_demo.model.User;

/**
 * 作者：叶应是叶
 * 时间：2018/5/19 10:51
 * 描述：include 和 viewStub
 * <p>
 * 对于 include 的布局文件，一样是支持通过 dataBinding 来进行数据绑定，此时一样需要在待 include 的布局中依然使用 layout 标签，声明需要使用到的变量
 * 如果需要为 ViewStub 绑定变量值，则 ViewStub 文件一样要使用 layout 标签进行布局，主布局文件使用自定义的 bind 命名空间将变量传递给 ViewStub
 * 如果在 xml 中没有使用 bind:userInfo="@{userInf}"对 ViewStub 进行数据绑定，则可以等到当 ViewStub Inflate 时再绑定变量，此时需要为 ViewStub 设置 setOnInflateListener回调函数，在回调函数中进行数据绑定
 */
public class Main6Activity extends AppCompatActivity {

	private ActivityMain6Binding activityMain6Binding;

	private User user;

	private static final String TAG = "Main6Activity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		activityMain6Binding = DataBindingUtil.setContentView(this, R.layout.activity_main6);
		activityMain6Binding.setHandler(new Handler());
		user = new User("leavesC", "123456");
		activityMain6Binding.setUserInfo(user);
		activityMain6Binding.viewStub.setOnInflateListener(new ViewStub.OnInflateListener() {
			@Override
			public void onInflate(ViewStub stub, View inflated) {
				//如果在 xml 中没有使用 bind:userInfo="@{userInf}" 对 viewStub 进行数据绑定
				//那么可以在此处进行手动绑定
				ViewStubBinding viewStubBinding = DataBindingUtil.bind(inflated);
				viewStubBinding.setUserInfo(user);
				Log.e(TAG, "onInflate");
			}
		});
	}

	public class Handler {

		public void onClick(View v) {
			if (!activityMain6Binding.viewStub.isInflated()) {
				activityMain6Binding.viewStub.getViewStub().inflate();
			}
		}

	}

}

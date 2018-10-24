package com.leavesc.databinding_demo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.leavesc.databinding_demo.databinding.ActivityMain9Binding;

/**
 * 作者：叶应是叶
 * 时间：2018/5/20 18:00
 * 描述：资源引用
 * <p>
 * dataBinding 支持对尺寸和字符串等资源的访问,详情看该类的xml
 */
public class Main9Activity extends AppCompatActivity {

	private ActivityMain9Binding activityMain9Binding;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		activityMain9Binding = DataBindingUtil.setContentView(this, R.layout.activity_main9);
	}

	public void changeFlag(View view) {
		activityMain9Binding.setFlag(!activityMain9Binding.getFlag());
	}

}

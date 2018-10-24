package com.leavesc.databinding_demo;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableArrayMap;
import android.databinding.ObservableList;
import android.databinding.ObservableMap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.leavesc.databinding_demo.databinding.ActivityMain12Binding;

import java.util.Random;

/**
 * 作者：叶应是叶
 * 时间：2018/5/21 21:32
 * 描述：dataBinding 也支持在布局文件中使用 数组、Lsit、Set 和 Map，且在布局文件中都可以通过 list[index] 的形式来获取元素
 * 而为了和 variable 标签的尖括号区分开，在声明 Lsit< String > 之类的数据类型时，需要使用尖括号的转义字符
 */
public class Main12Activity extends AppCompatActivity {

	private ObservableMap<String, String> map;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActivityMain12Binding activityMain12Binding = DataBindingUtil.setContentView(this, R.layout.activity_main12);
		map = new ObservableArrayMap<>();
		map.put("name", "leavesC");
		map.put("age", "24");
		activityMain12Binding.setMap(map);
		ObservableList<String> list = new ObservableArrayList<>();
		list.add("Ye");
		list.add("leavesC");
		activityMain12Binding.setList(list);
		activityMain12Binding.setIndex(0);
		activityMain12Binding.setKey("name");
	}

	public void onClick(View view) {
		map.put("name", "leavesC,hi" + new Random().nextInt(100));
	}

}

package com.leavesc.databinding_demo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.leavesc.databinding_demo.databinding.ActivityMain7Binding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 作者：叶应是叶
 * 时间：2018/5/20 17:05
 * 描述：Array、List、Set、Map ...的使用
 * <p>
 * dataBinding 也支持在布局文件中使用 数组、List、Set 和 Map，且在布局文件中都可以通过 list[index] 的形式来获取元素
 * 而为了和 variable 标签的尖括号区分开，在声明 List< String > 之类的数据类型时，需要使用尖括号的转义字符
 */
public class Main7Activity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActivityMain7Binding activityMain7Binding = DataBindingUtil.setContentView(this, R.layout.activity_main7);
		activityMain7Binding.setList(new ArrayList<String>());
		Map<String, String> map = new HashMap<>();
		map.put("leavesC", "Hi");
		activityMain7Binding.setMap(map);
		activityMain7Binding.setKey("leavesC");
		Set<String> set = new HashSet<>();
		set.add("xxx");
		activityMain7Binding.setSet(set);
		activityMain7Binding.setArray(new String[]{"Hi", "hello"});
	}

}

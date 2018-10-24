package com.leavesc.databinding_demo;

import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import com.leavesc.databinding_demo.databinding.ActivityMain8Binding;
import com.leavesc.databinding_demo.model.Image;

import java.util.Random;

/**
 * 作者：叶应是叶
 * 时间：2018/5/20 14:10
 * 描述：BindingAdapter与BindingConversion的使用
 * <p>
 * dataBinding 提供了 BindingAdapter 这个注解用于支持自定义属性，或者是修改原有属性。注解值可以是已有的 xml 属性，例如 android:src、android:text等，也可以自定义属性然后在 xml 中使用
 * 注意:xml里对应的view的value必须是@{}的形式,否则无法改变对应view的值
 * 例如xml中的Button的android:text='@{"改变图片Url"}'如果改为android:text="改变图片Url"那么该类51行的@BindingAdapter("android:text")就会无效
 * 如果项目中定义了BindingAdapter那么会对整个项目生效
 * <p>
 * dataBinding 还支持对数据进行转换,或者进行类型转换,用BindingConversion实现
 */
public class Main8Activity extends AppCompatActivity {

	private static final String TAG = "Main8Activity";

	private ActivityMain8Binding activityMain8Binding;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		activityMain8Binding = DataBindingUtil.setContentView(this, R.layout.activity_main8);
		activityMain8Binding.setImage(new Image("onCreate"));
		activityMain8Binding.setHandler(new Handler());
	}

	public class Handler {

		public void onClick(Image image) {
			image.getUrl().set("onClick" + new Random().nextInt(1000));
		}

	}

	@BindingAdapter({"url"})
	public static void loadImage(ImageView view, String url) {
		Log.e(TAG, "loadImage url : " + url);
	}

	@BindingAdapter("android:text")
	public static void setText(Button view, String text) {
		view.setText(text + "-Button");
	}

	//与 BindingAdapter 类似，以下方法会将布局文件中所有以@{String}方式引用到的String类型变量加上后缀-conversionString
//    @BindingConversion
//    public static String conversionString(String text) {
//        return text + "-conversionString";
//    }

	//此外，BindingConversion 也可以用于转换属性值的类型
	@BindingConversion
	public static Drawable convertStringToDrawable(String str) {
		if (str.equals("红色")) {
			return new ColorDrawable(Color.parseColor("#FF4081"));
		}
		if (str.equals("蓝色")) {
			return new ColorDrawable(Color.parseColor("#3F51B5"));
		}
		return new ColorDrawable(Color.parseColor("#344567"));
	}

	@BindingConversion
	public static int convertStringToColor(String str) {
		if (str.equals("红色")) {
			return Color.parseColor("#FF4081");
		}
		if (str.equals("蓝色")) {
			return Color.parseColor("#3F51B5");
		}
		return Color.parseColor("#344567");
	}

}
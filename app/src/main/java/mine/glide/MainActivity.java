package mine.glide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.request.transition.Transition;

import java.io.File;

/**
 * Created by Administrator on 2021/3/23.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("*********  " + getClass().getSimpleName() + ".onCreate  *********");
        setContentView(R.layout.activity_client);


        //Activity.onCreate()中布局参数为负值，所以不会加载资源，等ViewTreeObserver.OnPreDrawListener()触发后（布局值已经确定）才会加载
//        ImageView imageView = findViewById(R.id.image);
//        System.out.println("height = " + imageView.getLayoutParams().height + ", widht = " + imageView.getLayoutParams().width);
        String url = "https://p.d1xz.net/2015/8/31/111855325532.jpg";
//
//        TheCustomViewTarget theCustomViewTarget = new TheCustomViewTarget(imageView);
//        Glide.with(this)
//                .load(url)
//                .into(theCustomViewTarget);


    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("*********  " + getClass().getSimpleName() + ".onStart  *********");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        System.out.println("*********  " + getClass().getSimpleName() + ".onRestoreInstanceState  *********");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("*********  " + getClass().getSimpleName() + ".onRestart  *********");

    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("*********  " + getClass().getSimpleName() + ".onResume  *********");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("*********  " + getClass().getSimpleName() + ".onPause  *********");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        System.out.println("*********  " + getClass().getSimpleName() + ".onBackPressed  *********");
    }


    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("*********  " + getClass().getSimpleName() + ".onStop  *********");
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        System.out.println("*********  " + getClass().getSimpleName() + ".onSaveInstanceState  *********");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("*********  " + getClass().getSimpleName() + ".onDestroy  *********");
    }


    public void start(View view) {
        System.out.println("~~button.start~~");

        String url = "https://p.d1xz.net/2015/8/31/111855325532.jpg";
//        url = null;
        ImageView imageView = (ImageView) findViewById(R.id.image);

        //各种占位图片
        Glide.with(this)
                .load(url)
//                .placeholder(R.drawable.ic_launcher_background)//占位图片
//                .error(R.drawable.ic_launcher_foreground)//错误图片（加载失败显示的图片）
//                .fallback(R.drawable.ic_baseline_block_24)//空图片（URL为空时显示的图片）
                .into(imageView);
    }


    public void stop(View view) {
        System.out.println("~~button.stop~~");


    }

    public void bind(View view) {
        System.out.println("~~button.bind~~");

        String url = "https://p.d1xz.net/2015/8/31/111855325532.jpg";
        ImageView imageView = (ImageView) findViewById(R.id.image);

        File file = new File(getCacheDir(), "box.jpg");
        if (!file.exists()) return;


        //方式一：自定义Target
        TheTarget<Drawable> target = new TheTarget<>(imageView);
        Glide.with(this)
                .load(file)
                .into(target);

//        imageView.setImageDrawable(target.getT());
//        Glide.with(this).clear(target);

        //方式二：
//        Target target = Glide.with(this)
//                .load(file)
//                .into(imageView);//ImageView将被包装为Target
//        System.out.println("target = " + target);

    }

    public void unbind(View view) {
        System.out.println("~~button.unbind~~");
        String url = "https://p.d1xz.net/2015/8/31/111855325532.jpg";


//        File file = new File(getCacheDir(), "box.jpg");
//        if (!file.exists()) return;

        ImageView imageView = findViewById(R.id.image);

        TheCustomViewTarget theCustomViewTarget = new TheCustomViewTarget(imageView);

        Glide.with(this)
                .load(url)
                .into(theCustomViewTarget.waitForLayout());

//        Glide.with(this).clear(theCustomViewTarget);

    }

    public void reloading(View view) {
        System.out.println("~~button.reloading~~");

    }


    public void del(View view) {
        System.out.println("~~button.del~~");

    }


    public void query(View view) {
        System.out.println("~~button.query~~");

    }

}

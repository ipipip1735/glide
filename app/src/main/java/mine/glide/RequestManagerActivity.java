package mine.glide;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.target.ViewTarget;

import java.io.File;
import java.lang.annotation.Target;

/**
 * Created by Administrator on 2021/3/28.
 */
public class RequestManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("*********  " + getClass().getSimpleName() + ".onCreate  *********");
        setContentView(R.layout.activity_client);


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


        ImageView imageView = (ImageView) findViewById(R.id.image);
        RequestManager requestManager = Glide.with(this);


        //方式一：加载网络资源
        String url = "https://p.d1xz.net/2015/8/31/111855325532.jpg";
//        RequestBuilder<Drawable> requestBuilder =  requestManager.load(url);

        //方式二：加载文件（将本地文件中的像素数据解析出来）
        File file = new File(getCacheDir(), "box.jpg");
        if (!file.exists()) return;
        RequestBuilder<Drawable> requestBuilder = requestManager.load(file);


        requestBuilder.into(imageView);


    }


    public void stop(View view) {
        System.out.println("~~button.stop~~");


        String url = "https://p.d1xz.net/2015/8/31/111855325532.jpg";


        //方式一
//        RequestBuilder<File> requestBuilder = Glide.with(this).downloadOnly();

        //方式二
        RequestBuilder<File> requestBuilder = Glide.with(this).download(url);


    }

    public void bind(View view) {
        System.out.println("~~button.bind~~");

        String url = "https://p.d1xz.net/2015/8/31/111855325532.jpg";

//        ImageView imageView = findViewById(R.id.image);
//        FutureTarget<TranscodeType> futureTarget = Glide.with(this)
//                .load(url)
//                .submit();
//
//                futureTarget

    }

    public void unbind(View view) {
        System.out.println("~~button.unbind~~");

        ImageView imageView = (ImageView) findViewById(R.id.image);
        RequestManager requestManager = Glide.with(this);


        File file = new File(getCacheDir(), "box.jpg");
        if (!file.exists()) return;
        RequestBuilder<Drawable> requestBuilder = requestManager.load(file);

        requestBuilder.fitCenter();

        requestBuilder.into(imageView);


    }

    public void reloading(View view) {
        System.out.println("~~button.reloading~~");

    }


    public void del(View view) {
        System.out.println("~~button.del~~");

        ImageView imageView = (ImageView) findViewById(R.id.image);
        String url = "https://p.d1xz.net/2015/8/31/111855325532.jpg";

        RequestManager requestManager = Glide.with(this);
        ViewTarget viewTarget = requestManager.load(url).into(imageView);

        requestManager.load(url).into(imageView);



        requestBuilder.into(imageView);


    }


    public void query(View view) {
        System.out.println("~~button.query~~");

    }

}

package mine.glide;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.request.transition.Transition;

import java.io.File;
import java.util.concurrent.ExecutionException;

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


        //仅下载
        String url = "https://p.d1xz.net/2015/8/31/111855325532.jpg";
        RequestBuilder<File> requestBuilder = Glide.with(this).download(url);

        requestBuilder.into(new CustomTarget<File>() {
            @Override
            public void onResourceReady(@NonNull File resource, @Nullable Transition<? super File> transition) {
                System.out.println("~~" + getClass().getSimpleName() + ".onResourceReady~~");
                System.out.println("resource = " + resource + ", transition = " + transition);//resource = /data/user/0/mine.glide/cache/image_manager_disk_cache/0eb30b7c4ae83bb3219287a9170559e58b7a34fe0f933daf2c0d1e0eb6dccf0d.0, transition = com.bumptech.glide.request.transition.NoTransition@fc1f6dc
            }

            @Override
            public void onLoadCleared(@Nullable Drawable placeholder) {
                System.out.println("~~" + getClass().getSimpleName() + ".onLoadCleared~~");
                System.out.println("placeholder = " + placeholder);
            }
        });
    }

    public void bind(View view) {
        System.out.println("~~button.bind~~");

        String url = "https://p.d1xz.net/2015/8/31/111855325532.jpg";

        ImageView imageView = findViewById(R.id.image);

        //获取
        FutureTarget<Drawable> futureTarget = Glide.with(this)
                .load(url)
                .submit();
        System.out.println(futureTarget.isDone());

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Drawable drawable = futureTarget.get();
                    System.out.println("drawable = " + drawable);
                    imageView.post(() -> imageView.setImageDrawable(drawable));
                } catch (ExecutionException | InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(futureTarget.isDone());
            }
        }).start();

    }

    public void unbind(View view) {
        System.out.println("~~button.unbind~~");

        String url = "https://p.d1xz.net/2015/8/31/111855325532.jpg";
        ImageView imageView = findViewById(R.id.image);

        RequestManager requestManager = Glide.with(this);
        RequestBuilder<Drawable> requestBuilder = requestManager.load(url);

        //指定变形有3种方式
        //方式一
        requestBuilder.fitCenter();

        //方式二
        requestBuilder.transform(new FitCenter());
        requestBuilder.transform(new FitCenter(), new RoundedCorners(12));

        //方式三
        RequestOptions requestOptions = new RequestOptions();
        requestBuilder.fitCenter();

        //方式四
        requestBuilder.apply(RequestOptions.centerCropTransform().placeholder(R.drawable.ok))
                .into(imageView);

        requestBuilder.into(imageView);
    }

    public void reloading(View view) {
        System.out.println("~~button.reloading~~");

    }


    public void del(View view) {
        System.out.println("~~button.del~~");

        ImageView imageView = findViewById(R.id.image);
        String url = "https://p.d1xz.net/2015/8/31/111855325532.jpg";

        RequestManager requestManager = Glide.with(this);
        RequestBuilder<Drawable> requestBuilder = requestManager.load(url);
        requestBuilder.transform(new TheTransformation()).into(imageView);
    }


    public void query(View view) {
        System.out.println("~~button.query~~");


        ImageView imageView = findViewById(R.id.image);
        String url = "https://p.d1xz.net/2015/8/31/111855325532.jpg";

        RequestManager requestManager = Glide.with(this);
        RequestBuilder<Drawable> requestBuilder = requestManager.load(url);
        requestBuilder.listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                System.out.println("~~" + getClass().getSimpleName() + ".onLoadFailed~~");
                System.out.println("e = " + e + ", model = " + model + ", target = " + target + ", isFirstResource = " + isFirstResource);
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                System.out.println("~~" + getClass().getSimpleName() + ".onResourceReady~~");
                System.out.println("resource = " + resource + ", model = " + model + ", target = " + target + ", dataSource = " + dataSource + ", isFirstResource = " + isFirstResource);
                return false;
            }
        })
                .thumbnail(0.5f)
                .into(imageView);


    }

}

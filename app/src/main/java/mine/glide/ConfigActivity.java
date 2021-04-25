package mine.glide;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;

import java.io.File;
import java.io.InputStream;

import mine.onelib.OneConfigActivity;

import static android.util.Log.INFO;
import static android.util.Log.i;

/**
 * Created by Administrator on 2021/3/28.
 */
public class ConfigActivity extends AppCompatActivity {

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

        Glide.get(this);
    }


    public void stop(View view) {
        System.out.println("~~button.stop~~");

        ImageView imageView = (ImageView) findViewById(R.id.image);
        String url = "https://p.d1xz.net/2015/8/31/111855325532.jpg";

        Glide.with(this)
                .load(url)
                .apply(RequestOptions.placeholderOf(R.drawable.bitmap_ok).centerInside())

                .into(imageView);
    }

    public void bind(View view) {
        System.out.println("~~button.bind~~");

        ImageView imageView = (ImageView) findViewById(R.id.image);
        String url = "https://p.d1xz.net/2015/8/31/111855325532.jpg";

        Glide.with(this)
//                .applyDefaultRequestOptions(RequestOptions.placeholderOf(R.drawable.bitmap_ok).centerInside())
                .load(url)
                .into(imageView);
    }

    public void unbind(View view) {
        System.out.println("~~button.unbind~~");
        ImageView imageView = (ImageView) findViewById(R.id.image);
        String url = "http://img2.a0bi.com/upload/qz/20150714/313479192953-266.jpg";

        Target<Drawable> target = new CustomTarget<Drawable>(50, 50) {
            @Override
            public void onResourceReady(@NonNull Drawable resource,
                                        @Nullable Transition<? super Drawable> transition) {
                System.out.println("~~Target.onResourceReady~~");
                System.out.println("resource = " + resource + ", transition = " + transition);
                imageView.setImageDrawable(resource);
            }

            @Override
            public void onLoadCleared(@Nullable Drawable placeholder) {
                System.out.println("~~Target.onLoadCleared~~");
            }
        };

        //自定义Model
//        Glide.with(this)
//                .as(Drawable.class)
//                .load(new TheM(0))
//                .into(target);

        //自定义Model
        Glide.with(this)
                .as(Drawable.class)
                .load(new File(getCacheDir(), "leaf.jpg"))
                .into(target);

    }

    public void reloading(View view) {
        System.out.println("~~button.reloading~~");

    }


    public void del(View view) {
        System.out.println("~~button.del~~");

        startActivity(new Intent(this, OneConfigActivity.class));

    }


    public void query(View view) {
        System.out.println("~~button.query~~");

    }

}

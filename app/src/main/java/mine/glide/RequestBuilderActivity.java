package mine.glide;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.request.RequestOptions;

import java.io.File;

/**
 * Created by Administrator on 2021/3/28.
 */
public class RequestBuilderActivity extends AppCompatActivity {

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

        File file = new File(getCacheDir(), "box.jpg");
        if (!file.exists()) return;


        //?????????
//        RequestBuilder<Drawable> requestBuilder = requestManager.load(file);
//        requestBuilder.fitCenter()
//                .into(imageView);


        //??????????????????RequestOptions??????
//        RequestOptions options = new RequestOptions();
//        options.fitCenter();
////        options.centerCrop();
////        options.centerInside();
//
//        Glide.with(this)
//                .load(file)
//                .apply(options)//????????????
//                .into(imageView);

        //?????????
//        Glide.with(this)
//                .load(file)
//                .apply(RequestOptions.centerCropTransform())//??????RequestOptions????????????????????????????????????
//                .into(imageView);

    }


    public void stop(View view) {
        System.out.println("~~button.stop~~");

        ImageView imageView = (ImageView) findViewById(R.id.image);

        File file = new File(getCacheDir(), "box.jpg");
        if (!file.exists()) return;


        //??????????????????
        Glide.with(this)
                .load(file)
//                .centerCrop()
//                .centerInside()
//                .circleCrop()
//                .fitCenter()
//                .transform(new MultiTransformation(new FitCenter()))
                .dontTransform()//??????????????????
//                .optionalCenterInside()//???CenterInside()????????????????????????????????????dontTransform()()
//                .optionalCircleCrop()//???CircleCrop()????????????????????????????????????dontTransform()()
//                .optionalFitCenter()//???FitCenter()????????????????????????????????????dontTransform()()
//                .optionalTransform(new FitCenter())//???Transform()????????????????????????????????????dontTransform()()
                .into(imageView);


        //??????????????????
        Glide.with(this)
                .load(file)
//                .override(20, 60)
                .sizeMultiplier(0.1f)
                .into(imageView);


    }

    public void bind(View view) {
        System.out.println("~~button.bind~~");

        String url = "https://p.d1xz.net/2015/8/31/111855325532.jpg";

        ImageView imageView = (ImageView) findViewById(R.id.image);

        File file = new File(getCacheDir(), "box.jpg");
        if (!file.exists()) return;


        //???????????????
        Glide.with(this)
                .load(url)
                .thumbnail(Glide.with(this).load(file))
                .into(imageView);
    }

    public void unbind(View view) {
        System.out.println("~~button.unbind~~");

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

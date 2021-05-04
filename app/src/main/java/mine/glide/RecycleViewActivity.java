package mine.glide;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.bumptech.glide.Glide;
import com.bumptech.glide.ListPreloader;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.integration.recyclerview.RecyclerViewPreloader;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.FixedPreloadSizeProvider;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Administrator on 2021/5/3.
 */
public class RecycleViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("*********  " + getClass().getSimpleName() + ".onCreate  *********");
        setContentView(R.layout.activity_recycleview);


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

        RecyclerView recyclerView = findViewById(R.id.rv);

        System.out.println("recyclerView = " + recyclerView);
        recyclerView.setAdapter(new RecyclerView.Adapter() {
            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                ImageView imageView = new ImageView(RecycleViewActivity.this);
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(220, 220);
                imageView.setLayoutParams(layoutParams);
                return  new ViewHolder(imageView){};
            }

            @Override
            public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
                Glide.with(RecycleViewActivity.this)
                        .load("https://p.d1xz.net/2015/8/31/111855325532.jpg")
                        .into((ImageView) holder.itemView);
            }

            @Override
            public int getItemCount() {
                return 120;
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        ListPreloader.PreloadSizeProvider<String> sizeProvider = new FixedPreloadSizeProvider<String>(220, 220);
        ListPreloader.PreloadModelProvider<String> modelProvider = new ListPreloader.PreloadModelProvider<String>() {
            @NonNull
            @Override
            public List<String> getPreloadItems(int position) {
                System.out.println("~~" + getClass().getSimpleName() + ".getPreloadItems~~");
                System.out.println("position = " + position);
                return Collections.singletonList("https://p.d1xz.net/2015/8/31/111855325532.jpg");
            }

            @Nullable
            @Override
            public RequestBuilder<?> getPreloadRequestBuilder(@NonNull String item) {
                System.out.println("~~" + getClass().getSimpleName() + ".getPreloadRequestBuilder~~");
                System.out.println("item = " + item);
                return null;
            }
        };

        RecyclerViewPreloader<String> preloader = new RecyclerViewPreloader<>(Glide.with(this), modelProvider, sizeProvider, 2);
        recyclerView.addOnScrollListener(preloader);

    }


    public void stop(View view) {
        System.out.println("~~button.stop~~");







    }

    public void bind(View view) {
        System.out.println("~~button.bind~~");
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

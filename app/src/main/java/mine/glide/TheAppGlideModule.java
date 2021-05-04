package mine.glide;

import android.content.Context;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
//import com.bumptech.glide.integration.volley.VolleyUrlLoader;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.AppGlideModule;

import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.OkHttp;
import okhttp3.OkHttpClient;

import static android.util.Log.VERBOSE;

/**
 * Created by Administrator on 2021/4/5.
 */
@GlideModule
public class TheAppGlideModule extends AppGlideModule {
    public TheAppGlideModule() {
        super();
        System.out.println("~~TheAppGlideModule.TheAppGlideModule~~");
    }

    @Override
    public boolean isManifestParsingEnabled() {
        return false;
    }

    @Override
    public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {
        System.out.println("~~TheAppGlideModule.applyOptions~~");
        System.out.println("context = " + context + ", builder = " + builder);
//        builder.setDefaultRequestOptions(RequestOptions.circleCropTransform());//设置默认选项
        builder.setLogLevel(VERBOSE);//设置日志级别
        builder.setMemoryCache(new LruResourceCache(1024 * 1024 * 0));//设置内存缓存尺寸
        builder.setBitmapPool(new LruBitmapPool(1024 * 1024 * 0));//设置BitmapPool尺寸
    }

    @Override
    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
        super.registerComponents(context, glide, registry);
        System.out.println("~~TheAppGlideModule.registerComponents~~");
        System.out.println("context = " + context + ", glide = " + glide + ", registry = " + registry);

//        registry.replace(TheM.class, TheD.class, new TheModel.TheModelLoaderFactory());
//        registry.prepend(ByteBuffer.class, Bitmap.class, new TheResourceDecoder(glide));


//        registry.replace(GlideUrl.class, InputStream.class,
//                new OkHttpUrlLoader.Factory(
//                        new OkHttpClient.Builder()
//                                .callTimeout(1L, TimeUnit.SECONDS)
//                                .build()));

//        registry.replace(GlideUrl.class, InputStream.class, new VolleyUrlLoader.Factory(context));
    }
}

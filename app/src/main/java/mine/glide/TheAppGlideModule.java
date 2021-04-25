package mine.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.request.RequestOptions;

import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;

import static android.util.Log.INFO;

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
        builder.setLogLevel(INFO);
        builder.setDefaultRequestOptions(RequestOptions.circleCropTransform());
    }

    @Override
    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
        super.registerComponents(context, glide, registry);
        System.out.println("~~TheAppGlideModule.registerComponents~~");
        System.out.println("context = " + context + ", glide = " + glide + ", registry = " + registry);

//        registry.replace(TheM.class, TheD.class, new TheModel.TheModelLoaderFactory());
        registry.prepend(ByteBuffer.class, Bitmap.class, new TheResourceDecoder(glide));
    }
}

package mine.onelib;

import android.content.Context;
import android.graphics.Bitmap;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.module.LibraryGlideModule;

import java.nio.ByteBuffer;

/**
 * Created by Administrator on 2021/4/19.
 */
//@GlideModule
public class OneLibraryGlideModule extends LibraryGlideModule {
    public OneLibraryGlideModule() {
        System.out.println("~~" + getClass().getSimpleName() + ".OneLibraryGlideModule~~");
    }

    @Override
    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
        super.registerComponents(context, glide, registry);
        System.out.println("~~" + getClass().getSimpleName() + ".registerComponents~~");
        System.out.println("context = " + context + ", glide = " + glide + ", registry = " + registry);

        registry.prepend(ByteBuffer.class, Bitmap.class, new OneResourceDecoder(glide));
    }

}

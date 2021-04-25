package mine.onelib;

import android.content.Context;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

/**
 * Created by Administrator on 2021/4/19.
 */
//@GlideModule
public class OneAppGlideModule extends AppGlideModule {
    public OneAppGlideModule() {
        System.out.println("~~" + getClass().getSimpleName() + ".OneAppGlideModule~~");
    }

    @Override
    public boolean isManifestParsingEnabled() {
        System.out.println("~~" + getClass().getSimpleName() + ".isManifestParsingEnabled~~");
        return true;
    }

    @Override
    public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {
        System.out.println("~~TheAppGlideModule.applyOptions~~");
        System.out.println("context = " + context + ", builder = " + builder);
    }

    @Override
    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
        super.registerComponents(context, glide, registry);
        System.out.println("~~TheAppGlideModule.registerComponents~~");
        System.out.println("context = " + context + ", glide = " + glide + ", registry = " + registry);
    }

}

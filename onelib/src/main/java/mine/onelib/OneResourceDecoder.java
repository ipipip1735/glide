package mine.onelib;

import android.graphics.Bitmap;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * Created by Administrator on 2021/4/18.
 */
public class OneResourceDecoder implements ResourceDecoder<ByteBuffer, Bitmap> {

    Glide glide;

    public OneResourceDecoder(Glide glide) {
        this.glide = glide;
    }

    @Override
    public boolean handles(@NonNull ByteBuffer source, @NonNull Options options) throws IOException {
        System.out.println("~~" + getClass().getSimpleName() + ".handles~~");
        System.out.println("source = " + source + ", options = " + options);
        return true;
    }

    @Nullable
    @Override
    public Resource<Bitmap> decode(@NonNull ByteBuffer source, int width, int height, @NonNull Options options) throws IOException {
        System.out.println("~~" + getClass().getSimpleName() + ".decode~~");
        System.out.println("source = " + source + ", width = " + width + ", height = " + height + ", options = " + options);
        return new BitmapResource(Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888), glide.getBitmapPool());
    }
}
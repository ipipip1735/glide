package mine.glide;

import android.content.Context;
import android.graphics.Bitmap;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;

import java.security.MessageDigest;

/**
 * Created by Administrator on 2021/5/1.
 */
public class TheTransformation implements Transformation<Bitmap> {
    @NonNull
    @Override
    public Resource<Bitmap> transform(@NonNull Context context, @NonNull Resource<Bitmap> resource, int outWidth, int outHeight) {
        System.out.println("~~" + getClass().getSimpleName() + ".transform~~");
        System.out.println("context = " + context + ", resource = " + resource + ", outWidth = " + outWidth + ", outHeight = " + outHeight);

        Bitmap temp = Bitmap.createBitmap(150, 150, Bitmap.Config.ARGB_8888);
        temp.recycle();
        //Glide.get(context).getBitmapPool().put(temp);

        Bitmap bitmap = TransformationUtils.circleCrop(Glide.get(context).getBitmapPool(), resource.get(), outWidth, outHeight);
        return BitmapResource.obtain(bitmap, Glide.get(context).getBitmapPool());
    }

    @Override
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        System.out.println("~~" + getClass().getSimpleName() + ".updateDiskCacheKey~~");
        System.out.println("messageDigest = " + messageDigest);
    }
}

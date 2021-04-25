package mine.glide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.load.Key;

import java.security.MessageDigest;

/**
 * Created by Administrator on 2021/4/22.
 */
public class TheKey implements Key {

    int id;

    public TheKey(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        System.out.println("~~" + getClass().getSimpleName() + ".hashCode~~");
        return super.hashCode();
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        System.out.println("~~" + getClass().getSimpleName() + ".equals~~");
        return super.equals(obj);
    }

    @Override
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        System.out.println("~~" + getClass().getSimpleName() + ".updateDiskCacheKey~~");
        System.out.println("messageDigest = " + messageDigest);

        messageDigest.update(Integer.valueOf(id).byteValue());
    }
}

package mine.glide;

import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;

/**
 * Created by Administrator on 2021/3/23.
 */
public class TheTarget<T> implements Target<T> {

    @Override
    public void onLoadStarted(@Nullable Drawable placeholder) {
        System.out.println("~~" + getClass().getSimpleName() + ".onLoadStarted~~");
        System.out.println("placeholder = " + placeholder);
    }

    @Override
    public void onLoadFailed(@Nullable Drawable errorDrawable) {
        System.out.println("~~" + getClass().getSimpleName() + ".onLoadFailed~~");
        System.out.println("errorDrawable = " + errorDrawable);

    }

    @Override
    public void onResourceReady(@NonNull T resource, @Nullable Transition<? super T> transition) {
        System.out.println("~~" + getClass().getSimpleName() + ".onResourceReady~~");
        System.out.println("resource = " + resource + ", transition = " + transition);
    }

    @Override
    public void onLoadCleared(@Nullable Drawable placeholder) {
        System.out.println("~~" + getClass().getSimpleName() + ".onLoadCleared~~");
        System.out.println("placeholder = " + placeholder);

    }

    @Override
    public void getSize(@NonNull SizeReadyCallback cb) {
        System.out.println("~~" + getClass().getSimpleName() + ".getSize~~");
        System.out.println("cb = " + cb);

    }

    @Override
    public void removeCallback(@NonNull SizeReadyCallback cb) {
        System.out.println("~~" + getClass().getSimpleName() + ".removeCallback~~");
        System.out.println("cb = " + cb);

    }

    @Override
    public void setRequest(@Nullable Request request) {
        System.out.println("~~" + getClass().getSimpleName() + ".setRequest~~");
        System.out.println("request = " + request);

    }

    @Nullable
    @Override
    public Request getRequest() {
        System.out.println("~~" + getClass().getSimpleName() + ".getRequest~~");
        return null;
    }

    @Override
    public void onStart() {
        System.out.println("~~" + getClass().getSimpleName() + ".onStart~~");

    }

    @Override
    public void onStop() {
        System.out.println("~~" + getClass().getSimpleName() + ".onStop~~");

    }

    @Override
    public void onDestroy() {
        System.out.println("~~" + getClass().getSimpleName() + ".onDestroy~~");

    }
}

package mine.glide;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.transition.Transition;

/**
 * Created by Administrator on 2021/4/3.
 */
public class TheCustomViewTarget extends CustomViewTarget<ImageView, Drawable> {

    public TheCustomViewTarget(@NonNull ImageView view) {
        super(view);
    }

    @Override
    protected void onResourceCleared(@Nullable Drawable placeholder) {
        System.out.println("TheCustomViewTarget.onResourceCleared");
        System.out.println("placeholder = " + placeholder);
        getView().setImageDrawable(null);

    }

    @Override
    protected void onResourceLoading(@Nullable Drawable placeholder) {
        getView().setImageDrawable(placeholder);
    }

    @Override
    public void onLoadFailed(@Nullable Drawable errorDrawable) {

    }

    @Override
    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
        getView().setImageDrawable(resource);
    }
}

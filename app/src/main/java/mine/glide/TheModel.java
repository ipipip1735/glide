package mine.glide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;

/**
 * Created by Administrator on 2021/4/18.
 */
public class TheModel implements ModelLoader<TheM, TheD> {


    @Nullable
    @Override
    public LoadData<TheD> buildLoadData(@NonNull TheM theM, int width, int height, @NonNull Options options) {
        System.out.println("~~" + getClass().getSimpleName() + ".buildLoadData~~");
        System.out.println("theM = " + theM + ", width = " + width + ", height = " + height + ", options = " + options);
        return null;
    }

    @Override
    public boolean handles(@NonNull TheM theM) {
        System.out.println("~~" + getClass().getSimpleName() + ".handles~~");
        return true;
    }

    public static class TheModelLoaderFactory implements ModelLoaderFactory<TheM, TheD> {

        @NonNull
        @Override
        public ModelLoader<TheM, TheD> build(@NonNull MultiModelLoaderFactory multiFactory) {
            System.out.println("~~" + getClass().getSimpleName() + ".build~~");
            return new TheModel();
        }

        @Override
        public void teardown() {

        }
    }
}

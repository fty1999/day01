package com.bawei.com.fantengya20190407.application;

import android.app.Application;
import android.os.Environment;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.File;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/4/7 14:35:05
 * @Description:
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        String path = Environment.getExternalStorageDirectory().getPath() + "/Image";
        File file = new File(path);

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .memoryCacheExtraOptions(200, 200)
                .memoryCacheSize(2 * 1024 * 1024)//配置内存缓存的大小
                .threadPoolSize(3)
                .threadPriority(1000)
                .diskCache(new UnlimitedDiskCache(file))
                .diskCacheFileCount(50)//配置sdcard缓存文件的数量
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .diskCacheSize(50 * 1024 * 1024)
                .build();

        ImageLoader.getInstance().init(config);
    }
}


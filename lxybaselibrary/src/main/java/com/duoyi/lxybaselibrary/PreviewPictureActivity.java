package com.duoyi.lxybaselibrary;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.duoyi.lxybaselibrary.base.BaseActivity;
import com.duoyi.lxybaselibrary.base.BaseVM;
import com.duoyi.lxybaselibrary.databinding.ActivityPreviewpictureBinding;
import com.duoyi.lxybaselibrary.widget.MyRCImageView;
import com.luck.picture.lib.photoview.PhotoView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lxy on 2018/11/8.
 * Desc:
 * 图片查看器
 */


public class PreviewPictureActivity extends BaseActivity<ActivityPreviewpictureBinding, BaseVM> {
    private List<View> views = new ArrayList<View>();
    private ArrayList<String> urls;
    private int position = 0;


    public static void startActivity(Context context , ArrayList<String> urls, int position) {

        Intent intent = new Intent(context, PreviewPictureActivity.class);
        intent.putExtra("urls", urls);
        intent.putExtra("position", position);
        context.startActivity(intent);
    }



    @Override
    public int getLayout() {
        return R.layout.activity_previewpicture;
    }

    @Override
    public BaseVM createVM() {
        return null;
    }

    @Override
    public void initView() {
       hiddenTitle();
       hideStatusBar();
        urls = getIntent().getStringArrayListExtra("urls");
        position = getIntent().getIntExtra("position", 0);
        mBinding.tvPosition.setText(position + 1 + "/" + urls.size());
        mBinding.viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                PreviewPictureActivity.this.position = position;
                mBinding.tvPosition.setText(position + 1 + "/" + urls.size());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mBinding.tvSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePicture();
            }
        });
    }

    public void savePicture() {
//        RxPermissions rxPermissions = new RxPermissions(this);
//        rxPermissions
//                .request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
//                .subscribe(granted -> {
//                    if (granted) {
//                        RequestOptions options = new RequestOptions();
//                        GlideApp.with(mContext)
//                                .asBitmap()
//                                .apply(options)
//                                .load(urls.get(position))
//                                .into(new SimpleTarget<Bitmap>() {
//                                    @Override
//                                    public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
//                                        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
//                                        String fileName = DateUtil.getStringTime(
//                                                DateUtil.getTime(), "yyyy年MM月dd日HH:mm:ss") + urls.get(position).substring(urls.get(position).lastIndexOf('/') + 1);
//                                        String path = FileHelper.saveFile(PreviewPictureActivity.this, fileName, bitmap);
//                                        File file = new File(path);
//                                        if (!StringUtil.isEmpty(path)) {
//                                            intent.setData(Uri.fromFile(new File(path)));
//                                            PreviewPictureActivity.this.sendBroadcast(intent);
//                                            toast("保存成功");
//                                            try {
//                                                MediaStore.Images.Media.insertImage(PreviewPictureActivity.this.getContentResolver(),
//                                                        file.getAbsolutePath(), fileName, null);
//                                            } catch (FileNotFoundException e) {
//                                                e.printStackTrace();
//                                            }
//                                            // 最后通知图库更新
//                                            PreviewPictureActivity.this.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse(file.getAbsolutePath())));
//                                        } else {
//                                            toast("保存失败");
//                                        }
//                                    }
//                                });
//
//                    } else {
//                        toast("没有权限不能保存图片");
//                    }
//                });
    }

    @Override
    public void initData() {
        views.clear();
        View view = null;
        for (int i = 0; i < urls.size(); i++) {
            view = buildImageView(MyRCImageView.IMAGE_URL+urls.get(i));
            views.add(view);
        }
        PicturePaperAdapter adapter = new PicturePaperAdapter(views);
        mBinding.viewpager.setAdapter(adapter);
        mBinding.viewpager.setCurrentItem(position);
    }

    private View buildImageView(String url) {
        View view = LayoutInflater.from(this).inflate(R.layout.layout_previewpicture, null);
        final PhotoView photoView = view.findViewById(R.id.photoview);
        photoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Glide.with(mContext).asBitmap().load(url).into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                photoView.setImageBitmap(resource);
               runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        photoView.setScale(1f);
                    }
                });
            }
        });
        return view;
    }


}
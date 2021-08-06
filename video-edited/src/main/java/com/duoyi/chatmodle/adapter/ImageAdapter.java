//package com.duoyi.chatmodle.adapter;
//
//import android.content.Context;
//import android.widget.LinearLayout;
//
//import com.duoyi.chatmodle.R;
//import com.duoyi.chatmodle.databinding.ItemImageBinding;
//import com.duoyi.lxybaselibrary.PreviewPictureActivity;
//import com.duoyi.lxybaselibrary.base.BaseAdapter;
//import com.duoyi.lxybaselibrary.base.ViewHolder;
//import com.duoyi.lxybaselibrary.utils.AppUtils;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * author : 创建人lxy
// * date : 2021/6/3 8:48
// * version :
// * desc : 于此创建有问题请联系
// */
//public class ImageAdapter extends BaseAdapter<String, ItemImageBinding> {
//    int w;
//    int h;
//    int margin;
//
//    public ImageAdapter(Context context, List<String> datas, int w, int h, int margin) {
//        super(context, datas, R.layout.item_image);
//        this.w = w;
//        this.h = h;
//        this.margin = margin;
//    }
//
//    @Override
//    protected void bindingData(ViewHolder holder, ItemImageBinding mBinding, String bean, int type, int position) {
//        mBinding.ivIcon.setUrl(bean);
//
//        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) mBinding.ivIcon.getLayoutParams();
//        layoutParams.width = AppUtils.dp2px(mContext, w);
//        layoutParams.height = AppUtils.dp2px(mContext, h);
//        layoutParams.topMargin = AppUtils.dp2px(mContext, margin);
//        layoutParams.leftMargin = AppUtils.dp2px(mContext, margin);
//        layoutParams.rightMargin = AppUtils.dp2px(mContext, margin);
//        layoutParams.bottomMargin = AppUtils.dp2px(mContext, margin);
//        mBinding.ivIcon.setLayoutParams(layoutParams);
//
//        mBinding.ivIcon.setOnClickListener(view -> PreviewPictureActivity.startActivity(mContext, new  ArrayList<String>(mList) ,position));
//    }
//}

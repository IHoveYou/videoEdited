package com.duoyi.lxybaselibrary.net.subscriber;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;

import com.duoyi.lxybaselibrary.utils.UIUtil;


public abstract class DialogSubscriber<T> extends CCSubscriber<T> {

    private Context mActivity;
    private Dialog mDialog;
    private boolean isShowLoading;

    public DialogSubscriber(Activity activity) {
        super(false);
        this.mActivity = activity;
    }


    public DialogSubscriber(Dialog dialog) {
        super(false);
        this.mDialog = dialog;
    }

    public DialogSubscriber(Context activity, boolean isShowErrorToast, boolean isShowLoading) {
        super(isShowErrorToast);
        this.mActivity = activity;
        this.isShowLoading = isShowLoading;
    }

    public DialogSubscriber(Dialog dialog, boolean showErrorToast) {
        super(showErrorToast);
        this.mDialog = dialog;
    }

    @Override
    public void onStart() {
        if (isShowLoading) {
            if (mDialog != null) {
                mDialog.show();
                return;
            }
            if (mActivity instanceof Activity){
                UIUtil.showLoadingDialog((Activity) mActivity);
            }
        }
    }

    @Override
    protected void onFinish() {
        if (mDialog != null) {
            mDialog.dismiss();
            return;
        }
        UIUtil.cancelLoadingDiaoog();
    }

}

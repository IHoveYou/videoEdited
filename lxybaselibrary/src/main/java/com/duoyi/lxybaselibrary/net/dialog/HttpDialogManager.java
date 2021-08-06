package com.duoyi.lxybaselibrary.net.dialog;

import android.app.Activity;
import android.app.Dialog;


public abstract class HttpDialogManager {

    public abstract Dialog showLoadingDialog(Activity activity);

    public void cancelLoadingDialog(Dialog dialog) {
        if (dialog == null) {
            return;
        }
        dialog.dismiss();
    }
}

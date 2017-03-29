package com.fushuang.assassinnews.xmpp;

/**
 * Created by sv-004 on 2016/6/15.
 */

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

/**
 * TODO 使用异步线程工具, AsyncTask,调用Load,result.
 * @author msh
 * @time 2016/6/15 20:33
*/

public abstract class XmppLoadThread {

    boolean isHint;
    ProgressDialog mdialog;
    private Context c;

    @SuppressLint("NewApi")
    public XmppLoadThread(Context _mcontext) {
        isHint = true;
        c = _mcontext;
        new AsyncTask<Void, Integer, Object>() {
            @Override
            protected Object doInBackground(Void... arg0) {
                return load();
            }
            @Override
            protected void onPostExecute(Object result) {
                if (isHint && (mdialog == null || !mdialog.isShowing())) {
                    return;
                } else {
                    try {
                        result(result);
                        if (isHint && (mdialog != null && mdialog.isShowing())) {

                            mdialog.dismiss();

//							mdialog.dismiss();
                        }
                    } catch (Throwable e) {
                        e.printStackTrace();
                    }
                }
            }
            @Override
            protected void onPreExecute() {
                if (isHint) {
                    try {
                        mdialog =  ProgressDialog.show(c, "提示", "正在加载......");
                        mdialog.setCancelable(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }.execute();
    }
    protected abstract Object load();
    protected abstract void result(Object object);

}

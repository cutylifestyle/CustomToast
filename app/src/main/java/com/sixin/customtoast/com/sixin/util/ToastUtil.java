package com.sixin.customtoast.com.sixin.util;

import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.sixin.customtoast.R;

/**
 * @author 周文涛
 */

public class ToastUtil {

    private static boolean isCreated;
    private static Toast toast;
    private Context context;

    private ToastUtil(Context context){
        this.context = context;
    }

    private void show(String message){

        if(toast == null && !isCreated){
            toast = new Toast(context);
            isCreated = true;
        }

        View view= LayoutInflater.from(context).inflate(R.layout.layout_toast, null);
        TextView textView = (TextView) view.findViewById(R.id.message);
        textView.setText(message);
        toast.setView(view);
        toast.show();

    }

    public void showDeflaut(String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public void showNonUIThread(String message){
        Looper.prepare();
        show(message);
        Looper.loop();
    }

}

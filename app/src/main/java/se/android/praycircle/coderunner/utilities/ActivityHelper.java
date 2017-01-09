package se.android.praycircle.coderunner.utilities;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Paulo Vila Nova on 2017-01-09.
 */

public class ActivityHelper {

    public static void log(Context context, TextView tv, String message, boolean append){

        if(tv != null && message != null && message.length() > 0){
            if(append){
                tv.append(message + "\n");

            }else{
                tv.setText(message);
            }

            Log.i(context.getClass().getSimpleName(), message); //return the simple name of the class..
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }
    }

    public static void setTextBack(){

    }



}

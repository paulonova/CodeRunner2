package se.android.praycircle.coderunner;

import android.app.Application;

/**
 * Created by Paulo Vila Nova on 2017-01-09.
 */

public class GlobalVariables extends Application {

    private String textToDisplay;



    public String getTextToDisplay() {
        return textToDisplay;
    }

    public void setTextToDisplay(String textToDisplay) {
        this.textToDisplay = textToDisplay;
    }

}

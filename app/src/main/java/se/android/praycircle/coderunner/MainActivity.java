package se.android.praycircle.coderunner;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import se.android.praycircle.coderunner.utilities.ActivityHelper;

public class MainActivity extends AppCompatActivity  implements BlankFragment.OnFragmentInteractionListener{

    private static final String LOG_TEXT_KEY = "LOG_TEXT_KEY" ;
    private ScrollView mScroll;
    private TextView mLog;
    private Button  mButtonRun,mButtonClear;

    private GlobalVariables appContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize the logging components
        mScroll = (ScrollView) findViewById(R.id.scrollLog);
        mLog = (TextView) findViewById(R.id.tvLog);

        appContext = (GlobalVariables) getApplicationContext();

        mLog.setText(appContext.getTextToDisplay());

        mButtonRun = (Button)findViewById(R.id.btnRun);
        mButtonClear = (Button)findViewById(R.id.btnClear);

        mButtonRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayMessage("Running code!");
            }
        });

        mButtonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLog.setText("");
                mScroll.scrollTo(0, mScroll.getBottom());
            }
        });

    }


    public void displayMessage(String message) {
        ActivityHelper.log(this, mLog, message, true);
        mScroll.scrollTo(0, mScroll.getBottom());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityHelper.log(this, mLog, "onDestroy", true);
        appContext.setTextToDisplay(mLog.getText().toString());
    }

    @Override
    public void onFragmentInteraction() {
        ActivityHelper.log(this, mLog, "Fragment button pressed", true);
    }


    /** Override methods to save and restore information from screen*/
//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        ActivityHelper.log(this, mLog, "saving statement", true);
//        outState.putString(LOG_TEXT_KEY, mLog.getText().toString() );
//        super.onSaveInstanceState(outState);
//    }
//
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        mLog.setText(savedInstanceState.getString(LOG_TEXT_KEY));
//        ActivityHelper.log(this, mLog, "restore statement", true);
//    }
}

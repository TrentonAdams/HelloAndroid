package org.adamsbros.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HelloAndroidActivity extends Activity implements OnClickListener
{

    private static final int DIALOG_OKAY_CANCEL = 0;
    private Button button;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View arg0)
    {
        Log.d(getClass().toString(), "clicked");
        showDialog(DIALOG_OKAY_CANCEL);
    }
    
    @Override
    protected Dialog onCreateDialog(int id)
    {
        switch (id)
        {
        case DIALOG_OKAY_CANCEL:
            DialogInterface.OnClickListener listener =
                    new DialogInterface.OnClickListener()
                    {
                        public void onClick(DialogInterface dialog,
                                int whichButton)
                        {
                            Log.d(getClass().toString(), "ooohh, clicked"
                                    + whichButton);
                        }
                    };
            Builder builder;
            builder = new AlertDialog.Builder(this);
            builder.setTitle(R.string.dialogtitle);
            builder.setPositiveButton(R.string.alert_dialog_ok, listener);
            builder.setNegativeButton(R.string.alert_dialog_cancel, listener);
            return builder.create();
        }
        return null;
    }

    
}
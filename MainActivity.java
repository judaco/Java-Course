package com.example.hackeru.lesson32_displaydialog;

import android.app.Activity;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity implements InputUserNameDialogFragment.UserNameListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnShowInputUserNameDialog(View view) {
        FragmentManager fragmentManager = getFragmentManager();
        InputUserNameDialogFragment inputUserNameDialogFragment = new InputUserNameDialogFragment();
        inputUserNameDialogFragment.setCancelable(false);
        inputUserNameDialogFragment.setDialogTitle("Enter Username");
        inputUserNameDialogFragment.setListener(this);
        inputUserNameDialogFragment.show(fragmentManager, "Bayush");
    }

    @Override
    public void hasUserName(String userName) {
        Toast.makeText(this, "userName:" + userName, Toast.LENGTH_SHORT).show();
    }

    public void btnShowInputConfirm(View view) {
        FragmentManager fragmentManager2 = getFragmentManager();

    }
}

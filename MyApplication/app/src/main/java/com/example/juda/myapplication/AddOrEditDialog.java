package com.example.juda.myapplication;

/**
 * Created by Juda on 18/11/2016.
 */

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by User on 17/11/2016.
 */

public class AddOrEditDialog extends DialogFragment {
    TextView frgText;
    EditText edtUser, edtPass;
    Button btnFrag;
    boolean isEdit;
    FragmentRes listener;
    String user,pass;

    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setEdit(boolean edit) {
        isEdit = edit;
    }

    public void setListener(FragmentRes listener) {
        this.listener = listener;
    }

    public static interface FragmentRes{
        void addNew (String username, String password);
        void editUser (String username, String password);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.new_or_edit_dialog, null);
        btnFrag = (Button) view.findViewById(R.id.btnFragment);
        edtPass = (EditText) view.findViewById(R.id.edtPasswordEdit);
        edtUser = (EditText) view.findViewById(R.id.edtUsernameEdit);
        frgText = (TextView) view.findViewById(R.id.txtFragmentText);

        if(isEdit){
            frgText.setText("Edit Username And Password :");
            btnFrag.setText("edit");
            edtUser.setHint(user);
            edtPass.setHint(pass);
        }else {
            frgText.setText("New Username And Password :");
            btnFrag.setText("add");
            edtUser.setHint("Username");
            edtPass.setHint("Password");
        }

        btnFrag.setOnClickListener(onClickListener);
        edtUser.requestFocus();

        return  view;
    }
    private View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            String pass =  edtPass.getText().toString();
            String user =  edtUser.getText().toString();
            if(isEdit){
                if(listener != null)
                    listener.editUser(user,pass);
                dismiss();
            }else {
                if(listener != null)
                    listener.addNew(user,pass);
                dismiss();
            }
        }
    };
}

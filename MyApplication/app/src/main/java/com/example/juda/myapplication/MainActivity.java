package com.example.juda.myapplication;

import android.app.Activity;
import android.app.FragmentManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements AddOrEditDialog.FragmentRes{


    ListView userItemList;
    List<Users> usersList;
    MyListAdaptor myListAdaptor;
    FragmentManager fragmentManager;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userItemList = (ListView)findViewById(R.id.userItemList);
        usersList = new ArrayList<>();
        usersList.add(new Users("moshe" , "123456"));
        usersList.add(new Users("aharon" , "123456"));
        usersList.add(new Users("shlomo" , "123456"));
        usersList.add(new Users("odelya" , "123456"));
        usersList.add(new Users("morya" , "123456"));
        usersList.add(new Users("noam" , "123456"));
        usersList.add(new Users("noam" , "123456"));
        usersList.add(new Users("noam" , "123456"));
        usersList.add(new Users("noam" , "123456"));
        usersList.add(new Users("noam" , "123456"));
        usersList.add(new Users("noam" , "123456"));
        usersList.add(new Users("noam" , "123456"));
        usersList.add(new Users("noam" , "123456"));
        usersList.add(new Users("noam" , "123456"));

        myListAdaptor = new MyListAdaptor(this, usersList);
        userItemList.setAdapter(myListAdaptor);
        userItemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                fragmentManager = getFragmentManager();
                AddOrEditDialog addOrEditDialog = new AddOrEditDialog();
                addOrEditDialog.setEdit(true);
                addOrEditDialog.setListener(MainActivity.this);
                addOrEditDialog.setPass(usersList.get(i).getPassword());
                addOrEditDialog.setUser(usersList.get(i).getUsername());
                pos = i;
                addOrEditDialog.show(fragmentManager ,"");
            }
        });


    }

    @Override
    public void addNew(String username, String password) {
        usersList.add(new Users(username,password));
    }

    @Override
    public void editUser(String username, String password) {
        usersList.set(pos, new Users(username, password));
        myListAdaptor.notifyDataSetChanged();
    }

    public void btnAddNewUser(View view) {
        fragmentManager = getFragmentManager();
        AddOrEditDialog addOrEditDialog = new AddOrEditDialog();
        addOrEditDialog.setEdit(false);
        addOrEditDialog.setListener(this);
        addOrEditDialog.show(fragmentManager,"");

    }
    public class MyListAdaptor extends ArrayAdapter<Users> {
        Activity activity;
        List<Users> usersList;


        public MyListAdaptor(Activity activity, List<Users> list) {
            super(activity,R.layout.users_item, list);
            this.activity = activity;
            this.usersList = list;
        }

        class ViewConteiner{
            TextView txtUser;
            Button btnRemove;
        }

        @NonNull
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View view = convertView;
            ViewConteiner viewConteiner = null;
            if(view == null){
                LayoutInflater inflater = activity.getLayoutInflater();
                view = inflater.inflate(R.layout.users_item, null);
                viewConteiner = new ViewConteiner();
                viewConteiner.txtUser = (TextView) view.findViewById(R.id.txtItemUser);
                viewConteiner.btnRemove = (Button) view.findViewById(R.id.btnRemoverUser);
                view.setTag(viewConteiner);
            }else {
                viewConteiner = (ViewConteiner) view.getTag();
            }

            viewConteiner.btnRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    usersList.remove(position);
                    myListAdaptor.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "You Deleted : " + usersList.get(position).getUsername(), Toast.LENGTH_SHORT).show();
                }
            });

            viewConteiner.txtUser.setText(usersList.get(position).getUsername());
            return view;
        }


    }

}

package com.tiy.day22assignment;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

//my IP address: 10.0.0.127
public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener {
    ListView list;
    EditText text;
    Button addButton;
    ChatClient myClient;
    ArrayAdapter<String> items;
//    public static void main(String[] args) {
//        //new MainActivity
//        ChatClient myClient = new ChatClient();
//        myClient.runClient();
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Bring the widgets in
        list = (ListView) findViewById(R.id.listView);
        text = (EditText) findViewById(R.id.editText);
        addButton = (Button) findViewById(R.id.button);

        items = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        list.setAdapter(items);
        addButton.setOnClickListener(this);
        list.setOnItemLongClickListener(this);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        myClient = new ChatClient();
        myClient.runClient();
    }
    @Override
    public void onClick(View v) {
        //when the user taps the send button, send a chat message to your server
        String item = text.getText().toString();
        items.add(item);
        text.setText("");
//        ChatClient.class;
        myClient.sendMessage(item);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        String item = items.getItem(position);
        items.remove(item);
        return true;
    }
}

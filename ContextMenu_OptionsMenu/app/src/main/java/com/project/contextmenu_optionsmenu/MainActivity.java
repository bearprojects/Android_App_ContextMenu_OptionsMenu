package com.project.contextmenu_optionsmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView,textView2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("ContextMenu_OptionsMenu");

        textView = (TextView)findViewById(R.id.textView);
        textView2 = (TextView)findViewById(R.id.textView2);
        btn = (Button)findViewById(R.id.btn);

        registerForContextMenu(btn);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,1,1,"Help");
        menu.add(0,2,2,"Quit");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == 1) {
            textView2.setText("按手機Action Bar上的功能表圖示開啟Menu功能表。\n長按按鈕顯示快顯功能表。");
        }
        else if(id == 2){
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (v == btn)
            getMenuInflater().inflate(R.menu.contextmenu, menu);

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.contextitem1:
                Log.d("Demo",getText(R.string.contextmenu1).toString());
                Toast.makeText(this, "快顯1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.contextitem2:
                Log.d("Demo",getText(R.string.contextmenu2).toString());
                Toast.makeText(this, "快顯2", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onContextItemSelected(item);
    }
}

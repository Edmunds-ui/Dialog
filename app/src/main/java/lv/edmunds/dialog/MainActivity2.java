package lv.edmunds.dialog;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void btnBack(View v) {
        finish();
        //Toast.makeText(MainActivity2.this, " checked", Toast.LENGTH_LONG).show();
    }

}
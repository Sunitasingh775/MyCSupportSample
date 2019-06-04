package com.coppermobile.mycsupportsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = findViewById(R.id.simple_textview);
        final EditText etNumber = findViewById(R.id.et_number);
        Button btCheck = findViewById(R.id.bt_check);

        tv.setText(stringFromJNI());
        btCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = etNumber.getText().toString();
                if (!number.isEmpty()) {
                    int no = Integer.parseInt(number);
                    if (isPrime(no)) {
                        Toast.makeText(MainActivity.this, "Prime Number", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Not Prime Number", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    public native boolean isPrime(int t);
}

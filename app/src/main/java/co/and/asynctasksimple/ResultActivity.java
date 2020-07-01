package co.and.asynctasksimple;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
private TextView txResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txResult = findViewById(R.id.txResult);
        String nameUser = getIntent().getStringExtra("user");
        txResult.setText("Welcome" + " " + nameUser);
    }
}
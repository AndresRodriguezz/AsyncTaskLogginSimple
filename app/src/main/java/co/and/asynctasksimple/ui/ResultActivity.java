package co.and.asynctasksimple.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import co.and.asynctasksimple.R;
import co.and.asynctasksimple.viewmodel.UserViewModel;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
private TextView txResult;
UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txResult = findViewById(R.id.txResult);
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        String userName = getIntent().getStringExtra("user");
        userViewModel.setName(userName);

        txResult.setText(userViewModel.getName());


    }
}
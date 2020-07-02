package co.and.asynctasksimple.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import co.and.asynctasksimple.task.AsyncTaskUSer;
import co.and.asynctasksimple.Comunication;
import co.and.asynctasksimple.R;
import co.and.asynctasksimple.User;
import co.and.asynctasksimple.viewmodel.UserViewModel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Comunication {
   public EditText etName,etPassword;
   public Button btOkay;
   public ProgressBar progressBar;

   User user;
   UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        etName = findViewById(R.id.etName);
        etPassword = findViewById(R.id.etPassword);
        btOkay = findViewById(R.id.btOk);
        progressBar = findViewById(R.id.progressBar);

        btOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user = new User();
                user.setName(etName.getText().toString());
                user.setPassword(etPassword.getText().toString());

                userViewModel.setName(user.getName());

                Toast.makeText(MainActivity.this, "" + userViewModel.getName(), Toast.LENGTH_SHORT).show();

                new AsyncTaskUSer(MainActivity.this).execute(etName.getText().toString(),
                        etPassword.getText().toString(),3000);
            }
        });
    }


    @Override
    public void progressBar(Boolean status) {
        if(status){
            progressBar.setVisibility(View.VISIBLE);
        }else {
            progressBar.setVisibility(View.GONE);
        }

    }

    @Override
    public void launchActivity(Class<?> kindActivity) {
        Intent mIntent = new Intent (this,kindActivity);
        mIntent.putExtra("user",user.getName());
        startActivity(mIntent);

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, "Information: "+ message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void visibleButton(Boolean visible) {
        if(visible){
            btOkay.setEnabled(true);
        }else{
            btOkay.setEnabled(false);
        }
    }
}
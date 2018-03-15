package com.firebase.admin.authentication;

import android.app.ProgressDialog;
import android.media.MediaCodec;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.net.PasswordAuthentication;
import java.util.regex.Pattern;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void Sign_up(View view) {

        EditText email  = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);

        if (Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches())
        {

        }
        else {
            Toast.makeText(Main2Activity.this, "invalid email syntax", Toast.LENGTH_SHORT).show();
            return;

        }

    if (password.length() >= 8 && password.length() < 33  )

    {
    }
    else {
            Toast.makeText(Main2Activity.this ,"password must be between 8 to 32 characters",Toast.LENGTH_SHORT ).show();
            return;
    }
        final ProgressDialog progress_bar = new ProgressDialog(Main2Activity.this);
        progress_bar.setTitle("please wait");
        progress_bar.setMessage("Creating account...");
        progress_bar.show();

    FirebaseAuth auth = FirebaseAuth.getInstance();
        OnCompleteListener<AuthResult>listener = new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progress_bar.hide();
                if (task.isSuccessful()) {
                    Toast.makeText(Main2Activity.this, "done", Toast.LENGTH_SHORT).show();
                }
                else

                {
                    Toast.makeText(Main2Activity.this, "error try again", Toast.LENGTH_SHORT).show();

                }

            }



        };
        auth.createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnCompleteListener(listener);

}
                }



package org.techtown.sns_example;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignupActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private static final String TAG=".SigninActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();


       findViewById(R.id.btn_signup).setOnClickListener(onClickListener);
       findViewById(R.id.btn_gotologin).setOnClickListener(onClickListener);

    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

    }
    @Override public  void onBackPressed()
    {
        super.onBackPressed();

    }

    private void signup() {
        String email = ((EditText) findViewById(R.id.tv_id)).getText().toString();
        String password = ((EditText) findViewById(R.id.tv_pw)).getText().toString();
        String passwordcheck = ((EditText) findViewById(R.id.tv_cpw)).getText().toString();
        if (email.length() > 0 && password.length() > 0 && passwordcheck.length() > 0) {
            if (password.equals(passwordcheck)) {
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    startToast("success");
                                    MystartActivity(MainActivity.class);

                                } else {
                                    if (task.getException() != null) {
                                        startToast(task.getException().toString());
                                    }
                                    // If sign in fails, display a message to the user.

                                }

                                // ...
                            }
                        });
            } else {
                startToast("pw and cpw is not same");
            }
        }
        else
            {
                startToast("black statement exist");
            }
        }


    private void startToast(String msg)
    {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }


    View.OnClickListener onClickListener =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_signup:
                    signup();
                    break;
                case R.id.btn_gotologin:
                    Log.e("wow","클릭됨");
                    MystartActivity(LoginActivity.class);
                    break;

            }
        }
    };

    private void MystartActivity(Class c){
        Intent intent = new Intent(this,c);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

}

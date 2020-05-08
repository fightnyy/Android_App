package org.techtown.sns_example;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Arrays;

public class MemberinitActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private static final String TAG=".LoginActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_init);


        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();


        findViewById(R.id.btn_check).setOnClickListener(onClickListener);

    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

    }

    public void profileUpdate()
    {
        String name=((EditText)findViewById(R.id.name)).getText().toString();
        String phonenumber=((EditText)findViewById(R.id.phonenumber)).getText().toString();
        String birthday=((EditText)findViewById(R.id.birthday)).getText().toString();
        String address=((EditText)findViewById(R.id.address)).getText().toString();

        if(name.length()>0&&phonenumber.length()>8&&birthday.length()>8&&address.length()>0) {
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();//uid갖게 하려면 있어야 함
            FirebaseFirestore db = FirebaseFirestore.getInstance();

            MemberInfo memberInfo = new MemberInfo(name, phonenumber, birthday, address);

            if (user != null) {
                db.collection("users").document(user.getUid()).set(memberInfo).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                    startToast("성공띠");
                    finish();
                    }
                })
                        .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        startToast("실패");
                    }
                });

            }
        }
        else {
            startToast("재입력 ㄱㄱ");
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
                case R.id.btn_check:
                    profileUpdate();
                    break;

            }
        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}

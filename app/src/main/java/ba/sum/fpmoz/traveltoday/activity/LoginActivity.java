package ba.sum.fpmoz.traveltoday.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import ba.sum.fpmoz.traveltoday.R;

public class LoginActivity extends AppCompatActivity {

    private TextView textViewRegister, textViewForgotPassword;

    private EditText emailEditText, passwordEditText;
    private Button buttonLogin;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textViewRegister = findViewById(R.id.textViewRegister);
        textViewForgotPassword = findViewById(R.id.textViewForgotPassword);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        buttonLogin = findViewById(R.id.buttonLogin);

        auth = FirebaseAuth.getInstance();

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String pass = passwordEditText.getText().toString();
                if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    if (!pass.isEmpty()) {
                        auth.signInWithEmailAndPassword(email, pass)
                                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                    @Override
                                    public void onSuccess(AuthResult authResult) {
                                        Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(LoginActivity.this, BottomBarActivity.class));
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    } else {
                        passwordEditText.setError("Empty fields are not allowed");
                    }
                } else if (email.isEmpty()) {
                    emailEditText.setError("Empty fields are not allowed");
                } else {
                    emailEditText.setError("Please enter correct email");
                }
            }
        });


        textViewRegister.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
            startActivity(intent);
        });

        textViewForgotPassword.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), ForgotPasswordActivity.class);
            startActivity(intent);
        });


    }
}

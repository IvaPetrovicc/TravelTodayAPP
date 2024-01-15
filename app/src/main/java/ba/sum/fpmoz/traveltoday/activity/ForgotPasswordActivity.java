package ba.sum.fpmoz.traveltoday.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import ba.sum.fpmoz.traveltoday.R;

public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText emailEditText;
    private Button buttonSendEmail;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        emailEditText = findViewById(R.id.emailEditText);
        buttonSendEmail = findViewById(R.id.buttonSendEmail);

        auth = FirebaseAuth.getInstance();

        buttonSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString().trim();
                if (!email.isEmpty()) {
                    resetPassword(email);
                } else {
                    Toast.makeText(ForgotPasswordActivity.this, "Enter your email address", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void resetPassword(String email) {
        auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(ForgotPasswordActivity.this, "Password reset email sent", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(ForgotPasswordActivity.this, "Error sending password reset email", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}


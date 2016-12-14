package com.epicodus.bitflip.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.bitflip.R;

import butterknife.Bind;
import butterknife.ButterKnife;

import static java.net.Proxy.Type.HTTP;

public class EmailOwnerActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.emailSubjectEditText) EditText mEmailSubjectEditText;
    @Bind(R.id.emailContentEditText) EditText getmEmailContentEditText;
    @Bind(R.id.sendEmailButton) Button mSendEmailButton;

    private String emailAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_owner);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        emailAddress = intent.getStringExtra("email");

        mSendEmailButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mSendEmailButton) {
            String emailSubject = mEmailSubjectEditText.getText().toString();
            String emailContent = getmEmailContentEditText.getText().toString();
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            String title = "Email with: ";
            emailIntent.setType("text/plain");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, emailAddress);
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
            emailIntent.putExtra(Intent.EXTRA_TEXT, emailContent);
            Intent chooser = Intent.createChooser(emailIntent, title);
            if (emailIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(chooser);
            }
        }
    }
}

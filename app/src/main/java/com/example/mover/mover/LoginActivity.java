package com.example.mover.mover;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.ContentResolver;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
//TODO: Add sign up functionality
public class LoginActivity extends AppCompatActivity {

    private EditText userNameText;
    private EditText passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userNameText = (EditText) findViewById(R.id.userNameText);
        passwordText = (EditText) findViewById(R.id.passwordText);

    }

    //TODO: Authenticate User
    private void attemptLogin() {

        // Store values at the time of the login attempt.
        String email = userNameText.getText().toString();
        String password = passwordText.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!isPasswordValid(password)) {
            passwordText.setError(Html.fromHtml("<font color='red'>Invalid Password</font>"));
            focusView = passwordText;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
           userNameText.setError(Html.fromHtml("<font color='red'>This Filed is Required</font>"));
            focusView = userNameText;
            cancel = true;
        } else if (!isEmailValid(email)) {
            userNameText.setError(Html.fromHtml("<font color='red'>Invalid Email</font>"));
            focusView = userNameText;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            //Go to main activity
            Intent k = new Intent(this, MainActivity.class);
            startActivity(k);
        }
    }

    private void signup() {
        Intent k = new Intent(this, signupActivity.class);
        startActivity(k);

    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

}


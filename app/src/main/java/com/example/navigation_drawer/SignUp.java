package com.example.navigation_drawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.navigation_drawer.GlobalClass;
import com.example.navigation_drawer.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SignUp extends AppCompatActivity {
    //region Description of Views
    private TextView dp;
    private TextInputLayout Email_layout,Password_layout;
    private TextInputEditText Email,Password;
    private String username, password, name;
    private Button signin;
    boolean isEmailValid, isPasswordValid;
    private CheckBox saveLoginCheckBox;
    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;
    private Boolean saveLogin;
    GlobalClass globalClass = new GlobalClass();  //GlobalClass's Gradient_function parameter passing flow(view,orientation,colors,corner_radius,stroke_width,stroke_color
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        init();                             //Initialize all Views
        dp_shape();                         //Handle shape of dp
        signin_button_before();             //SignIn button before filling data
        textlistner();                      //Add textListeners to views


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                store_data(v);                                     //On click listener for SignIn whether to
                                                                   // save username and password or not and link to another activity
            }
        });

        saveLogin = loginPreferences.getBoolean("saveLogin", false);              //Get saveLogin value from SharedPref
        if (saveLogin == true) {
            Email.setText(loginPreferences.getString("username", ""));            //Get username from SharedPref
            Password.setText(loginPreferences.getString("password", ""));         //Get password from SharedPref
            saveLoginCheckBox.setChecked(true);
        }
    }

    //region Description: Initialisation of views
    private void init() {
        dp = (TextView) findViewById(R.id.dp);
        signin = (Button) findViewById(R.id.signin);
        Email_layout = (TextInputLayout) findViewById(R.id.emailfill_layout);
        Email = (TextInputEditText) findViewById(R.id.emailfill);
        Password = (TextInputEditText) findViewById(R.id.passwordfill);
        Password_layout = (TextInputLayout) findViewById(R.id.password_layout);
        saveLoginCheckBox = (CheckBox) findViewById(R.id.remember);
        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();
    }
    //endregion

    private void dp_shape() {
        int[] colors = {Color.parseColor("#f8f8f8"), Color.parseColor("#f8f8f8")};
        globalClass.Gradient_function(dp, 1, colors, 200, 1, "#dddddd");
    }

    private void signin_button_before() {
        int[] colors = {Color.parseColor("#d1d1d1"), Color.parseColor("#d1d1d1")};
        globalClass.Gradient_function(signin, 1, colors, 10, 0, null);
        signin.setEnabled(false);
    }

    private void signin_button_after() {
        int[] colors = {Color.parseColor("#077f7b"), Color.parseColor("#077f7b")};
        globalClass.Gradient_function(signin, 1, colors, 10, 0, null);
        signin.setEnabled(true);
    }

   /* //region Description : Link this activity to Upload_Image activity
    private void next_page(){
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = Email.getText().toString().trim();
                Intent i = new Intent(SignUp.this, NavigationDrawer2Activity.class);
                i.putExtra("message_key", name);
                startActivity(i);
            }
        });
    }
    //endregion*/

    //region Description: Adding Textlistners
    private void textlistner() {
        Email.addTextChangedListener(tw);
        Password.addTextChangedListener(tw);
    }
    //endregion

    //region Description : Creating TextWatcher function for Email and Password
    private TextWatcher tw = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (Email.getText().toString().isEmpty()) {
                Email_layout.setError("Enter Email");
                isEmailValid = false;
            } else if (!Patterns.EMAIL_ADDRESS.matcher(Email.getText().toString()).matches()) {
                Email_layout.setError("Enter Valid Email");
                isEmailValid = false;
            } else {
                Email_layout.setErrorEnabled(false);
                isEmailValid = true;
            }
            if (Password.getText().toString().length() == 0) {
                Password_layout.setError("Enter Password");
                isPasswordValid = false;
            } else if (Password.getText().toString().length() < 8) {
                Password_layout.setError("Enter Valid Password");
                isPasswordValid = false;
            } else {
                Password_layout.setErrorEnabled(false);
                isPasswordValid = true;
            }
            if (isEmailValid && isPasswordValid) {          //Condition Check for SignIn
                signin_button_after();                         //Set SignIn button enabled

            } else
                signin_button_before();                     //Set SignIn button disabled
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };
    //endregion

    //region Description: Store Data in Shared Preferences
    public void store_data(View view) {
        if (view == signin) {
            /*InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(Email.getWindowToken(), 0);*/

            username = Email.getText().toString();           //Store Username
            password = Password.getText().toString();        //Store Password

            if (saveLoginCheckBox.isChecked()) {
                loginPrefsEditor.putBoolean("saveLogin", true);         //Set saveLogin to true in SharedPref
                loginPrefsEditor.putString("username", username);       //Set Username in Sharedpref
                loginPrefsEditor.putString("password", password);       //Set Password in Sharedpref
                loginPrefsEditor.commit();
                Toast.makeText(SignUp.this, "Hogya", Toast.LENGTH_SHORT).show();

            } else {
                loginPrefsEditor.clear();
                loginPrefsEditor.commit();             //Clear all things from SharedPref
            }
            name = Email.getText().toString().trim();
            Intent i = new Intent(SignUp.this, NavigationDrawer2Activity.class);      //Start new activity of navigation_drawer
            i.putExtra("message_key", name);
            startActivity(i);
        }
    }
    //endregion
}
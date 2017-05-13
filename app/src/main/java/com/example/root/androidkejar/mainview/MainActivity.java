package com.example.root.androidkejar.mainview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.root.androidkejar.R;
import com.example.root.androidkejar.interactor.InterfaceMain;
import com.example.root.androidkejar.interactor.InterfacePresenter;

public class MainActivity extends AppCompatActivity implements InterfaceMain {

    private EditText mTxtusername, mTxtpassword;
    private Button mButtonLogin;
    private InterfacePresenter mInterfacePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTxtusername = (EditText)findViewById(R.id.edtUsername);
        mTxtpassword = (EditText)findViewById(R.id.edtPassword);
        mButtonLogin = (Button)findViewById(R.id.btnLogin);

        mInterfacePresenter = new MainPresenter(this);

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mInterfacePresenter.login(mTxtusername.getText().toString(),
                        mTxtpassword.getText().toString());
            }
        });
    }


    @Override
    public void showError() {

    }

    @Override
    public void messageError() {
        Toast.makeText(this,"Username atau Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginError() {
        Toast.makeText(this, "Username atau Password salah", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {
//        Toast.makeText(this, "Berhasil Loggin", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        intent.putExtra("username",mTxtusername.getText().toString());
        startActivity(intent);
    }
}

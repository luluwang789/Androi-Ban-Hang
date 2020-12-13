package com.example.trana.cuahangthietbionline.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.trana.cuahangthietbionline.Connnect.Server;
import com.example.trana.cuahangthietbionline.R;
import com.google.common.base.Strings;

import java.util.HashMap;
import java.util.Map;

public class KhachHangActivity extends AppCompatActivity {

    EditText edtmk,edtho,edtten,edtdiachi,edtemail,edtsdt;
    Button btnLuu;
    Toolbar toolbarlt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khach_hang);
        Anhxxa();
        Actiontoolbar();
        Load();
        btnLuu = findViewById(R.id.buttondangkytaikhoan);
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                capnhapkhachhang();
            }
        });
    }
    public void Actiontoolbar() {
        setSupportActionBar(toolbarlt);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarlt.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void Load() {
        edtho.setText(DangNhapActivity.khackHang.getHo());
        edtten.setText(DangNhapActivity.khackHang.getTen());
        edtmk.setText(DangNhapActivity.khackHang.getPass());
        edtemail.setText(DangNhapActivity.khackHang.getEmail());
        edtsdt.setText(DangNhapActivity.khackHang.getSdt());
        edtdiachi.setText(DangNhapActivity.khackHang.getDiachi());
    }

    public void Anhxxa(){
        edtdiachi = findViewById(R.id.edittextsodiachi);
        edtho = findViewById(R.id.edittexthodangky);
        edtten =findViewById(R.id.edittextTendangky);
        edtemail = findViewById(R.id.edittextemail);
        edtsdt = findViewById(R.id.edittextsodienthoaidangky);
        edtmk = findViewById(R.id.edittextmatkhau);
        btnLuu = findViewById(R. id.buttondangkytaikhoan);
        toolbarlt = findViewById(R.id.toolbar2);
    }
    private void capnhapkhachhang(){
        final RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest=new StringRequest(Request.Method.POST, Server.capnhatkhachhang, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response=="error"){
                    Toast.makeText(getApplication(), "Cập Nhật Không Thành Công", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplication(), "Cập Nhật Thành Công", Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> param=new HashMap<String, String>();
                param.put("MaTaiKhoan",String.valueOf(DangNhapActivity.id));
                param.put("diachi",edtdiachi.getText().toString().trim());
                param.put("ho",edtho.getText().toString().trim());
                param.put("ten",edtten.getText().toString().trim());
                param.put("sdt",edtsdt.getText().toString().trim());
                param.put("email",edtemail.getText().toString().trim());
                return param;
            }
        };
        requestQueue.add(stringRequest);



    }
}
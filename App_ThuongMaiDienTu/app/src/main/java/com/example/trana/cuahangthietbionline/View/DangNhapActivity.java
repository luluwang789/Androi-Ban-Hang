package com.example.trana.cuahangthietbionline.View;

import android.content.Intent;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.trana.cuahangthietbionline.Connnect.CheckConnection;
import com.example.trana.cuahangthietbionline.Model.KhackHang;
import com.example.trana.cuahangthietbionline.Model.Sanpham;
import com.example.trana.cuahangthietbionline.R;
import com.example.trana.cuahangthietbionline.Connnect.Database;
import com.example.trana.cuahangthietbionline.Connnect.Server;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class DangNhapActivity extends AppCompatActivity {
    public static Database database;
    Button bttdangnhap,bttdangky;
    EditText   edtTenDN,edtMK;
    private TextView txtvcanhbao;
    public  int count=0;
    public static int id=0;
    public static KhackHang khackHang;
    private String ten,ho,diachi,sdt,email,matkhau,gioitinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        anhxa();
        bttdangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),DangKyActivity.class));
                finish();
            }
        });

        bttdangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tendn=edtMK.getText().toString().trim();
                String mk=edtTenDN.getText().toString().trim();
                if(tendn.length()>0 && mk.length()>0){
                     kiemtrataikhoan(); //mở khóa
                }else{

                    txtvcanhbao.setText("!!! Vui Lòng Điền Đầy Đủ Thông Tin");
                }
            }
        });

    }
    public  void kiemtrataikhoan() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String duongdan = Server.kiemtrataikhoan;
        StringRequest stringRequest = new StringRequest(Request.Method.POST, duongdan, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                    try {
                        Log.i("tagdangnhap", "[" + response + "]");
                        JSONArray jsonArray = new JSONArray(response);
                        Log.d("mangjson", jsonArray.toString());
                        ho = "";
                        ten = "";
                        sdt = "";
                        email = "";
                        diachi = "";
                        matkhau = "";
                        gioitinh = "";
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            id = jsonObject.getInt("MaTaiKhoan");
                            ho = jsonObject.getString("ho");
                            ten = jsonObject.getString("ten");
                            email = jsonObject.getString("email");
                            //matkhau=jsonObject.getString("MatKhau");
                            sdt = jsonObject.getString("sdt");
                            diachi = jsonObject.getString("diachi");
                            //gioitinh=jsonObject.getString("GioiTinh");
                            khackHang = new KhackHang(id, ho, ten, sdt, email, matkhau, diachi, gioitinh);
                            Intent intent = new Intent(DangNhapActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                        CheckConnection.ShowToast_short(getApplicationContext(), e.getMessage());
                    }
            }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(DangNhapActivity.this,"Lỗi Xảy Ra: " +error.getMessage(),Toast.LENGTH_LONG).show();
                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    HashMap<String, String> param = new HashMap<String, String>();
                    param.put("taikhoan",edtTenDN.getText().toString().trim());
                    param.put("matkhau",edtMK.getText().toString().trim());
                    return param;
                }
            };
            requestQueue.add(stringRequest);
    }
    public void anhxa(){
        txtvcanhbao=findViewById(R.id.textviewcanhbaodangnhap);
        bttdangky=findViewById(R.id.buttondangky);
        bttdangnhap=findViewById(R.id.buttondangnhap);
        edtMK=findViewById(R.id.edittextmatkhau);
        edtTenDN=findViewById(R.id.edittexttendangnhap);
    }
}

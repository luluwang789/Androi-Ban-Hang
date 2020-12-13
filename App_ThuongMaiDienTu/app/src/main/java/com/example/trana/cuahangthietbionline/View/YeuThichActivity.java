package com.example.trana.cuahangthietbionline.View;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.trana.cuahangthietbionline.Adapter.GioHangAdapter;
import com.example.trana.cuahangthietbionline.Adapter.LapTopAdapter;
import com.example.trana.cuahangthietbionline.Adapter.YeuThichAdapter;
import com.example.trana.cuahangthietbionline.Connnect.CheckConnection;
import com.example.trana.cuahangthietbionline.Connnect.Server;
import com.example.trana.cuahangthietbionline.Model.Giohang;
import com.example.trana.cuahangthietbionline.Model.Sanpham;
import com.example.trana.cuahangthietbionline.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class YeuThichActivity extends AppCompatActivity {

    public static ListView lvYeuThich;
    public static YeuThichAdapter adapter;
    public static View footerview;
    public static boolean limitdata=false;
    private int idlt=0;
    Toolbar toolbarlt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yeu_thich);
        lvYeuThich = findViewById(R.id.lvYeuThich);
        toolbarlt =findViewById(R.id.toolbar);
        Actiontoolbar();
        adapter=new YeuThichAdapter(YeuThichActivity.this,MainActivity.mangyeuthich);
        lvYeuThich.setAdapter(adapter);
        if(MainActivity.mangyeuthich!=null){
            MainActivity.mangyeuthich.clear();
        }
        RequestQueue requestQueue=Volley.newRequestQueue(getApplicationContext());
        String duongdan=Server.laymangyeuthich;
        StringRequest stringRequest=new StringRequest(Request.Method.POST, duongdan, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response!=null && response.length() != 2){
                    lvYeuThich.removeFooterView(footerview); //có dữ liệu thì sẽ mất biểu tưởng load
                    try {
                        Log.i("tagconvertstr", "["+response+"]");
                        JSONArray jsonArray = new JSONArray(response);
                        Log.d("mangjson",jsonArray.toString());
                        for(int i=0;i<jsonArray.length();i++){
                            JSONObject jsonObject=jsonArray.getJSONObject(i);
                            MainActivity.mangyeuthich.add(new Sanpham(jsonObject.getInt("id")
                                    ,jsonObject.getString("tensp")
                                    ,jsonObject.getInt("giasp")
                                    ,jsonObject.getString("hinhanhsp")
                                    ,jsonObject.getString("motasp")
                                    ,jsonObject.getInt("idsanpham")));
                        }
                        adapter=new YeuThichAdapter(YeuThichActivity.this,MainActivity.mangyeuthich);
                        lvYeuThich.setAdapter(adapter);
                        //adapter.notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.printStackTrace();
                        CheckConnection.ShowToast_short(getApplicationContext(),e.getMessage());
                    }
                }else{
                    limitdata=true;
                    lvYeuThich.removeFooterView(footerview);
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
                param.put("idtaikhoan",String.valueOf(DangNhapActivity.id));
                return param;
            }
        };
        requestQueue.add(stringRequest);
        //Xem thong tin chi tiec cua san pham yeu thich
        lvYeuThich.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getApplicationContext(),ChiTiecSanPham.class);
                intent.putExtra("thongtinsanpham",MainActivity.mangyeuthich.get(position));
                startActivity(intent);
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
}

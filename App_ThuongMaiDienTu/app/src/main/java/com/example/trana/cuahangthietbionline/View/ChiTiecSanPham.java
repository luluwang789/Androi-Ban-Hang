package com.example.trana.cuahangthietbionline.View;

import android.content.Intent;

import android.os.Bundle;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.trana.cuahangthietbionline.Connnect.CheckConnection;
import com.example.trana.cuahangthietbionline.Connnect.Server;
import com.example.trana.cuahangthietbionline.Model.Sanpham;
import com.example.trana.cuahangthietbionline.R;
import com.example.trana.cuahangthietbionline.Model.Giohang;

import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class ChiTiecSanPham extends AppCompatActivity {
    private TextView txtten,txtgia,txtnmota;
    private ImageView imghinh;
    private Toolbar toolbar;
    private ImageButton bttthem,btnyeuthich;
    private Spinner spinner;
    public int id=0;
    public String TenChiTiec="";
    public int GiaChitiec=0;
    public String hinhanhchitiec="";
    public String MoTachitiec="";
    public int idsanpham=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiec_san_pham);
        Anhxa();
        Actiontoolbar();
        Getdata();
        CathEventSpinner();
        EventButtonGioHang();
        EventButtonYeuThich();

    }

    private void EventButtonYeuThich() {
        btnyeuthich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int flag = (Integer) btnyeuthich.getTag();
                if(flag==0){
                    final RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
                    StringRequest stringRequest=new StringRequest(Request.Method.POST, Server.laythongtinyeuthich, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.d("yeuthich",response);
                            if(response.equals("success")){
                                btnyeuthich.setBackgroundResource(R.drawable.ic_favorite);
                                btnyeuthich.setTag(1);
                                CheckConnection.ShowToast_short(getApplicationContext(),"Bạn đã thêm thành công");
                            }else{
                                CheckConnection.ShowToast_short(getApplicationContext(),"Dữ liệu của bạn đã bị lỗi");
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            HashMap<String,String> hashMap=new HashMap<String,String>();
                            hashMap.put("idtaikhoan",String.valueOf(DangNhapActivity.id));
                            hashMap.put("idsanpham",String.valueOf(id));
                            return hashMap;
                        }
                    };
                    requestQueue.add(stringRequest);
                }else{
                    final RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
                    StringRequest stringRequest=new StringRequest(Request.Method.POST, Server.xoaspyeuthich, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.i("tagconverxoa", "["+response+"]");
                            if(response.equals("success")){
                                btnyeuthich.setBackgroundResource(R.drawable.ic_favorite_border);
                                btnyeuthich.setTag(0);
                                CheckConnection.ShowToast_short(getApplicationContext(),"Bạn đã xoá sản phẩm thành công");
                            }else{
                                CheckConnection.ShowToast_short(getApplicationContext(),"Dữ liệu của bạn đã bị lỗi");
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            HashMap<String,String> hashMap=new HashMap<String,String>();
                            hashMap.put("idtaikhoan",String.valueOf(DangNhapActivity.id));
                            hashMap.put("idsanpham",String.valueOf(id));
                            return hashMap;
                        }
                    };
                    requestQueue.add(stringRequest);
                }
            }
        });
    }
    private void EventButtonGioHang() {
        bttthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.manggiohang.size()>0){
                    int sl=Integer.parseInt(spinner.getSelectedItem().toString());
                    boolean exits=false;
                    for(int i=0;i<MainActivity.manggiohang.size();i++){
                        if(MainActivity.manggiohang.get(i).getIdsp() == id){
                            MainActivity.manggiohang.get(i).setSoluongsp(MainActivity.manggiohang.get(i).getSoluongsp()+sl);
                            if(MainActivity.manggiohang.get(i).getSoluongsp()>10){
                                MainActivity.manggiohang.get(i).setSoluongsp(10);
                            }
                            MainActivity.manggiohang.get(i).setGiasp(GiaChitiec*MainActivity.manggiohang.get(i).getSoluongsp());
                            exits=true;
                        }
                    }
                    if(exits==false){
                        int soluong=Integer.parseInt(spinner.getSelectedItem().toString());
                        long giamoi1=soluong*GiaChitiec;
                        MainActivity.manggiohang.add(new Giohang(id,TenChiTiec,giamoi1,hinhanhchitiec,soluong));
                    }
                }else{
                    int soluong=Integer.parseInt(spinner.getSelectedItem().toString());
                    long giamoi=soluong*GiaChitiec;
                    MainActivity.manggiohang.add(new Giohang(id,TenChiTiec,giamoi,hinhanhchitiec,soluong));
                }
                Intent intent=new Intent(getApplicationContext(),GioHang.class);
                startActivity(intent);
            }

        });
    }

    private void CathEventSpinner() {
        Integer[] soluong=new Integer[]{1,2,3,4,5,6,7,8,9,10};
        ArrayAdapter<Integer> arrayAdapter=new ArrayAdapter<Integer>(this,R.layout.support_simple_spinner_dropdown_item,soluong);
        spinner.setAdapter(arrayAdapter);
    }

    private void Getdata() {
        Sanpham sanpham= (Sanpham) getIntent().getSerializableExtra("thongtinsanpham");
        id=sanpham.getID();
        TenChiTiec=sanpham.getTensanpham();
        GiaChitiec=sanpham.getGiasanpham();
        hinhanhchitiec=sanpham.getHinhanhsanpham();
        MoTachitiec=sanpham.getMotasanpham();
        idsanpham=sanpham.getIDsanpham();
        int gia=sanpham.getGiasanpham();
        txtten.setText(sanpham.getTensanpham());
        txtnmota.setText(sanpham.getMotasanpham());
        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
        txtgia.setText("Gía "+decimalFormat.format(gia)+" đ");
        Picasso.with(getApplicationContext()).load(sanpham.getHinhanhsanpham())
                .placeholder(R.drawable.imageico)
                .error(R.drawable.error)
                .into(imghinh);
        btnyeuthich.setTag(0);
        for(int i=0;i<MainActivity.mangyeuthich.size();++i){
            if(sanpham.ID==MainActivity
                    .mangyeuthich.get(i).ID){
                btnyeuthich.setBackgroundResource(R.drawable.ic_favorite);
                btnyeuthich.setTag(1);
                break;
            }
        }
    }

    public void Actiontoolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_trangchinh,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menugiohang :
                Intent intent=new Intent(getApplicationContext(),GioHang.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void Anhxa() {
        spinner=(Spinner)findViewById(R.id.spinner);
        toolbar=(Toolbar)findViewById(R.id.toolbarchitiecsanpham);
        txtgia=(TextView)findViewById(R.id.textviewgiachitiec);
        txtnmota=(TextView)findViewById(R.id.textviewmotachitiec);
        txtten=(TextView)findViewById(R.id.textviewtenchitiec);
        imghinh=(ImageView)findViewById(R.id.imageviewanhchitiec);
        bttthem=(ImageButton) findViewById(R.id.buttongiohang);
        btnyeuthich = findViewById(R.id.btnyeuthich);
    }
}

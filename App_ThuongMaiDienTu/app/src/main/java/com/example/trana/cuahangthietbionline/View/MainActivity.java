package com.example.trana.cuahangthietbionline.View;

import android.Manifest;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;

import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import android.provider.MediaStore;
import android.provider.Telephony;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.trana.cuahangthietbionline.Adapter.SanphamLoaiMoiNhatAdapter;
import com.example.trana.cuahangthietbionline.Adapter.SpLoaiMoiNhatLaptopAdapter;
import com.example.trana.cuahangthietbionline.R;
import com.example.trana.cuahangthietbionline.Adapter.LoaispAdapter;
import com.example.trana.cuahangthietbionline.Adapter.SanphamAdapter;
import com.example.trana.cuahangthietbionline.Adapter.girdviewsanpham;
import com.example.trana.cuahangthietbionline.Model.Giohang;
import com.example.trana.cuahangthietbionline.Model.Loaisp;
import com.example.trana.cuahangthietbionline.Model.Sanpham;
import com.example.trana.cuahangthietbionline.Connnect.CheckConnection;
import com.example.trana.cuahangthietbionline.Connnect.Server;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    private Toolbar toolbar;
    private ViewFlipper viewFlipper;
    private RecyclerView recyclerViewmanhinhchinh,recyclerViewdt,recyclerViewlaptop;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ArrayList<Loaisp> mangloaisp;
    private LoaispAdapter loaispAdapter;
    private int id = 0;
    private String tenloaisp = "";
    private String hinhanhloaisp = "";
    public static ArrayList<Sanpham> mangsanpham;
    public static ArrayList<Sanpham> mangdt,manglaptop;
    private SanphamAdapter sanphamAdapter;
    private SanphamLoaiMoiNhatAdapter sanphamAdapterdt;
    private SpLoaiMoiNhatLaptopAdapter sanphamAdapterlaptop;
    public static ArrayList<Giohang> manggiohang;
    public static ArrayList<Sanpham> mangyeuthich = new ArrayList<>();
    private TextView txtxemtatcadt,txtxemtatcalaptop,txtmainfullname;
    private static final int PICK_IMAGE = 222;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        if (CheckConnection.haveNetworkConnection(getApplicationContext())) {
            Log.d("tagggg",CheckConnection.haveNetworkConnection(getApplicationContext())+"");

            ActionBar();
            setupNavDrawer();
            DangNhap();
            ActionViewFlipper();
            GetDuLieuLoaisp();
            loadyeuthich();
            GetDuLieuSanPhamNew();
            recyclerview(1);
            recyclerview(2);
            ChangeIntent();
            FMC();
        } else {
            CheckConnection.ShowToast_short(getApplicationContext(), "Bạn Hãy Kiểm Tra Lại Kết Nối");
            finish();
        }

    }
    private void FMC() {
        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {
                            Log.d("gettokenfail","Lỗi");
                            return;
                        }
                        // Get new Instance ID token
                        String token = task.getResult().getToken();
                        Log.d("gettoken", token);
                    }
                });
        FirebaseMessaging.getInstance().subscribeToTopic("TopicName");

    }
    private void ChangeIntent() {
        txtxemtatcadt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CheckConnection.haveNetworkConnection(getApplicationContext())) {
                    Intent intent = new Intent(MainActivity.this, DienThoaiActivity.class);
                    intent.putExtra("idloaisanpham", mangloaisp.get(1).getId());
                    startActivity(intent);
                } else {
                    CheckConnection.ShowToast_short(getApplicationContext(), "Lỗi");
                }
            }
        });
        txtxemtatcalaptop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CheckConnection.haveNetworkConnection(getApplicationContext())) {
                    Intent intent = new Intent(MainActivity.this, LapTopActivity.class);
                    intent.putExtra("idloaisanpham", mangloaisp.get(2).getId());
                    startActivity(intent);
                } else {
                    CheckConnection.ShowToast_short(getApplicationContext(), "Lỗi");
                }
            }
        });
    }
    private void recyclerview(final int page) {
        final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.laysanphammoidt+String.valueOf(page), new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    int ID = 0;
                    String Tensanpham = "";
                    Integer Giasanpham = 0;
                    String Hinhanhsanpham = "";
                    String Motasanpham = "";
                    int IDsanpham = 0;
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            ID = jsonObject.getInt("id");
                            Tensanpham = jsonObject.getString("tensp");
                            Giasanpham = jsonObject.getInt("giasp");
                            Hinhanhsanpham = jsonObject.getString("hinhanhsp");
                            Motasanpham = jsonObject.getString("motasp");
                            IDsanpham = jsonObject.getInt("idsanpham");
                            if(page==1){
                                mangdt.add(new Sanpham(ID, Tensanpham, Giasanpham, Hinhanhsanpham, Motasanpham, IDsanpham));
                                sanphamAdapterdt.notifyDataSetChanged();
                            }
                           else{
                                manglaptop.add(new Sanpham(ID, Tensanpham, Giasanpham, Hinhanhsanpham, Motasanpham, IDsanpham));
                                sanphamAdapterlaptop.notifyDataSetChanged();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                CheckConnection.ShowToast_short(getApplicationContext(), error.toString());
                finish();
            }
        });
        requestQueue.add(jsonArrayRequest);

    }
    private void GetDuLieuSanPhamNew() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.duongdansanpham, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    int ID = 0;
                    String Tensanpham = "";
                    Integer Giasanpham = 0;
                    String Hinhanhsanpham = "";
                    String Motasanpham = "";
                    int IDsanpham = 0;
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            ID = jsonObject.getInt("id");
                            Tensanpham = jsonObject.getString("tensp");
                            Giasanpham = jsonObject.getInt("giasp");
                            Hinhanhsanpham = jsonObject.getString("hinhanhsp");
                            Motasanpham = jsonObject.getString("motasp");
                            IDsanpham = jsonObject.getInt("idsanpham");
                            mangsanpham.add(new Sanpham(ID, Tensanpham, Giasanpham, Hinhanhsanpham, Motasanpham, IDsanpham));
                            sanphamAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);
    }
    private void GetDuLieuLoaisp() {
        final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.locahost, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            tenloaisp = jsonObject.getString("tenLoaisp");
                            hinhanhloaisp = jsonObject.getString("hinhanhloaisp");
                            mangloaisp.add(new Loaisp(id, tenloaisp, hinhanhloaisp));
                            loaispAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    mangloaisp.add(3, new Loaisp(0, "Liên Hệ", "https://images.techhive.com/images/article/2016/06/ios-mail-icon-100669537-large.jpg"));
                    mangloaisp.add(4, new Loaisp(0, "Thông Tin", "https://st2.depositphotos.com/3369547/11386/v/950/depositphotos_113864336-stock-illustration-avatar-man-icon-people-design.jpg"));
                    mangloaisp.add(5, new Loaisp(0, "Thanh Toán", "https://previews.123rf.com/images/yupiramos/yupiramos1709/yupiramos170930979/87003099-manos-humanas-que-pagan-dinero-aislado-icono-vector-ilustraci%C3%B3n-dise%C3%B1o.jpg"));
                    mangloaisp.add(6, new Loaisp(0, "Yêu Thích", "https://images.techhive.com/images/article/2016/06/ios-mail-icon-100669537-large.jpg"));
                    mangloaisp.add(7, new Loaisp(0, "Đăng Xuất", "https://images.techhive.com/images/article/2016/06/ios-mail-icon-100669537-large.jpg"));
                    loaispAdapter.notifyDataSetChanged();

                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                CheckConnection.ShowToast_short(getApplicationContext(), error.toString());
                finish();
            }
        });
        requestQueue.add(jsonArrayRequest);

    }
    public void DangNhap(){
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);getIntent.setType("image/*");
                Intent pickIntent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                pickIntent.setType("image/*");
                Intent chooserIntent = Intent.createChooser(getIntent,
                        getString(R.string.app_name));
                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[]{pickIntent});
                startActivityForResult(chooserIntent, PICK_IMAGE);
            }
        });
        txtmainfullname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, DangNhapActivity.class);
                    startActivity(intent);
                    finish();
            }
        });

    }
    private void ActionViewFlipper() {
        ArrayList<String> mangquangcao = new ArrayList<>();
        mangquangcao.add("https://cdn.tgdd.vn/Files/2020/04/29/1252555/laptop_800x450.jpg");
        mangquangcao.add("https://cdn.tgdd.vn/Files/2020/04/28/1252375/laptople_800x450.jpg");
        mangquangcao.add("https://cdn.tgdd.vn/Files/2020/04/23/1251226/1200-628_800x450.png");
        mangquangcao.add("https://cdn.tgdd.vn/Files/2020/05/04/1253433/fb_800x449.png");
        for (int i = 0; i < mangquangcao.size(); i++) {
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.with(getApplicationContext()).load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
            viewFlipper.setAutoStart(true);
            Animation animation_slide_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_right);
            Animation animation_slide_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out_right);
            viewFlipper.setInAnimation(animation_slide_in);
            viewFlipper.setOutAnimation(animation_slide_out);
        }
    }
    private void ActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_menu);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_trangchinh, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menugiohang:
                Intent intent = new Intent(getApplicationContext(), GioHang.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    private void Anhxa() {
        toolbar = findViewById(R.id.toobarmanhinhchinh);
        viewFlipper = findViewById(R.id.viewlipper);
        navigationView = findViewById(R.id.navigationview);
        View header = navigationView.getHeaderView(0);
        imageView =  header.findViewById(R.id.main_profile_image);
        txtmainfullname = header.findViewById(R.id.main_fullname);
        drawerLayout = findViewById(R.id.drawerlayout);
        txtxemtatcadt = findViewById(R.id.txtxemtatcadt);
        txtxemtatcalaptop=findViewById(R.id.txtxemtatcalaptop);
        loaispAdapter = new LoaispAdapter(mangloaisp, getApplicationContext());
        mangloaisp = new ArrayList<>();
        mangloaisp.add(0, new Loaisp(0, "Trang Chính", "https://www.clipartmax.com/png/middle/72-724499_42487-house-with-garden-icon-house-emoji-transparent.png"));
        loaispAdapter = new LoaispAdapter(mangloaisp, getApplicationContext());
        mangsanpham=new ArrayList<>();
        recyclerViewmanhinhchinh = findViewById(R.id.recyclerviewmanhinhchinh);
        sanphamAdapter = new SanphamAdapter(this, mangsanpham);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        gridLayoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
        recyclerViewmanhinhchinh.setLayoutManager(gridLayoutManager);
        recyclerViewmanhinhchinh.setAdapter(sanphamAdapter);
        //Recyclerview mang dien thoai
        mangdt=new ArrayList<>();
        recyclerViewdt= findViewById(R.id.recyclerviewdienthoai);
        sanphamAdapterdt = new SanphamLoaiMoiNhatAdapter(this, mangdt);
        GridLayoutManager gridLayoutManagerdt = new GridLayoutManager(this, 2);
        gridLayoutManagerdt.setOrientation(GridLayoutManager.VERTICAL);
        recyclerViewdt.setLayoutManager(gridLayoutManagerdt);
        recyclerViewdt.setNestedScrollingEnabled(false);
        recyclerViewdt.setAdapter(sanphamAdapterdt);
        //Recyclerview mang lap top
        manglaptop=new ArrayList<>();
        recyclerViewlaptop= findViewById(R.id.recyclerviewlaptop);
        sanphamAdapterlaptop = new SpLoaiMoiNhatLaptopAdapter(this, manglaptop);
        GridLayoutManager gridLayoutManagerlaptop = new GridLayoutManager(this, 2);
        gridLayoutManagerlaptop.setOrientation(GridLayoutManager.VERTICAL);
        recyclerViewlaptop.setLayoutManager(gridLayoutManagerlaptop);
        recyclerViewlaptop.setNestedScrollingEnabled(false);
        recyclerViewlaptop.setAdapter(sanphamAdapterlaptop);

        if (manggiohang != null) {

        } else {
            manggiohang = new ArrayList<>();
        }
    }
    public void loadyeuthich() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String duongdan = Server.laymangyeuthich;
        StringRequest stringRequest = new StringRequest(Request.Method.POST, duongdan, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    Log.i("tagconvertstr", "[" + response + "]");
                    JSONArray jsonArray = new JSONArray(response);
                    Log.d("mangjson", jsonArray.toString());
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        mangyeuthich.add(new Sanpham(jsonObject.getInt("id")
                                , jsonObject.getString("tensp")
                                , jsonObject.getInt("giasp")
                                , jsonObject.getString("hinhanhsp")
                                , jsonObject.getString("motasp")
                                , jsonObject.getInt("idsanpham")));

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    CheckConnection.ShowToast_short(getApplicationContext(), e.getMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> param = new HashMap<String, String>();
                param.put("idtaikhoan", String.valueOf(DangNhapActivity.id));
                return param;
            }
        };
        requestQueue.add(stringRequest);
    }
    public void setupNavDrawer() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                final int menuItemId = menuItem.getItemId();
                switch (menuItemId) {
                    case R.id.nav_my_account:{
                        Intent intent = new Intent(MainActivity.this, KhachHangActivity.class);
                        MainActivity.this.startActivity(intent);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Toast.makeText(MainActivity.this, "Account", Toast.LENGTH_SHORT).show();
                        return true;
                    }
                    case R.id.nav_my_orders: {
                        Intent intent = new Intent(MainActivity.this, GioHang.class);
                        MainActivity.this.startActivity(intent);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;
                    }
                    case R.id.nav_my_rewrad: {
                        if (CheckConnection.haveNetworkConnection(MainActivity.this.getApplicationContext())) {
                            Intent intent = new Intent(MainActivity.this, SanPhamDaDat.class);
                            MainActivity.this.startActivity(intent);
                        } else {
                            CheckConnection.ShowToast_short(MainActivity.this.getApplicationContext(), "Lỗi");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;
                    }
                    case R.id.nav_my_wishlist: {
                        if (CheckConnection.haveNetworkConnection(MainActivity.this.getApplicationContext())) {
                            Intent intent = new Intent(MainActivity.this, YeuThichActivity.class);
                            MainActivity.this.startActivity(intent);
                        } else {
                            CheckConnection.ShowToast_short(MainActivity.this.getApplicationContext(), "Lỗi");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;
                    }
                    case R.id.nav_email:{
                        SendEmail();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;
                    }
                    case R.id.nav_call:{
                        if (isPermissionGranted()) {
                            call_action();
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;
                    }
                    case R.id.nav_location: {
                        if (CheckConnection.haveNetworkConnection(getApplicationContext())) {
                            Intent intent = new Intent(MainActivity.this, ThongTinActivity.class);
                            startActivity(intent);
                        } else {
                            CheckConnection.ShowToast_short(getApplicationContext(), "Lỗi");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;
                    }
                    case R.id.nav_sign_out:{
                        if (CheckConnection.haveNetworkConnection(getApplicationContext())) {
                            Intent intent = new Intent(MainActivity.this, DangNhapActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            CheckConnection.ShowToast_short(getApplicationContext(), "Lỗi");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;
                    }
                    default: {
                        return false;
                    }
                }

            }
        });

    }
    public void SendEmail() {
        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.layemail, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("error")) {
                    CheckConnection.ShowToast_short(MainActivity.this, "Lỗi");

                } else {

                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setType("message/rfc822");
                    intent.putExtra(Intent.EXTRA_EMAIL, response);
                    intent.setData(Uri.parse("mailto:" + "spaceteam.hcmue@gmail.com"));
                    intent.putExtra(Intent.EXTRA_SUBJECT, "");
                    intent.putExtra(Intent.EXTRA_TEXT, "");
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.addFlags(Intent.FLAG_FROM_BACKGROUND);
                    try {

                        startActivity(intent);
                    } catch (android.content.ActivityNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        Log.d("Email error:", e.toString());
                    }

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("MaTaiKhoan", String.valueOf(DangNhapActivity.id));
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
    public void call_action() {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            callIntent.setData(Uri.parse("tel:0918835917"));
        }else{
            isPermissionGranted();
        }
        startActivity(callIntent);
    }
    public  boolean isPermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.CALL_PHONE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v("TAG","Permission is granted");
                return true;
            } else {

                Log.v("TAG","Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                return false;
            }
        }
        else {
            //permission is automatically granted on sdk<23 upon installation
            Log.v("TAG","Permission is granted");
            return true;
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {

            case 1: {

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getApplicationContext(), "Permission granted", Toast.LENGTH_SHORT).show();
                    call_action();
                } else {
                    Toast.makeText(getApplicationContext(), "Permission denied", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK) {

            try {
                Uri imageUri = data.getData();
                final Bitmap photo = MediaStore.Images.Media.getBitmap(this.getContentResolver(),
                        imageUri);
                imageView.setImageBitmap(photo);
                // upload hinh
                final RequestQueue requestQueue=Volley.newRequestQueue(getApplicationContext());
                StringRequest stringRequest=new StringRequest(Request.Method.POST, Server.capnhathinh, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error+"", Toast.LENGTH_SHORT).show();
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        HashMap<String,String> param=new HashMap<String, String>();
                        param.put("MaTaiKhoan",String.valueOf(DangNhapActivity.id));
                        String image = getStringImage(photo);
                        param.put("hinh",image);
                        return param;
                    }
                };
                requestQueue.add(stringRequest);

            } catch (IOException e) {
                Toast.makeText(MainActivity.this, e.getMessage()+"", Toast.LENGTH_SHORT).show();
            }

            return;
        }

    }
    public String getStringImage(Bitmap bmp){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }
}

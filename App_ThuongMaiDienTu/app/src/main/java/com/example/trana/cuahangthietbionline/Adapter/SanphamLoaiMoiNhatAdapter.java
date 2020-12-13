package com.example.trana.cuahangthietbionline.Adapter;

import android.content.Context;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.trana.cuahangthietbionline.Model.Sanpham;
import com.example.trana.cuahangthietbionline.R;
import com.example.trana.cuahangthietbionline.View.ChiTiecSanPham;
import com.example.trana.cuahangthietbionline.View.MainActivity;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class SanphamLoaiMoiNhatAdapter extends RecyclerView.Adapter<SanphamLoaiMoiNhatAdapter.ItemHolder> {
    public Context context;
    public ArrayList<Sanpham> arraysanpham;

    public SanphamLoaiMoiNhatAdapter(Context context, ArrayList<Sanpham> arraysanpham) {
        this.context = context;
        this.arraysanpham = arraysanpham;
    }


    @Override
    public SanphamLoaiMoiNhatAdapter.ItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dong_sanphammoinhat,null);
        SanphamLoaiMoiNhatAdapter.ItemHolder itemHolder=new SanphamLoaiMoiNhatAdapter.ItemHolder(v);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(SanphamLoaiMoiNhatAdapter.ItemHolder itemHolder, final int i) {
        Sanpham sanpham=arraysanpham.get(i);
        itemHolder.txttensanpham.setText(sanpham.getTensanpham());
        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
        itemHolder.txtgiasanpham.setText(decimalFormat.format(sanpham.getGiasanpham())+" đ");
        Picasso.with(context).load(sanpham.getHinhanhsanpham())
                .placeholder(R.drawable.imageico)
                .error(R.drawable.error)
                .into(itemHolder.imghinhsanpham);
        itemHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context.getApplicationContext(), ChiTiecSanPham.class);
                intent.putExtra("thongtinsanpham", MainActivity.mangdt.get(i));
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return arraysanpham.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder{
        public ImageView imghinhsanpham;
        public TextView txttensanpham,txtgiasanpham;

        public ItemHolder(View itemView) {
            super(itemView);
            imghinhsanpham=(ImageView)itemView.findViewById(R.id.imageviewsanpham);
            txttensanpham=(TextView)itemView.findViewById(R.id.textviewtensanpham);
            txtgiasanpham=(TextView)itemView.findViewById(R.id.textviewgiasanpham);


        }
    }
}

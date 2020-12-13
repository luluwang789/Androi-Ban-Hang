package com.example.trana.cuahangthietbionline.Adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.trana.cuahangthietbionline.Model.Giohang;
import com.example.trana.cuahangthietbionline.Model.Sanpham;
import com.example.trana.cuahangthietbionline.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class YeuThichAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Sanpham> mangyeuthich;

    public YeuThichAdapter(Context context, ArrayList<Sanpham> mangyeuthich) {
        this.context = context;
        this.mangyeuthich = mangyeuthich;
    }

    @Override
    public int getCount() {
        return mangyeuthich == null ? 0  : mangyeuthich.size();
    }

    @Override
    public Object getItem(int position) {
        return mangyeuthich.get(position);
    }
    public static class  ViewHolder{
        public static TextView txttenyeuthich,txtgiayeuthich,txtmotayeuthich;
        public ImageView imgyeuthich;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(viewHolder==null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.dong_yeuthich,null);
            viewHolder.txttenyeuthich=convertView.findViewById(R.id.textviewtenyeuthich);
            viewHolder.txtgiayeuthich=convertView.findViewById(R.id.textviewgiayeuthich);
            viewHolder.imgyeuthich=convertView.findViewById(R.id.imageviewyeuthich);
            viewHolder.txtmotayeuthich=convertView.findViewById(R.id.textviewmotayeuthich);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Sanpham sanpham =(Sanpham) getItem(position);
        viewHolder.txttenyeuthich.setText(sanpham.getTensanpham());
        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
        viewHolder.txtgiayeuthich.setText("Gía: "+decimalFormat.format(sanpham.getGiasanpham())+" đ");
        Picasso.with(context).load(sanpham.getHinhanhsanpham())
                .placeholder(R.drawable.imageico)
                .error(R.drawable.error)
                .into(viewHolder.imgyeuthich);
        viewHolder.txtmotayeuthich.setMaxLines(2);
        viewHolder.txtmotayeuthich.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.txtmotayeuthich.setText(sanpham.getMotasanpham());
        return convertView;
    }
}

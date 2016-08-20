package com.week.app.app160806.mypage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.week.app.app160806.R;
import com.week.app.app160806.member.MemberBean;

import java.util.ArrayList;

public class MemberAdapter extends BaseAdapter {
    ArrayList<MemberBean> list;
    LayoutInflater inflater;
    int[] imgs = {
            R.drawable.cupcake,
            R.drawable.donut,
            R.drawable.eclair,
            R.drawable.froyo,
            R.drawable.gingerbread,
            R.drawable.honeycomb,
            R.drawable.icecream,
            R.drawable.jellybean,
            R.drawable.kitkat,
            R.drawable.lollipop
    };

    public MemberAdapter(Context context, ArrayList<MemberBean> list) {
        this.list = list;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View v, ViewGroup g) {
        ViewHolder holder; //holder는 쪼가리
        if (v == null) {
            v = inflater.inflate(R.layout.member_list, null);
            holder = new ViewHolder();
            holder.ivPhoto = (ImageView) v.findViewById(R.id.iv_photo);
            holder.tvName = (TextView) v.findViewById(R.id.tv_name);
            holder.tvPhone = (TextView) v.findViewById(R.id.tv_phone);
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }
        holder.ivPhoto.setImageResource(imgs[i]);
        holder.tvName.setText(list.get(i).getName());
        holder.tvPhone.setText(list.get(i).getPhone());

        return v; //holder는 쪼가리다, View에다가 getTag()한 쪼가리이다.
    }

    static class ViewHolder {
        ImageView ivPhoto;
        TextView tvName;
        TextView tvPhone;
    }
}

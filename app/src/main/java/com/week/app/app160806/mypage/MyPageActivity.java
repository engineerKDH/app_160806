package com.week.app.app160806.mypage;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.week.app.app160806.R;
import com.week.app.app160806.member.MemberBean;
import com.week.app.app160806.member.MemberService;
import com.week.app.app160806.member.MemberServiceImpl;

public class MyPageActivity extends Activity implements View.OnClickListener {
    TextView tv_name, tv_id, tv_phone, tv_email, tv_addr;
    ImageView iv_profile;
    Button bt_call, bt_map;
    MemberService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);
        service = new MemberServiceImpl(this.getApplicationContext());
        Log.d("마이페이지 액티비티에 전달된 ID",getIntent().getStringExtra("id"));
        MemberBean member = service.findById(getIntent().getStringExtra("id"));
        Log.d("DB에서 추출된 이름 : ",member.getName());
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_id = (TextView) findViewById(R.id.tv_id);
        tv_phone = (TextView) findViewById(R.id.tv_phone);
        tv_email = (TextView) findViewById(R.id.tv_email);
        tv_addr = (TextView) findViewById(R.id.tv_addr);
        iv_profile = (ImageView) findViewById(R.id.iv_profile);
        bt_call = (Button) findViewById(R.id.bt_call);
        bt_map = (Button) findViewById(R.id.bt_map);

        tv_name.setText(member.getName());
        tv_id.setText(member.getId());
        tv_phone.setText(member.getPhone());
        tv_email.setText(member.getEmail());
        tv_addr.setText(member.getAddr());
        iv_profile.setImageResource(R.drawable.song);

        bt_call.setOnClickListener(this);
        bt_map.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}

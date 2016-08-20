package com.week.app.app160806.mypage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.week.app.app160806.R;
import com.week.app.app160806.member.MemberBean;
import com.week.app.app160806.member.MemberService;
import com.week.app.app160806.member.MemberServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends Activity implements View.OnClickListener {
    EditText et_search;
    Button bt_mypage, bt_findByName, bt_findById;
    MemberService service;
    ListView lv_memberlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        service = new MemberServiceImpl(this.getApplicationContext());
        ArrayList<MemberBean> list = service.list();
        et_search = (EditText) findViewById(R.id.et_search);
        bt_mypage = (Button) findViewById(R.id.bt_mypage);
        bt_findByName = (Button) findViewById(R.id.bt_findByName);
        bt_findById = (Button) findViewById(R.id.bt_findById);
        lv_memberlist = (ListView) findViewById(R.id.lv_memberlist);
        lv_memberlist.setAdapter(new MemberAdapter(this, list));
        lv_memberlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View v, int i, long l) {
                Object o = lv_memberlist.getItemIdAtPosition(i);
                MemberBean member = (MemberBean) o;
                Log.d("선택한 이름",o.toString());
                Intent intent = new Intent(ListActivity.this, DetailActivity.class);
                intent.putExtra("id",member.getId());
                startActivity(intent);
            }
        });

        bt_mypage.setOnClickListener(this);
        bt_findByName.setOnClickListener(this);
        bt_findById.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String keyword = et_search.getText().toString();

        switch (v.getId()) {
            case R.id.bt_mypage:
                String id = getIntent().getStringExtra("id");
                Log.d("==== 로그온시 넘어온 ID ====", id);
                Intent intent = new Intent(this.getApplicationContext(), MyPageActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.bt_findByName:

                if (keyword.equals("")) {
                    Toast.makeText(ListActivity.this, "검색어를 먼저 입력하세요 ", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ListActivity.this, "검색어: " + keyword, Toast.LENGTH_SHORT).show();
                    List<MemberBean> list = service.findByName(keyword);
                }


                break;
            case R.id.bt_findById:
                if (keyword.equals("")) {
                    Toast.makeText(ListActivity.this, "검색어를 먼저 입력하세요", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ListActivity.this, "검색어: " + keyword, Toast.LENGTH_SHORT).show();
                    MemberBean member = service.findById(keyword);
                    if (member.getId().equals("NONE")) {
                        Toast.makeText(ListActivity.this, "해당 ID 존재하지 않습니다.", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent2 = new Intent(this.getApplicationContext(), DetailActivity.class);
                        intent2.putExtra("id", member.getId());
                        startActivity(intent2);
                    }
                }


                break;
        }
    }
}

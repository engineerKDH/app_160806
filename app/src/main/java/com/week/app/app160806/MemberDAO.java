package com.week.app.app160806;

import android.content.Context;
import android.util.Log;

public class MemberDAO {

    public MemberDAO(Context context) {
    }

    public void login(MemberBean member) {
        Log.d("DAO: LOGIN - ID 체크", member.getId());
    };

    public void join(MemberBean member) {
        Log.d("DAO: JOIN - ID 체크", member.getId());
    };
}

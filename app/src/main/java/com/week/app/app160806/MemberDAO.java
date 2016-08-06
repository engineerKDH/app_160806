package com.week.app.app160806;

import android.content.Context;
import android.util.Log;

/**
 * Created by KDH on 2016-08-06.
 */
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

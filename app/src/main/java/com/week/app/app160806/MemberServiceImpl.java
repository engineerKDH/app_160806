package com.week.app.app160806;

import android.content.Context;
import android.util.Log;

/**
 * Created by KDH on 2016-08-06.
 */
public class MemberServiceImpl implements MemberService {

    MemberDAO dao;

    public MemberServiceImpl(Context context) {
        this.dao = new MemberDAO(context); //토스
    }

    @Override
    public void login(MemberBean member) {
        Log.d("서비스: LOGIN - ID 체크", member.getId());
    }

    @Override
    public void join(MemberBean member) {
        Log.d("서비스: JOIN - ID 체크", member.getId());
        dao.join(member); //토스
    }
}

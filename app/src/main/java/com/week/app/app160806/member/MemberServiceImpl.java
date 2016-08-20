package com.week.app.app160806.member;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MemberServiceImpl implements MemberService {

    MemberDAO dao;

    public MemberServiceImpl(Context context) {
        this.dao = new MemberDAO(context); //토스
    }

    @Override
    public MemberBean login(MemberBean member) {
        Log.d("서비스: LOGIN - ID 체크", member.getId());
        return dao.login(member);
    }

    @Override
    public MemberBean findById(String id) {
        Log.d("서비스: FIND_BY_ID - ID 체크", id);
        return dao.findById(id);
    }

    @Override
    public int count() {
        Log.d("서비스: COUNT(*)", "진입");
        return dao.count();
    }

    @Override
    public ArrayList<MemberBean> list() {
        Log.d("서비스: LIST", "진입");
        return dao.list();
    }

    @Override
    public List<MemberBean> findByName(String name) {
        Log.d("서비스: FIND_BY_NAME", name);
        return dao.findByName(name);
    }

    @Override
    public void update(MemberBean member) {
        Log.d("서비스: UPDATE", member.getId());
        dao.update(member);
    }

    @Override
    public void delete(String id) {
        Log.d("서비스: DELETE", id);
        dao.delete(id);
    }

    @Override
    public void join(MemberBean member) {
        Log.d("서비스: JOIN", member.getId());
        dao.join(member); //토스
    }
}

package com.week.app.app160806.member;

import java.util.ArrayList;
import java.util.List;

public interface MemberService {

    //CREATE (C)
    public void join(MemberBean member); //회원가입

    //RAED (R)
    public MemberBean login(MemberBean member); //로그인
    public MemberBean findById(String id); //ID 존재여부
    public int count(); //회원 수
    public ArrayList<MemberBean> list();
    public List<MemberBean> findByName(String name);

    //UPDATE (U)
    public void update(MemberBean member);

    //DELETE (D)
    public void delete(String id);
}

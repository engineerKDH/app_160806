package com.week.app.app160806.member;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MemberDAO extends SQLiteOpenHelper {

    public static final String ID = "id";
    public static final String PW = "pw";
    public static final String NAME = "name";
    public static final String PHONE = "phone";
    public static final String EMAIL = "email";
    public static final String ADDR = "addr";

    public MemberDAO(Context context) {
        super(context, "hanbitdb", null, 3);
        this.getWritableDatabase();
        Log.d("DAO 진입 여부","==== OK !! =====");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // id,pw,name,phone,email,addr
        // 테이블 생성 sql : create table TEST ( ID text, PW int);
        // 테이블 입력 sql : insert into TEST (ID,PW) values ('HONG',1);
        // 테이블 삭제 sql : drop table if exists TEST;
        // 테이블 검색 sql : select ID,PW from TEST where ID = 'HONG';
        db.execSQL("create table if not exists member(" +
                " id text primary key," +
                " pw text," +
                " name text," +
                " phone text," +
                " email text," +
                " addr text );");
        db.execSQL("insert into member (id, pw, name, phone, email, addr) " +
                " values ('hong', '1', 'gildong', '01097889788', 'kdh@grit.co.kr', '37.5597680,126.9423080');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists member;");
        this.onCreate(db);
    }

    public MemberBean login(MemberBean member) {
        Log.d("DAO: LOGIN - ID 체크", member.getId());
        MemberBean result = new MemberBean();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select id, pw from member" +
                " where id = '" + member.getId() + "';", null);
        if (cursor.moveToNext()) {
            result.setId(cursor.getString(0));
            result.setPw(cursor.getString(1));
            Log.d("커서 내부 ID 체크", result.getId());
        } else {
            result.setId("NONE"); //ID가 존재하지 않는다.
            Log.d("커서 내부 ID 체크", "ID가 존재하지 않는다.");
        }
        return result;
    }

    public void join(MemberBean member) {
        Log.d("DAO:JOIN - ID 체크", member.getId());
        String sql = "insert into " +
                String.format("member(%s,%s,%s,%s,%s,%s) ",ID,PW,NAME,PHONE,EMAIL,ADDR) +
                String.format("values ('%s','%s','%s','%s','%s','%s');"
                        ,member.getId(),member.getPw(),member.getName(),
                        member.getPhone(),member.getEmail(),member.getAddr());
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        db.close();
    }

    public MemberBean findById(String id) {
        Log.d("DAO findById 진입 : ",id);
        String sql = "select "+
                String.format(" %s,%s,%s,%s,%s,%s ",ID,PW,NAME,PHONE,EMAIL,ADDR)
                +" from member " +
                String.format("where id = '%s';",id) ;
        SQLiteDatabase db = this.getReadableDatabase();
        MemberBean result = new MemberBean();
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor.moveToNext()) {
            result.setId(cursor.getString(0));
            result.setPw(cursor.getString(1));
            result.setName(cursor.getString(2));
            result.setPhone(cursor.getString(3));
            result.setEmail(cursor.getString(4));
            result.setAddr(cursor.getString(5));
        }else {
            result.setId("NONE");
        }
        return result;
    }

    public int count() {
        return 0;
    }

    public ArrayList<MemberBean> list() {
        String sql = "select "+
                String.format(" %s,%s,%s,%s,%s,%s ",ID,PW,NAME,PHONE,EMAIL,ADDR)
                +" from member; ";
        ArrayList<MemberBean> temp = new ArrayList<MemberBean>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor != null){
            Log.d("목록조회","성공 !!");
            cursor.moveToFirst();
        }
        do{
            MemberBean result = new MemberBean();
            result.setId(cursor.getString(0));
            result.setPw(cursor.getString(1));
            result.setName(cursor.getString(2));
            result.setPhone(cursor.getString(3));
            result.setEmail(cursor.getString(4));
            result.setAddr(cursor.getString(5));
            temp.add(result);
        } while(cursor.moveToNext());
        return temp;
    }
    public List<MemberBean> findByName(String name) {
        return null;
    }
    //UPDATE (U)
    public void update(MemberBean member) {
    }
    //DELETE (D)
    public void delete(String id) {
    }
}

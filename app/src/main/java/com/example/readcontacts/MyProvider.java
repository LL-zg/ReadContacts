package com.example.readcontacts;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyProvider  extends ContentProvider {
    public static final int TABLE_DIR=0;
    public static final int TABLE_ITEM=1;
    private static UriMatcher uriMatcher;
    //静态代码块
    static {
        uriMatcher=new UriMatcher((UriMatcher.NO_MATCH));
        uriMatcher.addURI("com.example.app.provider","contacts",TABLE_DIR);//加入读取表中所有数据uri
        uriMatcher.addURI("com.example.app.provider","contacts/#",TABLE_ITEM);//加入读取表中某条数据的URI
    }


    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        switch (uriMatcher.match(uri)){
            case TABLE_DIR:
            //读取contacs表中的全部数据
                break;
            case TABLE_ITEM:
                //读取表中的某条数据
                break;
            default:
                break;
        }
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch (uriMatcher.match(uri)){
            case TABLE_DIR:
                return "vnd.android.cursor.dir/vnd.com.example.app.provider.contacts";
            case TABLE_ITEM:
                return "vnd.android.cursor.item/vnd.com.example.app.provider.contacts";
            default:
                break;
        }
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        switch (uriMatcher.match(uri)){
            case TABLE_DIR:

                break;
            case TABLE_ITEM:

                break;
            default:
                break;
        }
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        switch (uriMatcher.match(uri)){
            case TABLE_DIR:

                break;
            case TABLE_ITEM:

                break;
            default:
                break;
        }
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        switch (uriMatcher.match(uri)){
            case TABLE_DIR:
              /*  SQLiteDatabase db=dbHelper.getWritableDatabase();
                Cursor cursor=db.query("contacts",null,null,null,null,null,null);
                if (cursor.moveToFirst()){
                    do {
                        String  name=cursor.getString(cursor.getColumnIndex("displayName"));
                        String  number=cursor.getString(cursor.getColumnIndex("number"));
                        String  sex=cursor.getString(cursor.getColumnIndex("sex"));
                    }while (cursor.moveToNext());
                }
                cursor.close();*/
                break;
            case TABLE_ITEM:

                break;
            default:
                break;
        }
        return 0;
    }
}

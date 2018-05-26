package com.example.huangjie.ipc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by huangjie on 2018/5/22.
 */

public class AidlService extends Service {
    private ArrayList<Book> bookList;
    private IBinder mBinder = new BookManager.Stub() {
        @Override
        public void addBook(Book book) throws RemoteException {
            bookList.add(book);
        }

        @Override
        public List<Book> getBookList() throws RemoteException {
            return bookList;
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        bookList = new ArrayList<>();
        bookList.add(new Book("ID123", "Android开发艺术探索"));
        bookList.add(new Book("ID124", "剑指offer Java版"));

    }


}

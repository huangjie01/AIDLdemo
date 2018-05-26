// BookManager.aidl
package com.example.huangjie.ipc;

// Declare any non-default types here with import statements

import com.example.huangjie.ipc.Book;

 interface BookManager {
     void addBook(in Book book);
     List<Book> getBookList();
}

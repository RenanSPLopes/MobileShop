package com.renan.mobileshop.Persistency;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.renan.mobileshop.Models.Product;

@Database(entities = {Product.class}, version = 1)
public abstract class AppDatabase  extends RoomDatabase{

    public abstract ProductDAO productDAO();
}

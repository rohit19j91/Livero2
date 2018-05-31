package fr.livero.livero;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

/**
 * Created by Rohit on 5/27/2018.
 */

@Dao
public interface DataAccess {

    @Insert
    public void addCustomer(CustomerDb customer);
}

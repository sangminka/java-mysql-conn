package com.mtcoding.store;

import java.util.List;

public class StoreApp {
    public static void main(String[] args) {

        StoreRepository repo = new StoreRepository();
        int result = 0;
        //int result = repo.insert(3,"감자",1000,2);

//        result = repo.updateOne(1,"고구마",2000,100);
//        result = repo.deleteOne(1);

//        Store store = repo.selectOne(2);
//        System.out.println(store);

        List<Store> list = repo.selectAll();

        for(Store s : list){
            System.out.println(s);
        }
//        System.out.println(result);


    }
}

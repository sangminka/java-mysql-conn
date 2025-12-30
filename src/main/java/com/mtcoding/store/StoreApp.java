package com.mtcoding.store;

public class StoreApp {
    public static void main(String[] args) {

        StoreRepository repo = new StoreRepository();
        int result = 0;
        //int result = repo.insert(3,"감자",1000,2);

//        result = repo.updateOne(1,"고구마",2000,100);
        result = repo.deleteOne(1);

        System.out.println(result);

    }
}

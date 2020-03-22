package com.itxiaoliu.utils;

public class TransactionManager {
    private Connectionutils connectionutils;

    public void setConnectionutils(Connectionutils connectionutils) {
        this.connectionutils = connectionutils;
    }

    public void beginTransaction(){
        try {
            connectionutils.getThreadConnection().setAutoCommit(false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void commit(){
        try {
            connectionutils.getThreadConnection().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void rollback(){
        try {
            connectionutils.getThreadConnection().rollback();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void release(){
        try {
            connectionutils.getThreadConnection().close();
            connectionutils.removeConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

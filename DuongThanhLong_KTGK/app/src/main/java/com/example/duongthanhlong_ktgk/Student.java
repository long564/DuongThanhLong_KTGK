package com.example.duongthanhlong_ktgk;

public class Student {
    private String name;
    private String mssv;
    public Student(String name, String mssv)
    {
        this.name = name;
        this.mssv = mssv;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getMssv()
    {
        return mssv;
    }
    public void setMssv(String mss)
    {
        this.mssv = mssv;
    }
    @Override
    public String toString()
    {
        return name + "\n" + mssv;
    }
}

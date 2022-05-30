package com.company.keepers_test;

public class k_careVO {

    private String c_manager_id;
    private String c_name;
    private String c_age;
    private String c_phone;
    private String c_address;
    private String c_memo;

    public k_careVO() {
    }

    public k_careVO(String c_manager_id, String c_name, String c_age, String c_phone, String c_address, String c_memo) {
        this.c_manager_id = c_manager_id;
        this.c_name = c_name;
        this.c_age = c_age;
        this.c_phone = c_phone;
        this.c_address = c_address;
        this.c_memo = c_memo;
    }

    @Override
    public String toString() {
        return "k_careVO{" +
                "c_manager_id='" + c_manager_id + '\'' +
                ", c_name='" + c_name + '\'' +
                ", c_age='" + c_age + '\'' +
                ", c_phone='" + c_phone + '\'' +
                ", c_address='" + c_address + '\'' +
                ", c_memo='" + c_memo + '\'' +
                '}';
    }

    public String getC_manager_id() {
        return c_manager_id;
    }

    public void setC_manager_id(String c_manager_id) {
        this.c_manager_id = c_manager_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_age() {
        return c_age;
    }

    public void setC_age(String c_age) {
        this.c_age = c_age;
    }

    public String getC_phone() {
        return c_phone;
    }

    public void setC_phone(String c_phone) {
        this.c_phone = c_phone;
    }

    public String getC_address() {
        return c_address;
    }

    public void setC_address(String c_address) {
        this.c_address = c_address;
    }

    public String getC_memo() {
        return c_memo;
    }

    public void setC_memo(String c_memo) {
        this.c_memo = c_memo;
    }
}

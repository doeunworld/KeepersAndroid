package com.company.keepers_test;

public class k_memberVO {

    private String m_id;
    private String m_pw;
    private String m_name;
    private String m_phone;
    private String m_email;
    private String m_department;
    private String m_type;
    private String m_joindate;

    public k_memberVO() {
    }

    public k_memberVO(String m_id, String m_pw, String m_name, String m_phone, String m_email, String m_department, String m_type, String m_joindate) {
        this.m_id = m_id;
        this.m_pw = m_pw;
        this.m_name = m_name;
        this.m_phone = m_phone;
        this.m_email = m_email;
        this.m_department = m_department;
        this.m_type = m_type;
        this.m_joindate = m_joindate;
    }

    @Override
    public String toString() {
        return "k_memberVO{" +
                "m_id='" + m_id + '\'' +
                ", m_pw='" + m_pw + '\'' +
                ", m_name='" + m_name + '\'' +
                ", m_phone='" + m_phone + '\'' +
                ", m_email='" + m_email + '\'' +
                ", m_department='" + m_department + '\'' +
                ", m_type='" + m_type + '\'' +
                ", m_joindate='" + m_joindate + '\'' +
                '}';
    }

    public String getM_id() {
        return m_id;
    }

    public void setM_id(String m_id) {
        this.m_id = m_id;
    }

    public String getM_pw() {
        return m_pw;
    }

    public void setM_pw(String m_pw) {
        this.m_pw = m_pw;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public String getM_phone() {
        return m_phone;
    }

    public void setM_phone(String m_phone) {
        this.m_phone = m_phone;
    }

    public String getM_email() {
        return m_email;
    }

    public void setM_email(String m_email) {
        this.m_email = m_email;
    }

    public String getM_department() {
        return m_department;
    }

    public void setM_department(String m_department) {
        this.m_department = m_department;
    }

    public String getM_type() {
        return m_type;
    }

    public void setM_type(String m_type) {
        this.m_type = m_type;
    }

    public String getM_joindate() {
        return m_joindate;
    }

    public void setM_joindate(String m_joindate) {
        this.m_joindate = m_joindate;
    }
}

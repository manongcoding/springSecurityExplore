package com.mydomain.service.model;

public class User {
    private Integer id;

    private String  username;

    private String  mobile;

    private String  password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * password getter
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * password setter
     *
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}

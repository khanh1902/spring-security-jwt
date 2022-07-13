package com.javaWeb.SpringSecurityJwt.dto.request;

import javax.validation.constraints.NotBlank;

public class SigninRequest {

    /*
        @NotBlank: Annotation này từ chối String có giá trị null và String có độ dài là 0 sau khi đã trim (loại
        bỏ hết khoảng trắng thừa ở đầu và cuối của String).
    */
    @NotBlank
    private String userName;

    @NotBlank
    private String password;

    // getter and setter
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

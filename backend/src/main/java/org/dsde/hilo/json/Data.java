
package org.dsde.hilo.json;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Data {

    @Expose
    private Long isMailBind;
    @Expose
    private Long isPhoneBind;
    @Expose
    private Token token;

    public Long getIsMailBind() {
        return isMailBind;
    }

    public void setIsMailBind(Long isMailBind) {
        this.isMailBind = isMailBind;
    }

    public Long getIsPhoneBind() {
        return isPhoneBind;
    }

    public void setIsPhoneBind(Long isPhoneBind) {
        this.isPhoneBind = isPhoneBind;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

}

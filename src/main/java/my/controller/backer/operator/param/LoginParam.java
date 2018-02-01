package my.controller.backer.operator.param;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/1/30
 */
public class LoginParam {

    @NotBlank
    private String loginId;

    @NotBlank
    private String password;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

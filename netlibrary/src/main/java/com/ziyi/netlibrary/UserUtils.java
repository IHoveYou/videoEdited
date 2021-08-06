package com.ziyi.netlibrary;

import com.duoyi.lxybaselibrary.BaseApplication;
import com.duoyi.lxybaselibrary.utils.SQUtils;
import com.duoyi.lxybaselibrary.utils.StringUtil;
import com.ziyi.netlibrary.bean.UserBean;
import com.ziyi.netlibrary.bean.UserInfoBean;

/**
 * author : 创建人lxy
 * date : 2021/5/20 15:53
 * version :
 * desc : 于此创建有问题请联系
 */
public class UserUtils {
    final String USER_BEAN = "userBean";
    final String USER_INFO = "USER_INFO";
    static UserUtils userUtils;
     UserBean userBean;
    UserInfoBean userInfo;
    LogInChat logInChat;
    public static UserUtils getInsten() {
        if (userUtils == null)
            userUtils = new UserUtils();
        return userUtils;
    }

    UserUtils() {
        userBean = SQUtils.getInstance().getBean(USER_BEAN, UserBean.class);
        userInfo = SQUtils.getInstance().getBean(USER_INFO, UserInfoBean.class);
    }


    public boolean isLogIn() {
        if (userBean == null || StringUtil.isEmpty(userBean.getTOKEN())) {
            userBean = null;
            return false;
        }
        return true;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public String getUSER_INFO() {
        return USER_INFO;
    }

//    public boolean isLogIn(boolean isStart) {
//        if (!isLogIn()) {
//            if (isStart){
//                LogInA
//                return false;
//            }
//            return false;
//        } else {
//            return true;
//        }
//    }

    public void setUser(UserBean userBean) {
        this.userBean = userBean;
        SQUtils.getInstance().add(USER_BEAN, userBean);
        if (logInChat!=null){
            logInChat.loginChat(userBean.getIM_ID(),userBean.getIM_PAS());
        }
    }

    public void setUserInfo(UserInfoBean infoBean) {
        this.userInfo = infoBean;
        userInfo = infoBean;

        UserBean userBean = getUserBean();
        userBean.setIM_ID(infoBean.getIM_ID());
        userBean.setIS_UPDATE_PWD(infoBean.getIS_UPDATE_PWD());
        setUser(userBean);

        SQUtils.getInstance().add(USER_INFO, infoBean);
        if (logInChat!=null){
            logInChat.loginChat(userBean.getIM_ID(),userBean.getIM_PAS());
        }
    }

    public UserInfoBean getUserInfo() {
        return userInfo;
    }

    public String getToken() {
        return isLogIn() ? userBean.getTOKEN() : "";
    }

    public String getImId() {
        return isLogIn() ? userBean.getIM_ID() : "";
    }

    public String getImPwd() {
        return isLogIn() ? userBean.getIM_PAS() : "";
    }

    public boolean isUpdataPwd() {
        int type = userBean.getIS_UPDATE_PWD();
        if (userInfo!=null){
            type = userBean.getIS_UPDATE_PWD();
        }

        return isLogIn() ? (type == 1) : false;
    }


    public String getUserId() {
        if (userBean == null) return "";
        return userBean.getUSER_ID();
    }


    public void outLogin() {
        userBean = null;
        userInfo = null;
        SQUtils.getInstance().delete(USER_BEAN);
        SQUtils.getInstance().delete(USER_INFO);
        BaseApplication.getInstance().outLogIn();
    }

    public void lost() {
        userBean = null;
        userInfo = null;
        SQUtils.getInstance().delete(USER_BEAN);
        SQUtils.getInstance().delete(USER_INFO);
    }

    public void setLogInChat(LogInChat logInChat) {
        this.logInChat = logInChat;
    }

    public interface LogInChat{
        public void loginChat(String userName,String pwd);
    }

}

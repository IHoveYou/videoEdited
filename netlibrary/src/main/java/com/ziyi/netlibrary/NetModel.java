package com.ziyi.netlibrary;

import com.duoyi.lxybaselibrary.net.BaseEntity;
import com.duoyi.lxybaselibrary.net.RxRetrofitClient;
import com.duoyi.lxybaselibrary.utils.MD5;
import com.duoyi.lxybaselibrary.utils.StringUtil;
import com.ziyi.netlibrary.bean.BillListBean;
import com.ziyi.netlibrary.bean.ChatBean;
import com.ziyi.netlibrary.bean.HomeItemBean;
import com.ziyi.netlibrary.bean.HomeOrderBean;
import com.ziyi.netlibrary.bean.HomeUserBean;
import com.ziyi.netlibrary.bean.MessageBean;
import com.ziyi.netlibrary.bean.MyEvaluationBean;
import com.ziyi.netlibrary.bean.MyServeBean;
import com.ziyi.netlibrary.bean.OrderDetailBean;
import com.ziyi.netlibrary.bean.RefundBean;
import com.ziyi.netlibrary.bean.ReplyBean;
import com.ziyi.netlibrary.bean.ReportBean;
import com.ziyi.netlibrary.bean.UserBean;
import com.ziyi.netlibrary.bean.UserInfoBean;
import com.ziyi.netlibrary.bean.WebBean;

import java.util.ArrayList;

import rx.Observable;

/**
 * author : 创建人lxy
 * date : 2021/5/21 9:20
 * version :
 * desc : 于此创建有问题请联系
 */
public class NetModel {

    private final NetWorkTask netWorkTask;
    private static NetModel netModel;
    //            测试环境
//   static final   String url = "http://192.168.2.44:8081/";
//   static final   String H5_URL = "http://testh5.csjc19.com/";
//   static final   String DATA_URL = "https://social.csjc19.com:4006/sa?project=default";
//   static final   String WEB_URL = "http://testh5.csjc19.com/";

//        预发布环境

    //根据环境自动配置接口地址
    static final String url = BuildConfig.BASE_URL;
    public static final String H5_URL = BuildConfig.H5_URL;
    public static final String DATA_URL = BuildConfig.DATA_URL;
    public static final String WEB_URL = BuildConfig.WEB_URL;

////////////    //    生产环境
//   static final   String url = "https://api.csjc19.com/";
//    static final  String H5_URL = "https://h5.csjc19.com/";
//    static final  String DATA_URL = "https://social.csjc19.com:4006/sa?project=production";
//    static final  String WEB_URL = "https://h5.csjc19.com/";


    private NetModel() {
        netWorkTask = RxRetrofitClient.getInstance().getHttpInterface(url, NetWorkTask.class);
    }

    public static NetModel getInstance() {
        if (netModel == null) {
            netModel = new NetModel();
        }
        return netModel;
    }

    public Observable<BaseEntity<Object>> sendCoded(String moblie) {
        return netWorkTask.sendCoded(moblie, "1");

    }

    public Observable<BaseEntity<UserBean>> login(String moblie, String pwd) {
        return netWorkTask.login(moblie, pwd);

    }


    public Observable<BaseEntity<UserInfoBean>> getUserInfo() {
        return netWorkTask.getUserInfo(getUserId(), "1");

    }


    public Observable<BaseEntity<UserInfoBean>> viewUserForSetUp() {
        return netWorkTask.viewUserForSetUp(getUserId());

    }

    public Observable<BaseEntity<HomeUserBean>> getUser() {
        return netWorkTask.getUser(getUserId());

    }


    public Observable<BaseEntity<MyServeBean>> getMyService() {
        return netWorkTask.getMyService(getUserId());

    }

    public Observable<BaseEntity<OrderDetailBean>> getOrderDetail(String orderID) {
        return netWorkTask.getOrderDetail(getUserId(), orderID);

    }


    public Observable<BaseEntity<RefundBean>> getRefundInfo(String orderID) {
        return netWorkTask.getRefundInfo(getUserId(), orderID);

    }


    public Observable<BaseEntity<Object>> editMyService(String aa, String bb) {
        return netWorkTask.editMyService(getUserId(), aa, bb);

    }

    public Observable<BaseEntity<ArrayList<HomeOrderBean>>> getOrderList(String STATUS, String REFUND_STATUS, String REPORT_STATUS,
                                                                         int paeg, int pagesize) {
        return netWorkTask.getOrderList("2",
                getUserId(),
                STATUS,
                "0", REFUND_STATUS, REPORT_STATUS, paeg + "", pagesize + "");

    }


    public Observable<BaseEntity<Object>> updateStatus(String type) {
        return netWorkTask.updateStatus(getUserId(), type);

    }

    public Observable<BaseEntity<Object>> cancleAudit() {
        return netWorkTask.cancleAudit(getUserId());

    }


    public Observable<BaseEntity<WebBean>> getWebUrl(String type) {
        return netWorkTask.getWebUrl(getUserId(), type);

    }


    public Observable<BaseEntity<ChatBean>> getChatRoomStatusForDoc(String toUid) {
        return netWorkTask.getChatRoomStatusForDoc(getUserId(), toUid);

    }

    public Observable<BaseEntity<Object>> finshChat(String toUid) {
        return netWorkTask.finshChat(getUserId(), toUid);

    }


    public Observable<BaseEntity<Object>> setStatusForSingle(String toUid) {
        return netWorkTask.setStatusForSingle(getUserId(), toUid);

    }

    public Observable<BaseEntity<Object>> setStatusForAll(String toUid) {
        return netWorkTask.setStatusForAll(getUserId(), toUid);

    }

    public Observable<BaseEntity<ArrayList<ReplyBean>>> getAskListByDoctor(String toUid) {
        return netWorkTask.getAskListByDoctor(getUserId(), toUid);

    }

    public Observable<BaseEntity<Object>> addAskByDoctor(String toUid, String content) {
        return netWorkTask.addAskByDoctor(getUserId(), toUid, content);

    }


    public Observable<BaseEntity<Object>> comment(String USERNAME,
                                                  String EMAIL,
                                                  int TITLE,
                                                  int DEPARTMENT,
                                                  String PROFESSIONAL,
                                                  String CAREER_PROFILE,
                                                  String LOGO,
                                                  String CERTIFICATE_PIC,
                                                  String PHONE,
                                                  String CODE,
                                                  String REMARK) {
        return netWorkTask.comment(getUserId(), USERNAME, EMAIL, TITLE, DEPARTMENT, PROFESSIONAL, CAREER_PROFILE, LOGO, CERTIFICATE_PIC, PHONE, CODE, REMARK);

    }


    public Observable<BaseEntity<UserBean>> forgetPwd(String phone, String code, String pwd, String pwdType) {
        return netWorkTask.forgetPwd(code, MD5.getMessageDigest(pwd.getBytes()), phone, pwdType);

    }

    public Observable<BaseEntity<ArrayList<HomeItemBean>>> getChatRoomFor(String chatStatus, String page, String pageSize) {
        return netWorkTask.getChatRoomForPC(getUserId(), chatStatus, page, pageSize);

    }


    public Observable<BaseEntity<Object>> commendReport(String toUserName, String title, String content) {
        return netWorkTask.commendReport(getUserId(), toUserName, content, title);

    }


    public Observable<BaseEntity<BillListBean>> getMyBillList(String type, String page, String pageSize) {
        return netWorkTask.getMyBillList(getUserId(), type, page, pageSize);

    }

    public Observable<BaseEntity<ArrayList<MyEvaluationBean>>> getAssessListForHospital(String type, String page, String pageSize) {
        return netWorkTask.getAssessListForHospital(getUserId(), type, page, pageSize);

    }

    public Observable<BaseEntity<ArrayList<MyEvaluationBean>>> getListForPC(String type, String page, String pageSize) {
        return netWorkTask.getListForPC(getUserId(), type, page, pageSize);

    }

    public Observable<BaseEntity<ArrayList<MessageBean>>> getMessageList(String type, String page, String pageSize) {
        return netWorkTask.getMessageList(getUserId(), type, page, pageSize);

    }


    public Observable<BaseEntity<ReportBean>> getReport(String toUserName) {
        return netWorkTask.getReport(getUserId(), toUserName);

    }


    public Observable<BaseEntity<Object>> checkOffline(boolean isOutLogIn) {
        return netWorkTask.checkOffline(getUserId(),isOutLogIn?"2":"1");

    }


    public String getUserId() {
        String userId = UserUtils.getInsten().getUserId();
        if (StringUtil.isEmpty(userId)) {
            userId = "0";
        }
        return userId;
    }

    public String getToken() {
        return UserUtils.getInsten().getToken();
    }
}


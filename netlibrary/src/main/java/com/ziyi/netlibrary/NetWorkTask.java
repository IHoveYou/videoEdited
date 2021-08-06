package com.ziyi.netlibrary;

import com.duoyi.lxybaselibrary.net.BaseEntity;
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

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * author : 创建人lxy
 * date : 2021/5/21 9:20
 * version :
 * desc : 于此创建有问题请联系
 */
public interface NetWorkTask {

    @FormUrlEncoded
    @POST("TX/online_inquiry/user/sendCode.do")
    Observable<BaseEntity<Object>> sendCoded(@Field("PHONE") String PHONE, @Field("TYPE") String TYPE);

    @FormUrlEncoded
    @POST("TX/online_inquiry/user/login.do")
    Observable<BaseEntity<UserBean>> login(@Field("PHONE") String PHONE, @Field("PASSWORD") String PASSWORD);

    @FormUrlEncoded
    @POST("TX/online_inquiry/user/viewUser.do")
    Observable<BaseEntity<UserInfoBean>> getUserInfo(@Field("USER_ID") String USER_ID, @Field("VIEW_TYPE") String VIEW_TYPE);


    @FormUrlEncoded
    @POST("TX/online_inquiry/user/viewUserForSetUp.do")
    Observable<BaseEntity<UserInfoBean>> viewUserForSetUp(@Field("USER_ID") String USER_ID);


    @FormUrlEncoded
    @POST("/TX/online_inquiry/user/myPersonalCenter.do")
    Observable<BaseEntity<HomeUserBean>> getUser(@Field("USER_ID") String USER_ID);


    @FormUrlEncoded
    @POST("TX/online_inquiry/user/getMyService.do")
    Observable<BaseEntity<MyServeBean>> getMyService(@Field("USER_ID") String USER_ID);


    @FormUrlEncoded
    @POST("TX/inquiry_order/order.do")
    Observable<BaseEntity<OrderDetailBean>> getOrderDetail(@Field("USER_ID") String USER_ID, @Field("ORDER_ID") String ORDER_ID);


    @FormUrlEncoded
    @POST("TX/inquiry_refund/getRefundInfo.do")
    Observable<BaseEntity<RefundBean>> getRefundInfo(@Field("USER_ID") String USER_ID, @Field("ORDER_ID") String ORDER_ID);


    @FormUrlEncoded
    @POST("TX/online_inquiry/user/editMyService.do")
    Observable<BaseEntity<Object>> editMyService(@Field("USER_ID") String USER_ID,
                                                 @Field("PRIVATE_DOCTOR_STATUS") String PRIVATE_DOCTOR_STATUS,
                                                 @Field("NIGHT_EMERGENCY_STATUS") String NIGHT_EMERGENCY_STATUS);


    @FormUrlEncoded
    @POST("TX/inquiry_order/list.do")
    Observable<BaseEntity<ArrayList<HomeOrderBean>>> getOrderList(@Field("GET_TYPE") String GET_TYPE
            , @Field("USER_ID") String USER_ID
            , @Field("STATUS") String STATUS
            , @Field("CATEGORY") String CATEGORY
            , @Field("REFUND_STATUS") String REFUND_STATUS
            , @Field("REPORT_STATUS") String REPORT_STATUS
            , @Field("PAGE") String PAGE
            , @Field("COUNT") String COUNT);


    @FormUrlEncoded
    @POST("TX/online_inquiry/user/updateStatus.do")
    Observable<BaseEntity<Object>> updateStatus(@Field("USER_ID") String USER_ID, @Field("UPDATE_STATUS") String UPDATE_STATUS);


    @FormUrlEncoded
    @POST("TX/online_inquiry/user/cancleAudit.do")
    Observable<BaseEntity<Object>> cancleAudit(@Field("USER_ID") String USER_ID);


    @FormUrlEncoded
    @POST("TX/app_text/getInfo.do")
    Observable<BaseEntity<WebBean>> getWebUrl(@Field("USER_ID") String USER_ID, @Field("CATEGORY") String CATEGORY);


    @FormUrlEncoded
    @POST("TX/online_inquiry/user/editHospitalUser.do")
    Observable<BaseEntity<Object>> comment(@Field("USER_ID") String USER_ID,
                                           @Field("USERNAME") String USERNAME,
                                           @Field("EMAIL") String EMAIL,
                                           @Field("TITLE") int TITLE,
                                           @Field("DEPARTMENT") int DEPARTMENT,
                                           @Field("PROFESSIONAL") String PROFESSIONAL,
                                           @Field("CAREER_PROFILE") String CAREER_PROFILE,
                                           @Field("LOGO") String LOGO,
                                           @Field("CERTIFICATE_PIC") String CERTIFICATE_PIC,
                                           @Field("PHONE") String PHONE,
                                           @Field("CODE") String CODE,
                                           @Field("REMARK") String REMARK);

    @FormUrlEncoded
    @POST("TX/online_inquiry/user/setPwd.do")
    Observable<BaseEntity<UserBean>> forgetPwd(@Field("CODE") String code, @Field("PASSWORD") String password
            , @Field("PHONE") String phone, @Field("PWD_TYPE") String pwdType);


    @FormUrlEncoded
    @POST("TX/inquiry_order/addReport.do")
    Observable<BaseEntity<Object>> commendReport(@Field("USER_ID") String USER_ID,
                                                 @Field("ORDER_ID") String ORDER_ID, @Field("REPORT_ADVICE") String REPORT_ADVICE
            , @Field("REPORT_TITLE") String REPORT_TITLE);


    @FormUrlEncoded
    @POST("TX/online_inquiry/balance/getBillList.do")
    Observable<BaseEntity<BillListBean>> getMyBillList(@Field("USER_ID") String USER_ID,
                                                       @Field("TYPE") String TYPE,
                                                       @Field("PAGE") String PAGE,
                                                       @Field("COUNT") String COUNT);
    @FormUrlEncoded
    @POST("TX/online_inquiry/assess/getAssessListForHospital.do")
    Observable<BaseEntity<ArrayList<MyEvaluationBean>>> getAssessListForHospital(@Field("USER_ID") String USER_ID,
                                                                                 @Field("GET_TYPE") String GET_TYPE,
                                                                                 @Field("PAGE") String PAGE,
                                                                                 @Field("COUNT") String COUNT);

    @FormUrlEncoded
    @POST("TX/online_inquiry/silk_banner/getListForPC.do")
    Observable<BaseEntity<ArrayList<MyEvaluationBean>>> getListForPC(@Field("USER_ID") String USER_ID,
                                                                                 @Field("GET_TYPE") String GET_TYPE,
                                                                                 @Field("PAGE") String PAGE,
                                                                                 @Field("COUNT") String COUNT);
    @FormUrlEncoded
    @POST("TX/online_inquiry/news/getNewsList.do")
    Observable<BaseEntity<ArrayList<MessageBean>>> getMessageList(@Field("USER_ID") String USER_ID,
                                                                  @Field("GET_TYPE") String GET_TYPE,
                                                                  @Field("PAGE") String PAGE,
                                                                  @Field("COUNT") String COUNT);



    @FormUrlEncoded
    @POST("TX/inquiry_order/getReport.do")
    Observable<BaseEntity<ReportBean>> getReport(@Field("USER_ID") String USER_ID,
                                                 @Field("ORDER_ID") String ORDER_ID);


    @FormUrlEncoded
    @POST("TX/inquiry_chatRoom/getChatRoomForPC.do")
    Observable<BaseEntity<ArrayList<HomeItemBean>>> getChatRoomForPC(@Field("USER_ID") String USER_ID, @Field("CHAT_STATUS") String CHAT_STATUS
            , @Field("PAGE") String PAGE, @Field("COUNT") String COUNT);

    @FormUrlEncoded
    @POST("TX/inquiry_chatRoom/getChatRoomStatusForDoc.do")
    Observable<BaseEntity<ChatBean>> getChatRoomStatusForDoc(@Field("USER_ID") String USER_ID, @Field("USER_IM_ID") String USER_IM_ID);

    @FormUrlEncoded
    @POST("TX/inquiry_order/getServiceEndByHand.do")
    Observable<BaseEntity<Object>> finshChat(@Field("USER_ID") String USER_ID, @Field("USER_IM_ID") String USER_IM_ID);

    @FormUrlEncoded//单条消息置为已读
    @POST("TX/online_inquiry/news/setStatusForSingle.do")
    Observable<BaseEntity<Object>> setStatusForSingle(@Field("USER_ID") String USER_ID, @Field("NEWS_ID") String USER_IM_ID);

    @FormUrlEncoded//全部标记为已读
    @POST("TX/online_inquiry/news/setStatusForAll.do")
    Observable<BaseEntity<Object>> setStatusForAll(@Field("USER_ID") String USER_ID, @Field("SET_TYPE") String USER_IM_ID);


    @FormUrlEncoded
    @POST("TX/inquiry_order/getAskListByDoctor.do")
    Observable<BaseEntity<ArrayList<ReplyBean>>> getAskListByDoctor(@Field("USER_ID") String USER_ID, @Field("ORDER_ID") String ORDER_ID);


    @FormUrlEncoded
    @POST("TX/inquiry_order/addAskByDoctor.do")
    Observable<BaseEntity<Object>> addAskByDoctor(@Field("USER_ID") String USER_ID
            , @Field("ORDER_ID") String ORDER_ID, @Field("CONTENT") String CONTENT);

    @FormUrlEncoded
    @POST("TX/online_inquiry/user/checkOffline_v2.do")
    Observable<BaseEntity<Object>> checkOffline(@Field("USER_ID") String USER_ID,@Field("TYPE") String TYPE);


    @FormUrlEncoded
    @POST("TX/online_inquiry/chatRecord/getChatRecodeList.do")
    Observable<BaseEntity<Object>> getChatRecodeList(@Field("USER_ID") String USER_ID);
}

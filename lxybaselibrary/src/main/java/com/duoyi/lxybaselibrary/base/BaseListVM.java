package com.duoyi.lxybaselibrary.base;

import androidx.annotation.NonNull;

import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

/**
 * 列表页面专用VM
 * author : 创建人lxy
 * date : 2021/5/24 11:26
 * version :
 * desc : 于此创建有问题请联系
 */
//B为实体类 A为界面对象可以是继承于BaseView 的所有对象
public abstract class BaseListVM<B, A extends BaseView> extends BaseVM<BaseActivity, A> {
    public List<B> list = new ArrayList<>();
    public int page = 0;
    public int pageSize = 20;
    public SmartRefreshLayout refreshLayout;


    public BaseListVM(BaseActivity mContext, A mView) {
        super(mContext, mView);
    }


    /**
     * 初始化数据 比如首次进入 或者需要刷新后回到顶部
     * 多用于用户手动下拉刷新
     */
    public void init() {
        page = 0;
        http(page, pageSize, false);
    }

    /**
     * 加载更多
     */
    public void lodingMore() {
        page++;
        http(page, pageSize, true);
    }

    /**
     * 刷新方法
     * 更新数据数量为当前已加载条数
     * 多用于刷新后位置不改变
     */
    public void refresh() {
        http(0, (page+1) * pageSize, false);
    }

    /**
     *
     * @param page
     * @param pageSize
     * @param isloding 是否为加载 加载 true  刷新 false
     */
    protected abstract void http(int page, int pageSize, boolean isloding);

    /**
     * 设置刷新控件 SmartRefreshLayout
     * @param refreshLayout
     */
    public void setRefresh(SmartRefreshLayout refreshLayout) {
        this.refreshLayout = refreshLayout;
        init();
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                init();
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                lodingMore();
            }
        });
    }

    /**
     * 结束刷新或者加载动画
     * 在网络请求完成后手动调用
     */
    public void httpFinish() {
        if (refreshLayout == null)
            return;
        refreshLayout.finishLoadMore();
        refreshLayout.finishRefresh();
    }

}

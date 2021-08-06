package com.duoyi.lxybaselibrary.base;

/**
 * 作者 lxy on Time 2020-08-1318:50.
 * 上有天，下有地，中间站着你自己，做一天人，尽一天人事儿
 * 人生是一个永不停息的工厂，那里没有懒人的位置。工作吧！创造吧！
 */
public interface BaseView<VM extends BaseVM> {
    /**
     * 绑定内容布局
     */
    public int getLayout();

    /**
     * 子类重写此方法绑定VM
     *
     * @return
     */
    public VM createVM();


    /**
     * 初始化界面
     */
    public void initView();

    /**
     * 初始化数据
     */
    public void initData();


    public void refresh();

}

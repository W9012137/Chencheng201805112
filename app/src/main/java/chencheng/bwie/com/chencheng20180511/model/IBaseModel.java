package chencheng.bwie.com.chencheng20180511.model;


import chencheng.bwie.com.chencheng20180511.bean.BaseBean;
import chencheng.bwie.com.chencheng20180511.net.NetListenter;

/**
 * Created by dell on 2018/5/9.
 */

public interface IBaseModel {
    void getView(String pscid, String page, NetListenter<BaseBean> netListenter);
}

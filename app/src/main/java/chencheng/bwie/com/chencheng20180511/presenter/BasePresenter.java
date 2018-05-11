package chencheng.bwie.com.chencheng20180511.presenter;


import chencheng.bwie.com.chencheng20180511.bean.BaseBean;
import chencheng.bwie.com.chencheng20180511.model.BaseModel;
import chencheng.bwie.com.chencheng20180511.model.IBaseModel;
import chencheng.bwie.com.chencheng20180511.net.NetListenter;
import chencheng.bwie.com.chencheng20180511.view.IMainView;

/**
 * Created by dell on 2018/5/9.
 */

public class BasePresenter {
    private IMainView iMainView;
    private IBaseModel iBaseModel;

    public BasePresenter(IMainView iMainView) {
        this.iMainView = iMainView;
        iBaseModel=new BaseModel();
    }
    public void Showrx(final String pscid, final String page){
        iBaseModel.getView( pscid, page,new NetListenter<BaseBean>() {
            @Override
            public void onSccess(BaseBean baseBean) {
                iMainView.show(baseBean,pscid,page);
            }

            @Override
            public void onFailuer(Exception e) {

            }
        });
    }
}

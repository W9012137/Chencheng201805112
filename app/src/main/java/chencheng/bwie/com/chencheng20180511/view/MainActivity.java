package chencheng.bwie.com.chencheng20180511.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import chencheng.bwie.com.chencheng20180511.R;
import chencheng.bwie.com.chencheng20180511.adapter.MyAdapter;
import chencheng.bwie.com.chencheng20180511.bean.BaseBean;
import chencheng.bwie.com.chencheng20180511.presenter.BasePresenter;


public class MainActivity extends AppCompatActivity implements IMainView, View.OnClickListener {

    private XRecyclerView mXrView;
    BasePresenter presenter;
    String pscid = "39";
    int page = 1;
    private MyAdapter adapter;
    /**
     * 显示
     */
    private Button mBut;
    private boolean b = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        presenter = new BasePresenter(this);
        presenter.Showrx(pscid, page + "");

    }


    private void initView() {
        mXrView = (XRecyclerView) findViewById(R.id.xr_view);
        mXrView.setLayoutManager(new LinearLayoutManager(this));
        mXrView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page--;
                presenter.Showrx(pscid, page + "");
                adapter.notifyDataSetChanged();
                mXrView.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                page++;
                presenter.Showrx(pscid, page + "");
                adapter.notifyDataSetChanged();
                mXrView.loadMoreComplete();
            }
        });
        mBut = (Button) findViewById(R.id.but);
        mBut.setOnClickListener(this);
    }

    @Override
    public void show(BaseBean baseBean, String pscid, String page) {
        adapter = new MyAdapter(MainActivity.this, baseBean.getData());
        mXrView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.but:
                if (b == false) {
                    mBut.setText("隐藏");
                    mXrView.setVisibility(View.VISIBLE);
                    b=true;
                    ;
                }else if (b == true) {
                    mBut.setText("显示");
                    mXrView.setVisibility(View.INVISIBLE);
                    b=false;
                }
                break;
        }
    }
}

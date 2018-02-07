package com.sung.walterfalllayout;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class WalterFallActivity extends AppCompatActivity {
    private RecyclerView mList;
    private List mData;

    private int[] colors = {
            R.color.colorOrange,
            R.color.colorRed,
            R.color.colorPurpers,
            R.color.colorGreen,
            R.color.colorGrey,
            R.color.colorBlue,
            R.color.colorBlack,
            R.color.colorCyan,
            R.color.colorDarkred};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walter_fall);

        mList = findViewById(R.id.rc_list);

        addData();
        mList.setHasFixedSize(true);
        mList.addItemDecoration(new RecyclerItemDecoration(null, 0, 0, true));
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        mList.setLayoutManager(layoutManager);
        ListAdapter adapter = new ListAdapter();
        mList.setAdapter(adapter);

    }

    private void addData() {
        mData = new ArrayList();
        for (int i = 0; i < 30; i++) {
            mData.add(i + "");
        }
    }

    class ListAdapter extends RecyclerView.Adapter {

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ListHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, null, false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ListHolder item = (ListHolder) holder;
            item.onBind(position);
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }

        class ListHolder extends RecyclerView.ViewHolder {
            private ImageView iamge;

            public ListHolder(View itemView) {
                super(itemView);
                iamge = itemView.findViewById(R.id.iv_item);
                int width = WalterFallActivity.this.getWindowManager().getDefaultDisplay().getWidth();
                int iamgeHeight = (int) (400 + Math.random() * 400);
                if (iamge.getTag()!=null){
                    iamgeHeight = (int) iamge.getTag();
                }
                ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(width / 3,iamgeHeight);
                iamge.setLayoutParams(params);
            }

            void onBind(int position) {
                iamge.setImageResource(colors[(int) (Math.random() * 9)]);
            }
        }
    }
}

package setnumber.zr.com.setnumberofentries;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yc on 2020/6/11.
 */

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> {
    List<TestData> testDataList;
    private int i1;

    public TestAdapter(List<TestData> testDataList) {
        this.testDataList = testDataList;
    }

    @NonNull
    @Override
    public TestAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        int parentHeight = parent.getHeight();
        parent.getWidth();
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        layoutParams.height = (parentHeight / 6);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TestAdapter.ViewHolder holder, int position) {
        TestData testData = testDataList.get(position);
        holder.textView.setText("第" + testData.getTitle() + "条item");
        i1 = testData.getTitle() % 2;
        if (i1 == 1) {
            holder.textView.setBackgroundResource(R.color.colorPrimaryDark);
        } else {
            holder.textView.setBackgroundResource(R.color.back);
        }
    }

    @Override
    public int getItemCount() {
        return testDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item_test);
        }
    }
}

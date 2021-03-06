package com.back.vom.adapters;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.back.vom.R;
import com.back.vom.ReportActivity;
import com.back.vom.models.Report;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * The type Notifications adapter.
 */
public class YourReportsAdapter extends RecyclerView.Adapter<YourReportsAdapter.YourReportsAdapterViewHolder> {


    private List<Report> mData;
    private Activity mActivity;

    /**
     * Instantiates a new Notifications adapter.
     *
     * @param mNotificationData the m data
     */
    public YourReportsAdapter(List<Report> mNotificationData,Activity a) {
        this.mData = mNotificationData;
        mActivity = a;
    }

    /**
     * This method will be invoked when notifications is to be displayed.
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public YourReportsAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_your_reports, parent, false);
        return new YourReportsAdapterViewHolder(view);
    }

    /**
     * This method will be invoked to bind all the data to recycler view.
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(YourReportsAdapterViewHolder holder, final int position) {
        holder.mTitle.setText(mData.get(position).getCategory());
        holder.loadPic(mData.get(position).getImageUrl());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mActivity, ReportActivity.class);
                i.putExtra(ReportActivity.REPORT_ID,mData.get(position).getUid());
                mActivity.startActivity(i);
            }
        });
    }

    /**
     * The getItemCount method.
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return mData.size();
    }



    /**
     * The type Notification view holder.
     */
    class YourReportsAdapterViewHolder extends RecyclerView.ViewHolder {

        TextView mTitle;
        ImageView mImageView;

        YourReportsAdapterViewHolder(View itemView) {
            super(itemView);

            mTitle = itemView.findViewById(R.id.category);
            mImageView = itemView.findViewById(R.id.image_view_my);




            Report r = (Report) itemView.getTag();
        }
        public void loadPic(String url) {
            Picasso.get().load(url).into(mImageView);
        }



    }
}

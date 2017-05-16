package htkien.timetable.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Calendar;

import htkien.timetable.R;
import htkien.timetable.util.TimeUtils;


/**
 * Created by kienht on 4/21/17.
 */

public class WeekCalendarPagerAdapter extends PagerAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private TextView mTextViewName;

    private int mWeeksOfTime;
    private int color = 0;

    public WeekCalendarPagerAdapter(Context context, int mWeeksOfTime) {
        this.mContext = context;
        this.mWeeksOfTime = mWeeksOfTime;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mWeeksOfTime;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.item_week_calendar_pager, container, false);

        mTextViewName = (TextView) itemView.findViewById(R.id.textview_date);
        mTextViewName.setTextColor(color == 0 ? ContextCompat.getColor(mContext, android.R.color.black) : color);
        Calendar calendar = TimeUtils.getWeekForPosition(position);

        String fisrtDayOfWeek = TimeUtils.getFirstDayOfWeek(calendar);
        String lastDayOfWeek = TimeUtils.getLastDayOfWeek(calendar);

        mTextViewName.setText(String.format(mContext.getString(R.string.date_time_table), fisrtDayOfWeek, lastDayOfWeek));

        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }

    public void setTextColor(int color) {
        this.color = color;
    }
}

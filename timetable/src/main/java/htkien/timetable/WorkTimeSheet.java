package htkien.timetable;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;

import butterknife.ButterKnife;
import htkien.timetable.adapter.WeekCalendarPagerAdapter;
import htkien.timetable.listener.OnWeekCalendarChangeListener;
import htkien.timetable.util.TimeUtils;
import htkien.timetable.view.RoundedCornerView;


/**
 * Created by kienht on 5/16/17.
 */

public class WorkTimeSheet extends LinearLayout {

    private static final int TIME_DELAY = 200;

    private NestedScrollView mScrollTimeTable;
    private ViewPager mWeekCalendarPager;
    private TextView mTxtItemHour;
    private ImageButton mBtnPreviousDate;
    private ImageButton mBtnNextDate;
    private ImageView mBtnUpHour;
    private ImageView mBtnDownHour;
    private TextView mTextViewNoteFirst;
    private TextView mTextViewNoteSecond;
    private TextView mTextViewNoteThird;

    /**
     * Monday
     */
    private RoundedCornerView mViewFirstMonday;
    private RoundedCornerView mViewSecondMonday;
    private RoundedCornerView mViewThirdMonday;

    /**
     * Tuesday
     */
    private RoundedCornerView mViewFirstTuesday;
    private RoundedCornerView mViewSecondTuesday;
    private RoundedCornerView mViewThirdTuesday;

    /**
     * Wednessday
     */
    private RoundedCornerView mViewFirstWednesday;
    private RoundedCornerView mViewSecondWednesday;
    private RoundedCornerView mViewThirdWednesday;

    /**
     * Thursday
     */
    private RoundedCornerView mViewFirstThurday;
    private RoundedCornerView mViewSecondThurday;
    private RoundedCornerView mViewThirdThurday;

    /**
     * Friday
     */
    private RoundedCornerView mViewFirstFriday;
    private RoundedCornerView mViewSecondFriday;
    private RoundedCornerView mViewThirdFriday;

    /**
     * Saturday
     */
    private RoundedCornerView mViewFirstSaturday;
    private RoundedCornerView mViewSecondSaturday;
    private RoundedCornerView mViewThirdSaturday;

    /**
     * Sunday
     */
    private RoundedCornerView mViewFirstSunday;
    private RoundedCornerView mViewSecondSunday;
    private RoundedCornerView mViewThirdSunday;

    /**
     * Note
     */
    private RoundedCornerView mViewNoteFirst;
    private RoundedCornerView mViewNoteSecond;
    private RoundedCornerView mViewNoteThird;

    private WeekCalendarPagerAdapter mWeekCalendarPagerAdapter;
    private int itemHourHeight;

    public WorkTimeSheet(Context context) {
        super(context);
        initViews(null);
    }

    public WorkTimeSheet(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initViews(attrs);
    }

    public WorkTimeSheet(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public WorkTimeSheet(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initViews(attrs);
    }

    private void initViews(AttributeSet attrs) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_work_time_sheet, this, true);

        mScrollTimeTable = ButterKnife.findById(view, R.id.scroll_time_table);
        mWeekCalendarPager = ButterKnife.findById(view, R.id.view_pager_date);
        mBtnPreviousDate = ButterKnife.findById(view, R.id.button_previous_date);
        mBtnNextDate = ButterKnife.findById(view, R.id.button_next_date);
        mBtnUpHour = ButterKnife.findById(view, R.id.button_up_hour);
        mBtnDownHour = ButterKnife.findById(view, R.id.button_down_hour);
        mTextViewNoteFirst = ButterKnife.findById(view, R.id.textview_note_first);
        mTextViewNoteSecond = ButterKnife.findById(view, R.id.textview_note_second);
        mTextViewNoteThird = ButterKnife.findById(view, R.id.textview_note_third);

        mViewNoteFirst = ButterKnife.findById(view, R.id.view_note_first);
        mViewNoteSecond = ButterKnife.findById(view, R.id.view_note_second);
        mViewNoteThird = ButterKnife.findById(view, R.id.view_note_third);

        mTxtItemHour = ButterKnife.findById(view, R.id.textview_hour);
        mTxtItemHour.post(new Runnable() {
            @Override
            public void run() {
                itemHourHeight = mTxtItemHour.getHeight();
            }
        });

        mViewFirstMonday = ButterKnife.findById(view, R.id.view_first_monday);
        mViewSecondMonday = ButterKnife.findById(view, R.id.view_second_monday);
        mViewThirdMonday = ButterKnife.findById(view, R.id.view_third_monday);

        mViewFirstTuesday = ButterKnife.findById(view, R.id.view_first_tuesday);
        mViewSecondTuesday = ButterKnife.findById(view, R.id.view_second_tuesday);
        mViewThirdTuesday = ButterKnife.findById(view, R.id.view_third_tuesday);

        mViewFirstWednesday = ButterKnife.findById(view, R.id.view_first_wednesday);
        mViewSecondWednesday = ButterKnife.findById(view, R.id.view_second_wednesday);
        mViewThirdWednesday = ButterKnife.findById(view, R.id.view_third_wednesday);

        mViewFirstThurday = ButterKnife.findById(view, R.id.view_first_thursday);
        mViewSecondThurday = ButterKnife.findById(view, R.id.view_second_thursday);
        mViewThirdThurday = ButterKnife.findById(view, R.id.view_third_thursday);

        mViewFirstFriday = ButterKnife.findById(view, R.id.view_first_friday);
        mViewSecondFriday = ButterKnife.findById(view, R.id.view_second_friday);
        mViewThirdFriday = ButterKnife.findById(view, R.id.view_third_friday);

        mViewFirstSaturday = ButterKnife.findById(view, R.id.view_first_saturday);
        mViewSecondSaturday = ButterKnife.findById(view, R.id.view_second_saturday);
        mViewThirdSaturday = ButterKnife.findById(view, R.id.view_third_saturday);

        mViewFirstSunday = ButterKnife.findById(view, R.id.view_first_sunday);
        mViewSecondSunday = ButterKnife.findById(view, R.id.view_second_sunday);
        mViewThirdSunday = ButterKnife.findById(view, R.id.view_third_sunday);

        initWeekCalendarViewPager();

        mBtnPreviousDate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mWeekCalendarPager.setCurrentItem(mWeekCalendarPager.getCurrentItem() - 1, true);
            }
        });

        mBtnNextDate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mWeekCalendarPager.setCurrentItem(mWeekCalendarPager.getCurrentItem() + 1, true);
            }
        });

        mBtnUpHour.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mScrollTimeTable.smoothScrollBy(0, 100);
            }
        });

        mBtnDownHour.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mScrollTimeTable.smoothScrollBy(0, -100);
            }
        });
    }

    private void initWeekCalendarViewPager() {
        mWeekCalendarPagerAdapter = new WeekCalendarPagerAdapter(getContext(), TimeUtils.getWeekOfTime());
        mWeekCalendarPager.setAdapter(mWeekCalendarPagerAdapter);
    }

    public void setCurrentItemDatePager(int position) {
        mWeekCalendarPager.setCurrentItem(position);
    }

    public void setTextNoteFirst(String text) {
        mTextViewNoteFirst.setText(text);
    }

    public void setTextNoteSecond(String text) {
        mTextViewNoteSecond.setText(text);
    }

    public void setTextNoteThird(String text) {
        mTextViewNoteThird.setText(text);
    }

    public void setColorViewFirst(int color) {
        mViewNoteFirst.setBackgroundColor(color);
        mViewFirstMonday.setBackgroundColor(color);
        mViewFirstTuesday.setBackgroundColor(color);
        mViewFirstWednesday.setBackgroundColor(color);
        mViewFirstThurday.setBackgroundColor(color);
        mViewFirstFriday.setBackgroundColor(color);
        mViewFirstSaturday.setBackgroundColor(color);
        mViewFirstSunday.setBackgroundColor(color);
    }

    public void setColorViewSecond(int color) {
        mViewNoteSecond.setBackgroundColor(color);
        mViewSecondMonday.setBackgroundColor(color);
        mViewSecondTuesday.setBackgroundColor(color);
        mViewSecondWednesday.setBackgroundColor(color);
        mViewSecondThurday.setBackgroundColor(color);
        mViewSecondFriday.setBackgroundColor(color);
        mViewSecondSaturday.setBackgroundColor(color);
        mViewSecondSunday.setBackgroundColor(color);
    }

    public void setColorViewThird(int color) {
        mViewNoteThird.setBackgroundColor(color);
        mViewThirdMonday.setBackgroundColor(color);
        mViewThirdTuesday.setBackgroundColor(color);
        mViewThirdWednesday.setBackgroundColor(color);
        mViewThirdThurday.setBackgroundColor(color);
        mViewThirdFriday.setBackgroundColor(color);
        mViewThirdSaturday.setBackgroundColor(color);
        mViewThirdSunday.setBackgroundColor(color);
    }

    public void setTextColorDate(int color) {
        mWeekCalendarPagerAdapter.setTextColor(color);
    }

    public void setOnWeekCalendarSelected(OnWeekCalendarChangeListener mOnWeekCalendarChangeListener) {
        mWeekCalendarPager.addOnPageChangeListener(mOnWeekCalendarChangeListener);
    }

    public void setContentMonday(final int startFirst, final int endFirst, final int startSecond, final int endSecond
            , final int startThird, final int endThird) {
        mViewFirstMonday.postDelayed(new Runnable() {
            @Override
            public void run() {
                mViewFirstMonday.setLayoutParams(initLayoutParam(itemHourHeight * (endFirst - startFirst)
                        , itemHourHeight * startFirst));

                mViewSecondMonday.setLayoutParams(initLayoutParam(itemHourHeight * (endSecond - startSecond)
                        , itemHourHeight * startSecond));

                mViewThirdMonday.setLayoutParams(initLayoutParam(itemHourHeight * (endThird - startThird)
                        , itemHourHeight * startThird));
            }
        }, TIME_DELAY);
    }

    public void setContentTuesday(final int startFirst, final int endFirst, final int startSecond, final int endSecond
            , final int startThird, final int endThird) {
        mViewFirstTuesday.postDelayed(new Runnable() {
            @Override
            public void run() {
                mViewFirstTuesday.setLayoutParams(initLayoutParam(itemHourHeight * (endFirst - startFirst)
                        , itemHourHeight * startFirst));

                mViewSecondTuesday.setLayoutParams(initLayoutParam(itemHourHeight * (endSecond - startSecond)
                        , itemHourHeight * startSecond));

                mViewThirdTuesday.setLayoutParams(initLayoutParam(itemHourHeight * (endThird - startThird)
                        , itemHourHeight * startThird));
            }
        }, TIME_DELAY);
    }

    public void setContentWednesday(final int startFirst, final int endFirst, final int startSecond, final int endSecond
            , final int startThird, final int endThird) {
        mViewFirstWednesday.postDelayed(new Runnable() {
            @Override
            public void run() {
                mViewFirstWednesday.setLayoutParams(initLayoutParam(itemHourHeight * (endFirst - startFirst)
                        , itemHourHeight * startFirst));

                mViewSecondWednesday.setLayoutParams(initLayoutParam(itemHourHeight * (endSecond - startSecond)
                        , itemHourHeight * startSecond));

                mViewThirdWednesday.setLayoutParams(initLayoutParam(itemHourHeight * (endThird - startThird)
                        , itemHourHeight * startThird));
            }
        }, TIME_DELAY);
    }

    public void setContentThurday(final int startFirst, final int endFirst, final int startSecond, final int endSecond
            , final int startThird, final int endThird) {
        mViewFirstThurday.postDelayed(new Runnable() {
            @Override
            public void run() {
                mViewFirstThurday.setLayoutParams(initLayoutParam(itemHourHeight * (endFirst - startFirst)
                        , itemHourHeight * startFirst));

                mViewSecondThurday.setLayoutParams(initLayoutParam(itemHourHeight * (endSecond - startSecond)
                        , itemHourHeight * startSecond));

                mViewThirdThurday.setLayoutParams(initLayoutParam(itemHourHeight * (endThird - startThird)
                        , itemHourHeight * startThird));
            }
        }, TIME_DELAY);
    }

    public void setContentFriday(final int startFirst, final int endFirst, final int startSecond, final int endSecond
            , final int startThird, final int endThird) {
        mViewFirstFriday.postDelayed(new Runnable() {
            @Override
            public void run() {
                mViewFirstFriday.setLayoutParams(initLayoutParam(itemHourHeight * (endFirst - startFirst)
                        , itemHourHeight * startFirst));

                mViewSecondFriday.setLayoutParams(initLayoutParam(itemHourHeight * (endSecond - startSecond)
                        , itemHourHeight * startSecond));

                mViewThirdFriday.setLayoutParams(initLayoutParam(itemHourHeight * (endThird - startThird)
                        , itemHourHeight * startThird));
            }
        }, TIME_DELAY);
    }

    public void setContentSaturday(final int startFirst, final int endFirst, final int startSecond, final int endSecond
            , final int startThird, final int endThird) {
        mViewFirstSaturday.postDelayed(new Runnable() {
            @Override
            public void run() {
                mViewFirstSaturday.setLayoutParams(initLayoutParam(itemHourHeight * (endFirst - startFirst)
                        , itemHourHeight * startFirst));

                mViewSecondSaturday.setLayoutParams(initLayoutParam(itemHourHeight * (endSecond - startSecond)
                        , itemHourHeight * startSecond));

                mViewThirdSaturday.setLayoutParams(initLayoutParam(itemHourHeight * (endThird - startThird)
                        , itemHourHeight * startThird));
            }
        }, TIME_DELAY);
    }

    public void setContentSunday(final int startFirst, final int endFirst, final int startSecond, final int endSecond
            , final int startThird, final int endThird) {
        mViewFirstSunday.postDelayed(new Runnable() {
            @Override
            public void run() {
                mViewFirstSunday.setLayoutParams(initLayoutParam(itemHourHeight * (endFirst - startFirst)
                        , itemHourHeight * startFirst));

                mViewSecondSunday.setLayoutParams(initLayoutParam(itemHourHeight * (endSecond - startSecond)
                        , itemHourHeight * startSecond));

                mViewThirdSunday.setLayoutParams(initLayoutParam(itemHourHeight * (endThird - startThird)
                        , itemHourHeight * startThird));
            }
        }, TIME_DELAY);
    }

    private FrameLayout.LayoutParams initLayoutParam(int height, int marginTop) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, height - 10);
        layoutParams.setMargins(0, marginTop, 0, 0);
        return layoutParams;
    }


}

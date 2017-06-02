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

import butterknife.ButterKnife;
import htkien.timetable.adapter.WeekCalendarPagerAdapter;
import htkien.timetable.listener.OnClickWarningBtnListener;
import htkien.timetable.listener.OnWeekCalendarChangeListener;
import htkien.timetable.util.TimeUtils;
import htkien.timetable.view.RoundedCornerView;


/**
 * Created by kienht on 5/16/17.
 */

public class WorkTimeSheet extends LinearLayout {
    private static final int TIME_DELAY = 200;
    public static final double HEIGHT_HOUR_TIME_TABLE = 0.25;

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
    private ImageButton mButtonWarning;

    /**
     * Monday
     */
    private RoundedCornerView mFirstViewMonday;
    private RoundedCornerView mSecondViewMonday;
    private RoundedCornerView mThirdViewMonday;
    private RoundedCornerView mFourViewMonday;

    /**
     * Tuesday
     */
    private RoundedCornerView mFirstViewTuesday;
    private RoundedCornerView mSecondViewTuesday;
    private RoundedCornerView mThirdViewTuesday;
    private RoundedCornerView mFourViewTuesday;

    /**
     * Wednessday
     */
    private RoundedCornerView mFirstViewWednesday;
    private RoundedCornerView mSecondViewWednesday;
    private RoundedCornerView mThirdViewWednesday;
    private RoundedCornerView mFourViewWednesday;

    /**
     * Thursday
     */
    private RoundedCornerView mFirstViewThurday;
    private RoundedCornerView mSecondViewThurday;
    private RoundedCornerView mThirdViewThurday;
    private RoundedCornerView mFourViewThurday;

    /**
     * Friday
     */
    private RoundedCornerView mFirstViewFriday;
    private RoundedCornerView mSecondViewFriday;
    private RoundedCornerView mThirdViewFriday;
    private RoundedCornerView mFourViewFriday;

    /**
     * Saturday
     */
    private RoundedCornerView mFirstViewSaturday;
    private RoundedCornerView mSecondViewSaturday;
    private RoundedCornerView mThirdViewSaturday;
    private RoundedCornerView mFourViewSaturday;

    /**
     * Sunday
     */
    private RoundedCornerView mFirstViewSunday;
    private RoundedCornerView mSecondViewSunday;
    private RoundedCornerView mThirdViewSunday;
    private RoundedCornerView mFourViewSunday;


    /**
     * Note
     */
    private RoundedCornerView mViewNoteFirst;
    private RoundedCornerView mViewNoteSecond;
    private RoundedCornerView mViewNoteThird;

    private WeekCalendarPagerAdapter mWeekCalendarPagerAdapter;
    private OnClickWarningBtnListener listener;
    private int itemHourHeight;

    public WorkTimeSheet(Context context) {
        super(context);
        initViews(context);
    }

    public WorkTimeSheet(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initViews(context);
    }

    public WorkTimeSheet(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public WorkTimeSheet(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initViews(context);
    }

    private void initViews(Context context) {
        final View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_work_time_sheet, this, true);

        findViewById(view);

        mTxtItemHour.post(new Runnable() {
            @Override
            public void run() {
                itemHourHeight = mTxtItemHour.getHeight();
            }
        });

        initWeekCalendarViewPager();

        mButtonWarning.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null)
                    listener.onClickWarningBtn();
            }
        });

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

    public void refreshLayout() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, 0);
        layoutParams.setMargins(0, 0, 0, 0);

        mFirstViewMonday.setLayoutParams(layoutParams);
        mSecondViewMonday.setLayoutParams(layoutParams);
        mThirdViewMonday.setLayoutParams(layoutParams);
        mFourViewMonday.setLayoutParams(layoutParams);

        mFirstViewTuesday.setLayoutParams(layoutParams);
        mSecondViewTuesday.setLayoutParams(layoutParams);
        mThirdViewTuesday.setLayoutParams(layoutParams);
        mFourViewTuesday.setLayoutParams(layoutParams);

        mFirstViewWednesday.setLayoutParams(layoutParams);
        mSecondViewWednesday.setLayoutParams(layoutParams);
        mThirdViewWednesday.setLayoutParams(layoutParams);
        mFourViewWednesday.setLayoutParams(layoutParams);

        mFirstViewThurday.setLayoutParams(layoutParams);
        mSecondViewThurday.setLayoutParams(layoutParams);
        mThirdViewThurday.setLayoutParams(layoutParams);
        mFourViewThurday.setLayoutParams(layoutParams);

        mFirstViewFriday.setLayoutParams(layoutParams);
        mSecondViewFriday.setLayoutParams(layoutParams);
        mThirdViewFriday.setLayoutParams(layoutParams);
        mFourViewFriday.setLayoutParams(layoutParams);

        mFirstViewSaturday.setLayoutParams(layoutParams);
        mSecondViewSaturday.setLayoutParams(layoutParams);
        mThirdViewSaturday.setLayoutParams(layoutParams);
        mFourViewSaturday.setLayoutParams(layoutParams);

        mFirstViewSunday.setLayoutParams(layoutParams);
        mSecondViewSunday.setLayoutParams(layoutParams);
        mThirdViewSunday.setLayoutParams(layoutParams);
        mFourViewSunday.setLayoutParams(layoutParams);

        invalidate();
    }

    private void findViewById(View view) {
        mScrollTimeTable = ButterKnife.findById(view, R.id.scroll_time_table);
        mWeekCalendarPager = ButterKnife.findById(view, R.id.view_pager_date);
        mBtnPreviousDate = ButterKnife.findById(view, R.id.button_previous_date);
        mBtnNextDate = ButterKnife.findById(view, R.id.button_next_date);
        mBtnUpHour = ButterKnife.findById(view, R.id.button_up_hour);
        mBtnDownHour = ButterKnife.findById(view, R.id.button_down_hour);
        mTextViewNoteFirst = ButterKnife.findById(view, R.id.textview_note_first);
        mTextViewNoteSecond = ButterKnife.findById(view, R.id.textview_note_second);
        mTextViewNoteThird = ButterKnife.findById(view, R.id.textview_note_third);
        mButtonWarning = ButterKnife.findById(view, R.id.button_warning);

        mTxtItemHour = ButterKnife.findById(view, R.id.textview_hour);

        mFirstViewMonday = ButterKnife.findById(view, R.id.view_first_monday);
        mSecondViewMonday = ButterKnife.findById(view, R.id.view_second_monday);
        mThirdViewMonday = ButterKnife.findById(view, R.id.view_third_monday);
        mFourViewMonday = ButterKnife.findById(view, R.id.view_four_monday);

        mFirstViewTuesday = ButterKnife.findById(view, R.id.view_first_tuesday);
        mSecondViewTuesday = ButterKnife.findById(view, R.id.view_second_tuesday);
        mThirdViewTuesday = ButterKnife.findById(view, R.id.view_third_tuesday);
        mFourViewTuesday = ButterKnife.findById(view, R.id.view_four_tuesday);

        mFirstViewWednesday = ButterKnife.findById(view, R.id.view_first_wednesday);
        mSecondViewWednesday = ButterKnife.findById(view, R.id.view_second_wednesday);
        mThirdViewWednesday = ButterKnife.findById(view, R.id.view_third_wednesday);
        mFourViewWednesday = ButterKnife.findById(view, R.id.view_four_wednesday);

        mFirstViewThurday = ButterKnife.findById(view, R.id.view_first_thursday);
        mSecondViewThurday = ButterKnife.findById(view, R.id.view_second_thursday);
        mThirdViewThurday = ButterKnife.findById(view, R.id.view_third_thursday);
        mFourViewThurday = ButterKnife.findById(view, R.id.view_four_thursday);

        mFirstViewFriday = ButterKnife.findById(view, R.id.view_first_friday);
        mSecondViewFriday = ButterKnife.findById(view, R.id.view_second_friday);
        mThirdViewFriday = ButterKnife.findById(view, R.id.view_third_friday);
        mFourViewFriday = ButterKnife.findById(view, R.id.view_four_friday);

        mFirstViewSaturday = ButterKnife.findById(view, R.id.view_first_saturday);
        mSecondViewSaturday = ButterKnife.findById(view, R.id.view_second_saturday);
        mThirdViewSaturday = ButterKnife.findById(view, R.id.view_third_saturday);
        mFourViewSaturday = ButterKnife.findById(view, R.id.view_four_saturday);

        mFirstViewSunday = ButterKnife.findById(view, R.id.view_first_sunday);
        mSecondViewSunday = ButterKnife.findById(view, R.id.view_second_sunday);
        mThirdViewSunday = ButterKnife.findById(view, R.id.view_third_sunday);
        mFourViewSunday = ButterKnife.findById(view, R.id.view_four_sunday);

        mViewNoteFirst = ButterKnife.findById(view, R.id.view_note_first);
        mViewNoteSecond = ButterKnife.findById(view, R.id.view_note_second);
        mViewNoteThird = ButterKnife.findById(view, R.id.view_note_third);
    }

    private void initWeekCalendarViewPager() {
        mWeekCalendarPagerAdapter = new WeekCalendarPagerAdapter(getContext(), TimeUtils.getWeekOfTime());
        mWeekCalendarPager.setAdapter(mWeekCalendarPagerAdapter);
    }

    public void setOnClickWarningBtn(OnClickWarningBtnListener listener) {
        this.listener = listener;
    }

    public void setCurrentItemDatePager(final int position) {
        mWeekCalendarPager.setCurrentItem(position, true);
    }

    public void notifyDataSetChangedWeekPager() {
        mWeekCalendarPager.setAdapter(null);
        mWeekCalendarPager.setAdapter(mWeekCalendarPagerAdapter);
    }

    public void setFirstNoteText(String text) {
        mTextViewNoteFirst.setText(text);
    }

    public void setFirstNoteColor(int color) {
        mViewNoteFirst.setBackgroundColor(color);
    }

    public void setSecondNoteText(String text) {
        mTextViewNoteSecond.setText(text);
    }

    public void setSecondNoteColor(int color) {
        mViewNoteSecond.setBackgroundColor(color);
    }

    public void setThirdNoteText(String text) {
        mTextViewNoteThird.setText(text);
    }

    public void setThirdNoteColor(int color) {
        mViewNoteThird.setBackgroundColor(color);
    }

    public void setTextDateColor(int color) {
        mWeekCalendarPagerAdapter.setTextColor(color);
    }

    public void setOnWeekCalendarSelected(OnWeekCalendarChangeListener mOnWeekCalendarChangeListener) {
        mWeekCalendarPager.addOnPageChangeListener(mOnWeekCalendarChangeListener);
    }

    public void setFirstViewColor(int color) {
        mFirstViewMonday.setBackgroundColor(color);
        mFirstViewTuesday.setBackgroundColor(color);
        mFirstViewWednesday.setBackgroundColor(color);
        mFirstViewThurday.setBackgroundColor(color);
        mFirstViewFriday.setBackgroundColor(color);
        mFirstViewSaturday.setBackgroundColor(color);
        mFirstViewSunday.setBackgroundColor(color);
    }

    public void setSecondViewColor(int color) {
        mSecondViewMonday.setBackgroundColor(color);
        mSecondViewTuesday.setBackgroundColor(color);
        mSecondViewWednesday.setBackgroundColor(color);
        mSecondViewThurday.setBackgroundColor(color);
        mSecondViewFriday.setBackgroundColor(color);
        mSecondViewSaturday.setBackgroundColor(color);
        mSecondViewSunday.setBackgroundColor(color);
    }

    public void setThirdViewColor(int color) {
        mThirdViewMonday.setBackgroundColor(color);
        mThirdViewTuesday.setBackgroundColor(color);
        mThirdViewWednesday.setBackgroundColor(color);
        mThirdViewThurday.setBackgroundColor(color);
        mThirdViewFriday.setBackgroundColor(color);
        mThirdViewSaturday.setBackgroundColor(color);
        mThirdViewSunday.setBackgroundColor(color);
    }

    public void setFourViewColor(int color) {
        mFourViewMonday.setBackgroundColor(color);
        mFourViewTuesday.setBackgroundColor(color);
        mFourViewWednesday.setBackgroundColor(color);
        mFourViewThurday.setBackgroundColor(color);
        mFourViewFriday.setBackgroundColor(color);
        mFourViewSaturday.setBackgroundColor(color);
        mFourViewSunday.setBackgroundColor(color);
    }

    public void setFirstContentViewOfMonday(String date, String from, String to) {
        float timeHight = TimeUtils.calculatorHour(from, to);
        float timeMargin = TimeUtils.calculatorHour(date.concat(" 00:00"), from);
        final int hight = (int) (timeHight / HEIGHT_HOUR_TIME_TABLE) + 1;
        final int marginTop = (int) (timeMargin / HEIGHT_HOUR_TIME_TABLE);
        mFirstViewMonday.postDelayed(new Runnable() {
            @Override
            public void run() {
                mFirstViewMonday.setLayoutParams(initLayoutParam(itemHourHeight * hight
                        , itemHourHeight * marginTop));
            }
        }, TIME_DELAY);
    }

    public void setSecondContentViewOfMonday(String date, String from, String to) {
        float timeHight = TimeUtils.calculatorHour(from, to);
        float timeMargin = TimeUtils.calculatorHour(date.concat(" 00:00"), from);
        final int hight = (int) (timeHight / HEIGHT_HOUR_TIME_TABLE) + 1;
        final int marginTop = (int) (timeMargin / HEIGHT_HOUR_TIME_TABLE);
        mSecondViewMonday.postDelayed(new Runnable() {
            @Override
            public void run() {
                mSecondViewMonday.setLayoutParams(initLayoutParam(itemHourHeight * hight
                        , itemHourHeight * marginTop));
            }
        }, TIME_DELAY);
    }

    public void setThirdContentViewOfMonday(String date, String from, String to) {
        float timeHight = TimeUtils.calculatorHour(from, to);
        float timeMargin = TimeUtils.calculatorHour(date.concat(" 00:00"), from);
        final int hight = (int) (timeHight / HEIGHT_HOUR_TIME_TABLE) + 1;
        final int marginTop = (int) (timeMargin / HEIGHT_HOUR_TIME_TABLE);
        mThirdViewMonday.postDelayed(new Runnable() {
            @Override
            public void run() {
                mThirdViewMonday.setLayoutParams(initLayoutParam(itemHourHeight * hight
                        , itemHourHeight * marginTop));
            }
        }, TIME_DELAY);
    }

    public void setFourContentViewOfMonday(String date, String from, String to) {
        float timeHight = TimeUtils.calculatorHour(from, to);
        float timeMargin = TimeUtils.calculatorHour(date.concat(" 00:00"), from);
        final int hight = (int) (timeHight / HEIGHT_HOUR_TIME_TABLE) + 1;
        final int marginTop = (int) (timeMargin / HEIGHT_HOUR_TIME_TABLE);
        mFourViewMonday.postDelayed(new Runnable() {
            @Override
            public void run() {
                mFourViewMonday.setLayoutParams(initLayoutParam(itemHourHeight * hight
                        , itemHourHeight * marginTop));
            }
        }, TIME_DELAY);
    }

    public void setFirstContentViewOfTuesday(String date, String from, String to) {
        float timeHight = TimeUtils.calculatorHour(from, to);
        float timeMargin = TimeUtils.calculatorHour(date.concat(" 00:00"), from);
        final int hight = (int) (timeHight / HEIGHT_HOUR_TIME_TABLE) + 1;
        final int marginTop = (int) (timeMargin / HEIGHT_HOUR_TIME_TABLE);
        mFirstViewTuesday.postDelayed(new Runnable() {
            @Override
            public void run() {
                mFirstViewTuesday.setLayoutParams(initLayoutParam(itemHourHeight * hight
                        , itemHourHeight * marginTop));
            }
        }, TIME_DELAY);
    }

    public void setSecondContentViewOfTuesday(String date, String from, String to) {
        float timeHight = TimeUtils.calculatorHour(from, to);
        float timeMargin = TimeUtils.calculatorHour(date.concat(" 00:00"), from);
        final int hight = (int) (timeHight / HEIGHT_HOUR_TIME_TABLE) + 1;
        final int marginTop = (int) (timeMargin / HEIGHT_HOUR_TIME_TABLE);
        mSecondViewTuesday.postDelayed(new Runnable() {
            @Override
            public void run() {
                mSecondViewTuesday.setLayoutParams(initLayoutParam(itemHourHeight * hight
                        , itemHourHeight * marginTop));
            }
        }, TIME_DELAY);
    }

    public void setThirdContentViewOfTuesday(String date, String from, String to) {
        float timeHight = TimeUtils.calculatorHour(from, to);
        float timeMargin = TimeUtils.calculatorHour(date.concat(" 00:00"), from);
        final int hight = (int) (timeHight / HEIGHT_HOUR_TIME_TABLE) + 1;
        final int marginTop = (int) (timeMargin / HEIGHT_HOUR_TIME_TABLE);
        mThirdViewTuesday.postDelayed(new Runnable() {
            @Override
            public void run() {
                mThirdViewTuesday.setLayoutParams(initLayoutParam(itemHourHeight * hight
                        , itemHourHeight * marginTop));
            }
        }, TIME_DELAY);
    }

    public void setFourContentViewOfTuesday(String date, String from, String to) {
        float timeHight = TimeUtils.calculatorHour(from, to);
        float timeMargin = TimeUtils.calculatorHour(date.concat(" 00:00"), from);
        final int hight = (int) (timeHight / HEIGHT_HOUR_TIME_TABLE) + 1;
        final int marginTop = (int) (timeMargin / HEIGHT_HOUR_TIME_TABLE);
        mFourViewTuesday.postDelayed(new Runnable() {
            @Override
            public void run() {
                mFourViewTuesday.setLayoutParams(initLayoutParam(itemHourHeight * hight
                        , itemHourHeight * marginTop));
            }
        }, TIME_DELAY);
    }

    public void setFirstContentViewOfWednesday(String date, String from, String to) {
        float timeHight = TimeUtils.calculatorHour(from, to);
        float timeMargin = TimeUtils.calculatorHour(date.concat(" 00:00"), from);
        final int hight = (int) (timeHight / HEIGHT_HOUR_TIME_TABLE) + 1;
        final int marginTop = (int) (timeMargin / HEIGHT_HOUR_TIME_TABLE);
        mFirstViewWednesday.postDelayed(new Runnable() {
            @Override
            public void run() {
                mFirstViewWednesday.setLayoutParams(initLayoutParam(itemHourHeight * hight
                        , itemHourHeight * marginTop));
            }
        }, TIME_DELAY);
    }

    public void setSecondContentViewOfWednesday(String date, String from, String to) {
        float timeHight = TimeUtils.calculatorHour(from, to);
        float timeMargin = TimeUtils.calculatorHour(date.concat(" 00:00"), from);
        final int hight = (int) (timeHight / HEIGHT_HOUR_TIME_TABLE) + 1;
        final int marginTop = (int) (timeMargin / HEIGHT_HOUR_TIME_TABLE);
        mSecondViewWednesday.postDelayed(new Runnable() {
            @Override
            public void run() {
                mSecondViewWednesday.setLayoutParams(initLayoutParam(itemHourHeight * hight
                        , itemHourHeight * marginTop));
            }
        }, TIME_DELAY);
    }

    public void setThirdContentViewOfWednesday(String date, String from, String to) {
        float timeHight = TimeUtils.calculatorHour(from, to);
        float timeMargin = TimeUtils.calculatorHour(date.concat(" 00:00"), from);
        final int hight = (int) (timeHight / HEIGHT_HOUR_TIME_TABLE) + 1;
        final int marginTop = (int) (timeMargin / HEIGHT_HOUR_TIME_TABLE);
        mThirdViewWednesday.postDelayed(new Runnable() {
            @Override
            public void run() {
                mThirdViewWednesday.setLayoutParams(initLayoutParam(itemHourHeight * hight
                        , itemHourHeight * marginTop));
            }
        }, TIME_DELAY);
    }

    public void setFourContentViewOfWednesday(String date, String from, String to) {
        float timeHight = TimeUtils.calculatorHour(from, to);
        float timeMargin = TimeUtils.calculatorHour(date.concat(" 00:00"), from);
        final int hight = (int) (timeHight / HEIGHT_HOUR_TIME_TABLE) + 1;
        final int marginTop = (int) (timeMargin / HEIGHT_HOUR_TIME_TABLE);
        mFourViewWednesday.postDelayed(new Runnable() {
            @Override
            public void run() {
                mFourViewWednesday.setLayoutParams(initLayoutParam(itemHourHeight * hight
                        , itemHourHeight * marginTop));
            }
        }, TIME_DELAY);
    }

    public void setFirstContentViewOfThurday(String date, String from, String to) {
        float timeHight = TimeUtils.calculatorHour(from, to);
        float timeMargin = TimeUtils.calculatorHour(date.concat(" 00:00"), from);
        final int hight = (int) (timeHight / HEIGHT_HOUR_TIME_TABLE) + 1;
        final int marginTop = (int) (timeMargin / HEIGHT_HOUR_TIME_TABLE);
        mFirstViewThurday.postDelayed(new Runnable() {
            @Override
            public void run() {
                mFirstViewThurday.setLayoutParams(initLayoutParam(itemHourHeight * hight
                        , itemHourHeight * marginTop));
            }
        }, TIME_DELAY);
    }

    public void setSecondContentViewOfThurday(String date, String from, String to) {
        float timeHight = TimeUtils.calculatorHour(from, to);
        float timeMargin = TimeUtils.calculatorHour(date.concat(" 00:00"), from);
        final int hight = (int) (timeHight / HEIGHT_HOUR_TIME_TABLE) + 1;
        final int marginTop = (int) (timeMargin / HEIGHT_HOUR_TIME_TABLE);
        mSecondViewThurday.postDelayed(new Runnable() {
            @Override
            public void run() {
                mSecondViewThurday.setLayoutParams(initLayoutParam(itemHourHeight * hight
                        , itemHourHeight * marginTop));
            }
        }, TIME_DELAY);
    }

    public void setThirdContentViewOfThurday(String date, String from, String to) {
        float timeHight = TimeUtils.calculatorHour(from, to);
        float timeMargin = TimeUtils.calculatorHour(date.concat(" 00:00"), from);
        final int hight = (int) (timeHight / HEIGHT_HOUR_TIME_TABLE) + 1;
        final int marginTop = (int) (timeMargin / HEIGHT_HOUR_TIME_TABLE);
        mThirdViewThurday.postDelayed(new Runnable() {
            @Override
            public void run() {
                mThirdViewThurday.setLayoutParams(initLayoutParam(itemHourHeight * hight
                        , itemHourHeight * marginTop));
            }
        }, TIME_DELAY);
    }

    public void setFourContentViewOfThurday(String date, String from, String to) {
        float timeHight = TimeUtils.calculatorHour(from, to);
        float timeMargin = TimeUtils.calculatorHour(date.concat(" 00:00"), from);
        final int hight = (int) (timeHight / HEIGHT_HOUR_TIME_TABLE) + 1;
        final int marginTop = (int) (timeMargin / HEIGHT_HOUR_TIME_TABLE);
        mFourViewThurday.postDelayed(new Runnable() {
            @Override
            public void run() {
                mFourViewThurday.setLayoutParams(initLayoutParam(itemHourHeight * hight
                        , itemHourHeight * marginTop));
            }
        }, TIME_DELAY);
    }

    public void setFirstContentViewOfFriday(String date, String from, String to) {
        float timeHight = TimeUtils.calculatorHour(from, to);
        float timeMargin = TimeUtils.calculatorHour(date.concat(" 00:00"), from);
        final int hight = (int) (timeHight / HEIGHT_HOUR_TIME_TABLE) + 1;
        final int marginTop = (int) (timeMargin / HEIGHT_HOUR_TIME_TABLE);
        mFirstViewFriday.postDelayed(new Runnable() {
            @Override
            public void run() {
                mFirstViewFriday.setLayoutParams(initLayoutParam(itemHourHeight * hight
                        , itemHourHeight * marginTop));
            }
        }, TIME_DELAY);
    }

    public void setSecondContentViewOfFriday(String date, String from, String to) {
        float timeHight = TimeUtils.calculatorHour(from, to);
        float timeMargin = TimeUtils.calculatorHour(date.concat(" 00:00"), from);
        final int hight = (int) (timeHight / HEIGHT_HOUR_TIME_TABLE) + 1;
        final int marginTop = (int) (timeMargin / HEIGHT_HOUR_TIME_TABLE);
        mSecondViewFriday.postDelayed(new Runnable() {
            @Override
            public void run() {
                mSecondViewFriday.setLayoutParams(initLayoutParam(itemHourHeight * hight
                        , itemHourHeight * marginTop));
            }
        }, TIME_DELAY);
    }

    public void setThirdContentViewOfFriday(String date, String from, String to) {
        float timeHight = TimeUtils.calculatorHour(from, to);
        float timeMargin = TimeUtils.calculatorHour(date.concat(" 00:00"), from);
        final int hight = (int) (timeHight / HEIGHT_HOUR_TIME_TABLE) + 1;
        final int marginTop = (int) (timeMargin / HEIGHT_HOUR_TIME_TABLE);
        mThirdViewFriday.postDelayed(new Runnable() {
            @Override
            public void run() {
                mThirdViewFriday.setLayoutParams(initLayoutParam(itemHourHeight * hight
                        , itemHourHeight * marginTop));
            }
        }, TIME_DELAY);
    }

    public void setFourContentViewOfFriday(String date, String from, String to) {
        float timeHight = TimeUtils.calculatorHour(from, to);
        float timeMargin = TimeUtils.calculatorHour(date.concat(" 00:00"), from);
        final int hight = (int) (timeHight / HEIGHT_HOUR_TIME_TABLE) + 1;
        final int marginTop = (int) (timeMargin / HEIGHT_HOUR_TIME_TABLE);
        mFourViewFriday.postDelayed(new Runnable() {
            @Override
            public void run() {
                mFourViewFriday.setLayoutParams(initLayoutParam(itemHourHeight * hight
                        , itemHourHeight * marginTop));
            }
        }, TIME_DELAY);
    }

    public void setFirstContentViewOfSaturday(String date, String from, String to) {
        float timeHight = TimeUtils.calculatorHour(from, to);
        float timeMargin = TimeUtils.calculatorHour(date.concat(" 00:00"), from);
        final int hight = (int) (timeHight / HEIGHT_HOUR_TIME_TABLE) + 1;
        final int marginTop = (int) (timeMargin / HEIGHT_HOUR_TIME_TABLE);
        mFirstViewSaturday.postDelayed(new Runnable() {
            @Override
            public void run() {
                mFirstViewSaturday.setLayoutParams(initLayoutParam(itemHourHeight * hight
                        , itemHourHeight * marginTop));
            }
        }, TIME_DELAY);
    }

    public void setSecondContentViewOfSaturday(String date, String from, String to) {
        float timeHight = TimeUtils.calculatorHour(from, to);
        float timeMargin = TimeUtils.calculatorHour(date.concat(" 00:00"), from);
        final int hight = (int) (timeHight / HEIGHT_HOUR_TIME_TABLE) + 1;
        final int marginTop = (int) (timeMargin / HEIGHT_HOUR_TIME_TABLE);
        mSecondViewSaturday.postDelayed(new Runnable() {
            @Override
            public void run() {
                mSecondViewSaturday.setLayoutParams(initLayoutParam(itemHourHeight * hight
                        , itemHourHeight * marginTop));
            }
        }, TIME_DELAY);
    }

    public void setThirdContentViewOfSaturday(String date, String from, String to) {
        float timeHight = TimeUtils.calculatorHour(from, to);
        float timeMargin = TimeUtils.calculatorHour(date.concat(" 00:00"), from);
        final int hight = (int) (timeHight / HEIGHT_HOUR_TIME_TABLE) + 1;
        final int marginTop = (int) (timeMargin / HEIGHT_HOUR_TIME_TABLE);
        mThirdViewSaturday.postDelayed(new Runnable() {
            @Override
            public void run() {
                mThirdViewSaturday.setLayoutParams(initLayoutParam(itemHourHeight * hight
                        , itemHourHeight * marginTop));
            }
        }, TIME_DELAY);
    }

    public void setFourContentViewOfSaturday(String date, String from, String to) {
        float timeHight = TimeUtils.calculatorHour(from, to);
        float timeMargin = TimeUtils.calculatorHour(date.concat(" 00:00"), from);
        final int hight = (int) (timeHight / HEIGHT_HOUR_TIME_TABLE) + 1;
        final int marginTop = (int) (timeMargin / HEIGHT_HOUR_TIME_TABLE);
        mFourViewSaturday.postDelayed(new Runnable() {
            @Override
            public void run() {
                mFourViewSaturday.setLayoutParams(initLayoutParam(itemHourHeight * hight
                        , itemHourHeight * marginTop));
            }
        }, TIME_DELAY);
    }

    public void setFirstContentViewOfSunday(String date, String from, String to) {
        float timeHight = TimeUtils.calculatorHour(from, to);
        float timeMargin = TimeUtils.calculatorHour(date.concat(" 00:00"), from);
        final int hight = (int) (timeHight / HEIGHT_HOUR_TIME_TABLE) + 1;
        final int marginTop = (int) (timeMargin / HEIGHT_HOUR_TIME_TABLE);
        mFirstViewSunday.postDelayed(new Runnable() {
            @Override
            public void run() {
                mFirstViewSunday.setLayoutParams(initLayoutParam(itemHourHeight * hight
                        , itemHourHeight * marginTop));
            }
        }, TIME_DELAY);
    }

    public void setSecondContentViewOfSunday(String date, String from, String to) {
        float timeHight = TimeUtils.calculatorHour(from, to);
        float timeMargin = TimeUtils.calculatorHour(date.concat(" 00:00"), from);
        final int hight = (int) (timeHight / HEIGHT_HOUR_TIME_TABLE) + 1;
        final int marginTop = (int) (timeMargin / HEIGHT_HOUR_TIME_TABLE);
        mSecondViewSunday.postDelayed(new Runnable() {
            @Override
            public void run() {
                mSecondViewSunday.setLayoutParams(initLayoutParam(itemHourHeight * hight
                        , itemHourHeight * marginTop));
            }
        }, TIME_DELAY);
    }

    public void setThirdContentViewOfSunday(String date, String from, String to) {
        float timeHight = TimeUtils.calculatorHour(from, to);
        float timeMargin = TimeUtils.calculatorHour(date.concat(" 00:00"), from);
        final int hight = (int) (timeHight / HEIGHT_HOUR_TIME_TABLE) + 1;
        final int marginTop = (int) (timeMargin / HEIGHT_HOUR_TIME_TABLE);
        mThirdViewSunday.postDelayed(new Runnable() {
            @Override
            public void run() {
                mThirdViewSunday.setLayoutParams(initLayoutParam(itemHourHeight * hight
                        , itemHourHeight * marginTop));
            }
        }, TIME_DELAY);
    }

    public void setFourContentViewOfSunday(String date, String from, String to) {
        float timeHight = TimeUtils.calculatorHour(from, to);
        float timeMargin = TimeUtils.calculatorHour(date.concat(" 00:00"), from);
        final int hight = (int) (timeHight / HEIGHT_HOUR_TIME_TABLE) + 1;
        final int marginTop = (int) (timeMargin / HEIGHT_HOUR_TIME_TABLE);
        mFourViewSunday.postDelayed(new Runnable() {
            @Override
            public void run() {
                mFourViewSunday.setLayoutParams(initLayoutParam(itemHourHeight * hight
                        , itemHourHeight * marginTop));
            }
        }, TIME_DELAY);
    }

    private FrameLayout.LayoutParams initLayoutParam(int height, int marginTop) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, height - 10);
        layoutParams.setMargins(0, marginTop, 0, 0);
        return layoutParams;
    }

}

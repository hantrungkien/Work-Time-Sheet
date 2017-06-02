package htkien.worktimesheet;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import htkien.timetable.WorkTimeSheet;
import htkien.timetable.listener.OnClickWarningBtnListener;
import htkien.timetable.listener.OnWeekCalendarChangeListener;
import htkien.timetable.util.TimeUtils;

public class MainActivity extends AppCompatActivity implements
        OnWeekCalendarChangeListener.OnWeekCalendarSelected
        , OnClickWarningBtnListener {

    public static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.work_time_sheet)
    WorkTimeSheet mWorkTimeSheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mWorkTimeSheet.setOnWeekCalendarSelected(new OnWeekCalendarChangeListener(this));
        mWorkTimeSheet.setOnClickWarningBtn(this);

        mWorkTimeSheet.setTextDateColor(ContextCompat.getColor(this, android.R.color.holo_red_dark));

        mWorkTimeSheet.setFirstViewColor(ContextCompat.getColor(this, android.R.color.black));
        mWorkTimeSheet.setFirstNoteColor(ContextCompat.getColor(this, android.R.color.black));

        mWorkTimeSheet.setSecondViewColor(ContextCompat.getColor(this, android.R.color.holo_red_dark));
        mWorkTimeSheet.setSecondNoteColor(ContextCompat.getColor(this, android.R.color.holo_red_dark));

        mWorkTimeSheet.setThirdViewColor(ContextCompat.getColor(this, android.R.color.holo_green_dark));
        mWorkTimeSheet.setThirdNoteColor(ContextCompat.getColor(this, android.R.color.holo_green_dark));

        mWorkTimeSheet.setCurrentItemDatePager(TimeUtils.getPositionForWeek(Calendar.getInstance()));

    }

    @OnClick(R.id.button_test)
    void test() {
        mWorkTimeSheet.refreshLayout();
    }

    @Override
    public void onWeekCalendarSelected(int position) {
        Log.e(TAG, "onWeekCalendarSelected: " + position);
        mWorkTimeSheet.setFirstContentViewOfMonday("29.05.2017", "29.05.2017 20:30", "29.05.2017 23:00");

    }

    @Override
    public void onClickWarningBtn() {
        Log.e(TAG, "onClickWarningBtn: ");
    }
}


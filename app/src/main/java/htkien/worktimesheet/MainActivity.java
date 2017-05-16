package htkien.worktimesheet;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import htkien.timetable.WorkTimeSheet;
import htkien.timetable.listener.OnWeekCalendarChangeListener;

public class MainActivity extends AppCompatActivity implements OnWeekCalendarChangeListener.OnWeekCalendarSelected {

    @BindView(R.id.work_time_sheet)
    WorkTimeSheet mWorkTimeSheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mWorkTimeSheet.setOnWeekCalendarSelected(new OnWeekCalendarChangeListener(this));
        mWorkTimeSheet.setTextColorDate(ContextCompat.getColor(this, android.R.color.holo_red_dark));
        mWorkTimeSheet.setColorViewFirst(ContextCompat.getColor(this, android.R.color.black));
        mWorkTimeSheet.setColorViewSecond(ContextCompat.getColor(this, android.R.color.holo_red_dark));
        mWorkTimeSheet.setColorViewThird(ContextCompat.getColor(this, android.R.color.holo_green_dark));

    }

    @Override
    public void onWeekCalendarSelected(int position) {
        mWorkTimeSheet.setContentMonday(0, 10, 10, 20, 20, 30);
        mWorkTimeSheet.setContentTuesday(0, 10, 10, 20, 20, 30);
        mWorkTimeSheet.setContentWednesday(0, 10, 10, 20, 20, 30);
        mWorkTimeSheet.setContentThurday(0, 10, 10, 20, 20, 30);
        mWorkTimeSheet.setContentFriday(0, 10, 10, 20, 20, 30);
        mWorkTimeSheet.setContentSaturday(0, 10, 10, 20, 20, 30);
        mWorkTimeSheet.setContentSunday(0, 10, 10, 20, 20, 30);
    }
}


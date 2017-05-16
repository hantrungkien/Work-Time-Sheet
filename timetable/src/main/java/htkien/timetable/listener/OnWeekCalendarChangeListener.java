package htkien.timetable.listener;

import android.support.v4.view.ViewPager;

/**
 * Created by kienht on 5/5/17.
 */

public class OnWeekCalendarChangeListener implements ViewPager.OnPageChangeListener {

    private OnWeekCalendarSelected listener;

    public OnWeekCalendarChangeListener(OnWeekCalendarSelected listener) {
        this.listener = listener;
    }

    public interface OnWeekCalendarSelected {
        void onWeekCalendarSelected(int position);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        listener.onWeekCalendarSelected(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}

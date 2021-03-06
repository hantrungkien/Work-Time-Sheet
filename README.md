# Work-Time-Sheet
Work Time Sheet

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Platform](https://img.shields.io/badge/platform-android-green.svg)](http://developer.android.com/index.html)
[![](https://jitpack.io/v/hantrungkien/Work-Time-Sheet.svg)](https://jitpack.io/#hantrungkien/Work-Time-Sheet)

<a><img src="./image/screenshot.jpg" width="200"></a>

### install:

**via JitPack (to get current code)**

project/build.gradle
````gradle
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
````
module/build.gradle
````gradle
compile 'com.github.hantrungkien:Work-Time-Sheet:1.1.3'
````

#### How to use:

````xml
<htkien.timetable.WorkTimeSheet
 android:id="@+id/work_time_sheet"
 android:layout_width="match_parent"
 android:layout_height="match_parent" />
````

See [MainActivity.java](https://github.com/hantrungkien/Work-Time-Sheet/blob/master/app/src/main/java/htkien/worktimesheet/MainActivity.java) to know how to use

````Java
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
````

### Contribution

If you've found an error, please file an issue.

Patches and new samples are encouraged, and may be submitted by forking this project and submitting a pull request through GitHub.

### LICENCE

    Copyright 2017 Kien Han Trung

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.




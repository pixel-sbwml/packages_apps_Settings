/*
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.applications;

import android.content.Intent;
import android.util.FeatureFlagUtils;

import com.android.settings.SettingsActivity;
import com.android.settings.applications.appinfo.AppInfoDashboardFragment;
import com.android.settings.core.FeatureFlags;

public class InstalledAppDetailsTop extends SettingsActivity {

    @Override
    public Intent getIntent() {
        Intent modIntent = new Intent(super.getIntent());
        if (FeatureFlagUtils.isEnabled(this, FeatureFlags.APP_INFO_V2)) {
            modIntent.putExtra(EXTRA_SHOW_FRAGMENT, AppInfoDashboardFragment.class.getName());
        } else {
            modIntent.putExtra(EXTRA_SHOW_FRAGMENT, InstalledAppDetails.class.getName());
        }
        return modIntent;
    }

    @Override
    protected boolean isValidFragment(String fragmentName) {
        if (FeatureFlagUtils.isEnabled(this, FeatureFlags.APP_INFO_V2)) {
            return AppInfoDashboardFragment.class.getName().equals(fragmentName);
        }
        return InstalledAppDetails.class.getName().equals(fragmentName);
    }
}

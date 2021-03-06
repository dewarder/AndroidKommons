/*
 * Copyright (C) 2017 Artem Hluhovskyi
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

package com.dewarder.akommons.binding.view

import android.os.Bundle
import android.support.test.rule.ActivityTestRule
import android.support.v7.app.AppCompatActivity
import android.widget.FrameLayout
import com.dewarder.akommons.binding.common.view.BaseViewTest
import com.dewarder.akommons.binding.common.view.TestableView
import com.dewarder.akommons.binding.common.R
import org.junit.Rule

class FragmentViewTest : BaseViewTest() {

    class Activity : AppCompatActivity() {

        lateinit var fragment: TestViewFragment

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            val container = FrameLayout(this).apply {
                id = R.id.action_container
            }
            setContentView(container)
            fragment = TestViewFragment()

            fragmentManager.beginTransaction()
                    .replace(R.id.action_container, fragment)
                    .commit()
        }
    }

    @get:Rule
    val activityRule = ActivityTestRule<Activity>(Activity::class.java)

    override fun getTestableView(): TestableView {
        return activityRule.activity.fragment
    }
}
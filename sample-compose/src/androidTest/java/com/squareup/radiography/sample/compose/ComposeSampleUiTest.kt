package com.squareup.radiography.sample.compose

import androidx.ui.test.android.createAndroidComposeRule
import androidx.ui.test.assert
import androidx.ui.test.assertIsDisplayed
import androidx.ui.test.hasSubstring
import androidx.ui.test.onNodeWithTag
import androidx.ui.test.onNodeWithText
import androidx.ui.test.performTextReplacement
import org.junit.Rule
import org.junit.Test

class ComposeSampleUiTest {

  @get:Rule
  val activityRule = createAndroidComposeRule<MainActivity>()

  @Test fun launches() {
    onNodeWithText("Remember me").assertIsDisplayed()
  }

  @Test fun displaysHierarchyInline() {
    onNodeWithTag(LIVE_HIERARCHY_TEST_TAG)
        .assert(hasSubstring("Remember me"))
        .assert(hasSubstring("Unchecked"))

    onNodeWithTag(TEXT_FIELD_TEST_TAG)
        .performTextReplacement("foobar")

    onNodeWithTag(LIVE_HIERARCHY_TEST_TAG)
        .assert(hasSubstring("Remember me"))
        .assert(hasSubstring("foobar"))
  }
}

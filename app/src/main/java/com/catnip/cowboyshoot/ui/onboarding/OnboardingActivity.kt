package com.catnip.cowboyshoot.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.catnip.cowboyshoot.R
import com.catnip.cowboyshoot.ui.onboarding.inputname.InputNameFragment
import com.github.appintro.AppIntro2
import com.github.appintro.AppIntroFragment

class OnboardingActivity : AppIntro2() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setupSliderFragment()
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        if (currentFragment is OnFinishNavigateListener) {
            currentFragment.onFinishNavigateListener()
        }
    }

    private fun setupSliderFragment() {
        isSkipButtonEnabled = false
        buildSliderFragment(R.string.text_title_onboarding_1, R.string.text_desc_onboarding_1)
        buildSliderFragment(R.string.text_title_onboarding_2, R.string.text_desc_onboarding_2)
        addSlide(InputNameFragment())
    }

    private fun buildSliderFragment(textTitle: Int, textDescription: Int) {
        addSlide(
            AppIntroFragment.createInstance(
                title = getString(textTitle),
                description = getString(textDescription),
                imageDrawable = R.drawable.ic_cowboy_left_shoot_true,
                titleTypefaceFontRes = R.font.pixelated_font,
                descriptionTypefaceFontRes = R.font.pixelated_font,
                backgroundDrawable = R.drawable.bg_game,
                descriptionColorRes = R.color.white,
                titleColorRes = R.color.white
            )
        )
    }
}

interface OnFinishNavigateListener {
    fun onFinishNavigateListener()
}
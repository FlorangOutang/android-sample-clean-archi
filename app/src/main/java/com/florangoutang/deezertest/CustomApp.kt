package com.florangoutang.deezertest

import com.florangoutang.deezertest.injection.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


class CustomApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val applicationComponent = DaggerApplicationComponent.builder().application(this).build()
        applicationComponent.inject(this)
        return applicationComponent
    }
}
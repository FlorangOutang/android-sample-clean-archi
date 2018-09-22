package com.florangoutang.deezertest.interfaceadapter.util.scheduler

import io.reactivex.Scheduler


interface BaseSchedulerProvider {

    fun computation(): Scheduler

    fun io(): Scheduler

    fun ui(): Scheduler
}
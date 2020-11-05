package com.badmitry.kotlingeekbrains.vm

import com.badmitry.kotlingeekbrains.data.Repository
import com.badmitry.kotlingeekbrains.data.error.NotAuthentication
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch

class SplashViewModel (private val repository: Repository) : BaseViewModel<Boolean?>(repository) {
    private val startMainActivityChannel = Channel<Unit>()
    fun getStartMainActivityChannel(): Channel<Unit> = startMainActivityChannel

    suspend fun startMainActivity() {
        startMainActivityChannel.send(Unit)
    }

    fun requestUser() {
        launch {
            repository.getCurrentUser()?.let {
                setData(true)
                startMainActivity()
            } ?: setError(NotAuthentication())
        }
    }
}
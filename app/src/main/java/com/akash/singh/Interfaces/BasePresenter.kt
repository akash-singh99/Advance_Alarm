package com.akash.singh.Interfaces


interface BasePresenter<T> {
    /**
     * method for initializing and starting some initial data or services.
     */
    fun start()

    fun takeView(view: T)
}
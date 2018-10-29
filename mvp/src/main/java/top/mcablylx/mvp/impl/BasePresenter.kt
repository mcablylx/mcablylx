package top.mcablylx.mvp.impl

import android.content.res.Configuration
import android.os.Bundle
import top.mcablylx.mvp.IMvpView
import top.mcablylx.mvp.IPresenter

/**
 * If there is no bug, Created by Mcablylx on 2018-10-26.
 * otherwise, I do not know who create it either
 * If anyone finds out I have bug, I can only kill him quietly
 */
abstract class BasePresenter<out P : IMvpView<BasePresenter<P>>> : IPresenter<P> {
    override lateinit var view: @UnsafeVariance P

    override fun onCreate(savedInstanceState: Bundle?) = Unit

    override fun onSaveInstanceState(outState: Bundle) = Unit

    override fun onViewStateRestored(savedInstanceState: Bundle?) = Unit

    override fun onConfigurationChanged(newConfig: Configuration) = Unit

    override fun onDestroy() = Unit

    override fun onStart() = Unit

    override fun onStop() = Unit

    override fun onResume() = Unit

    override fun onPause() = Unit

}
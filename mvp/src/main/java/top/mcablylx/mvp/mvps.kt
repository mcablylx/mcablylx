package top.mcablylx.mvp

/**
 * If there is no bug, Created by Mcablylx on 2018-10-24.
 * otherwise, I do not know who create it either
 * If anyone finds out I have bug, I can only kill him quietly
 */
interface IPresenter<out View : IMvpView<IPresenter<View>>> :ILifecycle{
    val view: View
}

interface IMvpView<out Presenter : IPresenter<IMvpView<Presenter>>> :ILifecycle{
    val presenter: Presenter
}
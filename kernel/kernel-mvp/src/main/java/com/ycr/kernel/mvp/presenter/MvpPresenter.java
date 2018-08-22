package com.ycr.kernel.mvp.presenter;

import com.ycr.kernel.mvp.view.IMvpView;

import java.lang.ref.WeakReference;

/**
 * Created by yuchengren on 2018/7/27.
 */
public abstract class MvpPresenter<V extends IMvpView> implements IMvpPresenter<V>{

	private WeakReference<V> mViewWeakReference;

	public MvpPresenter(V mvpView){
		try {
			injectView(mvpView);
			mvpView.getMvpConnector().injectPresenter(this);
		}catch (Throwable tr){
			tr.printStackTrace();
		}
	}

	@Override
	public void injectView(V mvpView) {
		if(mViewWeakReference == null){
			mViewWeakReference = new WeakReference<>(mvpView);
		}else{
			V view = mViewWeakReference.get();
			if(view != mvpView){
				mViewWeakReference = new WeakReference<>(mvpView);
			}
		}
	}

	@Override
	public void destroyView() {
		mViewWeakReference = null;
	}

	@Override
	public V getView() {
		if(mViewWeakReference == null || mViewWeakReference.get() == null){
			return getEmptyView();
		}
		return mViewWeakReference.get();
	}

	public abstract V getEmptyView();

}

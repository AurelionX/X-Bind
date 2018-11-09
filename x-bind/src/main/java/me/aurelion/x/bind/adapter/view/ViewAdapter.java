package me.aurelion.x.bind.adapter.view;

import android.annotation.SuppressLint;
import android.databinding.BindingAdapter;
import android.view.View;

import com.jakewharton.rxbinding2.view.RxView;

import java.util.concurrent.TimeUnit;

import me.aurelion.x.bind.command.BindAction;


/**
 * @author Leon (wshk729@163.com)
 * @date 2018/11/7
 */
public final class ViewAdapter {

    @SuppressLint("CheckResult")
    @BindingAdapter(value = {"clickAction", "throttleFirst"}, requireAll = false)
    public static void clickAction(View view, final BindAction action, int milliseconds) {
        RxView.clicks(view)
                .throttleFirst(milliseconds, TimeUnit.MILLISECONDS)
                .subscribe(o -> {
                            if (action != null) {
                                action.go();
                            }
                        },
                        Throwable::printStackTrace);
    }

    @SuppressLint("CheckResult")
    @BindingAdapter(value = {"clickRunnable", "throttleFirst"}, requireAll = false)
    public static void clickRunnable(View view, final Runnable runnable, int milliseconds) {
        RxView.clicks(view)
                .throttleFirst(milliseconds, TimeUnit.MILLISECONDS)
                .subscribe(o -> {
                            if (runnable != null) {
                                runnable.run();
                            }
                        },
                        Throwable::printStackTrace);
    }

    @SuppressLint("CheckResult")
    @BindingAdapter(value = {"longClickAction"})
    public static void longClickAction(View view, final BindAction action) {
        RxView.longClicks(view)
                .subscribe(o -> {
                            if (action != null) {
                                action.go();
                            }
                        },
                        Throwable::printStackTrace);
    }

    @SuppressLint("CheckResult")
    @BindingAdapter(value = {"longClickRunnable"})
    public static void longClickRunnable(View view, final Runnable runnable) {
        RxView.longClicks(view)
                .subscribe(o -> {
                            if (runnable != null) {
                                runnable.run();
                            }
                        },
                        Throwable::printStackTrace);
    }

}

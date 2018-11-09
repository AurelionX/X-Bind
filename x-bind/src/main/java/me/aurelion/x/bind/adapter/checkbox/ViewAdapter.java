package me.aurelion.x.bind.adapter.checkbox;

import android.annotation.SuppressLint;
import android.databinding.BindingAdapter;
import android.widget.CheckBox;

import com.jakewharton.rxbinding2.widget.RxCompoundButton;

import me.aurelion.x.bind.command.BindConsumer;

/**
 * @author Leon (wshk729@163.com)
 * @date 2018/11/8
 */
public final class ViewAdapter {

    @SuppressLint("CheckResult")
    @BindingAdapter(value = {"changeChecked"})
    public static void changeChecked(final CheckBox checkBox, final BindConsumer<Boolean> consumer) {
        RxCompoundButton.checkedChanges(checkBox)
                .subscribe(aBoolean -> {
                            if (consumer != null) {
                                consumer.go(aBoolean);
                            }
                        },
                        Throwable::printStackTrace);
    }

}

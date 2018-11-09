package me.aurelion.x.bind.adapter.edittext;

import android.annotation.SuppressLint;
import android.databinding.BindingAdapter;
import android.widget.EditText;

import com.jakewharton.rxbinding2.widget.RxTextView;

import me.aurelion.x.bind.command.BindConsumer;

/**
 * @author Leon (wshk729@163.com)
 * @date 2018/11/8
 */
public final class ViewAdapter {

    @SuppressLint("CheckResult")
    @BindingAdapter(value = {"changeChecked"})
    public static void changeEdit(final EditText editText, final BindConsumer<String> consumer) {
        RxTextView.textChanges(editText)
                .map(CharSequence::toString)
                .subscribe(s -> {
                            if (consumer != null) {
                                consumer.go(s);
                            }
                        },
                        Throwable::printStackTrace);
    }

}

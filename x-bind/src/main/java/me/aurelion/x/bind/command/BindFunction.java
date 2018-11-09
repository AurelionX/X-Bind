package me.aurelion.x.bind.command;

/**
 * @author Leon (wshk729@163.com)
 * @date 2018/11/8
 */
public class BindFunction<T, R> extends BindCommand {

    private final IBindFunction<T, R> function;

    public BindFunction(IBindFunction<T, R> function) {
        this(function, null);
    }

    public BindFunction(IBindFunction<T, R> function, IBindReply<Boolean> enable) {
        super(enable);
        this.function = function;
    }

    public R go(T t) {
        if (function != null && enable()) {
            return function.apply(t);
        }
        return null;
    }
}

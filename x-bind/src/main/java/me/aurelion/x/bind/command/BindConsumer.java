package me.aurelion.x.bind.command;

/**
 * @author Leon (wshk729@163.com)
 * @date 2018/11/8
 */
public class BindConsumer<T> extends BindCommand {

    private final IBindConsumer<T> consumer;

    public BindConsumer(IBindConsumer<T> consumer) {
        this(consumer, null);
    }

    public BindConsumer(IBindConsumer<T> consumer, IBindReply<Boolean> enable) {
        super(enable);
        this.consumer = consumer;
    }

    public void go(T t) {
        if (consumer != null && enable()) {
            consumer.accept(t);
        }
    }

}

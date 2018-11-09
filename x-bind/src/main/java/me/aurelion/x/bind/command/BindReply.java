package me.aurelion.x.bind.command;

/**
 * @author Leon (wshk729@163.com)
 * @date 2018/11/8
 */
public class BindReply<R> extends BindCommand {

    private final IBindReply<R> reply;

    public BindReply(IBindReply<R> reply) {
        this(reply, null);
    }

    public BindReply(IBindReply<R> reply, IBindReply<Boolean> enable) {
        super(enable);
        this.reply = reply;
    }

    public R go() {
        if (reply != null && enable()) {
            return reply.call();
        }
        return null;
    }
}

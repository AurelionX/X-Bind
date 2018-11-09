package me.aurelion.x.bind.command;

/**
 * @author Leon (wshk729@163.com)
 * @date 2018/11/8
 */
class BindCommand {

    private final IBindReply<Boolean> enable;

    BindCommand(IBindReply<Boolean> enable) {
        this.enable = enable;
    }

    protected boolean enable() {
        if (enable == null) {
            return true;
        }
        return enable.call();
    }

}

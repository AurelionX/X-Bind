package me.aurelion.x.bind.command;

/**
 * @author Leon (wshk729@163.com)
 * @date 2018/11/8
 */
public class BindAction extends BindCommand {

    private final IBindAction action;

    public BindAction(IBindAction action) {
        this(action, null);
    }

    public BindAction(IBindAction action, IBindReply<Boolean> enable) {
        super(enable);
        this.action = action;
    }

    public void go() {
        if (action != null && enable()) {
            action.run();
        }
    }

}

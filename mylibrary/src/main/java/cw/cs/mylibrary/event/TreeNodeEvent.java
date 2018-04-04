package cw.cs.mylibrary.event;

/**
 * 简单的通知事件类
 */

public class TreeNodeEvent {

    public static final int NOTIFY_PARENT = 1;
    public static final int NOTIFY_CHILDREN = 2;
    public static final int NOTIFY_BROTHER = 3;

    private int notifyType;

    public TreeNodeEvent(){
    }

    public TreeNodeEvent(int notifyType) {
        this.notifyType = notifyType;
    }

    public int getNotifyType() {
        return notifyType;
    }

    public void setNotifyType(int notifyType) {
        this.notifyType = notifyType;
    }
}

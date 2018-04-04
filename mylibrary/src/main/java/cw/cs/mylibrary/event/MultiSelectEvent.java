package cw.cs.mylibrary.event;


public class MultiSelectEvent extends TreeNodeEvent {

    public static final int EVENT_SET_SELECTED = 1;
    public static final int EVENT_SET_EXPAND = 2;

    //事件类型
    private int eventType;
    private boolean isSelected;
    private boolean isExpand;

    public MultiSelectEvent() {
    }

    public MultiSelectEvent(int eventType){
        this.eventType = eventType;
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public boolean isExpand() {
        return isExpand;
    }

    public void setExpand(boolean isExpand) {
        this.isExpand = isExpand;
    }
}

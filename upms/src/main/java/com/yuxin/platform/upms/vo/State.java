package com.yuxin.platform.upms.vo;

public class State {

    private boolean checked;
    private boolean expanded;


    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

	/*public State(boolean checked) {
		super();
		this.checked = checked;
	}*/

    public State(boolean checked, boolean expanded) {
        super();
        this.checked = checked;
        this.expanded = expanded;
    }

    public State(boolean expanded) {
        super();
        this.expanded = expanded;
    }


}

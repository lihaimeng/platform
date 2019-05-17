package com.yuxin.platform.common.dto;

import com.yuxin.platform.common.model.SubSealOrder;
import com.yuxin.platform.common.model.SubSealSealxx;

import java.util.List;

public class SubSealOrderRequestDto {
    private SubSealOrder subSealOrder;
    private List<SubSealSealxx> sealxxList;

    public SubSealOrder getSubSealOrder() {
        return subSealOrder;
    }

    public void setSubSealOrder(SubSealOrder subSealOrder) {
        this.subSealOrder = subSealOrder;
    }

    public List<SubSealSealxx> getSealxxList() {
        return sealxxList;
    }

    public void setSealxxList(List<SubSealSealxx> sealxxList) {
        this.sealxxList = sealxxList;
    }
}

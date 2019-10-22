package com.bds.vue.bean;

public enum Status {
    XINJIAN("1", "新建"), LIXIANG("2", "立项"),SUSSEC("3","支付成功"),FAILED("2", "支付失败");;

    private String value;
    private String desc;

    public  String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private Status(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }
    /**
     * 通过状态描述获取状态码
     * @param desc
     * @return
     */
    public static Integer getValueByDesc(String desc){
        String value = "";
        if (desc.equals(Status.XINJIAN.getDesc()) ){
            value = Status.XINJIAN.getValue();
        } else if(desc.equals(Status.LIXIANG.getDesc())){
            value = Status.LIXIANG.getValue();
        } else if(desc.equals(Status.SUSSEC.getDesc())){
            value = Status.SUSSEC.getValue();
        } else if(desc.equals(Status.FAILED.getDesc())){
            value = Status.FAILED.getValue();
        }
        Integer status = Integer.valueOf(value);
        return status;
    }
    /**
     * 通过状态码获取状态描述
     * @param value
     * @return
     */
    public static String getDescByValue(String value){
        String desc = "";
        if (value.equals(Status.XINJIAN.getValue())){
            desc = Status.XINJIAN.getDesc();
        } else if(value.equals(Status.LIXIANG.getValue())){
            desc = Status.LIXIANG.getDesc();
        } else if(value.equals(Status.SUSSEC.getValue())){
            desc = Status.SUSSEC.getDesc();
        } else if(value.equals(Status.FAILED.getValue())){
            desc = Status.FAILED.getDesc();
        }
        return desc;
    }

    public static void main(String[] args) {
        String descByValue = getDescByValue("1");
        System.out.println(descByValue);
    }

}

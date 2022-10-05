package com.example.demo.dto;

public class BaseDto {

    private MainDto TbPublicWifiInfo;

    public BaseDto() {
    }

    public MainDto getTbPublicWifiInfo() {
        return this.TbPublicWifiInfo;
    }

    public void setTbPublicWifiInfo(MainDto TbPublicWifiInfo) {
        this.TbPublicWifiInfo = TbPublicWifiInfo;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof BaseDto)) return false;
        final BaseDto other = (BaseDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$TbPublicWifiInfo = this.getTbPublicWifiInfo();
        final Object other$TbPublicWifiInfo = other.getTbPublicWifiInfo();
        if (this$TbPublicWifiInfo == null ? other$TbPublicWifiInfo != null : !this$TbPublicWifiInfo.equals(other$TbPublicWifiInfo))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BaseDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $TbPublicWifiInfo = this.getTbPublicWifiInfo();
        result = result * PRIME + ($TbPublicWifiInfo == null ? 43 : $TbPublicWifiInfo.hashCode());
        return result;
    }

    public String toString() {
        return "BaseDto(TbPublicWifiInfo=" + this.getTbPublicWifiInfo() + ")";
    }
}

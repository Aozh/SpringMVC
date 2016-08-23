package com.gaussic.model;

import javax.persistence.*;
import java.util.Date;
/**
 * Created by zhaoli8 on 2016/8/22.
 */
@Entity
@Table(name = "permission", schema = "springdemo", catalog = "")
public class PermissionEntity {
    private String pin;
    private Integer add;
    private Integer show;
    private Integer delete;

    @Id
    @Column(name = "pin", nullable = false, length = 20)
    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Basic
    @Column(name = "add", nullable = true)
    public Integer getAdd() {
        return add;
    }

    public void setAdd(Integer add) {
        this.add = add;
    }

    @Basic
    @Column(name = "show", nullable = true)
    public Integer getShow() {
        return show;
    }

    public void setShow(Integer show) {
        this.show = show;
    }

    @Basic
    @Column(name = "delete", nullable = true)
    public Integer getDelete() {
        return delete;
    }

    public void setDelete(Integer delete) {
        this.delete = delete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PermissionEntity that = (PermissionEntity) o;

        if (pin != null ? !pin.equals(that.pin) : that.pin != null) return false;
        if (add != null ? !add.equals(that.add) : that.add != null) return false;
        if (show != null ? !show.equals(that.show) : that.show != null) return false;
        if (delete != null ? !delete.equals(that.delete) : that.delete != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pin != null ? pin.hashCode() : 0;
        result = 31 * result + (add != null ? add.hashCode() : 0);
        result = 31 * result + (show != null ? show.hashCode() : 0);
        result = 31 * result + (delete != null ? delete.hashCode() : 0);
        return result;
    }
}

package com.marchsoft.domain;

import java.io.Serializable;

public class Mg implements Serializable {
    int id;
    int mid;
    int gid;

    public Mg(){}

    public Mg(int mid, int gid) {
        this.mid = mid;
        this.gid = gid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    @Override
    public String toString() {
        return "Mg{" +
                "id=" + id +
                ", mid=" + mid +
                ", gid=" + gid +
                '}';
    }
}

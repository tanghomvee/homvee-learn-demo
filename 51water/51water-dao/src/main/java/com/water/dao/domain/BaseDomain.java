package com.water.dao.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @Package: com.water.dao.domain
 * @Description: TODO
 * @date:2015年12月09日
 * @author: Homvee.Tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2015, DMall All Rights Reserved.
 */
public class BaseDomain implements Serializable {
    protected Long id;
    protected Date creationTime; //创建时间
    protected Date modificationTime;// 修改时间
    protected byte valid=-1;// 该条记录是否有效(0:无效,1:有效)

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(Date modificationTime) {
        this.modificationTime = modificationTime;
    }

    public byte getValid() {
        return valid;
    }

    public void setValid(byte valid) {
        this.valid = valid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

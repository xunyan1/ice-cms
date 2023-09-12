package com.cssl.icewkment.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserRole implements Serializable {
    private Integer userId;

    private Integer roleId;
}

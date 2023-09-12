package com.cssl.icewkment.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class Setting implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;

    /**
     * 备案号
     */
    private String beian;

    /**
     * 版权©️
     */
    private String banquan;

    /**
     * 评论显示
     */
    private boolean comment_show;

    /**
     * 网站标题
     */
    private String sitTitle;

    /**
     * 网站Logo
     */
    private String sitLogo;

    private boolean imageFormat;

    /**
     * 设置访问域名
     */
    private String cosIntage;

    /**
     * 存储桶名称
     */
    private String cosBucketName;

    /**
     * secretId
     */
    private String cosSecretId;

    /**
     * secretKey
     */
    private String cosSecretKey;

    /**
     * bucket的区域
     */
    private String cosClientConfig;

    private Boolean isCos;
}

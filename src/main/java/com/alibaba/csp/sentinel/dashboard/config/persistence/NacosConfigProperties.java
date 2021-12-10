package com.alibaba.csp.sentinel.dashboard.config.persistence;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Nacos配置文件
 *
 * @Program: sentinel-dashboard
 * @Author: ytq
 * @Date: 2021/12/09 19:35:21
 */
@ConfigurationProperties(prefix = "tq.nacos")
public class NacosConfigProperties {
    private String address;
    private String username;
    private String password;
    private String namespace;
    private String groupId;

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(final String namespace) {
        this.namespace = namespace;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(final String groupId) {
        this.groupId = groupId;
    }
}

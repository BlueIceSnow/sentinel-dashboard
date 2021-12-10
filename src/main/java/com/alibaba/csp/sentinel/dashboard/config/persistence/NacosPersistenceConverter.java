package com.alibaba.csp.sentinel.dashboard.config.persistence;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.GatewayFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.AuthorityRuleEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.DegradeRuleEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.FlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.ParamFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.SystemRuleEntity;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.fastjson.JSON;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Nacos持久化转换配置类
 *
 * @Program: sentinel-dashboard
 * @Author: ytq
 * @Date: 2021/12/10 08:37:11
 */
@Configuration
public class NacosPersistenceConverter {


    @Bean
    public Converter<String, List<FlowRuleEntity>> flowConverter() {
        return s -> JSON.parseArray(s, FlowRuleEntity.class);
    }

    @Bean
    public Converter<List<FlowRuleEntity>, String> flowDeConverter() {
        return JSON::toJSONString;
    }

    @Bean
    public Converter<String, List<ParamFlowRuleEntity>> paramFlowConverter() {
        return s -> JSON.parseArray(s, ParamFlowRuleEntity.class);
    }

    @Bean
    public Converter<List<ParamFlowRuleEntity>, String> paramFlowDeConverter() {
        return JSON::toJSONString;
    }

    @Bean
    public Converter<String, List<DegradeRuleEntity>> degradeConverter() {
        return s -> JSON.parseArray(s, DegradeRuleEntity.class);
    }

    @Bean
    public Converter<List<DegradeRuleEntity>, String> degradeDeConverter() {
        return JSON::toJSONString;
    }

    @Bean
    public Converter<String, List<SystemRuleEntity>> systemConverter() {
        return s -> JSON.parseArray(s, SystemRuleEntity.class);
    }

    @Bean
    public Converter<List<SystemRuleEntity>, String> systemDeConverter() {
        return JSON::toJSONString;
    }


    @Bean
    public Converter<String, List<AuthorityRuleEntity>> authorityConverter() {
        return s -> JSON.parseArray(s, AuthorityRuleEntity.class);
    }

    @Bean
    public Converter<List<AuthorityRuleEntity>, String> authorityDeConverter() {
        return JSON::toJSONString;
    }

    @Bean
    public Converter<String, List<GatewayFlowRuleEntity>> gatewayFlowConverter() {
        return s -> JSON.parseArray(s, GatewayFlowRuleEntity.class);
    }

    @Bean
    public Converter<List<GatewayFlowRuleEntity>, String> gatewayFlowDeConverter() {
        return JSON::toJSONString;
    }

}

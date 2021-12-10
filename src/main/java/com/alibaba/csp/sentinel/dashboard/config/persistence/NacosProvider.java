package com.alibaba.csp.sentinel.dashboard.config.persistence;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.GatewayFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.AuthorityRuleEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.DegradeRuleEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.FlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.ParamFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.SystemRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRuleProvider;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.util.StringUtil;
import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * nacos规则提供者
 *
 * @Program: sentinel-dashboard
 * @Author: ytq
 * @Date: 2021/12/09 19:47:50
 */
@Configuration
public class NacosProvider {
    @Resource
    private NacosConfigProperties nacosConfigProperties;

    @Bean
    public DynamicRuleProvider<List<FlowRuleEntity>> flowRuleNacosProvider(
            ConfigService configService, Converter<String, List<FlowRuleEntity>> flowConverter) {
        return appName -> {
            String rules = configService.getConfig(appName + NacosConfigUtil.FLOW_DATA_ID_POSTFIX,
                    nacosConfigProperties.getGroupId(), 3000);
            if (StringUtil.isEmpty(rules)) {
                return new ArrayList<>();
            }
            return flowConverter.convert(rules);
        };
    }

    @Bean
    public DynamicRuleProvider<List<ParamFlowRuleEntity>> paramFlowRuleNacosProvider(
            ConfigService configService,
            Converter<String, List<ParamFlowRuleEntity>> paramFlowConverter) {
        return appName -> {
            String rules =
                    configService.getConfig(appName + NacosConfigUtil.PARAM_FLOW_DATA_ID_POSTFIX,
                            nacosConfigProperties.getGroupId(), 3000);
            if (StringUtil.isEmpty(rules)) {
                return new ArrayList<>();
            }
            return paramFlowConverter.convert(rules);
        };
    }

    @Bean
    public DynamicRuleProvider<List<DegradeRuleEntity>> degradeRuleNacosProvider(
            ConfigService configService,
            Converter<String, List<DegradeRuleEntity>> degradeConverter) {
        return appName -> {
            String rules =
                    configService.getConfig(appName + NacosConfigUtil.DEGRADE_DATA_ID_POSTFIX,
                            nacosConfigProperties.getGroupId(), 3000);
            if (StringUtil.isEmpty(rules)) {
                return new ArrayList<>();
            }
            return degradeConverter.convert(rules);
        };
    }

    @Bean
    public DynamicRuleProvider<List<SystemRuleEntity>> systemRuleNacosProvider(
            ConfigService configService,
            Converter<String, List<SystemRuleEntity>> systemConverter) {
        return appName -> {
            String rules =
                    configService.getConfig(appName + NacosConfigUtil.SYSTEM_DATA_ID_POSTFIX,
                            nacosConfigProperties.getGroupId(), 3000);
            if (StringUtil.isEmpty(rules)) {
                return new ArrayList<>();
            }
            return systemConverter.convert(rules);
        };
    }

    @Bean
    public DynamicRuleProvider<List<AuthorityRuleEntity>> authorityRuleNacosProvider(
            ConfigService configService,
            Converter<String, List<AuthorityRuleEntity>> authorityConverter) {
        return appName -> {
            String rules =
                    configService.getConfig(appName + NacosConfigUtil.AUTHORITY_DATA_ID_POSTFIX,
                            nacosConfigProperties.getGroupId(), 3000);
            if (StringUtil.isEmpty(rules)) {
                return new ArrayList<>();
            }
            return authorityConverter.convert(rules);
        };
    }

    @Bean
    public DynamicRuleProvider<List<GatewayFlowRuleEntity>> gatewayRuleNacosProvider(
            ConfigService configService,
            Converter<String, List<GatewayFlowRuleEntity>> gatewayFlowConverter) {
        return appName -> {
            String rules =
                    configService.getConfig(appName + NacosConfigUtil.GATEWAY_FLOW_DATA_ID_POSTFIX,
                            nacosConfigProperties.getGroupId(), 3000);
            if (StringUtil.isEmpty(rules)) {
                return new ArrayList<>();
            }
            return gatewayFlowConverter.convert(rules);
        };
    }
}

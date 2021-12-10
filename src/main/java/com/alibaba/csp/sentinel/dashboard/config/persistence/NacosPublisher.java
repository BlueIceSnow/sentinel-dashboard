package com.alibaba.csp.sentinel.dashboard.config.persistence;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.GatewayFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.AuthorityRuleEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.DegradeRuleEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.FlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.ParamFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.SystemRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRulePublisher;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.util.AssertUtil;
import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.List;

/**
 * nacos规则发布配置
 *
 * @Program: sentinel-dashboard
 * @Author: ytq
 * @Date: 2021/12/09 19:56:10
 */
@Configuration
public class NacosPublisher {
    @Resource
    private NacosConfigProperties nacosConfigProperties;

    @Bean
    public DynamicRulePublisher<List<FlowRuleEntity>> flowRuleNacosPublisher(
            ConfigService configService, Converter<List<FlowRuleEntity>, String> flowDeConverter) {
        return (app, rules) -> {
            AssertUtil.notEmpty(app, "app name cannot be empty");
            if (rules == null) {
                return;
            }
            configService.publishConfig(app + NacosConfigUtil.FLOW_DATA_ID_POSTFIX,
                    nacosConfigProperties.getGroupId(), flowDeConverter.convert(rules));
        };
    }

    @Bean
    public DynamicRulePublisher<List<ParamFlowRuleEntity>> paramFlowRNacosPublisher(
            ConfigService configService,
            Converter<List<ParamFlowRuleEntity>, String> paramFlowDeConverter) {
        return (app, rules) -> {
            AssertUtil.notEmpty(app, "app name cannot be empty");
            if (rules == null) {
                return;
            }
            configService.publishConfig(app + NacosConfigUtil.PARAM_FLOW_DATA_ID_POSTFIX,
                    nacosConfigProperties.getGroupId(), paramFlowDeConverter.convert(rules));
        };
    }

    @Bean
    public DynamicRulePublisher<List<DegradeRuleEntity>> degradeRuleNacosPublisher(
            ConfigService configService,
            Converter<List<DegradeRuleEntity>, String> degradeDeConverter) {
        return (app, rules) -> {
            AssertUtil.notEmpty(app, "app name cannot be empty");
            if (rules == null) {
                return;
            }
            configService.publishConfig(app + NacosConfigUtil.DEGRADE_DATA_ID_POSTFIX,
                    nacosConfigProperties.getGroupId(), degradeDeConverter.convert(rules));
        };
    }

    @Bean
    public DynamicRulePublisher<List<SystemRuleEntity>> systemRuleNacosPublisher(
            ConfigService configService,
            Converter<List<SystemRuleEntity>, String> systemDeConverter) {
        return (app, rules) -> {
            AssertUtil.notEmpty(app, "app name cannot be empty");
            if (rules == null) {
                return;
            }
            configService.publishConfig(app + NacosConfigUtil.SYSTEM_DATA_ID_POSTFIX,
                    nacosConfigProperties.getGroupId(), systemDeConverter.convert(rules));
        };
    }

    @Bean
    public DynamicRulePublisher<List<AuthorityRuleEntity>> authorityRuleNacosPublisher(
            ConfigService configService,
            Converter<List<AuthorityRuleEntity>, String> authorityDeConverter) {
        return (app, rules) -> {
            AssertUtil.notEmpty(app, "app name cannot be empty");
            if (rules == null) {
                return;
            }
            configService.publishConfig(app + NacosConfigUtil.AUTHORITY_DATA_ID_POSTFIX,
                    nacosConfigProperties.getGroupId(), authorityDeConverter.convert(rules));
        };
    }

    @Bean
    public DynamicRulePublisher<List<GatewayFlowRuleEntity>> gatewayFlowRuleNacosPublisher(
            ConfigService configService,
            Converter<List<GatewayFlowRuleEntity>, String> gatewayFlowDeConverter) {
        return (app, rules) -> {
            AssertUtil.notEmpty(app, "app name cannot be empty");
            if (rules == null) {
                return;
            }
            configService.publishConfig(app + NacosConfigUtil.GATEWAY_FLOW_DATA_ID_POSTFIX,
                    nacosConfigProperties.getGroupId(), gatewayFlowDeConverter.convert(rules));
        };
    }
}

/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.csp.sentinel.dashboard.config.persistence;

import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigFactory;
import com.alibaba.nacos.api.config.ConfigService;
import lombok.Data;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.Properties;

/**
 * @author Eric Zhao
 * @since 1.4.0
 */
@Configuration
@Data
@EnableConfigurationProperties(value = {NacosConfigProperties.class})
public class NacosConfig {

    @Resource
    private NacosConfigProperties nacosConfigProperties;

    @Bean
    public ConfigService nacosConfigService() throws Exception {
        final Properties properties = new Properties();
        properties.put(PropertyKeyConst.SERVER_ADDR, nacosConfigProperties.getAddress());
        properties.put(PropertyKeyConst.NAMESPACE, nacosConfigProperties.getNamespace());
        properties.put(PropertyKeyConst.USERNAME, nacosConfigProperties.getUsername());
        properties.put(PropertyKeyConst.PASSWORD, nacosConfigProperties.getPassword());
        return ConfigFactory.createConfigService(properties);
    }
}

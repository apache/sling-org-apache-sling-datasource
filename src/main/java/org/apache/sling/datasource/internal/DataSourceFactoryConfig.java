/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.sling.datasource.internal;

import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.osgi.service.metatype.annotations.Option;

@SuppressWarnings("java:S100")
@ObjectClassDefinition(
        localization = "OSGI-INF/l10n/metatype",
        name = "%datasource.component.name",
        description = "%datasource.component.description")
public @interface DataSourceFactoryConfig {

    /**
     * Value indicating default value should be used. if the value is set to
     * this value then that value would be treated as null
     */
    String DEFAULT_VAL = "default";

    @AttributeDefinition
    String datasource_name() default "";

    @AttributeDefinition
    String datasource_svc_prop_name() default JNDIDataSourceFactory.PROP_DATASOURCE_NAME;

    @AttributeDefinition
    String url() default "";

    @AttributeDefinition
    String username() default "";

    @AttributeDefinition(type = AttributeType.PASSWORD)
    String password() default "";

    @AttributeDefinition(
            options = {
                    @Option(label = "Default", value = DEFAULT_VAL),
                    @Option(label = "true", value = "true"),
                    @Option(label = "false", value = "false"),
                    @Option(label = "error", value = "error")
            },
            defaultValue = DEFAULT_VAL)
    String defaultAutoCommit();

    @AttributeDefinition(
            options = {
                    @Option(label = "Default", value = DEFAULT_VAL),
                    @Option(label = "true", value = "true"),
                    @Option(label = "false", value = "false"),
                    @Option(label = "error", value = "error")
            },
            defaultValue = DEFAULT_VAL)
    String defaultReadOnly();

    @AttributeDefinition(
            options = {
                    @Option(label = "Default", value = DEFAULT_VAL),
                    @Option(label = "NONE", value = "NONE"),
                    @Option(label = "READ_COMMITTED", value = "READ_COMMITTED"),
                    @Option(label = "READ_UNCOMMITTED", value = "READ_UNCOMMITTED"),
                    @Option(label = "REPEATABLE_READ", value = "REPEATABLE_READ"),
                    @Option(label = "SERIALIZABLE", value = "SERIALIZABLE")
            },
            defaultValue = DEFAULT_VAL)
    String defaultTransactionIsolation();

    @AttributeDefinition
    String driverClassName() default "";

    @AttributeDefinition
    String defaultCatalog() default "";

    @AttributeDefinition
    int maxActive() default PoolProperties.DEFAULT_MAX_ACTIVE;

    @AttributeDefinition
    int maxIdle() default PoolProperties.DEFAULT_MAX_ACTIVE;

    @AttributeDefinition
    int minIdle() default 10; //defaults to initialSize

    @AttributeDefinition
    int initialSize() default 10;

    @AttributeDefinition
    int maxWait() default 30000;

    @AttributeDefinition
    int maxAge() default 0;

    @AttributeDefinition
    boolean testOnBorrow() default false;

    @AttributeDefinition
    boolean testOnReturn() default false;

    @AttributeDefinition
    boolean testWhileIdle() default false;

    @AttributeDefinition
    String validationQuery() default "";

    @AttributeDefinition
    int validationQueryTimeout() default -1;

    @AttributeDefinition
    int timeBetweenEvictionRunsMillis() default 5000;

    @AttributeDefinition
    int minEvictableIdleTimeMillis() default 60000;

    @AttributeDefinition
    String connectionProperties() default "";

    @AttributeDefinition
    String initSQL() default "";

    @AttributeDefinition
    String jdbcInterceptors() default "StatementCache;SlowQueryReport(threshold=10000);ConnectionState";

    @AttributeDefinition
    int validationInterval() default 30000;

    @AttributeDefinition
    boolean logValidationErrors() default true;

    @AttributeDefinition(cardinality = 1024)
    String[] datasource_svc_properties() default {};
}

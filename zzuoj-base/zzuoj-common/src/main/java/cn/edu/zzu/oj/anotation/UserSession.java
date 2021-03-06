/*
 * Copyright 2020-2021 the original author or authors.
 *
 * Licensed under the General Public License, Version 3.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.gnu.org/licenses/gpl-3.0.en.html
 */

package cn.edu.zzu.oj.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * @see cn.edu.zzu.oj.entity.UserSessionDTO
 * @see cn.edu.zzu.oj.config.UserSessionMethodArgumentResolver
 * @see cn.edu.zzu.oj.config.HttpArgumentResolverConfig
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface UserSession {
    boolean nullable() default false;
}
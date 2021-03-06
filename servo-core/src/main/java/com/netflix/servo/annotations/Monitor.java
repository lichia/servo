/*
 * #%L
 * servo
 * %%
 * Copyright (C) 2011 - 2012 Netflix
 * %%
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
 * #L%
 */
package com.netflix.servo.annotations;

import java.lang.annotation.*;

/**
 * Annotation indicating a field or method should be collected for monitoring.
 * The attributes annotated should be thread-safe for access by a background
 * thread. If a method is annotated it should be inexpensive and avoid any
 * potentially costly operations such as IO and networking. Expect that the
 * fields will be polled frequently and cache values that require expensive
 * computation rather than computing them inline.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface Monitor {
    /**
     * Name of the annotated attribute.
     */
    String name();

    /**
     * Type of value that is annotated, for more information see
     * {@link DataSourceType}.
     */
    DataSourceType type() default DataSourceType.INFORMATIONAL;

    /**
     * A human readable description of the annotated attribute.
     */
    String description() default "";
}

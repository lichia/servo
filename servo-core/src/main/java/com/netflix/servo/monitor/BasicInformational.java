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
package com.netflix.servo.monitor;

import com.google.common.base.Objects;

import java.util.concurrent.atomic.AtomicReference;

/**
 * A simple informational implementation that maintains a string value.
 */
public final class BasicInformational extends AbstractMonitor<String> implements Informational {
    private final AtomicReference<String> info = new AtomicReference();

    /**
     * Creates a new instance of the counter.
     */
    public BasicInformational(MonitorConfig config){
        super(config);
    }

    /** Set the value to show for this monitor. */
    public void setValue(String value){
        info.set(value);
    }

    /** {@inheritDoc} */
    @Override
    public String getValue() {
        return info.get();
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof BasicInformational)) {
            return false;
        }
        BasicInformational m = (BasicInformational) obj;
        return config.equals(m.getConfig()) && Objects.equal(info.get(), m.info.get());
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        return Objects.hashCode(config, info.get());
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("config", config)
                .add("info", info.get())
                .toString();
    }
}

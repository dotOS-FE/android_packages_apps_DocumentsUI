/*
 * Copyright (C) 2016 The Android Open Source Project
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

package com.android.documentsui.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.function.Predicate;

import javax.annotation.Nullable;

/**
 * Test {@link Predicate} that can be used to spy on,  control responses from,
 * and make assertions against values tested.
 */
public class TestPredicate<T> implements Predicate<T> {

    private @Nullable T lastValue;
    private boolean nextReturnValue;
    private boolean called;

    @Override
    public boolean test(T t) {
        called = true;
        lastValue = t;
        return nextReturnValue;
    }

    public void assertLastArgument(@Nullable T expected) {
        assertEquals(expected, lastValue);
    }

    public void assertCalled() {
        assertTrue(called);
    }

    public void nextReturn(boolean value) {
        nextReturnValue = value;
    }
}
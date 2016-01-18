/**
 *
 * Copyright (c) 2006-2016, Speedment, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); You may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.speedment.internal.ui.config;

import com.speedment.config.Document;
import com.speedment.internal.ui.config.trait.HasUiVisibleProperties;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import java.util.function.Supplier;
import java.util.stream.Stream;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

/**
 *
 * @author Emil Forslund
 */
public interface DocumentProperty extends Document, HasUiVisibleProperties {
    
    StringProperty stringPropertyOf(String key, Supplier<String> ifEmpty);
    
    IntegerProperty integerPropertyOf(String key, IntSupplier ifEmpty);
    
    LongProperty longPropertyOf(String key, LongSupplier ifEmpty);
    
    DoubleProperty doublePropertyOf(String key, DoubleSupplier ifEmpty);
    
    BooleanProperty booleanPropertyOf(String key, BooleanSupplier ifEmpty);
    
    <T> ObjectProperty<T> objectPropertyOf(String key, Class<T> type, Supplier<T> ifEmpty);

    @Override
    Stream<? extends DocumentProperty> children();
    
    Stream<ObservableList<DocumentProperty>> childrenProperty();
}
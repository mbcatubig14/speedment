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
package com.speedment.config.db.trait;

import com.speedment.annotation.Api;
import com.speedment.config.Document;
import com.speedment.internal.util.document.TraitUtil.AbstractTraitView;
import static com.speedment.internal.util.document.TraitUtil.viewOf;
import java.util.Map;

/**
 * Trait for {@link Document} implementations that implement the 
 * {@link #isNullable()} method.
 * 
 * @author   Emil Forslund
 * @version  2.3
 */
@Api(version = "2.3")
public interface HasNullable extends Document {
    
    /**
     * The key of the {@code nullable} property.
     */
    final String NULLABLE = "nullable";
    
    /**
     * Returns whether or not this column can hold {@code null} values.
     *
     * @return  {@code true} if null values are tolerated, else {@code false}
     */
    default boolean isNullable() {
        return getAsBoolean(NULLABLE).orElse(true);
    }
    
    /**
     * Returns a wrapper of the specified document that implements the 
     * {@link HasNullable} trait. If the specified document already implements 
     * the trait, it is returned unwrapped.
     * 
     * @param document  the document to wrap
     * @return          the wrapper
     */
    static HasNullable of(Document document) {
        return viewOf(document, HasNullable.class, HasNullableView::new);
    }
}

/**
 * A wrapper class that makes sure that a given {@link Document} implements the
 * {@link HasNullable} trait.
 * 
 * @author  Emil Forslund
 * @since   2.3
 */
class HasNullableView extends AbstractTraitView implements HasNullable {

    /**
     * Constructs a new nullable view of with the specified parent and data.
     * 
     * @param parent         the parent of the wrapped document
     * @param data           the data of the wrapped document
     * @param mainInterface  the main interface of the wrapped document
     */
    HasNullableView(Document parent, Map<String, Object> data, Class<? extends Document> mainInterface) {
        super(parent, data, mainInterface);
    }
}
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
package com.speedment.field.predicate;

import com.speedment.annotation.Api;
import com.speedment.field.predicate.trait.HasEffectivePredicateType;
import com.speedment.field.predicate.trait.HasFieldTrait;
import com.speedment.field.predicate.trait.HasGetter;
import com.speedment.field.predicate.trait.HasNegated;
import com.speedment.field.predicate.trait.HasPredicateType;
import com.speedment.field.predicate.trait.HasReferenceFieldTrait;
import java.util.function.Predicate;

/**
 * The base interface for all {@link Predicate predicates} generated by
 * Speedment entity fields.
 * 
 * @param <ENTITY>  the entity type
 * @param <D>       the database type
 * @param <V>       the value type
 * 
 * @author  Per Minborg
 * @since   2.1
 */
@Api(version = "2.3")
public interface SpeedmentPredicate<ENTITY, D, V> extends
    HasGetter<ENTITY, V>,
    HasPredicateType,
    HasEffectivePredicateType,
    HasFieldTrait,
    HasReferenceFieldTrait<ENTITY, D, V>,
    HasNegated,
    Predicate<ENTITY> {

    @Override
    SpeedmentPredicate<ENTITY, D, V> negate();
}
/*
 * Copyright 2013-2017 the original author or authors.
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
package gameshop.catalog;

import org.salespointframework.catalog.Catalog;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import gameshop.catalog.Game.GameType;

/**
 * An extension of {@link Catalog} to add video shop specific query methods.
 * 
 * @author Oliver Gierke
 */
public interface GameCatalog extends Catalog<Game> {

	static final Sort DEFAULT_SORT = new Sort(Direction.DESC, "productIdentifier");

	/**
	 * Returns all {@link Game}s by type ordered by the given {@link Sort}.
	 * 
	 * @param type must not be {@literal null}.
	 * @param sort must not be {@literal null}.
	 * @return
	 */
	Iterable<Game> findByType(GameType type, Sort sort);

	/**
	 * Returns all {@link Game}s by type ordered their identifier.
	 * 
	 * @param type must not be {@literal null}.
	 * @param sort must not be {@literal null}.
	 * @return
	 */
	default Iterable<Game> findByType(GameType type) {
		return findByType(type, DEFAULT_SORT);
	}
}

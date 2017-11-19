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
package gameshop.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import gameshop.AbstractIntegrationTests;
import gameshop.catalog.Game;
import gameshop.catalog.GameCatalog;
import gameshop.catalog.Game.GameType;

/**
 * Integration tests for {@link GameCatalog}.
 * 
 * @author Oliver Gierke
 * @author Andreas Zaschka
 */
public class GameCatalogIntegrationTests extends AbstractIntegrationTests {

	@Autowired GameCatalog catalog;

	@Test
	public void findsAllMulti() {

		Iterable<Game> result = catalog.findByType(GameType.MULTI);
		assertThat(result).hasSize(9);
	}

	/**
	 * @see #50
	 */
	@Test
	public void discsDontHaveAnyCategoriesAssigned() {

		for (Game game : catalog.findByType(GameType.MULTI)) {
			assertThat(game.getCategories()).isEmpty();
		}
	}
}

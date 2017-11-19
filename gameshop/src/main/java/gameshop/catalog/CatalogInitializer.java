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

import static org.salespointframework.core.Currencies.*;

import org.javamoney.moneta.Money;
import org.salespointframework.core.DataInitializer;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import gameshop.catalog.Game.GameType;

/**
 * A {@link DataInitializer} implementation that will create dummy data for the application on application startup.
 * 
 * @author Paul Henke
 * @author Oliver Gierke
 * @see DataInitializer
 */
@Component
@Order(20)
class CatalogInitializer implements DataInitializer {

	private final GameCatalog gameCatalog;

	CatalogInitializer(GameCatalog gameCatalog) {

		Assert.notNull(gameCatalog, "VideoCatalog must not be null!");

		this.gameCatalog = gameCatalog;
	}

	/* 
	 * (non-Javadoc)
	 * @see org.salespointframework.core.DataInitializer#initialize()
	 */
	@Override
	public void initialize() {

		if (gameCatalog.findAll().iterator().hasNext()) {
			return;
		}

		gameCatalog.save(new Game("Last Action Hero", "lac", Money.of(100, EURO), "Äktschn/Comedy", GameType.SINGLE));
		gameCatalog.save(new Game("Back to the Future", "bttf", Money.of(9.99, EURO), "Sci-Fi", GameType.SINGLE));
		gameCatalog.save(new Game("Fido", "fido", Money.of(9.99, EURO), "Comedy/Drama/Horror", GameType.SINGLE));
		gameCatalog.save(new Game("Super Fuzz", "sf", Money.of(9.99, EURO), "Action/Sci-Fi/Comedy", GameType.SINGLE));
		gameCatalog.save(new Game("Armour of God II: Operation Condor", "aog2oc", Money.of(14.99, EURO),
				"Action/Adventure/Comedy", GameType.SINGLE));
		gameCatalog.save(new Game("Persepolis", "pers", Money.of(14.99, EURO), "Animation/Biography/Drama", GameType.SINGLE));
		gameCatalog
				.save(new Game("Hot Shots! Part Deux", "hspd", Money.of(9999.0, EURO), "Action/Comedy/War", GameType.SINGLE));
		gameCatalog.save(new Game("Avatar: The Last Airbender", "tla", Money.of(19.99, EURO), "Animation/Action/Adventure",
				GameType.SINGLE));

		gameCatalog.save(new Game("Secretary", "secretary", Money.of(6.99, EURO), "Political Drama", GameType.MULTI));
		gameCatalog.save(new Game("The Godfather", "tg", Money.of(19.99, EURO), "Crime/Drama", GameType.MULTI));
		gameCatalog
				.save(new Game("No Retreat, No Surrender", "nrns", Money.of(29.99, EURO), "Martial Arts", GameType.MULTI));
		gameCatalog
				.save(new Game("The Princess Bride", "tpb", Money.of(39.99, EURO), "Adventure/Comedy/Family", GameType.MULTI));
		gameCatalog.save(new Game("Top Secret!", "ts", Money.of(39.99, EURO), "Comedy", GameType.MULTI));
		gameCatalog
				.save(new Game("The Iron Giant", "tig", Money.of(34.99, EURO), "Animation/Action/Adventure", GameType.MULTI));
		gameCatalog.save(new Game("Battle Royale", "br", Money.of(19.99, EURO), "Action/Drama/Thriller", GameType.MULTI));
		gameCatalog.save(new Game("Oldboy", "old", Money.of(24.99, EURO), "Action/Drama/Thriller", GameType.MULTI));
		gameCatalog.save(new Game("Bill & Ted's Excellent Adventure", "bt", Money.of(29.99, EURO),
				"Adventure/Comedy/Family", GameType.MULTI));
	}
}

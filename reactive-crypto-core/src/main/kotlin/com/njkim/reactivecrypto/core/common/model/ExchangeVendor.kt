/*
 * Copyright 2019 namjug-kim
 *
 * LINE Corporation licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.njkim.reactivecrypto.core.common.model

enum class ExchangeVendor(val implementedClassName: String) {
    UPBIT("com.njkim.reactivecrypto.upbit.UpbitWebsocketClient"),
    BINANCE("com.njkim.reactivecrypto.binance.BinanceWebsocketClient"),
    HUOBI_KOREA("com.njkim.reactivecrypto.huobikorea.HuobiKoreaWebsocketClient"),
    OKEX("com.njkim.reactivecrypto.okex.OkexWebsocketClient"),
    BITHUMB("com.njkim.reactivecrypto.bithumb.BithumbWebsocketClient"),
    HUBI("com.njkim.reactivecrypto.hubi.HubiWebsocketClient"),
    BITMEX("com.njkim.reactivecrypto.bitmex.BitmexWebsocketClient"),
    KRAKEN("com.njkim.reactivecrypto.kraken.KrakenWebsocketClient"),
    BITMAX("com.njkim.reactivecrypto.bitmax.BitmaxWebsocketClient"),
    IDAX("com.njkim.reactivecrypto.idax.IdaxWebsocketClient"),
    COINEAL("com.njkim.reactivecrypto.coineal.CoinealWebsocketClient")
}
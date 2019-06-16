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

package com.njkim.reactivecrypto.bitstamp.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.njkim.reactivecrypto.core.common.model.order.TradeSideType
import java.math.BigDecimal
import java.time.ZonedDateTime

data class BitstampTradeEvent(
    @JsonProperty("microtimestamp")
    val microTimestamp: ZonedDateTime,
    @JsonProperty("buy_order_id")
    val buyOrderId: Long,
    @JsonProperty("sell_order_id")
    val sellOrderId: Long,
    @JsonProperty("amount_str")
    val amount: BigDecimal,
    @JsonProperty("price_str")
    val price: BigDecimal,
    @JsonProperty("timestamp")
    val timestamp: ZonedDateTime,
    @JsonProperty("type")
    val type: TradeSideType,
    @JsonProperty("id")
    val id: Long
)

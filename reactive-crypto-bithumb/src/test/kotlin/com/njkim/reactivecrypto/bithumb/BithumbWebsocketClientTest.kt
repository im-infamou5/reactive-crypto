package com.njkim.reactivecrypto.bithumb

import com.njkim.reactivecrypto.core.common.model.ExchangeVendor
import com.njkim.reactivecrypto.core.common.model.currency.CurrencyPair
import mu.KotlinLogging
import org.assertj.core.api.Assertions
import org.junit.Test
import reactor.test.StepVerifier
import java.math.BigDecimal

class BithumbWebsocketClientTest {
    private val log = KotlinLogging.logger {}

    @Test
    fun `bithumb tick data subscribe`() {
        // given
        val targetCurrencyPairs = listOf(
            CurrencyPair.parse("BTC", "KRW"),
            CurrencyPair.parse("ETH", "KRW")
        )
        val bithumbTickDataFlux = BithumbWebsocketClient()
            .createTradeWebsocket(targetCurrencyPairs)
            .doOnNext { log.debug { it } }

        // when
        StepVerifier.create(bithumbTickDataFlux.limitRequest(5))
            // then
            .expectNextCount(3)
            .assertNext {
                Assertions.assertThat(it).isNotNull
                Assertions.assertThat(targetCurrencyPairs.contains(it.currencyPair))
                    .isTrue()
                Assertions.assertThat(it.exchangeVendor)
                    .isEqualByComparingTo(ExchangeVendor.BITHUMB)
                Assertions.assertThat(it.price)
                    .isGreaterThan(BigDecimal.ZERO)
                Assertions.assertThat(it.quantity)
                    .isGreaterThan(BigDecimal.ZERO)
            }
            .assertNext {
                Assertions.assertThat(it).isNotNull
                Assertions.assertThat(targetCurrencyPairs.contains(it.currencyPair))
                    .isTrue()
                Assertions.assertThat(it.exchangeVendor)
                    .isEqualByComparingTo(ExchangeVendor.BITHUMB)
                Assertions.assertThat(it.price)
                    .isGreaterThan(BigDecimal.ZERO)
                Assertions.assertThat(it.quantity)
                    .isGreaterThan(BigDecimal.ZERO)
            }
            .verifyComplete()
    }

    @Test
    fun `bithumb orderBook subscribe`() {
        // given
        val targetCurrencyPair = CurrencyPair.parse("BTC", "KRW")
        val orderBookFlux = BithumbWebsocketClient()
            .createDepthSnapshot(listOf(targetCurrencyPair))
            .doOnNext { log.debug { it } }

        // when
        StepVerifier.create(orderBookFlux.limitRequest(5))
            // then
            .expectNextCount(3)
            .assertNext {
                Assertions.assertThat(it).isNotNull
                Assertions.assertThat(it.currencyPair)
                    .isEqualTo(targetCurrencyPair)
                Assertions.assertThat(it.exchangeVendor)
                    .isEqualByComparingTo(ExchangeVendor.BITHUMB)
                Assertions.assertThat(it.asks)
                    .isNotEmpty
                Assertions.assertThat(it.bids)
                    .isNotEmpty

                Assertions.assertThat(it.asks[0].quantity)
                    .isGreaterThan(BigDecimal.ZERO)
                Assertions.assertThat(it.bids[0].quantity)
                    .isGreaterThan(BigDecimal.ZERO)

                Assertions.assertThat(it.asks[0].price)
                    .withFailMessage("ask price must be bigger than bid price")
                    .isGreaterThan(it.bids[0].price)

                Assertions.assertThat(it.asks[0].price)
                    .withFailMessage("asks must be sorted by price asc")
                    .isLessThan(it.asks[1].price)
                Assertions.assertThat(it.bids[0].price)
                    .withFailMessage("bids must be sorted by price desc")
                    .isGreaterThan(it.bids[1].price)
            }
            .assertNext {
                Assertions.assertThat(it).isNotNull
                Assertions.assertThat(it.currencyPair)
                    .isEqualTo(targetCurrencyPair)
                Assertions.assertThat(it.exchangeVendor)
                    .isEqualByComparingTo(ExchangeVendor.BITHUMB)
                Assertions.assertThat(it.asks)
                    .isNotEmpty
                Assertions.assertThat(it.bids)
                    .isNotEmpty

                Assertions.assertThat(it.asks[0].quantity)
                    .isGreaterThan(BigDecimal.ZERO)
                Assertions.assertThat(it.bids[0].quantity)
                    .isGreaterThan(BigDecimal.ZERO)

                Assertions.assertThat(it.asks[0].price)
                    .withFailMessage("ask price must be bigger than bid price")
                    .isGreaterThan(it.bids[0].price)

                Assertions.assertThat(it.asks[0].price)
                    .withFailMessage("asks must be sorted by price asc")
                    .isLessThan(it.asks[1].price)
                Assertions.assertThat(it.bids[0].price)
                    .withFailMessage("bids must be sorted by price desc")
                    .isGreaterThan(it.bids[1].price)
            }
            .verifyComplete()
    }
}
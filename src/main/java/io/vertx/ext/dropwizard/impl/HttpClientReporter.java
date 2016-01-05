package io.vertx.ext.dropwizard.impl;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.RatioGauge;
import io.vertx.core.net.SocketAddress;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
class HttpClientReporter extends HttpMetricsImpl {

  volatile int totalMaxPoolSize;

  public HttpClientReporter(MetricRegistry registry, String baseName, SocketAddress localAdress) {
    super(registry, baseName, localAdress);

    // max pool size gauge
    gauge(() -> totalMaxPoolSize, "connections", "max-pool-size");

    // connection pool ratio
    RatioGauge gauge = new RatioGauge() {
      @Override
      protected Ratio getRatio() {
        return Ratio.of(connections(), totalMaxPoolSize);
      }
    };
    gauge(gauge, "connections", "pool-ratio");
  }

  void incMaxPoolSize(int maxPoolSize) {
    totalMaxPoolSize += maxPoolSize;
  }

  void decMaxPoolSize(int maxPoolSize) {
    totalMaxPoolSize -= maxPoolSize;
  }
}

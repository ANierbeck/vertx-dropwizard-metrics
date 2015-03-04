/**
 * == Metrics
 *
 * Vert.x provides a fairly simple API to retrieve metrics via the {@link io.vertx.core.metrics.Measured Measured} interface
 * which is implemented by various Vert.x components like {@link io.vertx.core.http.HttpServer HttpServer}, {@link io.vertx.core.net.NetServer},
 * and even {@link io.vertx.core.Vertx Vertx} itself.
 *
 * By default Vert.x does not record any metrics. Instead it provides an SPI for others to implement like https://github.com/vert-x3/vertx-metrics[vertx-metrics]
 * which can be added to the classpath. Once added, you can enable metrics by doing the following:
 * [source,$lang]
 * ----
 * {@link examples.MetricsExamples#example2}
 * ----
 *
 * Once enabled, you can retrieve metrics from any {@link io.vertx.core.metrics.Measured Measured} object which provides
 * a map of the metric name to the data, represented by a {@link io.vertx.core.json.JsonObject}. So for example if we were to print
 * out all metrics for a particular Vert.x instance:
 * [source,$lang]
 * ----
 * {@link examples.MetricsExamples#example1}
 * ----
 *
 * NOTE: For details on the actual contents of the data (the actual metric) represented by the {@link io.vertx.core.json.JsonObject}
 * consult the implementation documentation like https://github.com/vert-x3/vertx-metrics[vertx-metrics]
 *
 * Often it is desired that you only want to capture specific metrics for a particular component, like an http server
 * without having to know the details of the naming scheme of every metric (something which is left to the implementers of the SPI).
 *
 * Since {@link io.vertx.core.http.HttpServer HttpServer} implements {@link io.vertx.core.metrics.Measured}, you can easily grab all metrics
 * that are specific for that particular http server.
 * [source,$lang]
 * ----
 * {@link examples.MetricsExamples#example3}
 * ----
 */
@GenModule(name = "vertx-metrics")
@Document(fileName = "index.adoc")
package io.vertx.ext.metrics;

import io.vertx.codegen.annotations.GenModule;
import io.vertx.docgen.Document;
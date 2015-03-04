/*
 * Copyright (c) 2011-2013 The original author or authors
 *  ------------------------------------------------------
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Apache License v2.0 which accompanies this distribution.
 *
 *      The Eclipse Public License is available at
 *      http://www.eclipse.org/legal/epl-v10.html
 *
 *      The Apache License v2.0 is available at
 *      http://www.opensource.org/licenses/apache2.0.php
 *
 *  You may elect to redistribute this code under either of these licenses.
 */

package io.vertx.ext.metrics;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;
import io.vertx.core.metrics.MetricsOptions;

/**
 * Vert.x metrics service configuration.
 *
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
@DataObject
public class MetricsServiceOptions extends MetricsOptions {

  /**
   * The default value of metrics enabled false
   */
  public static final boolean DEFAULT_METRICS_ENABLED = false;

  /**
   * The default value of JMX enabled = false
   */
  public static final boolean DEFAULT_JMX_ENABLED = false;

  private boolean enabled;
  private String name;
  private boolean jmxEnabled;
  private String jmxDomain;

  /**
   * Default constructor
   */
  public MetricsServiceOptions() {
    enabled = DEFAULT_METRICS_ENABLED;
    jmxEnabled = DEFAULT_JMX_ENABLED;
  }

  /**
   * Copy constructor
   *
   * @param other The other {@link io.vertx.ext.metrics.MetricsServiceOptions} to copy when creating this
   */
  public MetricsServiceOptions(MetricsServiceOptions other) {
    this.enabled = other.isEnabled();
    this.name = other.getName();
    this.jmxEnabled = other.isJmxEnabled();
    this.jmxDomain = other.getJmxDomain();
  }

  /**
   * Create an instance from a {@link io.vertx.core.json.JsonObject}
   *
   * @param json the JsonObject to create it from
   */
  public MetricsServiceOptions(JsonObject json) {
    this.enabled = json.getBoolean("enabled", DEFAULT_METRICS_ENABLED);
    this.name = json.getString("name");
    this.jmxEnabled = json.getBoolean("jmxEnabled", DEFAULT_JMX_ENABLED);
    this.jmxDomain = json.getString("jmxDomain");
  }

  /**
   * Will metrics be enabled on the Vert.x instance?
   *
   * @return true if enabled, false if not.
   */
  public boolean isEnabled() {
    return enabled;
  }

  /**
   * Set whether metrics will be enabled on the Vert.x instance.
   *
   * @param enable true if metrics enabled, or false if not.
   * @return a reference to this, so the API can be used fluently
   */
  public MetricsServiceOptions setEnabled(boolean enable) {
    this.enabled = enable;
    return this;
  }

  /**
   * An optional name used by the metrics implementation for namespacing or registering the metrics.
   *
   * @return the metrics name
   */
  public String getName() {
    return name;
  }

  /**
   * Set the name used by the metrics implementation for namespacing or registering the metrics.
   *
   * @param name the name
   * @return a reference to this, so the API can be used fluently
   */
  public MetricsServiceOptions setName(String name) {
    this.name = name;
    return this;
  }

  /**
   * Will JMX be enabled on the Vert.x instance?
   *
   * @return true if enabled, false if not.
   */
  public boolean isJmxEnabled() {
    return jmxEnabled;
  }

  /**
   * Set whether JMX will be enabled on the Vert.x instance.
   *
   * @param jmxEnabled true if JMX enabled, or false if not.
   * @return a reference to this, so the API can be used fluently
   */
  public MetricsServiceOptions setJmxEnabled(boolean jmxEnabled) {
    this.jmxEnabled = jmxEnabled;
    if (jmxEnabled) enabled = true;
    return this;
  }

  /**
   * Get the JMX domain to use when JMX metrics are enabled.
   *
   * @return the JMX domain
   */
  public String getJmxDomain() {
    return jmxDomain;
  }

  /**
   * Set the JMX domain to use when JMX metrics are enabled.
   *
   * @param jmxDomain  the JMX domain
   * @return a reference to this, so the API can be used fluently
   */
  public MetricsServiceOptions setJmxDomain(String jmxDomain) {
    this.jmxDomain = jmxDomain;
    return this;
  }
}

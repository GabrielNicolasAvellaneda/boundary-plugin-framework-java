package com.boundary.plugin.sdk;

public class MetricDefinitionBuilder {

	private String name;
	private String displayName;
	private String displayNameShort;
	private String description;
	private long defaultResolutionMS;
	private MetricAggregate defaultAggregate;
	private MetricUnit unit;
	private boolean isDisabled;
	
	public MetricDefinitionBuilder() {
		this.name = "";
		this.displayName = "";
		this.description = "";
		this.defaultResolutionMS = 1000L;
		this.defaultAggregate = MetricAggregate.avg;
		this.unit = MetricUnit.number;
	}
	
	public MetricDefinitionBuilder setName(String name) {
		this.name = name;
		return this;
	}
	public MetricDefinitionBuilder setDisplayName(String displayName) {
		this.displayName = displayName;
		return this;
	}
	public MetricDefinitionBuilder setDisplayNameShort(String displayNameShort) {
		this.displayNameShort = displayNameShort;
		return this;
	}
	public MetricDefinitionBuilder setDescription(String description) {
		this.description = description;
		return this;
	}
	public MetricDefinitionBuilder setDefaultResolutionMS(long defaultResolutionMS) {
		this.defaultResolutionMS = defaultResolutionMS;
		return this;
	}
	public MetricDefinitionBuilder setDefaultAggregate(MetricAggregate defaultAggregate) {
		this.defaultAggregate = defaultAggregate;
		return this;
	}
	public MetricDefinitionBuilder setUnit(MetricUnit unit) {
		this.unit = unit;
		return this;
	}
	
	public MetricDefinition build() {
		MetricDefinition m = new MetricDefinition();
		m.defaultAggregate = this.defaultAggregate;
		m.defaultResolutionMS = this.defaultResolutionMS;
		m.description = this.description;
		m.displayName = this.displayName;
		m.displayNameShort = this.displayNameShort;
		m.isDisabled = this.isDisabled;
		m.name = this.name;
		m.unit = this.unit;

		return m;
	}
}

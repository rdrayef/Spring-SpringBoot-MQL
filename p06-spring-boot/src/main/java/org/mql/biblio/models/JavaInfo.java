package org.mql.biblio.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JavaInfo {
	@Value("${java.specification.name}")
	private String name;
	@Value("${java.version}")
	private String version;
	@Value("${java.version.date}")
	private String date;	
	@Value("${java.vendor}")
	private String vendor;
	@Value("${java.vendor.url}")
	private String url;
	@Value("${java.runtime.name}")
	private String jre;
	@Value("${java.home}")
	private String home;

	public String getName() {
		return name;
	}

	public String getVersion() {
		return version;
	}

	public String getDate() {
		return date;
	}

	public String getVendor() {
		return vendor;
	}

	public String getUrl() {
		return url;
	}

	public String getJre() {
		return jre;
	}

	public String getHome() {
		return home;
	}

}

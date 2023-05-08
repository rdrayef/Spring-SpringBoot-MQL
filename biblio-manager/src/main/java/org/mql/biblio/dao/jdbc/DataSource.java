package org.mql.biblio.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//Si j'utilise pas propertysource il va chercher dans application.properties
@PropertySource("classpath:biblio.properties")
public class DataSource {
	@Value("${biblio.ds.driver}")
	private String driver;
	@Value("${biblio.ds.bridge}")
	private String bridge;
	@Value("${biblio.ds.host}")
	private String host;
	@Value("${biblio.ds.source}")
	private String source;
	@Value("${biblio.ds.user}")
	private String user;
	@Value("${biblio.ds.password}")
	private String password;

	public DataSource() {
		// TODO Auto-generated constructor stub
	}

	public DataSource(String driver, String bridge, String host, String source, String user, String password) {
		super();
		this.driver = driver;
		this.bridge = bridge;
		this.host = host;
		this.source = source;
		this.user = user;
		this.password = password;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getBridge() {
		return bridge;
	}

	public void setBridge(String bridge) {
		this.bridge = bridge;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Connection getConnection() {
		try {
			// 1- Chargement du Driver
			Class.forName(driver);
			// 2- Composition URL
			String url = bridge + "//" + host + "/" + source;
			// 3- Connexion
			Connection db = DriverManager.getConnection(url, user, password);
			System.out.println("Connexion bien établie");
			return db;

		} catch (Exception ex) {
			System.out.println("Erreur: " + ex.getMessage());
			return null;
		}
	}

}

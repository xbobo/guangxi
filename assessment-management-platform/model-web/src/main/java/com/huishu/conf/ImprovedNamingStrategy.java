/*package com.huishu.conf;

import org.apache.commons.lang.StringUtils;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;

public class ImprovedNamingStrategy  extends SpringPhysicalNamingStrategy{

	 	*//**
	 * 
	 *//*
	private static final long serialVersionUID = -6313582279794287890L;

		@Override
	    public Identifier toPhysicalCatalogName(Identifier identifier, JdbcEnvironment jdbcEnv) {
			 return convert(identifier);
	    }

	    @Override
	    public Identifier toPhysicalColumnName(Identifier identifier, JdbcEnvironment jdbcEnv) {
	    	 return convert(identifier);
	    }

	    @Override
	    public Identifier toPhysicalSchemaName(Identifier identifier, JdbcEnvironment jdbcEnv) {
	    	 return convert(identifier);
	    }

	    @Override
	    public Identifier toPhysicalSequenceName(Identifier identifier, JdbcEnvironment jdbcEnv) {
	    	 return convert(identifier);
	    }

	    @Override
	    public Identifier toPhysicalTableName(Identifier identifier, JdbcEnvironment jdbcEnv) {
	    	 return convert(identifier);
	    }
	    private Identifier convert(Identifier identifier) {
	        if (identifier == null || StringUtils.isBlank(identifier.getText())) {
	            return identifier;
	        }

	        String regex = "([a-z])([A-Z])";
	        String newName = identifier.getText().toUpperCase();
	        return Identifier.toIdentifier(newName);
	    }
}
*/
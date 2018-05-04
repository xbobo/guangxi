package com.huishu.conf;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.boot.model.naming.EntityNaming;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.ImplicitBasicColumnNameSource;
import org.hibernate.boot.model.naming.ImplicitCollectionTableNameSource;
import org.hibernate.boot.model.naming.ImplicitEntityNameSource;
import org.hibernate.boot.model.naming.ImplicitJoinTableNameSource;
import org.hibernate.boot.model.naming.ImplicitNamingStrategy;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.internal.util.StringHelper;
 
public class MyImplicitNamingStrategy extends ImplicitNamingStrategyJpaCompliantImpl implements ImplicitNamingStrategy{
    /**
	 * 
	 */
	private static final long serialVersionUID = -1783599788222948168L;

	@Override
    public Identifier determineBasicColumnName(ImplicitBasicColumnNameSource source) {
        return convert(source);
    }

    private Identifier convert(ImplicitBasicColumnNameSource source) {
        if (StringUtils.isBlank(transformAttributePath(source.getAttributePath()))) {
            return toIdentifier(transformAttributePath(source.getAttributePath()), 
                                source.getBuildingContext());
        }

        String regex = "([a-z])([A-Z])";
        String replacement = "";
//        String newName = transformAttributePath(source.getAttributePath())
//                .replaceAll(regex, replacement).toLowerCase();
        String newName = transformAttributePath(source.getAttributePath());
        return toIdentifier(newName, source.getBuildingContext());
    }
}

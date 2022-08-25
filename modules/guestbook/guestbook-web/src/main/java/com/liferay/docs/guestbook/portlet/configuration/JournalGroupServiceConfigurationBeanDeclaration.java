package com.liferay.docs.guestbook.portlet.configuration;

import aQute.bnd.annotation.component.Component;
import com.liferay.journal.configuration.JournalGroupServiceConfiguration;
import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;

@Component
public class JournalGroupServiceConfigurationBeanDeclaration implements ConfigurationBeanDeclaration {
    @Override
    public Class<?> getConfigurationBeanClass() {
        return JournalGroupServiceConfiguration.class;
    }

}

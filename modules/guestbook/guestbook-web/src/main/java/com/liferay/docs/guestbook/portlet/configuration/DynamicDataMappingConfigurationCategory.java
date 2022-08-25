package com.liferay.docs.guestbook.portlet.configuration;

import com.liferay.configuration.admin.category.ConfigurationCategory;
import org.osgi.service.component.annotations.Component;

@Component
public class DynamicDataMappingConfigurationCategory
    implements ConfigurationCategory {

    @Override
    public String getCategoryIcon() {
        return "dynamic-data-list";
    }

    @Override
    public String getCategoryKey() {
        return _KEY;
    }

    @Override
    public String getCategorySection() {
        return _CATEGORY_SET_KEY;
    }

    private static final String _CATEGORY_SET_KEY = "content-management";

    private static final String _KEY = "dynamic-data-mapping";

}

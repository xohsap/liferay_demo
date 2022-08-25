package com.liferay.docs.guestbook.portlet.configuration;

import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(
    category = "dynamic-data-mapping",
    scope = ExtendedObjectClassDefinition.Scope.GROUP
)
@Meta.OCD(
    id = "com.liferay.dynamic.data.mapping.form.web.configuration.DDMFormWebConfiguration",
    localization = "content/Language",
    name = "ddm-form-web-configuration-name"
)
public interface DDMFormWebConfiguration {

    @Meta.AD(
        deflt = "1", description = "autosave-interval-description",
        name = "autosave-interval-name", required = false
    )
    public int autosaveInterval();

    @Meta.AD(
        deflt = "descriptive", name = "default-display-view",
        optionLabels = {"Descriptive", "List"},
        optionValues = {"descriptive", "list"}, required = false
    )
    public String defaultDisplayView();

    @Meta.AD(required = false)
    public String favoriteColor();

}

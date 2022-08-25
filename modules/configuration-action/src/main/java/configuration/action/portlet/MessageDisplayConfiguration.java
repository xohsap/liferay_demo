package configuration.action.portlet;

import aQute.bnd.annotation.metatype.Meta;


@Meta.OCD(
    id = "com.liferay.blade.samples.configurationaction.MessageDisplayConfiguration"
)
public interface MessageDisplayConfiguration {

    @Meta.AD(required = false)
    public String fontColor();

    @Meta.AD(required = false)
    public String fontFamily();

    @Meta.AD(required = false)
    public int fontSize();

}

package configuration.action.portlet;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import configuration.action.constants.BladeMessagePortletKeys;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;

@Component(
    configurationPid = "com.liferay.blade.samples.configurationaction.MessageDisplayConfiguration",
    configurationPolicy = ConfigurationPolicy.OPTIONAL, immediate = true,
    property = "javax.portlet.name=" + BladeMessagePortletKeys.BLADE_MESSAGE_PORTLET,
    service = ConfigurationAction.class
)
public class MessageDisplayConfigurationAction
    extends DefaultConfigurationAction {

    @Override
    public void include(
        PortletConfig portletConfig, HttpServletRequest httpServletRequest,
        HttpServletResponse httpServletResponse)
        throws Exception {

        if (_log.isInfoEnabled()) {
            _log.info("Blade Message Portlet configuration include");
        }

        httpServletRequest.setAttribute(
            MessageDisplayConfiguration.class.getName(),
            _messageDisplayConfiguration);

        super.include(portletConfig, httpServletRequest, httpServletResponse);
    }

    @Override
    public void processAction(
        PortletConfig portletConfig, ActionRequest actionRequest,
        ActionResponse actionResponse)
        throws Exception {

        if (_log.isInfoEnabled()) {
            _log.info("Blade Message Portlet configuration action");
        }

        String fontColor = ParamUtil.getString(actionRequest, "fontColor");
        String fontFamily = ParamUtil.getString(actionRequest, "fontFamily");
        String fontSize = ParamUtil.getString(actionRequest, "fontSize");

        if (_log.isInfoEnabled()) {
            _log.info(
                "Message Display Configuration: Font Family: " + fontFamily);

            _log.info("Message Display Configuration: Font Size: " + fontSize);

            _log.info(
                "Message Display Configuration: Font Color: " + fontColor);
        }

        setPreference(actionRequest, "fontColor", fontColor);
        setPreference(actionRequest, "fontFamily", fontFamily);
        setPreference(actionRequest, "fontSize", fontSize);

        super.processAction(portletConfig, actionRequest, actionResponse);
    }

    @Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
        _messageDisplayConfiguration = ConfigurableUtil.createConfigurable(
            MessageDisplayConfiguration.class, properties);
    }

    private static final Log _log = LogFactoryUtil.getLog(
        MessageDisplayConfigurationAction.class);

    private volatile MessageDisplayConfiguration _messageDisplayConfiguration;

}

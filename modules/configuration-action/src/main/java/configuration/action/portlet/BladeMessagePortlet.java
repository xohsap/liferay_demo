package configuration.action.portlet;

import configuration.action.constants.BladeMessagePortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author xohsa
 */

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.IOException;

import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Modified;

/**
 * @author Liferay
 */
@Component(
    configurationPid = "com.liferay.blade.samples.configurationaction.MessageDisplayConfiguration",
    immediate = true,
    property = {
        "com.liferay.portlet.display-category=category.sample",
        "com.liferay.portlet.instanceable=true",
        "javax.portlet.display-name=Blade Message Portlet",
        "javax.portlet.init-param.config-template=/configuration.jsp",
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.init-param.view-template=/view.jsp",
        "javax.portlet.name=" + BladeMessagePortletKeys.BLADE_MESSAGE_PORTLET,
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=power-user,user"
    },
    service = Portlet.class
)
public class BladeMessagePortlet extends MVCPortlet {

    @Override
    public void doView(
        RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {

        if (_log.isInfoEnabled()) {
            _log.info("Blade Message Portlet render");
        }

        renderRequest.setAttribute(
            MessageDisplayConfiguration.class.getName(),
            _messageDisplayConfiguration);

        super.doView(renderRequest, renderResponse);
    }

    @Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
        _messageDisplayConfiguration = ConfigurableUtil.createConfigurable(
            MessageDisplayConfiguration.class, properties);
    }

    private static final Log _log = LogFactoryUtil.getLog(
        BladeMessagePortlet.class);

    private volatile MessageDisplayConfiguration _messageDisplayConfiguration;

}

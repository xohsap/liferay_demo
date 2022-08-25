<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
    taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
    taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
    taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="configuration.action.portlet.MessageDisplayConfiguration " %><%@
    page import="com.liferay.portal.kernel.util.StringPool" %><%@
    page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.petra.string.StringPool" %>
<liferay-theme:defineObjects />
<portlet:defineObjects />
<%
    MessageDisplayConfiguration messageDisplayConfiguration =
        (MessageDisplayConfiguration)
            renderRequest.getAttribute(MessageDisplayConfiguration.class.getName());
    String fontFamily = StringPool.BLANK;
    String fontColor = StringPool.BLANK;
    String fontSize = StringPool.BLANK;
    if (messageDisplayConfiguration != null) {
        fontFamily = portletPreferences.getValue("fontFamily", messageDisplayConfiguration.fontFamily());
        fontColor = portletPreferences.getValue("fontColor", messageDisplayConfiguration.fontColor());
        fontSize = portletPreferences.getValue("fontSize", String.valueOf(messageDisplayConfiguration.fontSize()));
    }
%>

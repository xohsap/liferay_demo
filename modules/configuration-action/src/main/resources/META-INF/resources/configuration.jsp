%@ page import="com.liferay.portal.kernel.util.Constants" %>

<%@ include file="/init.jsp" %>

<liferay-portlet:actionURL
    portletConfiguration="<%= true %>"
    var="configurationActionURL"
/>

<liferay-portlet:renderURL
    portletConfiguration="<%= true %>"
    var="configurationRenderURL"
/>

<aui:form action="<%= configurationActionURL %>" method="post" name="fm">
    <aui:input
        name="<%= Constants.CMD %>"
        type="hidden"
        value="<%= Constants.UPDATE %>"
    />

    <aui:input
        name="redirect"
        type="hidden"
        value="<%= configurationRenderURL %>"
    />

    <aui:fieldset>
        <aui:select
            label="Font Family"
            name="fontFamily"
            value="<%= fontFamily %>"
        >
            <aui:option value="Arial">Arial</aui:option>
            <aui:option value="Comic Sans MS">Comic Sans MS</aui:option>
            <aui:option value="Courier New">Courier New</aui:option>
            <aui:option value="Georgia">Georgia</aui:option>
            <aui:option value="Verdana">Verdana</aui:option>
        </aui:select>

        <aui:select label="Font Size" name="fontSize" value="<%= fontSize %>">
            <aui:option value="10">10</aui:option>
            <aui:option value="11">11</aui:option>
            <aui:option value="12">12</aui:option>
            <aui:option value="13">13</aui:option>
            <aui:option value="14">14</aui:option>
            <aui:option value="15">15</aui:option>
        </aui:select>

        <aui:select
            label="Font Color"
            name="fontColor"
            value="<%= fontColor %>"
        >
            <aui:option value="violet">Violet</aui:option>
            <aui:option value="indigo">Indigo</aui:option>
            <aui:option value="blue">Blue</aui:option>
            <aui:option value="green">Green</aui:option>
            <aui:option value="yellow">Yellow</aui:option>
            <aui:option value="orange">Orange</aui:option>
            <aui:option value="red">Red</aui:option>
        </aui:select>
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit"></aui:button>
    </aui:button-row>
</aui:form>

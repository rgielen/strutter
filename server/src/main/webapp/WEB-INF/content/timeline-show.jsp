<!DOCTYPE html PUBLIC
        "-//W3C//DTD XHTML 1.1 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
        <title>Strutter: Simple Web Client</title>
</head>
<body>

    <div style="padding: 5px;background-color: #ccc;width:418px;text-align:center;">
        <a href="<%= request.getContextPath() %>/login">Login as a different user</a> |
        <a href="<%= request.getContextPath() %>/posts/${id}">View your Posts</a>
    </div>

    <p/>

    <s:form method="post" action="%{#request.contextPath}/posts/%{id}/create">
    <table>
        <s:hidden name="message.author.alias" value="%{id}"/>
        <s:textarea name="message.text" label="What are you doing" cols="52" rows="3" labelposition="top" />
        <tr>
            <td colspan="2">
                <s:submit value="Update"/>
            </td>
    </table>
    </s:form>

    <s:actionmessage />

    <div style="background-color: #ccc;width:430px;">
        <h3 style="padding:5px;text-align:center;">Your Timeline</h3>
    </div>
    
    <table>
        <s:iterator value="%{model}">
        <tr>
            <td valign="middle" width="50" rowspan="2">
                <img src="<%= request.getContextPath() %>/images/user.jpg" border="0"  style="width:50px; height:50px"><br>
                <strong><s:property value="author.alias" /></strong>
            </td>
            <td style="vertical-align:top;padding-left: 20px; height:48px;width:350px;">
                <div style="background-color:#ddd; height:100%; padding:2px;">
                    <s:property value="text" />
                </div>
            </td>
        </tr>
        <tr>
            <td style="vertical-align:top;padding-left: 20px;text-align:left;">
                <s:date name="sent" format="dd.MM.yyyy HH:mm" nice="true"/>
            </td>
        </tr>
        </s:iterator>
    </table>
    
    <p/>

</body>
</html>
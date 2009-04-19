<!DOCTYPE html PUBLIC
        "-//W3C//DTD XHTML 1.1 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
        <title>Message <s:property value="message.id" /></title>
</head>
<body>
    <s:form method="post" action="%{#request.contextPath}/posts/%{message.id}">
    <s:hidden name="_method" value="put" />
    <table>
        <s:textfield name="message.author.alias" label="Username" disabled="true"/>
        <s:textarea name="message.text" label="Message"/>
        <tr>
            <td colspan="2">
                <s:submit />
            </td>
    </table>
    </s:form>
    <a href="<%=request.getContextPath() %>/posts">Back to Messages</a>
</body>
</html>

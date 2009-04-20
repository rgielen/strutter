<!DOCTYPE html PUBLIC
        "-//W3C//DTD XHTML 1.1 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
        <title>Login</title>
</head>
<body>
    <s:form method="post" action="%{#request.contextPath}/login">
    <table>
        <s:textfield name="username" label="Username"/>
        <s:password name="password" label="Password" />
        <tr>
            <td colspan="2">
                <s:submit />
            </td>
    </table>
    </s:form>
</body>
</html>
<!DOCTYPE html PUBLIC
        "-//W3C//DTD XHTML 1.1 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
        <title>Timeline Messages</title>
</head>
<body>
    <s:actionmessage />
    <table>
        <tr>
            <th>ID</th>
            <th>Author</th>
            <th>Date</th>
            <th>Text</th>
        </tr>
        <s:iterator value="%{model}">
        <tr>
            <td><s:property value="id" /></td>
            <td><s:property value="author.realname" /> (<s:property value="author.alias" />)</td>
            <td><s:property value="sent" /></td>
            <td><s:property value="text" /></td>
        </tr>
        </s:iterator>
    </table>
</body>
</html>
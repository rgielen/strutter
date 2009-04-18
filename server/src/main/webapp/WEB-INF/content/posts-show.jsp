<!DOCTYPE html PUBLIC
        "-//W3C//DTD XHTML 1.1 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
        <title>Message ${id}</title>
</head>
<body>
    <table>
        <tr>
            <th>Author</th>
            <td><s:property value="author.realname" /> (<s:property value="author.alias" />) </td>
        </tr>
        <tr>
            <th>Sent</th>
            <td><s:property value="sent" /></td>
        </tr>
        <tr>
            <th>Text</th>
            <td><s:property value="text" /></td>
        </tr>
    </table>
    <a href="../posts">Back to Messages</a>
</body>
</html>


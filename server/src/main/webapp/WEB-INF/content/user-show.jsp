<!DOCTYPE html PUBLIC                                                                                                                                                             
        "-//W3C//DTD XHTML 1.1 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
        <title>User ${alias}</title>
</head>
<body>
    <table>
        <tr>
            <th>Alias</th>
            <td><s:property value="alias" /> </td>
        </tr>
        <tr>
            <th>Realname</th>
            <td><s:property value="realname" /></td>
        </tr>
        <tr>
            <th>Short Biography</th>
            <td><s:property value="shortBio" /></td>
        </tr>
    </table>
    <a href="../user">Back to Users</a>
</body>
</html>


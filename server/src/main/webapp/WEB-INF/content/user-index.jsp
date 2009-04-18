<!DOCTYPE html PUBLIC
        "-//W3C//DTD XHTML 1.1 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
        <title>Users</title>
</head>
<body>
    <s:actionmessage />
    <table>
        <tr>
            <th>Alias</th>
            <th>Realname</th>
            <th>Short Biography</th>
            <th>Actions</th>
        </tr>
        <s:iterator value="%{model}">
        <tr>
            <td><s:property value="alias" /></td>
            <td><s:property value="realname" /></td>
            <td><s:property value="shortBio" /></td>
            <td>
                <a href="user/${alias}">View</a> |                                                                                                                                 
                <a href="user/${alias}/edit">Edit</a> |
                <a href="user/${alias}/deleteConfirm">Delete</a>
            </td>
        </tr>
        </s:iterator>
    </table>
    <a href="user/new">Create a new user</a>
</body>
</html>
<!DOCTYPE html PUBLIC
        "-//W3C//DTD XHTML 1.1 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
        <title>Message ${id}</title>
</head>
<body>
    <form action="../${id}?_method=DELETE" method="post">
        <p>
            Are you sure you want to delete message ${id}?
        </p>
        <div>
            <input type="submit" value="Delete" />
            <input type="button" value="Cancel" onclick="window.location.href = '../../posts'" />
        </div>
    </form>
    <br />
    <a href="../../posts">Back to Messages</a>
</body>
</html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <#list users as user>
        id: ${user.id}, username:${user.username} , password: ${user.password} <br>
    </#list>
</body>
</html>
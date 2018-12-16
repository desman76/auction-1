<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>

<script>
    var service = 'http://localhost:8080/cat';
    var RestGetAll = function () {
        $.ajax({
            type: 'GET',
            url: service + '/all',
            dataType: 'json',
            accept: 'json',
            contentType: 'application/json:utf-8',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result))
            },
            error: function (jqXHR, testStratus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR))
            }

        });

    };

    var RestGet = function (id) {
        $.ajax({
            type: 'GET',
            url: service + '/get/' + id,
            dataType: 'json',
            accept: 'json',
            contentType: 'application/json:utf-8',
            async: false,
            success: function (result) {
                //$('#response').html(JSON.stringify(result))
                //return result.name;
                $('#response').html(JSON.stringify(result.name))
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR))
            }
        });
    };

    var RestPOST = function (name, destription) {
        var JSONObject={
            'name' : name,
            'description' : destription
        };
        $.ajax({
            type: 'POST',
            url: service + '/add/',
            contentType: 'application/json:utf-8',
            dataType: 'json',
            accept: 'json',
            data:JSON.stringify(JSONObject),
            async: false,
            success: function (result) {
                //$('#response').html(JSON.stringify(result))
                //return result.name;
                $('#response').html(JSON.stringify(result.name))
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR))
            }
        });
    };

    var RestDelete = function (id) {
        $.ajax({
            type: 'DELETE',
            url: service + '/delete/' + id,
            dataType: 'json',
            accept: 'json',
            contentType: 'application/json:utf-8',
            async: false,
            success: function (result) {
                //$('#response').html(JSON.stringify(result))
                //return result.name;
                $('#response').html(JSON.stringify(result))
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR))
            }
        });
    };

    var RestPUT = function (id,name, destription) {
        var JSONObject={
            'id': id
            'name' : name,
            'description' : destription
        };
        $.ajax({
            type: 'PUT',
            url: service + '/update/',
            contentType: 'application/json:utf-8',
            dataType: 'json',
            accept: 'json',
            data:JSON.stringify(JSONObject),
            async: false,
            success: function (result) {
                //$('#response').html(JSON.stringify(result))
                //return result.name;
                $('#response').html(JSON.stringify(result.name))
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR))
            }
        });
    };
</script>
<body>
<h1>Bird's info</h1>

<table class="table">
    <tr>
        <th>Request type</th>
        <th>URL</th>
        <th>Value</th>
    </tr>

    <tr>
        <td>get all birds <code><strong>GET</strong></code></td>
        <td>/bird/all</td>
        <td>
            <button type="button" onclick="RestGetAll()">try</button>
        </td>
    </tr>

    <tr>
        <td>Get bird by ID <code><strong>GET</strong></code></td>
        <td>/bird/get/{id}</td>
        <td>
            id: <input id="getBirdId" value="">
            <button type="button" onclick="RestGet($('#getBirdId').val())">try</button>
        </td>
    </tr>
    <tr>
    <td>Add bird  <code><strong>POST</strong></code></td>
    <td>/bird/update/</td>
    <td>
        id :  <input id="birdIdForUpdate" value="">
        name: <input id="birdName" value="">
        description: <input id="birdDesctiption" value="">
        <button type="button" onclick="RestPOST ($('#birdName').val(),$('#birdDesctiption').val())">try</button>
    </td>
    </tr>
    <tr>
        <td>Update bird  <code><strong>PUT</strong></code></td>
        <td>/bird/add/</td>
        <td>
            name: <input id="birdNameForUpdate" value="">
            description: <input id="birdDescriptionForUpdate" value="">
            <button type="button" onclick="RestPUT ($('#birdIdForUpdate').val(),$('#birdNameForUpdate').val() ,$('#birdDescriptionForUpdate').val())">try</button>
        </td>
    </tr>

    <tr>
        <td>Delete bird by ID <code><strong>GET</strong></code></td>
        <td>/bird/delete/{id}</td>
        <td>
            id: <input id="birdIdForDelete" value="">
            <button type="button" onclick="RestDelete($('#birdIdForDelete').val())">try</button>
        </td>
    </tr>
</table>
<div class="panel panel-default">
    <div class="panel heading">
        <strong>RESPONSE</strong>
    </div>
    <div class="panel-body" id="response">

    </div>
</div>
</body>
</html>






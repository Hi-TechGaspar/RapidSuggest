<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

    <head>
        <title>Hi-Tech Gaspar Rapid Suggest!</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet">
    </head>

    <body>

        <div class="container">
            <div class="row">
                 <div class="col-lg-12">
                   <div>
                        <h1>Hi-Tech Gaspar Rapid Suggest</h1>
                        <h3>An Ajax-based Autocomplete Service & Widget</h3>

                        <input id="rapidsuggest" class="form-control" type="text" placeholder="Let's Autocomplete!" >

                        <script type="text/javascript" src="<c:url value="/resources/js/rapidsuggest.js"/>"></script>
                        <script>
                            RapidSuggest(document.getElementById('rapidsuggest'))
                        </script>

                   </div>
                 </div>
            </div>
        </div>


    </body>

</html>
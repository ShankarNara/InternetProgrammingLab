<html>
<body>

Welcome : <?php

    $servername = "localhost";
    $username ="root";
    $password = "thenextgenius";

    $conn = new mysqli($servername,$username,$password);

    if ($conn->connect_error){
        die("Connection failed!");
    }

    echo "Connection successful!";
?>

</body>
</html>
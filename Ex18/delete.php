<?php
$con=new  mysqli("localhost:3306","root","","test");
if($con->connect_error)
	echo "Failed!";
else
	echo "Success!";
$name=$_GET["name"];
$sql="delete from student where name=?";
$stmt=$con->prepare($sql);
mysqli_stmt_bind_param($stmt,"s",$name);
mysqli_stmt_execute($stmt);
echo "<br>"."Deleted!";
echo "<br>";
$sql1="select * from student";
$result=$con->query($sql1);
if($result->num_rows>0)
{
while($row=$result->fetch_assoc())
{
echo $row["name"]."   ";
echo $row["age"]."   ";
echo $row["date"]."   ";
echo $row["addr"]."   ";
echo $row["ph"]."   ";
echo $row["email"]."<br>";
}
}
?>
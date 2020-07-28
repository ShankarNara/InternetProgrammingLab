<?php
$con=new  mysqli("localhost:3306","root","","test");
if($con->connect_error)
	echo "Failed!";
else
	echo "Connected!"."<br>";
$age=$_GET["age"];
$name=$_GET["name"];
$date=$_GET["date"];
$addr=$_GET["addr"];
$ph=$_GET["ph"];
$email=$_GET["email"];
$pn='/^[a-zA-Z]+$/';
$pa='/^[0-9]{2}$/';
$pe='/^[a-zA-Z][a-zA-Z0-9]+\@[a-zA-Z]+\.[a-zA-Z]+$/';
$pp='/^[1-9][0-9]{9}$/';
if(preg_match($pn,$name)&& preg_match($pa,$age) && preg_match($pe,$email)&&preg_match($pp,$ph))
{
$sql="insert into student values(?,?,?,?,?,?)";
$stmt=mysqli_prepare($con,$sql);
mysqli_stmt_bind_param($stmt,"sissis",$name,$age,$date,$addr,$ph,$email);
mysqli_stmt_execute($stmt);
echo "<br>"."Inserted!";
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
}
else if((preg_match($pn,$name))!=1)
	echo "Invalid Name!";

else if((preg_match($pa,$age))!=1)
	echo "Invalid Age!";

else if((preg_match($pp,$ph))!=1)
	echo "Invalid Phone Number!";

else if((preg_match($pe,$email))!=1)
	echo "Invalid Email!";


?>
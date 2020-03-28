# Docker commands for MySQL

## Download image
docker pull mysql

## Start mysql container
docker run -p 3306:3306 --name mysql -e MYSQL_ROOT_PASSWORD=password -d mysql

## Connect to mysql container 
docker exec -it mysql bash -l  
mysql -uroot -ppassword

## Stop container
docker stop mysql
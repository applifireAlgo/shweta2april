




echo $PATH
DB_PATH=/tmp/applifire/db/89A6DEGCZE9H9C5Y4FJTEA/762B36F7-C9C3-4425-A29F-6FCFF75D1927
MYSQL=/usr/bin
USER=npro2
PASSWORD=npro2
HOST=localhost


echo 'drop db starts....'
$MYSQL/mysql -h$HOST -u$USER -p$PASSWORD -e "SOURCE $DB_PATH/drop_db.sql";
echo 'drop db ends....'
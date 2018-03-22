cd ..

cd leeshop-dependencies
call mvn clean install
cd ..

cd leeshop-commons
call mvn clean install
cd ..

cd leeshop-domain
call mvn clean install
cd ..

cd leeshop-service-admin-api
call mvn clean install
cd ..

cd leeshop-service-redis-api
call mvn clean install
cd ..

cd leeshop-service-portal-api
call mvn clean install
cd ..

cd leeshop-service-admin
call mvn clean install
cd ..

cd leeshop-service-redis
call mvn clean install
cd ..

cd leeshop-service-portal
call mvn clean install
cd ..

cd leeshop-web-admin
call mvn clean install
cd ..

cd leeshop-web-portal
call mvn clean install
cd ..
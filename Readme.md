# MedServiseHub
is test project and uses Hal browser. 
Authetntification works with password "123" 

Application uses REST HATEOAS 

The project starts with docker-compose you need to set file .env
You can go to the folder in the project:

>docker/dev

Please, create new file with name <strong>.env</strong>.  Look for file ENV and copy its containing to <strong>.env</strong>
and set its fields.


Next step: from directory docker/dev in command line insert
>docker-compose up --build -d

after that application is running

If you want to stop application:

>docker-compose down

for start working you need to get data fields from file ENV, create file .env and copy fields and fill data
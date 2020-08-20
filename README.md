# Club-searcher

Club-searcher.

### Installation

Unzip the file in your directory. 
There are two folders: 
- club-searcher-backend
- club-searcher-frontend


### Run club-searcher-backend
 
Go to club-searcher-backend directory and run :
```bash
mvn spring-boot:run
```
#### Sending request via postman: 
```bash
localhost:8080/api?clubName=YOUR_CLUB_NAME
```

### Run club-searcher-frontend
Frontend is an Angular app. 

Go to club-searcher-frontend directory and run :

You may need to reinstall node_modules by using
```bash
npm install
```
Then to run an app: 
```bash
ng serve --port 4200
```
Then open your browser  on :
```bash
http://localhost:4200/
```

In case of using frontend app I recommend start backend app before. 

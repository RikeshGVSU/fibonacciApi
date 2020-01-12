# fibonacciApi
**Web based API that steps through the Fibonacci sequence**

## How to run this application
### Docker
If you have Docker configured in your server then you will need to run the following command:
```
docker image build -t fibo .
```
Above command will build the image in which is in the file Dockerfile located in the project root folder
```
docker container run -p 8080:8080 -it fib
```
Above command will run tomcat server in port 8080 in a Docer container.

### Run on Tomcat Directly
If you do not have Docker, you can run Tomcat server and run this apppplication in tomcat server.

## API paths
The following are the API paths that can be used to get the fibonacci numbers.
These are localhost paths running in port 8080.
- http://localhost:8080/fibonacci/current - returns the current number in the sequence
- http://localhost:8080/fibonacci/next - returns the next number in the sequence
- http://localhost:8080/fibonacci/previous - returns the previous number in the sequence

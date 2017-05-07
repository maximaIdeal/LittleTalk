javac *.java
ping -n 3 127.0.0.1>nul
start rmiregistry
ping -n 3 127.0.0.1>nul
start java Server
ping -n 3 127.0.0.1>nul
start java Client
start java Client
exit
# Thrift with Scala

## requirements

* sbt 0.10

## setup

install thrift:

    $ brew install thrift

generate thfirt java code:

    $ thrift --gen java foo.thrift

mv the java code under src dir:

    $ mkdir src/main/java
    $ mv gen-java/* src/main/java

## run

run server:

    $ sbt run
    Multiple main classes detected, select one to run:

     [1] Client
     [2] Server

    Enter number: 2

run client:

    $ sbt run
    Multiple main classes detected, select one to run:

     [1] Client
     [2] Server

    Enter number: 1

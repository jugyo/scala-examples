# squeryl example

[http://squeryl.org/](http://squeryl.org/)

## run

* sbt 0.10.0 is requried

    $ sbt update run

## play in console

    $ sbt console

    scala> Main.setup
    scala> import Model._
    scala> import org.squeryl.PrimitiveTypeMode._
    scala> transaction { books.insert(new Book("Scala")) }

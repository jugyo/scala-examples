import org.squeryl._
import org.squeryl.PrimitiveTypeMode._
import adapters.H2Adapter

class Book(var title: String) extends KeyedEntity[Long] {
  val id: Long = 0
}

object Model extends Schema {
  val books = table[Book]
}

object Main {
  def setup {
    Class.forName("org.h2.Driver");
    SessionFactory.concreteFactory = Some(()=>
      Session.create(
        java.sql.DriverManager.getConnection("jdbc:h2:./example"),
        new H2Adapter
      )
    )
  }

  def main(args: Array[String]) {
    setup

    import Model._

    // drop & create table
    transaction {
      drop
      create
      printDdl
    }

    // insert
    transaction {
      books.insert(new Book("Scala"))
      books.insert(new Book("Java"))
      books.insert(new Book("Ruby"))
    }

    def print(book: Book) { println("%d, %s".format(book.id, book.title)) }

    // select all
    transaction {
      for (book <- from(books)((b) => select(b))) {
        print(book)
      }
    }

    // select where title = "Scala"
    transaction {
      val book = from(books)(b => where(b.title === "Scala") select(b)).single
      print(book)
    }

    // select with alternative syntax
    transaction { 
      val book = books.where(b => b.title === "Java").single
      print(book)
    }

    def printAll { for (book <- from(books)((b) => select(b))) println("%d, %s".format(book.id, book.title)) }

    // update 1
    transaction {
      val book = from(books)(b => where(b.title === "Scala") select(b)).single
      book.title = "Scala!!!"
      books.update(book)

      printAll
    }

    // update 2
    transaction {
      update(books)(b=>
        where(b.title === "Ruby")
        set(b.title := "Ruby!!!")
      )

      printAll
    }

    // count
    transaction {
      println("count: %d" format from(books)(b => compute(count)).single.measures)
    }

    // delete by id
    transaction {
      val book = from(books)(b => select(b)).head
      books.delete(book.id)
      println(books.lookup(book.id)) // None
    }

    // delete by query
    transaction {
      val query = from(books)(b => select(b))
      books.delete(query)
      println("count: %d" format from(books)(b => compute(count)).single.measures)
    }
  }
}

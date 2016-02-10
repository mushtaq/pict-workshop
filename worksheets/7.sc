import data.Data

Data.books foreach println


Data.books.map(book => book.title)
Data.books.map(_.title)

Data.books.filter(_.author == "odersky")


Data.books.groupBy(_.author) foreach println

Data.books.sortBy(_.author)

Data.books.sortBy(book => (book.author, -book.basePrice, book.title)) foreach println

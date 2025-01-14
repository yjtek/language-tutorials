package models

import (
	"github.com/jinzhu/gorm"
	"github.com/yjtek/learn-go/go-bookstore/pkg/config"
)

var db *gorm.DB //gorm.DB is a pointer to a DB object. *gorm.DB resolves the address to that DB object

type Book struct {
	gorm.Model
	Name        string `gorm:""json:"name"`
	Author      string `json:"author"`
	Publication string `json:"publication"`
}

func init() {
	config.Connect()    //creates a var `db` that resolves a pointer to a gorm.DB object
	db = config.GetDB() //using the `db` object created by config.Connect(), assign to db variable
	db.AutoMigrate(&Book{})
}

func (b *Book) CreateBook() *Book { //func (associated object) NameOfFunction(type of object you will receive) <type from function return>
	db.NewRecord(b) //NewRecord() is a gorm method
	db.Create(&b)
	return b
}

func GetAllBooks() []Book {
	var Books []Book
	db.Find(&Books)
	return Books
}

func GetBookById(Id int64) (*Book, *gorm.DB) {
	var getBook Book
	db := db.Where("ID=?", Id).Find(&getBook)
	return &getBook, db
}

func DeleteBook(ID int64) Book {
	var book Book
	db.Where("ID=?", ID).Delete(book)
	return book
}

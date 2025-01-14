package config

import (
	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/mysql" //special case for gorm dialect
)

var (
	db *gorm.DB
)

func Connect() {
	d, err := gorm.Open("mysql", "yjtek:password/simplerest?charset=utf8&parseTime=True&loc=Local")
	if err != nil {
		panic(err)
	}
	db = d
}

func GetDB() *gorm.DB {
	return db
}

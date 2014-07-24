package models

import play.api.db.slick.Config.driver.simple._

case class Cat(id: Option[Long], name: String, color: String)

/* Table mapping
 */
class CatsTable(tag: Tag) extends Table[Cat](tag, "CAT") {
	def id = column[Option[Long]]("id", O.AutoInc, O.PrimaryKey)
	def name = column[String]("name", O.NotNull)
	def color = column[String]("color", O.NotNull)

	def * = (id, name, color) <> (Cat.tupled, Cat.unapply _)
}

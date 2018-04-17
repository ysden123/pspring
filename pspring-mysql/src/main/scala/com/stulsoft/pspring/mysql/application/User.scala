package com.stulsoft.pspring.mysql.application

import javax.persistence._

/**
  * @author Yuriy Stul
  * @since 4/17/2018
  */
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "users")
class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  var id: Long = _

  var name: String = _
  var email: String = _


  def canEqual(other: Any): Boolean = other.isInstanceOf[User]

  override def equals(other: Any): Boolean = other match {
    case that: User =>
      (that canEqual this) &&
        id == that.id &&
        name == that.name &&
        email == that.email
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(id, name, email)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }

  override def toString = s"User($id, $name, $email)"
}

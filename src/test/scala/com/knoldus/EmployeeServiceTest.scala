package com.knoldus

import org.scalatest.FunSuite


/**
  * Created by knoldus on 3/4/16.
  */

class EmployeeServiceTest extends FunSuite with EmployeeServiceApi {

  val employee  = new EmployeeService

  test("adding a document "){
    val result = employee.add("Deepti", "23", "trainee", 3)
    assert(result.getId() === "3" )
  }

  test("read id 1 document"){
    val result = employee.get(2)
    assert(result.getId  === "2" )
  }

  test(" update a document "){
    val result= employee.update("name", "Richa",4)
    assert(result.getId === "4")

  }

  test("searching "){
    val result = employee.readAll
    assert(result.getHits.getTotalHits === 4)
  }


}

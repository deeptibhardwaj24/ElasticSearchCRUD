package com.knoldus


import org.elasticsearch.action.get.GetResponse
import org.elasticsearch.action.index.IndexResponse
import org.elasticsearch.action.search.SearchResponse
import org.elasticsearch.action.update.{UpdateResponse}
import org.elasticsearch.client.Client


/**
  * Created by knoldus on 2/4/16.
  */


trait EmployeeServiceApi {
  val client: Client = EsClient.client

  def add(name: String, age: String, designation: String, id: Int): IndexResponse = {

    val json =
      s"""
   {
     "name": "$name",
    "age": "$age",
    "designation"  :"$designation"
  }"""
    client.prepareIndex("employeedb", "Employee", id.toString).setSource(json).execute().actionGet()
  }


  def readAll:SearchResponse={

      val result=client.prepareSearch("employeedb").setTypes("Employee").execute().actionGet();
    result
  }
  def update(field:String,value:Any,id:Int):UpdateResponse ={
  client.prepareUpdate("employeedb", "Employee", id.toString).setDoc(field,value).setRefresh(true).execute().actionGet()

  }

  def get(id:Int) : GetResponse = {
  client.prepareGet("employeedb", "Employee", id.toString).get();

  }



}


class EmployeeService extends EmployeeServiceApi

package com.androindian.regkotlin

import org.json.JSONObject
import java.io.BufferedInputStream
import java.io.BufferedOutputStream
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

object JsonFun{


        fun RequestPost(url: String, param: String?):JSONObject?{

            var jsonObject:JSONObject?=null


            val jurl=URL(url)

            val c=jurl.openConnection()as HttpURLConnection

            c.doInput=true
            c.doOutput=true
            c.useCaches=false
            c.requestMethod="POST"
            c.connectTimeout=4000
            c.setRequestProperty("Content-Type", "application/x-www-form-urlencoded")
            c.setRequestProperty("Accept-Charset", "UTF-8")
            c.setRequestProperty("Accept", "application/json")
            c.connect()

            val outputsteam=BufferedOutputStream(c.outputStream)
            outputsteam.write(param!!.toByteArray())
            outputsteam.flush()

            val inputstream=BufferedInputStream(c.inputStream)
            val bufferredaer=BufferedReader(InputStreamReader(inputstream))
            val sf=StringBuffer()
            val abc:String
            abc=bufferredaer.readLine()
            //sf.append(abc)
            /* while ((abc)!= null){
                 sf.append("$abc/n")

             }*/
            inputstream.close()
            jsonObject = JSONObject(abc)

            return jsonObject

        }
    }
    /*fun RequestPost(url: String, param: String?): JSONObject?{
        val jsonObject:JSONObject?=null

        val testurl=URL(url)
        val con=testurl.openConnection();

        con.doInput=true
        con.doOutput=true
        con.connectTimeout=5000
        con.useCaches=false
        con.requestMethod="POST"
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded")
        con.setRequestProperty("Accept-Charset", "UTF-8")
        con.setRequestProperty("Accept", "application/json")
        con.connect()

        val outputsteam= BufferedOutputStream(con.outputStream)
        outputsteam.write(param!!.toByteArray())
        outputsteam.flush()


        val inputstream= BufferedInputStream(con.inputStream)
        val bufferredaer= BufferedReader(InputStreamReader(inputstream))
        val sf=StringBuffer()
        val abc:String
        abc=bufferredaer.readLine()
        //sf.append(abc)
        *//* while ((abc)!= null){
             sf.append("$abc/n")

         }*//*
        inputstream.close()
        jsonObject = JSONObject(abc)


        return jsonObject
    }*/

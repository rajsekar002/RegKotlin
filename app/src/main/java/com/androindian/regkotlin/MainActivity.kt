package com.androindian.regkotlin

import android.app.Dialog
import android.app.ProgressDialog
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    val  url="http://androindian.com/apps/example_app/api.php"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Reg.setOnClickListener {

            val j1= JSONObject()
            j1.put("name",Name.text.toString().trim())
            j1.put("mobile",Mobile.text.toString().trim())
            j1.put("email",email.text.toString().trim())
            j1.put("pswrd",pass.text.toString().trim())
            j1.put("baction","register_user")

            val reguser=RegUser();
            reguser.execute(j1.toString())
        }
    }


private inner class  RegUser() : AsyncTask<String, String, String>() {

    var progressDialog = ProgressDialog(this@MainActivity)

    override fun onPreExecute() {
        super.onPreExecute()
        progressDialog.setMessage("Please Wait")
        progressDialog.setTitle("Content Loading")
        progressDialog.show()
    }
    override fun doInBackground(vararg params: String?): String {

        val j2=JsonFun.RequestPost(url,params[0])
      return j2.toString()
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        progressDialog.dismiss()

        val j3=JSONObject(result.toString())

        val res1=j3.getString("response")

        if(res1.equals("failed")){

            val res2=j3.getString("user")
            Toast.makeText(this@MainActivity,""+res2,Toast.LENGTH_LONG).show()

        }else if(res1.equals("success")){
            val res2=j3.getString("user")
            Toast.makeText(this@MainActivity,""+res2,Toast.LENGTH_LONG).show()

        }else{
            val res2=j3.getString("user")
            Toast.makeText(this@MainActivity,""+res2,Toast.LENGTH_LONG).show()

        }
    }

}
    }

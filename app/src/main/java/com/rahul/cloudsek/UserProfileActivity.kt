package com.rahul.cloudsek

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_user_profile.*

class UserProfileActivity : AppCompatActivity() {
    private lateinit var mAuth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)
        getUserDetails()
    }

    fun getUserDetails(){
        mAuth= FirebaseAuth.getInstance()
        val currentUser = mAuth.currentUser
        tvName.text = currentUser?.displayName
        tvEmail.text = currentUser?.email
        Glide.with(this).load(currentUser?.photoUrl).into(profileImage);

        signOutBtn.setOnClickListener {
            mAuth.signOut()
            val intent = Intent(this, UserLoginActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}
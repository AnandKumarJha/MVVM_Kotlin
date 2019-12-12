package com.example.mvvmkotlin.model

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.example.mvvmkotlin.model.db.StudentDb
import com.example.mvvmkotlin.model.db.pojo.Student
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.room.migration.Migration



class StudentRepository(val context: Context) {

    val db = Room.databaseBuilder(
        context,
        StudentDb::class.java, "database-name"
    ).addMigrations(MIGRATION_1_2, MIGRATION_2_3).build()


    suspend fun getAllStudents(): LiveData<List<Student>> {
        return db.studentDao().getStudents()
    }

    suspend fun insertStudent(student: Student){
        db.studentDao().insertStudent(student)
    }

    suspend fun deleteStudent(student: Student){
        db.studentDao().deleteStudent(student)
    }


}

val MIGRATION_1_2: Migration = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE Student " + "ADD COLUMN Address TEXT not null default ''")
    }
}

val MIGRATION_2_3: Migration = object : Migration(2, 3) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE Student " + "ADD COLUMN Sex TEXT not null default ''")
    }
}
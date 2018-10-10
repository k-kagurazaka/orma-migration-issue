package com.kkagurazaka.orma.migration.issue

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.github.gfx.android.orma.migration.ManualStepMigration

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        when (BuildConfig.VERSION_CODE) {
            1 -> {
                val orma = OrmaDatabase.Builder(this).build()
                println("Orma: Database version = ${orma.connection.readableDatabase.version}")
            }
            2 -> {
                val orma = OrmaDatabase.Builder(this)
                        .migrationStep(1, object: ManualStepMigration.Step {
                            override fun up(helper: ManualStepMigration.Helper) {
                                println("Orma: migration up - this is never called")
                            }

                            override fun down(helper: ManualStepMigration.Helper) {
                                println("Orma: migration down")
                            }
                        })
                        .build()
                println("Orma: Database version = ${orma.connection.readableDatabase.version}")
            }
        }
    }
}

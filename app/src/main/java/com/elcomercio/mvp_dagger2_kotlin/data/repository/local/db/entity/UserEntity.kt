package com.elcomercio.mvp_dagger2_kotlin.data.repository.local.db.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * @author Carlos Vargas on 4/12/18.
 * @author Carlo Renzo on 4/12/18.
 */
@Entity
data class UserEntity(@PrimaryKey(autoGenerate = true) val id: Int, val name: String)
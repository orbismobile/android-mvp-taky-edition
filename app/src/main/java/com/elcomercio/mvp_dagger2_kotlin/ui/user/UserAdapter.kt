package com.elcomercio.mvp_dagger2_kotlin.ui.user

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.elcomercio.mvp_dagger2_kotlin.R
import com.elcomercio.mvp_dagger2_kotlin.data.repository.local.db.entity.UserEntity
import com.elcomercio.mvp_dagger2_kotlin.utils.inflate
import kotlinx.android.synthetic.main.item_user.view.*

/**
 * @author Carlos Vargas on 4/12/18.
 * @author Carlo Renzo on 4/12/18.
 * @version 1.0.5
 * @since 1.0.5
 */
class UserAdapter(private val listUserEntity: MutableList<UserEntity>,
                  val onUserItemClickListener: (UserEntity) -> Unit,
                  val onDeleteUserClickListener: (UserEntity, Int) -> Unit)
    : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder =
            UserViewHolder(parent)

    override fun getItemCount(): Int = listUserEntity.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(listUserEntity[position])
    }

    inner class UserViewHolder(viewGroup: ViewGroup) :
            RecyclerView.ViewHolder(viewGroup.inflate(R.layout.item_user)) {

        private lateinit var userEntity: UserEntity

        init {
            itemView.setOnClickListener {
                onUserItemClickListener(userEntity)
            }
            itemView.ibDelete.setOnClickListener({
                onDeleteUserClickListener(userEntity, adapterPosition)
            })
        }

        fun bind(userEntity: UserEntity) {
            this.userEntity = userEntity
            itemView.tvName.text = "${this.userEntity.name} id : ${this.userEntity.id}"
        }
    }

    fun addUsersList(usersList: List<UserEntity>) {
        listUserEntity.clear()
        listUserEntity.addAll(usersList)
        notifyDataSetChanged()
    }

    fun deleteUser(position: Int) {
        if (position != RecyclerView.NO_POSITION) {
            listUserEntity.removeAt(position)
            notifyItemRemoved(position)
        }
    }
}
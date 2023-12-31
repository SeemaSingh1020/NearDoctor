package com.neardoctor.view.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.neardoctor.databinding.ItemHospitalsListBinding
import com.neardoctor.model.NearHospitalsList

class HospitalsListAdapter(private val hospitalList: List<NearHospitalsList>) :
    RecyclerView.Adapter<HospitalListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalListViewHolder {
        val binding =
            ItemHospitalsListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HospitalListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HospitalListViewHolder, position: Int) {
        with(holder.binding) {
            with(hospitalList[position]) {
                txtHospitalsName.text = hospitalName
                txtContactPerson.text ="Contact Person : "+ contactPerson
                txtCallOn.text = "Contact : "+number
                txtKm.text = distance
            }

        }
    }

    override fun getItemCount() = hospitalList.size
}
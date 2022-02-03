package com.example.coronapandemic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

    public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.Recyclervh> implements Filterable {
        List<ViewModel> mviewlist;
        List<ViewModel> viewlistAll;
        ViewModel viewModel;
        private Context mContext;

        public ViewAdapter(Context c, List<ViewModel> viewModels) {
            this.mContext = c;
            this.mviewlist = viewModels;
            this.viewlistAll = new ArrayList<>(viewModels);
        }

        public Recyclervh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            android.view.View v = LayoutInflater.from(mContext).inflate(R.layout.viewrecycler, parent, false);
            return new Recyclervh(v);
        }

        @Override
        public void onBindViewHolder(@NonNull Recyclervh holder, int position) {
            viewModel = mviewlist.get(position);
            holder.mName.setText("Name : "+ viewModel.getName());
            holder.mOccupation.setText("Occupation : "+ viewModel.getOccupation());
            holder.mAdharno.setText("Aadhar No : "+ viewModel.getAdharno());
            holder.mPlace.setText("Place : "+ viewModel.getPlace());
            holder.mPin.setText("PIN Code : "+ viewModel.getPin());
            holder.mNo.setText("No of People : "+ viewModel.getNo());
        }

        @Override
        public int getItemCount() {
            return mviewlist.size();
        }

        @Override
        public Filter getFilter() {
            return filter;
        }
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                List<ViewModel> filteredList = new ArrayList<>();
                if (charSequence.toString().isEmpty()){
                    filteredList.addAll(viewlistAll);
                } else {
                    for (ViewModel records: viewlistAll){
                        String name = records.getName().toLowerCase();
                        if (name.contains(charSequence.toString().toLowerCase())){
                            filteredList.add(records);
                        }
                    }
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mviewlist.clear();
                mviewlist.addAll((Collection<? extends ViewModel>) filterResults.values);
                notifyDataSetChanged();
            }
        };

        public class Recyclervh extends RecyclerView.ViewHolder {
            TextView mName, mOccupation, mAdharno, mPlace, mPin, mNo;
            public Recyclervh(View itemview) {
                super(itemview);
                mName = (TextView) itemview.findViewById(R.id.clientname);
                mOccupation = (TextView) itemview.findViewById(R.id.clientoccupation);
                mAdharno = (TextView) itemview.findViewById(R.id.clientadharno);
                mPlace = (TextView) itemview.findViewById(R.id.clientplace);
                mPin = (TextView) itemview.findViewById(R.id.clientpin);
                mNo = (TextView) itemview.findViewById(R.id.clientno);
            }
        }
}

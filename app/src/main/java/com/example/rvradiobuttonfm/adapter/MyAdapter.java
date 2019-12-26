package com.example.rvradiobuttonfm.adapter;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;


import com.example.rvradiobuttonfm.Myinterface.itemCallback;
import com.example.rvradiobuttonfm.R;
import com.example.rvradiobuttonfm.model.MyModel;
import com.example.rvradiobuttonfm.viewModel.MyViewModel;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.VH> {

    private Activity context;
    private ArrayList<MyModel> mDataList;
    itemCallback mAdapterCallback;
    public MyViewModel viewModel;


    public MyAdapter(Activity context, ArrayList<MyModel> model, itemCallback adapterCallback) {
        this.context = context;
        this.mDataList = model;
        mAdapterCallback = adapterCallback;

        viewModel = ViewModelProviders.of((FragmentActivity) context).get(MyViewModel.class);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_item, parent, false);

        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {

        MyModel myModel = mDataList.get(position);
        holder._country.setText(mDataList.get(position).getCountry());
        holder._rates.setText("" + mDataList.get(position).getRates());
        //holder._imageFlag.setImageResource(mDataList.get(position).getImage());
        holder.itemView.setTag(position);
        holder.radioButton.setChecked(myModel.isChecked());
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }


    public class VH extends RecyclerView.ViewHolder {

        RadioButton radioButton;
        TextView _country, _rates;
        /*ImageView _imageFlag;*/

        public VH(@NonNull View itemView) {
            super(itemView);

            radioButton = itemView.findViewById(R.id.radio_button);
            _country = itemView.findViewById(R.id.tv_country);
            _rates = itemView.findViewById(R.id.tv_rates);
            //_imageFlag = itemView.findViewById(R.id.imageFlag);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int clickItem = (int) v.getTag();

                    updateCart(mDataList.get(clickItem));

                    mAdapterCallback.itemCallback(clickItem);
                    notifyDataSetChanged();
                }
            });
        }
    }


    private void updateCart(MyModel cartModel) {
        String txt = String.valueOf(cartModel.getCountry());
        //int imageFlags = cartModel.getImage();
        Log.d(TAG, "updateText: " + txt);

        // setData to viewModel
        viewModel.setmString(cartModel);

    }
}

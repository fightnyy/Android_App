package org.techtown.doit13;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.ViewHolder> {
   public static ArrayList<Customer>customers=new ArrayList<Customer>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.customer_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Customer item=customers.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return customers.size();
    }

    public void addItem(Customer c)
    {
        customers.add(c);
        notifyDataSetChanged();
    }

    public void setItems(ArrayList<Customer> customers)
    {
        this.customers=customers;
    }


    static class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView textView1;
        TextView textView2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView1=itemView.findViewById(R.id.textView);
            textView2=itemView.findViewById(R.id.textView2);
        }
        public void setItem(Customer customer)
        {
            textView1.setText(customer.getName()+"  "+customer.getBirthDay());
            textView2.setText(customer.getPhoneNum());
        }
    }
}

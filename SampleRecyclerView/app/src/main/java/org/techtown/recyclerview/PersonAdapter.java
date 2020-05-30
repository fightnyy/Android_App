package org.techtown.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {
    ArrayList<Person> items=new ArrayList<Person>();
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {//뷰홀더 객체가 만들어질때와 재사용될 때 자동으로 호출됨
        LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());//뷰 타입을 위한 정수값이 파라미터로 전달
        View itemView=inflater.inflate(R.layout.person_item,viewGroup,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewholder, int position) {//뷰홀더 객체가 만들어질때와 재사용될때 자동으로 호출됨
         Person item=items.get(position);
         viewholder.setItem(item);//뷰홀더가 재사용될 때 호출되므로 뷰 객체는 기존것을 그대로 사용하고 데이터만 바꿔준다.
    }

    @Override
    public int getItemCount() {//어탭터에서 관리하는 아이템 갯수 반환함
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        TextView textView2;

        public ViewHolder(View itemView)
        {
            super(itemView);

            textView=itemView.findViewById(R.id.textView);
            textView2=itemView.findViewById(R.id.textView2);
        }

        public void setItem(Person item)
        {
            textView.setText(item.getName());
            textView2.setText(item.getMobile());

        }
    }
    public void addItem(Person item)
    {
        items.add(item);
    }

    public void setItems(ArrayList<Person> items)
    {
        this.items=items;
    }
    public Person getItem(int position)
    {
        return items.get(position);
    }
    public void setItem(int position,Person item)
    {
        items.set(position,item);
    }

}

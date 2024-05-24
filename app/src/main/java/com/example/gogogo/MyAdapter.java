package com.example.gogogo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private String[] mPlace;
    private LayoutInflater minflater;
    private ItemClickListener mClickListener;

    MyAdapter(Context context, Integer[] images, String[] titles) {  //요소 가져온건가?
        this.minflater = LayoutInflater.from(context);
        this.mPlace = place;
    }

    @Override
    @NonNull    //뷰홀더 만들기,xml파일 인플레이터 인플레이터 된 뷰홀더 리턴
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = minflater.inflate(R.layout.placelist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) { //뷰홀더는 뷰아이템들가지고 있고 어댑터가 뷰홀더에게 바이터를 바인딩한다.
        holder.place.setText(mPlace[position]);
    }

    @Override
    public int getItemCount() {
        return mPlace.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView place,location,info;
        ImageView image;

        ViewHolder(View itemView) {
            super(itemView);
            place = itemView.findViewById(R.id.place);
            location = itemView.findViewById(R.id.location);
            info = itemView.findViewById(R.id.info);
            image = itemView.findViewById(R.id.image);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {    //RecyclerView의 각 아이템(뷰홀더)을 클릭했을 때 발생
            if (mClickListener != null) {   //아이템클릭리스너의 인스턴스 mClickListener
                mClickListener.onItemClick(view, getAdapterPosition()); //해당 인터페이스의 onItemClick 메서드를 호출하여 외부로 클릭 이벤트를 전달
            }
        }
    }

    String getItem(int id) {
        return mPlace[id];
    }

    void setClickListener(ItemClickListener itemClickListener) { //외부에서 RecyclerView의 아이템이 클릭되었을 때 실행할 동작을 지정할 수 있습니다.
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);   //클릭된 아이템의 View와 해당 아이템의 위치(position)을 전달받습니다.
    }
}
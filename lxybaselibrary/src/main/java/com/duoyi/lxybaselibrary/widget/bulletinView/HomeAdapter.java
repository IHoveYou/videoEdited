package com.duoyi.lxybaselibrary.widget.bulletinView;//package com.example.basedemo.widget.bulletinView;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//
//import com.example.basedemo.R;
//
//import java.util.List;
//
///**
// * Created by LXY on 2018/8/6.
// */
//
//public class HomeAdapter extends BulletinView.BulletinViewadapter<String> {
//
//    public HomeAdapter(List<String> data) {
//        super(data);
//    }
//
//    @Override
//    public int getItemCount() {
//        return getData().size();
//    }
//
//    @Override
//    public View onBindViewHolder(View itemView, int position, String itemData, int type) {
////        TextView textView = itemView.findViewById(R.id.tv_line);
////        textView.setText(itemData);
//        return itemView;
//    }
//
//    @Override
//    public View onCreateViewHolder(LayoutInflater inflater, ViewGroup parent, int position, int viewType) {
//        View view;
////        if (viewType!=0){
////            view =inflater.inflate(R.layout.lines, parent,false);
////        }else {
////            view =inflater.inflate(R.layout.lines_two, parent,false);
////        }
//        return view;
//    }
//
//    @Override
//    protected int getType(int viewType) {
//        return viewType%2;
//    }
//}

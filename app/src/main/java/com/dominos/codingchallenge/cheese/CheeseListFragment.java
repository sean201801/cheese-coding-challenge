package com.dominos.codingchallenge.cheese;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static com.dominos.codingchallenge.cheese.Constants.RESULT_KEY;

public class CheeseListFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<String> mCheeseList;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCheeseList = new ArrayList<>();
        Bundle bundle = getArguments();
        if(bundle !=null){
            mCheeseList = bundle.getStringArrayList(RESULT_KEY);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list,container,false);
        recyclerView = view.findViewById(R.id.cheese_list_view);
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CheeseListAdapter adapter = new CheeseListAdapter(mCheeseList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

    }

    public static class CheeseListAdapter extends RecyclerView.Adapter<CheeseListAdapter.ViewHolder>  {

        private ArrayList<String> mCheeseList;

        public CheeseListAdapter(ArrayList<String> cheeseList){
            mCheeseList = cheeseList;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, null);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            View itemView = holder.cheeseItemView;
            TextView textView = (TextView) itemView.findViewById(android.R.id.text1);
            textView.setText(mCheeseList.get(position));
        }

        @Override
        public int getItemCount() {
            return mCheeseList != null ? mCheeseList.size() : 0;
        }

        /**
         * Provide a reference to the views for each data item.
         */
        public class ViewHolder extends RecyclerView.ViewHolder {
            private final View cheeseItemView;
            public ViewHolder(View itemView) {
                super(itemView);
                cheeseItemView = itemView;
            }
        }
    }

}

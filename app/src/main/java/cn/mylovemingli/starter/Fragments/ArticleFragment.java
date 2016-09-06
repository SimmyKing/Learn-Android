package cn.mylovemingli.starter.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.mylovemingli.starter.Ipsum;
import cn.mylovemingli.starter.R;

/**
 * Created by Leary on 2016/9/5.
 */
public class ArticleFragment extends Fragment{
    public final static String ARG_POSITION = "position";
    int mCurrentPosition = -1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        if(savedInstanceState!=null){
            mCurrentPosition=savedInstanceState.getInt(ARG_POSITION);
        }
        return inflater.inflate(R.layout.article_view,container,false);
    }

    @Override
    public void onStart(){
        super.onStart();
        Bundle args=getArguments();
        if(args!=null){
            updateArticleView(args.getInt(ARG_POSITION));
        }else if(mCurrentPosition!=-1){
            updateArticleView(mCurrentPosition);
        }
    }

    public void updateArticleView(int position){
        TextView article=(TextView)getActivity().findViewById(R.id.article);
        article.setText(Ipsum.Articles[position]);
        mCurrentPosition=position;
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt(ARG_POSITION,mCurrentPosition);
    }


}

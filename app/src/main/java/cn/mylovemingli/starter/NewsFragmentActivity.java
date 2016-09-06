package cn.mylovemingli.starter;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import cn.mylovemingli.starter.Fragments.ArticleFragment;
import cn.mylovemingli.starter.Fragments.HeadlinesFragment;

/**
 * Created by Leary on 2016/9/5.
 */
public class NewsFragmentActivity extends FragmentActivity
            implements HeadlinesFragment.OnHeadLineSelectedListener{
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_articles);

        if(findViewById(R.id.fragment_container)!=null){
            if(savedInstanceState!=null){
                return;
            }

            HeadlinesFragment firstFragment=new HeadlinesFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container,firstFragment).commit();
        }
    }

    public void onArticleSelected(int position){
        ArticleFragment articleFragment = (ArticleFragment)
                getSupportFragmentManager().findFragmentById(R.id.article_fragment);
        if(articleFragment!=null){
            articleFragment.updateArticleView(position);
        }
        else{
            ArticleFragment newFragment=new ArticleFragment();
            Bundle args=new Bundle();
            args.putInt(ArticleFragment.ARG_POSITION,position);
            newFragment.setArguments(args);
            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container,newFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }
}

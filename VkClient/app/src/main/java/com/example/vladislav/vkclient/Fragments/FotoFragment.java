package com.example.vladislav.vkclient.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.vladislav.vkclient.Adapters.RecyclerViewAdapter;
import com.example.vladislav.vkclient.BuildConfig;
import com.example.vladislav.vkclient.Data.UrlsForRecycleItem;
import com.example.vladislav.vkclient.Interfaces.additionalFunctions;
import com.example.vladislav.vkclient.MoreInfoActivity;
import com.example.vladislav.vkclient.helper.App;
import com.example.vladislav.vkclient.Data.Photo.PhotoRoot;
import com.example.vladislav.vkclient.Interfaces.Vk;
import com.example.vladislav.vkclient.R;
import com.vk.sdk.VKAccessToken;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FotoFragment extends Fragment {

    private RecyclerView recycler;
    public RecyclerView getRecycler() {return recycler;}
    private SwipeRefreshLayout refresh;
    private RecyclerViewAdapter adapter = new RecyclerViewAdapter();
    private Vk vk;
    private String TYPE = "foto";
    private static final String TAG = "FotoFragment";
    public static String IMAGE_URL_KEY = "imageUrl";
    private int photosCount = 40;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_foto,container,false);
        return view;

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recycler = view.findViewById(R.id.recycler);
        recycler.setAdapter(adapter);
        int columnCount = 2;
        recycler.setLayoutManager(new GridLayoutManager(getActivity(),columnCount));
        adapter.setAdditionalFunctions(new AdapterLoadMoreItems());
        vk = App.getVk();
        refresh = view.findViewById(R.id.refresh);
        dataInsert();
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                dataInsert();
            }
        });
    }
    //first insert data or refreshing
    private void dataInsert() {
        int offsetPhotos = 0;
        vk.getAllPhotos(offsetPhotos,photosCount,VKAccessToken.currentToken().accessToken, BuildConfig.VERSION).enqueue(new Callback<PhotoRoot>() {
            @Override
            public void onResponse(Call<PhotoRoot> call, Response<PhotoRoot> response) {
                if (response.body().getResponse() != null) {
                    adapter.setData(response.body().getResponse().getItems());
                    Log.d(TAG, "PHOTO_GOOD_RESPONSE: " + response.body());
                    refresh.setRefreshing(false);
                }else Log.d(TAG, "<<RESPONSE IS NULL>>(dataInsert)");
            }

            @Override
            public void onFailure(Call<PhotoRoot> call, Throwable t) {
                Log.d(TAG, "FAIL_RESPONSE: " + t.getMessage());
                refresh.setRefreshing(false);
            }
        });
    }
    //this class needed for realisation loading method
    public class AdapterLoadMoreItems implements additionalFunctions {
        //loading next photos
        @Override
        public void loadPhotos() {
            int offsetPhotos = adapter.imageUrls.size();
            Log.d(TAG, "loadPhotos: PACKAGE URL SIZE" + adapter.imageUrls.size());
            vk.getAllPhotos(offsetPhotos,photosCount, VKAccessToken.currentToken().accessToken,BuildConfig.VERSION).enqueue(new Callback<PhotoRoot>() {
                @Override
                public void onResponse(Call<PhotoRoot> call, Response<PhotoRoot> response) {
                    if (response.body().getResponse() != null) {
                        adapter.loadMore(response.body().getResponse().getItems());
                        Log.d(TAG, "LOADING_SUCCESS : " + response.body());
                    }else Log.d(TAG, "<<RESPONSE IS NULL>>(loadPhotos)");
                }

                @Override
                public void onFailure(Call<PhotoRoot> call, Throwable t) {
                    Log.d(TAG, "LOADING_FAIL: " + t.getMessage());
                }
            });
        }

        @Override
        public void moreInfoAboutPhoto(List<String>bigImageUrls,int position) {
            Intent intent = new Intent(getActivity(), MoreInfoActivity.class);
            intent.putStringArrayListExtra("IMAGE_URLS", (ArrayList<String>) adapter.imageUrls);
            intent.putExtra("IMAGE_POSITION",position);
            Log.d(TAG, "IMAGE_URLS_SIZE_BEFORE_SENT : " + adapter.imageUrls.size());
            startActivity(intent);
        }
    }
}

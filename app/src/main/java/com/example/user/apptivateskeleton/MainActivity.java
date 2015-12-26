package com.example.user.apptivateskeleton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.user.apptivateskeleton.io.JsonPlaceholderService;
import com.example.user.apptivateskeleton.io.RetrofitGenerator;
import com.example.user.apptivateskeleton.model.Flickr;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends BaseActivity {

    private RecyclerView mRecyclerView;
    private SampleAdapter mSampleAdapter;
    JsonPlaceholderService jsonPlaceholderService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setup();

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        jsonPlaceholderService = RetrofitGenerator.createService(JsonPlaceholderService.class);

        //ideally data needs to be retrieved and adapter created
        mSampleAdapter = new SampleAdapter(getApplicationContext());
        mRecyclerView.setAdapter(mSampleAdapter);

        fetchDataFromServer("modi");
    }



    private void fetchDataFromServer(String query) {
        Call<Flickr> call = jsonPlaceholderService.getSearch(query);
        call.enqueue(new Callback<Flickr>() {
            @Override
            public void onResponse(Response<Flickr> response, Retrofit retrofit) {
                int statusCode = response.code();
                //Post post = response.body();
                Flickr flickr = response.body();
                mSampleAdapter.setmItems(flickr.getItems());
                mSampleAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Throwable t) {
                // Log error here since request failed
                Log.v("", "error");
            }
        });
    }

    /**
     * Dispatch onResume() to fragments.  Note that for better inter-operation
     * with older versions of the platform, at the point of this call the
     * fragments attached to the activity are <em>not</em> resumed.  This means
     * that in some cases the previous state may still be saved, not allowing
     * fragment transactions that modify the state.  To correctly interact
     * with fragments in their proper state, you should instead override
     * {@link #onResumeFragments()}.
     */
    @Override
    protected void onResume() {
        super.onResume();
        if(null != mSampleAdapter){
            SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            String query =sharedPref.getString(APPTIVATE_QUERY, "");
            fetchDataFromServer(query);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if(id == R.id.menu_search){
            Intent intent = new Intent(this,SearchActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

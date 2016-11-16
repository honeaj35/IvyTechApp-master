//package net.androidbootcamp.ivytechapp;
//
//import android.app.Activity;
//import android.app.ListActivity;
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.AdapterView.OnItemClickListener;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//
//import com.google.android.gms.appindexing.Action;
//import com.google.android.gms.appindexing.AppIndex;
//import com.google.android.gms.appindexing.Thing;
//import com.google.android.gms.common.api.GoogleApiClient;
//
//import net.androidbootcamp.ivytechapp.CustomListAdapter.CustomListAdapter;
//
//public class DiningActivityTake2 extends Activity {
//
//    ListView list;
//    String[] eatingOptions = {
//            "Wrap 'N' Roll Deli",
//            "Blue Bamboo Cafe"
//    };
//
//    Integer[] imgid = {
//            R.drawable.wrapnroll1,
//            R.drawable.bluebamboo1
//
//    };
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_dining_take2);
//
//        CustomListAdapter adapter = new CustomListAdapter(this, eatingOptions, imgid);
//        list = (ListView)findViewById(R.id.list);
//        list.setAdapter(adapter);
//
//        list.setOnItemClickListener(new OnItemClickListener() {
//           @Override
//            public void OnItemClick(AdapterView<?> parent, View view,
//                                    int position, long id){
//               String Slecteditem = eatingOptions[+position];
//               switch(position) {
//                   case 0: startActivity(new Intent(DiningActivityTake2.this, WrapNRollScrollingActivity.class));
//                       break;
//                   case 1: Intent browserIntent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.stackoverflow.com"));
//                       startActivity(browserIntent2);
//                       break;
//           }
//        });
//        //setListAdapter(new ArrayAdapter<String>(this, android.R.layout.activity_list_item, R.id.diningList, eatingOptions));
//        //setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.list, eatingOptions));
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        //setSupportActionBar(toolbar);
//    }
//
//   /* protected void onListItemCLickListener(ListView l, View v, int position, long id){
//        switch(position){
//            case 0:
//                startActivity(new Intent(DiningActivityTake2.this, WrapNRollScrollingActivity.class));
//                break;
//
//        }
//    }*/
//
//}













    package net.androidbootcamp.ivytechapp;

    import android.app.Activity;
    import android.content.Intent;
    import android.net.Uri;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.AdapterView;
    import android.widget.AdapterView.OnItemClickListener;
    import android.widget.ListView;

    import com.google.android.gms.appindexing.Action;
    import com.google.android.gms.appindexing.AppIndex;
    import com.google.android.gms.appindexing.Thing;
    import com.google.android.gms.common.api.GoogleApiClient;

    import net.androidbootcamp.ivytechapp.CustomListAdapter.CustomListAdapter;
    import net.androidbootcamp.ivytechapp.CustomListAdapter.DiningActivity;


    //public class MainActivity extends ListActivity {
    public class DiningActivityTake2 extends Activity {

        ListView list;
        String[] itemname = {
                "Wrap 'N' Roll Deli",
                "Blue Bamboo Cafe"
        };

        Integer[] imgid = {
                R.drawable.wrapnrolllogo2,
                R.drawable.bluebamboologo
        };
        /**
         * ATTENTION: This was auto-generated to implement the App Indexing API.
         * See https://g.co/AppIndexing/AndroidStudio for more information.
         */
        private GoogleApiClient client;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            CustomListAdapter adapter = new CustomListAdapter(this, itemname, imgid);
            list = (ListView) findViewById(R.id.list);
            list.setAdapter(adapter);

            list.setOnItemClickListener(new OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    // TODO Auto-generated method stub
                    String Slecteditem = itemname[+position];
                    switch(position) {
                        case 0: startActivity(new Intent(DiningActivityTake2.this, WrapNRollScrollingActivity.class));
                            break;
                        case 1: startActivity(new Intent(DiningActivityTake2.this, BlueBambooScrollingActivity.class));
                            break;
                    }
                }
            });
            // ATTENTION: This was auto-generated to implement the App Indexing API.
            // See https://g.co/AppIndexing/AndroidStudio for more information.
            client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        }

        /**
         * ATTENTION: This was auto-generated to implement the App Indexing API.
         * See https://g.co/AppIndexing/AndroidStudio for more information.
         */
        public Action getIndexApiAction() {
            Thing object = new Thing.Builder()
                    .setName("Main Page") // TODO: Define a title for the content shown.
                    // TODO: Make sure this auto-generated URL is correct.
                    .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                    .build();
            return new Action.Builder(Action.TYPE_VIEW)
                    .setObject(object)
                    .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                    .build();
        }

        @Override
        public void onStart() {
            super.onStart();

            // ATTENTION: This was auto-generated to implement the App Indexing API.
            // See https://g.co/AppIndexing/AndroidStudio for more information.
            client.connect();
            AppIndex.AppIndexApi.start(client, getIndexApiAction());
        }

        @Override
        public void onStop() {
            super.onStop();

            // ATTENTION: This was auto-generated to implement the App Indexing API.
            // See https://g.co/AppIndexing/AndroidStudio for more information.
            AppIndex.AppIndexApi.end(client, getIndexApiAction());
            client.disconnect();
        }


    }


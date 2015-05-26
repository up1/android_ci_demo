package workshop.temperatureconvertor;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class LongListActivity extends Activity {


    private static final int NUMBER_OF_ITEMS = 100;
    public static final String ROW_TEXT = "ROW_TEXT";
    private static final String ITEM_TEXT_FORMAT = "item: %d";
    private static final String ROW_ENABLED = "ROW_ENABLED";
    private List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
    private LayoutInflater layoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_long_list);
        populateData();

        ListView listView = (ListView) findViewById(R.id.list);
        layoutInflater = getLayoutInflater();

        String[] from = new String[]{ROW_TEXT, ROW_ENABLED};
        int[] to = new int[]{R.id.rowContentTextView, R.id.rowToggleButton};

        ListAdapter listAdapter = new LongListAdapter(from, to);
        listView.setAdapter(listAdapter);

    }

    private void populateData() {
        for (int i = 0; i < NUMBER_OF_ITEMS; i++) {
            data.add(makeItem(i));
        }
    }

    private Map<String, Object> makeItem(int forRow) {
        Map<String, Object> dataRow = Maps.newHashMap();
        dataRow.put(ROW_TEXT, String.format(ITEM_TEXT_FORMAT, forRow));
        dataRow.put(ROW_ENABLED, forRow == 1);
        return dataRow;
    }

    class LongListAdapter extends SimpleAdapter {

        public LongListAdapter(String[] from, int[] to) {
            super(LongListActivity.this, LongListActivity.this.data, R.layout.list_item, from, to);
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            // Inflate list items.
            if (null == convertView) {
                convertView = layoutInflater.inflate(R.layout.list_item, null);
            }

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((TextView) findViewById(R.id.selection_row_value)).setText(
                            String.valueOf(position));
                }
            });

            return super.getView(position, convertView, parent);
        }


    }

}


package com.example.reyna.alzreminder;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by reyna on 3/14/2018.
 */

public class ListAdapterTask extends ArrayAdapter<DataListTask>  {
    public ListAdapterTask(Activity context, ArrayList<DataListTask> object ){
        super(context, 0, object);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View obj = convertView;
        if (obj==null) {
            obj = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_task, parent, false
            );
        }
        DataListTask dl = getItem(position);

        TextView title = (TextView) obj.findViewById(R.id.title_task);
        title.setText(dl.getTitle());

        TextView desc = (TextView) obj.findViewById(R.id.desc_task);
        desc.setText(dl.getDescription());

        TextView clock = (TextView) obj.findViewById(R.id.clock);
        clock.setText(dl.getClock());

        TextView date = (TextView) obj.findViewById(R.id.date);
        date.setText(dl.getDate());

        return obj;
    }
}
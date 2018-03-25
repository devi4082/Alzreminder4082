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

public class ListAdapter extends ArrayAdapter<DataList>  {
    public ListAdapter(Activity context, ArrayList<DataList> object ){
        super(context, 0, object);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View obj = convertView;
        if (obj==null) {
            obj = LayoutInflater.from(getContext()).inflate(
                    R.layout.list, parent, false
            );
        }
            DataList dl = getItem(position);

            TextView title = (TextView) obj.findViewById(R.id.title);
            title.setText(dl.getTitle());

            TextView desc = (TextView) obj.findViewById(R.id.desc);
            desc.setText(dl.getDescription());

            ImageView imageView = (ImageView) obj.findViewById(R.id.image);
            if (dl.hasImage()) {
                imageView.setImageResource(dl.getGambar());
                imageView.setVisibility(View.VISIBLE);
            } else {
                imageView.setVisibility(View.GONE);
            }
            return obj;
        }
    }
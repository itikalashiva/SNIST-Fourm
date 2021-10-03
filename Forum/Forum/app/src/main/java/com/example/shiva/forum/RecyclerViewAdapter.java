package com.example.shiva.forum;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.storage.StorageReference;

import java.util.List;


class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
StorageReference srf;

   public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        Button btn;
        ViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.name);
            btn = (Button) itemView.findViewById(R.id.button);
        }
    }
    static private List<Row> list;
    private Context context;
   RecyclerViewAdapter(Context con, List<Row> li)
    {
        list=li;
        context=con;
    }

    Context getContext()
    {
        return context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View view = inflater.inflate(R.layout.row, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final Row r = list.get(position);
        TextView textView = holder.tv;
        textView.setText(r.getName());
        Button button = holder.btn;
        button.setText("Download");
        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Toast.makeText(context, r.getLink(), Toast.LENGTH_SHORT).show();
                DownloadManager downloadManager;
                downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
                Uri uri=Uri.parse(r.getLink().toString());
                DownloadManager.Request request=new DownloadManager.Request(uri);
                request.setTitle(r.getName());
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                Long refrence=downloadManager.enqueue(request);
                Toast.makeText(context,"downloading..",Toast.LENGTH_SHORT).show();


            }
        });
    }



    @Override
    public int getItemCount() {
        return list.size();
    }
}

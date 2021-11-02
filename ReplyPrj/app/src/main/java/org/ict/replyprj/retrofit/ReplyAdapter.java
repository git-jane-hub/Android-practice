package org.ict.replyprj.retrofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.ict.replyprj.R;
import org.ict.replyprj.vo.Example;

import java.util.List;

public class ReplyAdapter extends RecyclerView.Adapter<ReplyAdapter.ViewHolder> {

    List<Example> items;

    public ReplyAdapter(List<Example> items){
        this.items = items;
    }

    @NonNull
    @Override
    public ReplyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.reply, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Example item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView bno, rno, reply, replyer, replyDate, updateDate;

        public ViewHolder(View itemView){
            super(itemView);
            bno = itemView.findViewById(R.id.bno);
            rno = itemView.findViewById(R.id.rno);
            reply = itemView.findViewById(R.id.reply);
            replyer = itemView.findViewById(R.id.replyer);
            replyDate = itemView.findViewById(R.id.replyDate);
            updateDate = itemView.findViewById(R.id.updateDate);
        }

        public void setItem(Example item){
            bno.setText(item.getBno());
            rno.setText(item.getRno());
            reply.setText(item.getReply());
            replyer.setText(item.getReplyer());
            replyDate.setText(item.getReplydate() + "");
            updateDate.setText(item.getUpdatedate() + "");
        }
    }
}

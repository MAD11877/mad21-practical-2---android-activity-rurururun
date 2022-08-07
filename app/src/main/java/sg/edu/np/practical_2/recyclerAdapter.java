package sg.edu.np.practical_2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder> {
    ArrayList<User> userList;
    OnNoteListener monNoteListener;

    public recyclerAdapter(ArrayList<User> userList, OnNoteListener onNoteListener){
        this.userList = userList;
        this.monNoteListener = onNoteListener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView profile;
        TextView name;
        TextView desc;
        ImageView bigProfile;
        OnNoteListener onNoteListener;

        public MyViewHolder(final View view, OnNoteListener onNoteListener){
            super(view);

            profile = view.findViewById(R.id.profile1);
            name = view.findViewById(R.id.name1);
            desc = view.findViewById(R.id.description1);
            bigProfile = view.findViewById(R.id.bigProfile);
            this.onNoteListener = onNoteListener;

            profile.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onNoteListener.onNoteClick(getAdapterPosition());
        }
    }

    public interface OnNoteListener{
        void onNoteClick(int position);
    }

    @NonNull
    @Override
    public recyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.format, parent, false);
        return new MyViewHolder(itemView, monNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.MyViewHolder holder, int position) {
        String userName = userList.get(position).getName();
        String description = userList.get(position).getDescription();

        if (userName.endsWith("7")){
            holder.bigProfile.setVisibility(View.VISIBLE);
        }
        else{
            holder.bigProfile.setVisibility(View.GONE);
        }

        holder.name.setText(userName);
        holder.desc.setText(description);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}

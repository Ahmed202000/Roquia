package com.roqua;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

import static com.roqua.HelperMethod.ReplaceFragment;


public class AuthorsAdapter extends RecyclerView.Adapter<AuthorsAdapter.ProductViewHolder> {


    private Context context;
    private List<AuthorsItem> articleslist = new ArrayList<>();
    HomeActivity activity;


    public AuthorsAdapter(List<AuthorsItem> articleslist, Context context , HomeActivity activity) {
        this.articleslist = articleslist;
        this.context = context;
        this.activity=activity;

    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.authors_item, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        PlayerFragment fragment = new PlayerFragment();
        holder.ivAuthorImage.setBackgroundResource(articleslist.get(position).getImage());
        holder.tvAuthorName.setText(articleslist.get(position).getAuthor_name());
        holder.btnRoqia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment.mp.stop();
                fragment.path=articleslist.get(position).getRoqia_url();
                fragment.name =articleslist.get(position).getAuthor_name();
                fragment.type=holder.btnRoqia.getText().toString();
                ReplaceFragment( activity.getSupportFragmentManager(), fragment, R.id.container
                        , null, "");
            }
        });
        holder.btnHarqAya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment.mp.stop();
                fragment.path=articleslist.get(position).getHarq_url();
                fragment.name =articleslist.get(position).getAuthor_name();
                fragment.type=holder.btnHarqAya.getText().toString();
                ReplaceFragment( activity.getSupportFragmentManager(), fragment, R.id.container
                        , null, "");

            }
        });


    }

    @Override
    public int getItemCount() {
        return articleslist.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_author_image)
        CircleImageView ivAuthorImage;
        @BindView(R.id.tv_author_name)
        TextView tvAuthorName;
        @BindView(R.id.btn_roqia)
        Button btnRoqia;
        @BindView(R.id.btn_harq_aya)
        Button btnHarqAya;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}

package br.com.timeba.eduardo.desafiomoblee;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by EDUARDO on 13/03/2016.
 */
public class AdapterQuestao extends BaseAdapter {

    private ArrayList<Questao> questoes = new ArrayList<>();
    private final LayoutInflater inflater;

    public AdapterQuestao(Context context) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setItensList(ArrayList<Questao> questoes) {
        this.questoes = questoes;
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return questoes.size();
    }

    @Override
    public Object getItem(int position) {
        return questoes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.questoes_item, parent, false);
        }

        Questao atual = questoes.get(position);

        ((TextView)convertView.findViewById(R.id.titulo)).setText(atual.title);
        ( (TextView)convertView.findViewById(R.id.nome)).setText(atual.display_name);
        ((TextView)convertView.findViewById(R.id.votos)).setText(atual.reputation);

        return convertView;
    }
}
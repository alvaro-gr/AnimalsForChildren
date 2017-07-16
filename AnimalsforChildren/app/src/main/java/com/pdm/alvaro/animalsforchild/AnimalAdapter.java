package com.pdm.alvaro.animalsforchild;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import com.pdm.alvaro.animalsforchild.MainActivity;

import java.util.ArrayList;

/**
 * Created by alvaro on 27/04/17.
 */

public class AnimalAdapter extends BaseAdapter {

    private ArrayList<Animal> animales;
    private Context context;
    private LayoutInflater layoutInflater;

    public AnimalAdapter(ArrayList<Animal> array, Context c){
        this.animales = array;
        this.context = c;
    }

    public  void clear() {
        this.animales.clear();
    }
        @Override
    public int getCount() {
        return animales.size();
    }

    @Override
    public Object getItem(int position) {
        Object object = animales.get(position);
        return object;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View viewItem = layoutInflater.inflate(R.layout.animal_item, parent, false);
        final Context p = parent.getContext();

        Button animalBoton = (Button) viewItem.findViewById(R.id.animalButton);
        ImageView imageView = (ImageView) viewItem.findViewById(R.id.imagen);

        imageView.setImageResource(animales.get(position).getImagen());

        animalBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animal animal = animales.get(position);
                String[] letras;
                if (animal.getClasifcación().equals("invertebrado")){
                    AnimalesIVActivity animalesIVActivity = new AnimalesIVActivity();
                    animalesIVActivity.mostrarDialog(animal,p);
                } else {
                    MainActivity mainActivity = new MainActivity();
                    mainActivity.mostrarDialog(animal,p);
                }
            }
        });
        return viewItem;
    }







}

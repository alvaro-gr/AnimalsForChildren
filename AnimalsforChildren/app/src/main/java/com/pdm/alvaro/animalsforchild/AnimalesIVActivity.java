package com.pdm.alvaro.animalsforchild;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AnimalesIVActivity extends AppCompatActivity {

    private static final int ALPHA_SELECTED = 255;
    private static final int ALPHA_UNSELECTED = 128;
    private static final int NUM_TABS = 2;

    private ArrayList<Animal> animales;
    private ListView lista;
    private AnimalAdapter animalAdapter;
    private AnimalAdapter adpatador;


    private TabLayout tabLayout;
    private Dialog customDialog = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animales_iv);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager2);
        viewPager.setAdapter(new AnimalesIVActivity.MainPageAdapter());

        tabLayout = (TabLayout) findViewById(R.id.tabs2);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewPager);

        animales = new ArrayList<>();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.salir:
                intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                break;
            case R.id.Ayuda:
                intent = new Intent(getApplicationContext(), AyudaActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.AnimalesV:
                intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.AnimalesIV:
                intent = new Intent(getApplicationContext(), AnimalesIVActivity.class);
                startActivity(intent);
                finish();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    private class MainPageAdapter extends PagerAdapter {

        private ListView page1;
        private RelativeLayout page2;

        private final String[] titles = {"Animales Invertebrados", "Información"};

        @Override
        public int getCount() {
            return NUM_TABS;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

        @Override
        public Object instantiateItem(ViewGroup collection, int position) {
            View page = null;
            switch (position) {
                case 0:
                    if (page1 == null) {
                        page1 = (ListView) LayoutInflater.from(AnimalesIVActivity.this).inflate(R.layout
                                .pagina1, collection, false);
                        lista = page1;
                        cargarAnimalesIV(page1);
                        Log.d("mensaje: ",String.valueOf(adpatador.getCount()));
                    }
                    page = page1;
                    break;
                case 1:
                    if (page2 == null) {
                        page2 = (RelativeLayout) LayoutInflater.from(AnimalesIVActivity.this).inflate(R.layout
                                .pagina2info, collection, false);
                    }
                    page = page2;
                    break;
            }

            collection.addView(page, 0);

            return page;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup collection, int position, Object view) {
            collection.removeView((View) view);
        }

        private void cargarAnimalesIV(ListView l){

            animales.add(new Animal("abeja",1,R.drawable.abeja,"artrópodo","invertebrado"));
            animales.add(new Animal("almeja",2,R.drawable.almeja,"molusco","invertebrado"));
            animales.add(new Animal("araña",3,R.drawable.arana,"artrópodo","invertebrado"));
            animales.add(new Animal("cangrejo",4,R.drawable.cangrejo,"artrópodo","invertebrado"));
            animales.add(new Animal("caracol",5,R.drawable.caracol,"molusco","invertebrado"));
            animales.add(new Animal("ciempiés",6,R.drawable.ciempies,"miriápodo","invertebrado"));
            animales.add(new Animal("langosta",7,R.drawable.langosta,"artrópodo","invertebrado"));
            animales.add(new Animal("gusano",8,R.drawable.gusano,"gusano","invertebrado"));
            animales.add(new Animal("hormiga",9,R.drawable.hormiga,"artrópodo","invertebrado"));
            animales.add(new Animal("mariposa",10,R.drawable.mariposa,"artrópodo","invertebrado"));
            animales.add(new Animal("mariquita",11,R.drawable.mariquita,"artrópodo","invertebrado"));
            animales.add(new Animal("saltamontes",12,R.drawable.saltamontes,"artrópodo","invertebrado"));

            adpatador = new AnimalAdapter(animales, getApplicationContext());
            l.setAdapter(adpatador);

        }


    }

    public void mostrarDialog(final Animal animal, final Context context) {
        final Dialog customDialog;

        // con este tema personalizado evitamos los bordes por defecto
        customDialog = new Dialog(context);
        //deshabilitamos el título por defecto
        customDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //obligamos al usuario a pulsar los botones para cerrarlo
        customDialog.setCancelable(false);
        //establecemos el contenido de nuestro dialog
        customDialog.setContentView(R.layout.dialog);

        Integer id = animal.getAnimal_id();
        String[] letras = context.getResources().getStringArray(R.array.opciones2);;

        TextView tex = (TextView) customDialog.findViewById(R.id.letras);
        tex.setText(letras[id-1].toString());


        ((Button) customDialog.findViewById(R.id.aceptar)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) customDialog.findViewById(R.id.solucion);
                String solucion = editText.getText().toString().trim();
                customDialog.dismiss();
                ((AnimalesIVActivity)context).comprobarAnimal(animal,solucion);
            }
        });

        ((Button) customDialog.findViewById(R.id.cancelar)).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                customDialog.dismiss();
            }
        });

        customDialog.show();
        Window window = customDialog.getWindow();
        window.setLayout(ViewPager.LayoutParams.MATCH_PARENT, ViewPager.LayoutParams.WRAP_CONTENT);

    }

    public void comprobarAnimal(Animal animal, String nombre_introducido){

        if(animal.getNombre().equals(nombre_introducido)){
            Intent intent = new Intent(AnimalesIVActivity.this, CorrectoActivity.class);
            intent.putExtra("tipoAnimal",animal.getTipo());
            intent.putExtra("clasificacionAnimal", animal.getClasifcación());
            startActivity(intent);
            finish();
        } else {
            Intent intent = new Intent(AnimalesIVActivity.this, IncorrectoActivity.class);
            intent.putExtra("clasificacionAnimal", animal.getClasifcación());
            startActivity(intent);
            finish();
        }
    }

}

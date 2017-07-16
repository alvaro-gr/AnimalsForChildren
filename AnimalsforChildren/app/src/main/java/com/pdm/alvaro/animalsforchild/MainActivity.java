package com.pdm.alvaro.animalsforchild;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.util.Log;
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
import android.view.LayoutInflater;
import android.support.v4.view.PagerAdapter;

import java.io.Serializable;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity  {


    private static final int ALPHA_SELECTED = 255;
    private static final int ALPHA_UNSELECTED = 128;
    private static final int NUM_TABS = 2;

    private ArrayList<Animal> animales, listaAnimales;
    private ListView lista;
    private AnimalAdapter adpatador;


    private TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new MainPageAdapter());

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewPager);

        animales = listaAnimales = new ArrayList<>();

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

        private ListView  page1;
        private RelativeLayout  page2;
        private final String[] titles = {"Animales Vertebrados","Información"};

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
                        page1 = (ListView) LayoutInflater.from(MainActivity.this).inflate(R.layout
                                .pagina1, collection, false);
                    }
                    page = page1;
                    cargarAnimales(page1);
                    Log.d("mensaje: ",String.valueOf(adpatador.getCount()));
                    break;
                case 1:
                    if (page2 == null) {
                        page2 = (RelativeLayout) LayoutInflater.from(MainActivity.this).inflate(R.layout
                                .pagina1info, collection, false);
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


        private  void cargarAnimales(ListView l){
            animales.add(new Animal("elefante",1,R.drawable.elefante,"mamífero","vertebrado"));
            animales.add(new Animal("gato",2,R.drawable.gato,"mamífero","vertebrado"));
            animales.add(new Animal("león",3,R.drawable.leon,"mamífero","vertebrado"));
            animales.add(new Animal("mono",4,R.drawable.mono,"mamífero","vertebrado"));
            animales.add(new Animal("perro",5,R.drawable.perro,"mamífero","vertebrado"));
            animales.add(new Animal("vaca",6,R.drawable.vaca,"mamífero","vertebrado"));
            animales.add(new Animal("caballo",7,R.drawable.caballo,"mamífero","vertebrado"));
            animales.add(new Animal("girafa",8,R.drawable.girafa,"mamífero","vertebrado"));

            animales.add(new Animal("águila",9,R.drawable.aguila,"ave","vertebrado"));
            animales.add(new Animal("búho",10,R.drawable.buho,"ave","vertebrado"));
            animales.add(new Animal("gallina",11,R.drawable.gallina,"ave","vertebrado"));
            animales.add(new Animal("loro",12,R.drawable.loro,"ave","vertebrado"));
            animales.add(new Animal("paloma",13,R.drawable.paloma,"ave","vertebrado"));
            animales.add(new Animal("pato",14,R.drawable.pato,"ave","vertebrado"));
            animales.add(new Animal("pavo",15,R.drawable.pavo,"ave","vertebrado"));
            animales.add(new Animal("pinguino",16,R.drawable.pinguino,"ave","vertebrado"));

            animales.add(new Animal("atún",17,R.drawable.atun,"pez","vertebrado"));
            animales.add(new Animal("ballena",18,R.drawable.ballena,"pez","vertebrado"));
            animales.add(new Animal("delfín",19,R.drawable.delfin,"pez","vertebrado"));
            animales.add(new Animal("foca",20,R.drawable.foca,"pez","vertebrado"));
            animales.add(new Animal("pulpo",21,R.drawable.pulpo,"pez","vertebrado"));
            animales.add(new Animal("rana",22,R.drawable.rana,"pez","vertebrado"));
            animales.add(new Animal("sapo",23,R.drawable.sapo,"pez","vertebrado"));
            animales.add(new Animal("tiburón",24,R.drawable.tiburon,"pez","vertebrado"));

            animales.add(new Animal("caiman",25,R.drawable.caiman,"reptil","vertebrado"));
            animales.add(new Animal("camaleón",26,R.drawable.camaleon,"reptil","vertebrado"));
            animales.add(new Animal("cocodrilo",27,R.drawable.cocodrilo,"reptil","vertebrado"));
            animales.add(new Animal("dinosaurio",28,R.drawable.dinosaurio,"reptil","vertebrado"));
            animales.add(new Animal("iguana",29,R.drawable.iguana,"reptil","vertebrado"));
            animales.add(new Animal("lagarto",30,R.drawable.lagarto,"reptil","vertebrado"));
            animales.add(new Animal("serpiente",31,R.drawable.serpiente,"reptil","vertebrado"));
            animales.add(new Animal("torturga",32,R.drawable.tortuga,"reptil","vertebrado"));

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
        String[] letras = context.getResources().getStringArray(R.array.opciones_V);;

        TextView tex = (TextView) customDialog.findViewById(R.id.letras);
        tex.setText(letras[id-1].toString());


        ((Button) customDialog.findViewById(R.id.aceptar)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) customDialog.findViewById(R.id.solucion);
                String solucion = editText.getText().toString().trim();
                customDialog.dismiss();
                ((MainActivity)context).comprobarAnimal(animal,solucion);
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
            Intent intent = new Intent(MainActivity.this, CorrectoActivity.class);
            intent.putExtra("tipoAnimal",animal.getTipo());
            intent.putExtra("clasificacionAnimal", animal.getClasifcación());
            startActivity(intent);
            finish();

        } else {
            Intent intent = new Intent(MainActivity.this, IncorrectoActivity.class);
            intent.putExtra("clasificacionAnimal", animal.getClasifcación());
            startActivity(intent);
            finish();
            //Toast toast = Toast.makeText(c,"Incorrecto",Toast.LENGTH_SHORT);
            //toast.show();
        }
    }

}


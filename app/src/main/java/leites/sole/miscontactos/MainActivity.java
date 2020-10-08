package leites.sole.miscontactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;
    private RecyclerView rvContactos;
    public ContactoAdaptador adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        rvContactos = (RecyclerView) findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvContactos.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();



       /* ArrayList<String> nombresContacto = new ArrayList<>();
        for (Contacto contacto: contactos) {
            nombresContacto.add(contacto.getNombre());
        }
        ListView lstContactos = (ListView) findViewById(R.id.lstContactos);
        lstContactos.setAdapter(new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, nombresContacto));

        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.pnombre), contactos.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono), contactos.get(position).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail), contactos.get(position).getEmail());
                startActivity(intent);
                finish();
            }
        });*/
    }


    public void inicializarAdaptador(){
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos, this);
        rvContactos.setAdapter(adaptador);
        //ContactoAdaptador adaptador = new ContactoAdaptador(contactos);
       // listaContactos.setAdapter(adaptador);

    }

    public void inicializarListaContactos(){

        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto(R.drawable.ponny,"Sole", "445566", "Sole@mail.com"));
        contactos.add(new Contacto(R.drawable.turtle,"Eugenia", "556677", "eugi@mail.com"));
        contactos.add(new Contacto(R.drawable.bill,"Fernanda", "778899", "Fer@mail.com"));
        contactos.add(new Contacto(R.drawable.blue,"Georgia", "990011", "Georgi@mail.com"));
        contactos.add(new Contacto(R.drawable.polarpolls,"Helgua", "112233", "huelguis@mail.com"));
    }
}
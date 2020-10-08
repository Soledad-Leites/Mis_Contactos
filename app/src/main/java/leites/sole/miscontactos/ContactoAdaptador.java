package leites.sole.miscontactos;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder>{

    ArrayList<Contacto> contactos;
    Activity activity;

    public ContactoAdaptador(ArrayList<Contacto> contactos, Activity activity){ //METODO CONSTRUCTOR
        this.contactos = contactos;
        this.activity = activity;
    }

    @NonNull
    @Override //INFLA ELLAYOUT Y LO PASARA AL VIEWHOLDER PARA QUE OBTENGA LOS DATOS SOLICITADOS EN EL METODO onBindViewHolder
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto, parent, false);
        return new ContactoViewHolder(v);
    }

    @Override //ASOCIA CADA ELEMENTO DE LA LISTA CON CADA VIEW
    public void onBindViewHolder(@NonNull final ContactoViewHolder contactoViewHolder, int position) {
        final Contacto contacto = contactos.get(position);
        contactoViewHolder.imgFoto.setImageResource(contacto.getFoto());
        contactoViewHolder.tvNombreCv.setText(contacto.getNombre());
        contactoViewHolder.tvTelefonoCv.setText(contacto.getTelefono());
        contactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a " + contacto.getNombre(),
                        Toast.LENGTH_SHORT).show();
            }
        });
        contactoViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, contacto.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, DetalleContacto.class);
                intent.putExtra("nombre", contacto.getNombre());
                intent.putExtra("telefono", contacto.getTelefono());
                intent.putExtra("email", contacto.getEmail());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() { //CANTIDAD DE ELEMENTOS QUE CONTIENE MI LISTA DE CONTACTOS
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{

        private AppCompatImageView imgFoto;
        private AppCompatTextView tvNombreCv;
        private AppCompatTextView tvTelefonoCv;
        private AppCompatImageButton btnLike;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto         = (AppCompatImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCv      = (AppCompatTextView) itemView.findViewById(R.id.tvNombreCv);
            tvTelefonoCv    = (AppCompatTextView) itemView.findViewById(R.id.tvTelefonoCv);
            btnLike         = (AppCompatImageButton) itemView.findViewById(R.id.btnLike);

        }
    }
}

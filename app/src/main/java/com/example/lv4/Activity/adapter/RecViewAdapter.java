package com.example.lv4.Activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lv4.Activity.models.Student;
import com.example.lv4.R;

import java.util.ArrayList;

public class RecViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<Student> studenti;

    public RecViewAdapter(ArrayList<Student> students){ //KONSTRUKTOR
        this.studenti = students;
        notifyDataSetChanged();
    }

    @NonNull
    @Override //odlučuje koji view se inflatea s obzirom na viewtype parametar.
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == 0){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_header, parent, false);
            return new HeaderViewHolder(view);
        }
        else{
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_row, parent, false);
            return new StudentViewHolder(view);
        }
    }

    @Override //postavlja vrijednosti vieowa
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position) == 0){
            HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
            headerViewHolder.txtHeader.setText("STUDENTI");
        }
        else{
            StudentViewHolder studHolder = (StudentViewHolder) holder;
            studHolder.txtPersonal.setText(studenti.get(position).VratiImePrezime());
            studHolder.txtStud.setText(studenti.get(position).VratiPredmet());
        }

    }

    //za svaki view koji želimo prikazati napravimo klasu
    //objekt te klase se šalje bind view funkciji gdje se postavljaju vrijednosti viewova
    class HeaderViewHolder extends RecyclerView.ViewHolder //klasa za HEADER
    {
        TextView txtHeader;
        public HeaderViewHolder(@NonNull View itemView){ //konstruktor, kao paramtera prima prazan view i pretvara ga u view iz layouta
            super(itemView);
            txtHeader = itemView.findViewById(R.id.txtHeader);
        }
    }

    class StudentViewHolder extends RecyclerView.ViewHolder
    {
        TextView txtPersonal;
        TextView txtStud;
        public StudentViewHolder(@NonNull View itemView){
            super(itemView);
            txtPersonal = itemView.findViewById(R.id.personal_info_txt);
            txtStud = itemView.findViewById(R.id.student_info_txt);
        }
    }

    @Override
    public int getItemViewType(int position){ //vraća "poziciju" tj int vrijednost koja služi za odabiranje postavljanja viewa
        return position;
    }

    @Override
    public int getItemCount() { //vraća veličinu data seta, i u isto vrijeme određuje broj elemenata koji se prikazuju unutar recylcer viewa
        return studenti.size();
    }
}

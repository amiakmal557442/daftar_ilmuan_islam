package com.akmal.daftar_ilmuan_islam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;

public class list_ilmuan_activity extends AppCompatActivity {
// deklarasi
    String[] nama = {"Al Khawarizmi" , "Al Zahrawi" , "Ibnu al-Baithar" , "Ibnu al-Nafis" , "Ibnu Haitham " , "Ibnu Khaldun" , "Ibnu Sina" , "Jabir Ibn- Hayyan" , "Thbit ibn Qurra" , "Umar Khayyam"};
 int[] gambar = {R.drawable.alkhawarizmi,
         R.drawable.alzahrawi,
         R.drawable.ibnualbhaitar,
         R.drawable.ibnualnafis,
         R.drawable.ibnuhaitman,
         R.drawable.ibnukhaldun,
         R.drawable.ibnusina,
                 R.drawable.jabilibnhayyan,
                 R.drawable.thbitibnqurra,
                 R.drawable.umarkhayyam,
 };

String[] url = {"https://id.wikipedia.org/wiki/Mu%E1%B8%A5ammad_bin_M%C5%ABs%C4%81_al-Khaw%C4%81rizm%C4%AB" ,
        "https://id.wikipedia.org/wiki/Abu_al-Qasim_al-Zahrawi",
        "https://id.wikipedia.org/wiki/Ibnu_al-Baithar",
        "https://id.wikipedia.org/wiki/Ibnu_al-Nafis",
        "https://id.wikipedia.org/wiki/Ibnu_Haitham",
        "https://id.wikipedia.org/wiki/Ibnu_Khaldun" ,
        "https://id.wikipedia.org/wiki/Ibnu_Sina" ,
        "https://id.wikipedia.org/wiki/Abu_Musa_Jabir_bin_Hayyan" ,
        "https://id.wikipedia.org/wiki/Tsabit_bin_Qurrah" ,

        "https://id.wikipedia.org/wiki/Umar_Khayy%C4%81m"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.listViewIlmuwan);
        CustomListviewadapter customListviewadapter = new CustomListviewadapter();
        listView.setAdapter(customListviewadapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent akmal = new Intent(list_ilmuan_activity.this,detail_Ilmuwan.class);
                akmal.putExtra("putnama",nama[position]);
                akmal.putExtra("poturl",url[position]);
                startActivity(akmal);

            }
        });
    }

    class CustomListviewadapter extends BaseAdapter{

        @Override
        public int getCount() {
            return gambar.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.costum_listview,null);
            ImageView imageView = convertView.findViewById(R.id.imgIlmuwan);
            TextView textView = convertView.findViewById(R.id.txtIlmuwan);
            imageView.setImageResource(gambar[position]);
            textView.setText(nama[position]);
            return convertView;

        }
    }
}

package com.example.manlanktra1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText edtMaNv,edtHoTen, edtPhonBan;
    private Button btnThem, btnSua, btnXoa, btnThoat;
    private ListView lv1;

    private ArrayList<String> Arr;

    private ArrayAdapter<String> adapter;

    private int Vitri = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        Arr = new ArrayList<>();
        adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,Arr);
        lv1.setAdapter(adapter);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtMaNv.getText().toString().equals("") ||edtHoTen.getText().toString().equals("")||edtPhonBan.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this,"Thông tin không được để trống !!!",Toast.LENGTH_LONG).show();
                }
                else {
                    String ThongTin ="Mã Nhân Viên: "+ edtMaNv.getText().toString()+ "; Họ Tên:" + edtHoTen.getText().toString() + "; Phòng Ban:" + edtPhonBan.getText().toString();
//                     Arr.add(edtMaNv.getText().toString());
//                     Arr.add(edtHoTen.getText().toString());
//                     Arr.add(edtPhonBan.getText().toString());
                    Arr.add(ThongTin);
                    adapter.notifyDataSetChanged();
                }

            }
        });

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Vitri =i;
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtMaNv.getText().toString().equals("")||edtHoTen.getText().toString().equals("")||edtPhonBan.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "không được để trống", Toast.LENGTH_LONG).toString();
                } else {
                    String ThongTin ="Ma: "+ edtMaNv.getText().toString()+ "; Ho ten:" + edtHoTen.getText().toString() + "; lop:" + edtPhonBan.getText().toString();
                    Arr.set(Vitri,ThongTin);
                    adapter.notifyDataSetChanged();
                    edtMaNv.getText().clear();edtHoTen.getText().clear();edtPhonBan.getText().clear();
                }
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnXoa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Arr.remove(Vitri);
                        adapter.notifyDataSetChanged();
                        edtMaNv.setText("");
                        edtHoTen.setText("");
                        edtPhonBan.setText("");
                    }
                });
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Xác nhận thoát chương trình!");
                builder.setMessage("Bạn có muốn thoát ko?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog d1 = builder.create();
                d1.show();

            }
        });

    }

    private void anhxa() {
        edtMaNv= findViewById(R.id.edtMaNv);
        edtHoTen= findViewById(R.id.edtHoTen);
        edtPhonBan= findViewById(R.id.edtPhongBan);
        btnSua= findViewById(R.id.btnSua);
        btnThem= findViewById(R.id.btnThem);
        btnThoat = findViewById(R.id.btnThoat);
        btnXoa= findViewById(R.id.btnXoa);
        lv1 = findViewById(R.id.Lv1);
    }
}
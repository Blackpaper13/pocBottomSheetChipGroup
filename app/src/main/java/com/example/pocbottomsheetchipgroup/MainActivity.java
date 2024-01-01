package com.example.pocbottomsheetchipgroup;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList Img = new ArrayList<>(Arrays.asList(R.drawable.ambarella, R.drawable.banana, R.drawable.avocado,
                R.drawable.blackpaper, R.drawable.grape, R.drawable.blueberry, R.drawable.lemon, R.drawable.mango
            ));
    ArrayList Name = new ArrayList<>(Arrays.asList("ambarella", "banan", "avocado","blackpaper","grape","blueberry",
        "lemon","mango"
    ));

    ExtendedFloatingActionButton openBottomSheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        openBottomSheet = findViewById(R.id.buttonBottomSheetPersistent);

        openBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheetDialog();
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        AdapterRv adapter = new AdapterRv(MainActivity.this, Img, Name);

        // Setting Adapter to RecyclerView
        recyclerView.setAdapter(adapter);

    }

    private void showBottomSheetDialog() {
        final BottomSheetDialog dialog = new BottomSheetDialog(this);
        dialog.setContentView(R.layout.bottom_sheet_persistent);

        ChipGroup chipGroup = dialog.findViewById(R.id.chipGroup);
        Chip chip1, chip2, chip3,chip4,chip5;

        chip1 = dialog.findViewById(R.id.chipComplaintNumber);
        chip2 = dialog.findViewById(R.id.chipStatusComplaint);
        chip3 = dialog.findViewById(R.id.chipPriority);
        chip4 = dialog.findViewById(R.id.chipCreatedComplaint);
        chip5 = dialog.findViewById(R.id.chipProblem);


        chipGroup.setOnCheckedStateChangeListener(new ChipGroup.OnCheckedStateChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull ChipGroup group, @NonNull List<Integer> checkedIds) {
                int ids = chipGroup.getCheckedChipId();

                Log.i("check","nilai : " + ids);
            }
        });


        dialog.show();
    }
}